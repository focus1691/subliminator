<?php

function getTestCount() {
	include('MySQL/config.php');
	$count = 0;
	if ($result = mysqli_query($Connection, "SELECT testID FROM downloads")) {
		$count = $result->num_rows;
		$result->close();
	}
	printf("This test has been taken %d times", $count);
	mysqli_close($Connection);
	return $count;
}

function removeDelimiters($RTStr, $condition, $rspStr, $ansStr, $congStr, $cueStr) {
	
    $testData = array(
        "RT" => "",
        "condition" => "",
		"response" => "",
		"answer" => "",
		"congruence" => "",
		"cue" => ""
    );
	$testData['RT'] = explode(",", $RTStr);
	$testData['condition'] = explode(",", $condition);
	$testData['response'] = explode(",", $rspStr);
	$testData['answer'] = explode(",", $ansStr);
	$testData['congruence'] = explode(",", $congStr);
	$testData['cue'] = explode(",", $cueStr);
	return $testData;
}

function addTest($toa, $trials) {
	include('../MySQL/config.php');
	$date = date("Y-m-d H:i:s");
    $stmt = $Connection->prepare("INSERT INTO ANTTest (toa, trials, testDate) VALUES (?, ?, ?)");
    $stmt->bind_param('iis', $toa, $trials, $date);
    $stmt->execute();
	$id = mysqli_insert_id($Connection);
	$stmt->close();
	mysqli_close($Connection);
	return $id;
}

function addResponse($rt, $cond, $rsp, $answer, $cue, $congruency, $testID) {
	include('../MySQL/config.php');
	$stmt = $Connection->prepare("INSERT INTO ANTResponses (reactionTime, cond, response, answer, cue, congruence, test) VALUES (?, ?, ?, ?, ?, ?, ?)");
	$stmt->bind_param('iissssi', $rt, $cond, $rsp, $answer, $cue, $congruency, $testID);
	$stmt->execute();
	$stmt->close();
	mysqli_close($Connection);
}

function getCueScores($id) {
	include('../MySQL/config.php');
	$noCue;
	$doubleCue;
	$noEntry = 0;
	
	$results = array(
		"noCue" => "",
		"doubleCue" => "",
		"centerCue" => "",
		"spatialCue" => "",
		"congruent" => "",
		"incongruent" => ""
	);
	$result = mysqli_prepare($Connection, "SELECT AVG(reactionTime), cue FROM ANTResponses
										   INNER JOIN ANTTest ON (ANTResponses.test = ANTTest.testID)
										   AND ANTResponses.test =? AND NOT reactionTime = ? GROUP BY cue");
	
	mysqli_stmt_bind_param($result, 'ii', $id, $noEntry);
	mysqli_stmt_bind_result($result, $rt, $cue);
	mysqli_stmt_execute($result);
	mysqli_stmt_store_result($result);
	
	while (mysqli_stmt_fetch($result)) {
		// order
		// #1 both cue
		// #4 mid cue
		if (strcmp($cue, "fixPlus") == 0) {
			$results["noCue"] = $rt;
		}
		else if (strcmp($cue, "bothCue") == 0) {
			$results["doubleCue"] = $rt;
		}
		else if (strcmp($cue, "midCue") == 0) {
			$results["centerCue"] = $rt;
		}
		else if (strcmp($cue, "topCue") == 0 || strcmp($cue, "botCue") == 0) {
			$results["spatialCue"] = $rt;
		}
	}
	mysqli_stmt_close($result);
	mysqli_close($Connection);
	return $results;
}

function getCongruencyScores($id, $results) {
	include('../MySQL/config.php');
	$noEntry = 0;
	$congruence = 'c';
	$incongruence = 'i';
	$result = mysqli_prepare($Connection, "SELECT AVG(reactionTime), congruence FROM ANTResponses
										   INNER JOIN ANTTest ON (ANTResponses.test = ANTTest.testID)
										   AND ANTResponses.test = ? AND NOT reactionTime = ? WHERE congruence = ? OR congruence = ? GROUP BY congruence");
	
	mysqli_stmt_bind_param($result, 'iiss', $id, $noEntry, $congruence, $incongruence);
	mysqli_stmt_bind_result($result, $rt, $cong);
	mysqli_stmt_execute($result);
	mysqli_stmt_store_result($result);
	while (mysqli_stmt_fetch($result)) {
		if (strcmp($cong, "c") == 0) {
			$results["congruent"] = $rt;
		}
		else if (strcmp($cong, "i") == 0) {
			$results["incongruent"] = $rt;
		}
	}
	mysqli_stmt_close($result);
	mysqli_close($Connection);
	return $results;
}


