<?php
$link = mysqli_connect('localhost', 'root');
if ($link) {
	$sql = "CREATE DATABASE IF NOT EXISTS PsychoTechnology";
	$result = mysqli_query ($link, $sql);
	echo ($result ? 'Success' : 'Fail') . ": $sql";
	mysqli_close($link);
} else {
	echo 'Nothing created';
}