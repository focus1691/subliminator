<?php
	ob_start();
	$pageTitle = "PsychoTechnology | Change your Password";
	$pageDescription = "The Online Platform to Download Psychology Apps and Play Psychology games. Learn More About your Mind Today!";
	require_once 'php-includes/header.php';
	include 'php-includes/phpValidate.php';
	$sqlDir = "MySQL/config.php";
	
	if ($_SERVER['REQUEST_METHOD'] == "GET") {
		if (isset($_COOKIE['resetPass'])) {
			include $sqlDir;
			$email = mysqli_real_escape_string($Connection, $_GET['email']);
			$validationCode = mysqli_real_escape_string($Connection, $_GET['code']);

			if (codeMatches($email, $validationCode, $sqlDir)) {
				//LOG THE USER (SET SESSION) TO PASSWORD CHANGE FORM
				$_SESSION['newPassEmail'] = $email;
				header('Location: new-password');
			} else {
				echo '<div style="text-align: center"; class="alert alert-danger">
				      Invalid Code.</div>';
			}
		} else {
			 echo '<div style="text-align: center"; class="alert alert-danger">
				   You do not have permission to access this page.</div>';
		}
	}

?>

<?php
	require_once 'php-includes/footer.php';
?>