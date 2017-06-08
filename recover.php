<?php
	ob_start();
	$pageTitle = "PsychoTechnology | Recover your Password";
	$pageDescription = "Recover your Password to get Access to Our Psychology Apps and Games. Learn More About your Mind Today!";
	require_once 'php-includes/header.php';
	
if (isset($_SESSION['email'])) {
    header("Location: ../");
}
	
	$email = "";
	$errorMsg = "";

	if ($_SERVER['REQUEST_METHOD'] == "POST") {
		include 'php-includes/phpValidate.php';
		$dbDir = "MySQL/config.php";
		include $dbDir;
		$email = mysqli_real_escape_string($Connection, $_POST['email']);
		if (userExists($email, $dbDir)) {
			$validationCode = tokenGenerator();
			$_SESSION['newPassEmail'] = $validationCode;
			changeCode($email, $validationCode, $dbDir);
			mailResetLink($email, $validationCode);
			setcookie('resetPass', "OK", time() + (86400 * 30),"/"); // 1 = 1 sec (here 1 Day)
		} else {
			$errorMsg = "Email not found";
		}
		mysqli_close($Connection);
	}
?>

<div class="container">
	<div class="row">
		<div class="module form-module form loginForm">
			<div class="toggle"></div>
			<div class="  col-lg-12 col-md-12 col-sm-12 col-xs-12" id="login">
				<div class="form" id="login">
					<h2>Forgot your Password?</h2>
					<form action="<?php echo htmlentities("recover"); ?>" method="post" class="ajax">
						<div>
							<input type="text" name="email" placeholder="Email"/>
							<small class="errorText"><?php echo $errorMsg; ?></small>
						</div>
						<button>Reset</button>
					</form>
			  </div>
		  </div>
		</div>
	</div>
</div>


<?php
	require_once 'php-includes/footer.php';
?>