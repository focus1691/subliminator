<?php

$dbConnect = array (
	'server' => 'localhost',
	'user' => 'root',
	'pass' => '',
	'name' => 'PsychoTechnology'
);

$Connection = new mysqli($dbConnect['server'], $dbConnect['user'], $dbConnect['pass'], $dbConnect['name']);

if ($Connection->connect_errno > 0) {
	echo "Database connection error: " . $Connection->connect_error;
	exit;
}

ob_start();

?>