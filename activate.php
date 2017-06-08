<?php
$pageTitle = "PsychoTechnology | Activate your Account";
$pageDescription = "The Online Platform to Download Psychology Apps and Play Psychology games. Learn More About your Mind Today!";
	require_once 'php-includes/header.php';
	include 'php-includes/phpValidate.php';
	$sqlDir = "MySQL/config.php";
?>

	<h1><?php activateUser($sqlDir); ?></h1>

<?php
	require_once 'php-includes/footer.php';
?>