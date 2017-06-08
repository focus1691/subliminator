<?php

function addDownload($app) {
	include('MySQL/config.php');
	date_default_timezone_set("Europe/London");
	$date = date("Y-m-d H:i:s");
    if ($stmt = $Connection->prepare("INSERT INTO Downloads (appName, dateDownloaded) VALUES (?, ?)")) {
		if ($stmt->bind_param('ss', $app, $date)) {
			if ($stmt->execute()) {
				$stmt->close();
			} else {
				die("Statement failed to execute");
			}
		} else {
			die("Unable to bind app name and email for user");
		}
	} else {
		die("INSERT statement failed");
	}
	mysqli_close($Connection);
}

function getDownloadCount() {
	include('MySQL/config.php');
	$count = 0;
	$app = "Mind Booster";
	if ($stmt = $Connection->prepare("SELECT DownloadID FROM Downloads WHERE appName = ?")) {
		if ($stmt->bind_param('s', $app)) {		
			if ($stmt->execute()) {
				$stmt->store_result();
				$count = $stmt->num_rows();
				$stmt->close();
			} else {
				die("SELECT statement failed");
			}
		} else {
			die("Unable to bind app name");
		}
	} else {
		die("Statement failed to execute");
	}
	printf("Mind Booster has been downloaded <strong> %d </strong> times", $count );
	mysqli_close($Connection);
}

function checkDownload() {
	if (isset($_GET['file']) && basename($_GET['file']) == $_GET['file']) {
		include("php-includes/phpValidate.php");
		$sqlDir = "MySQL/config.php";
		$app = "Mind Booster";
		addDownload($app);
		$filename = $_GET['file'];
		$path_parts = pathinfo($filename);
		$path = "files/";
		$filename = $path . $filename;
		header("Content-type:application/" . $path_parts);
		header('Content-Disposition: attachment; filename=' . basename($filename));
		ob_clean(); #THIS!
		flush();
		readfile($filename);
		exit;
	}
}
