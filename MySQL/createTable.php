<?php

    include('config.php');
	
	function printError($Connection) { // Print the error if the prepared statement fails
		echo "Failed to connect to MySQL: (" . $Connection->connect_errno . ") " . $Connection->connect_error . "<br>";
	}
	
	// Table to store the list of registered site users
    $sql = "CREATE TABLE IF NOT EXISTS Users (
        UserID INT NOT NULL AUTO_INCREMENT,
        firstName VARCHAR(100) NOT NULL,
        lastName VARCHAR(100) NOT NULL,
        email VARCHAR(255) NOT NULL UNIQUE,
        password VARCHAR(255) NOT NULL,
        country VARCHAR(50) NOT NULL,
		verificationCode VARCHAR(50),
		active TINYINT NOT NULL DEFAULT 0,
        PRIMARY KEY (UserID)
    )";
	
	// Table to store the apps on the site
    $sql2 = "CREATE TABLE IF NOT EXISTS Apps (
        AppID INT NOT NULL AUTO_INCREMENT,
        appName VARCHAR(50) NOT NULL,
        PRIMARY KEY (AppID)
    )";
    
	// Table to count the number of app downloads
    $sql3 = "CREATE TABLE IF NOT EXISTS Downloads (
        DownloadID INT NOT NULL AUTO_INCREMENT,
        appName VARCHAR(50) NOT NULL,
        dateDownloaded DATETIME,
        PRIMARY KEY (DownloadID)
    )";
	
	// Registered users through Facebook
	$sql4 = "CREATE TABLE IF NOT EXISTS facebookUsers (
		id INT NOT NULL AUTO_INCREMENT,
		fname varchar(255) COLLATE utf8_unicode_ci NOT NULL,
		lname varchar(255) COLLATE utf8_unicode_ci NOT NULL,
		email varchar(255) COLLATE utf8_unicode_ci NOT NULL UNIQUE,
		gender varchar(10) COLLATE utf8_unicode_ci NOT NULL,
		locale varchar(10) COLLATE utf8_unicode_ci NOT NULL,
		picture text  COLLATE utf8_unicode_ci,
		PRIMARY KEY (id)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci";
	
	// A new test for the Attentional Network Task (ANT)
	$sql5 = "CREATE TABLE IF NOT EXISTS ANTTest (
		testID INT NOT NULL AUTO_INCREMENT,
		TOA INT NOT NULL,
		trials TINYINT NOT NULL,
		testDate DATETIME,
		PRIMARY KEY (testID)
	)";
	
	// A response set for ANT
	$sql6 = "CREATE TABLE IF NOT EXISTS ANTResponses (
		responseID INT NOT NULL AUTO_INCREMENT,
		reactionTime INT NOT NULL,
		cond VARCHAR(150) NOT NULL,
		response CHAR NOT NULL,
		congruence CHAR NOT NULL,
		answer CHAR NOT NULL,
		cue VARCHAR(50) NOT NULL,
		test INT NOT NULL,
		FOREIGN KEY (test) REFERENCES ANTTest (testID),
		PRIMARY KEY (responseID)
	)";
    
    $ResultSet1 = mysqli_query($Connection, $sql);
    $ResultSet2 = mysqli_query($Connection, $sql2);
    $ResultSet3 = mysqli_query($Connection, $sql3);
	$ResultSet4 = mysqli_query($Connection, $sql4);
	$ResultSet5 = mysqli_query($Connection, $sql5);
	$ResultSet6 = mysqli_query($Connection, $sql6);
	
	/* Insert Mind Booster Record into Apps */
	if (!$stmt = $Connection->prepare("INSERT INTO Apps (appName) VALUES (?)")) { // Check if the prepared statement returns false
		printError($Connection);
	} else {
		$mindBooster = "Mind Booster";
		$stmt->bind_param('s', $mindBooster);
		$stmt->execute();
		$stmt->close();
	}
	
	/* Insert Attentional Network Task Record into Apps */
	if (!$stmt = $Connection->prepare("INSERT INTO Apps(appName) VALUES(?)")) { // Same as above
		printError($Connection);
	} else {
		$ant = "Attentional Network Task";
		$stmt->bind_param('s', $ant);
		$stmt->execute();
		$stmt->close();
	}
	
	/* Insert Unconscious Biases Record into Apps */
	if (!$stmt = $Connection->prepare("INSERT INTO Apps(appName) VALUES(?)")) { // Same as above
		printError($Connection);
	} else {
		$UPD = "Unconscious Biases";
		$stmt->bind_param('s', $UPD);
		$stmt->execute();
		$stmt->close();
	}
    
    mysqli_close($Connection);
?>