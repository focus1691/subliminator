<?php
	ob_start();
	$pageTitle = "PsychoTechnology | Set a New Password";
	$pageDescription = "Set a New Password to Download and Play our Psychology Apps and Games. Learn More About your Mind Today!";
	require_once 'php-includes/header.php';
	
    $error = array(
		"passwords" => "",
    );

	if(isset($_SESSION['newPassEmail'])) {
		if ($_SERVER['REQUEST_METHOD'] == 'POST') {
	
			include 'MySQL/config.php';
			include 'php-includes/phpValidate.php';
			
			if (empty($_POST['password'])) { $error['passwords'] = "Password is required."; }
			else if (empty($_POST['password2'])) { $error['passwords'] = "Retype confirmation password"; }
			else if ($_POST['password'] !== $_POST['password2']) { $error['passwords'] = "Passwords don't match."; }
			else { $_POST['password'] = password_hash($_POST['password'], PASSWORD_BCRYPT); }

			if (empty($error['passwords'])) {
				$password =  mysqli_real_escape_string($Connection, $_POST['password']);
				$validationCode = md5(uniqid(rand(), true));
				$stmt = $Connection->prepare("update users set password = ? ,  verificationCode = ?  where email = ?");
				$stmt->bind_param('sss', $password, $validationCode, $_SESSION['newPassEmail']);
				$stmt->execute();
				$stmt->close();
				unset($_SESSION['newPassEmail']);
				setcookie('resetPass', "OK", time() - 1, "/");
				echo '<div style="text-align: center"; class="alert alert-success">
					  Your password has been successfully reset.
					  </div>';
			}
		}
	} else {
		echo '<div style="text-align: center"; class="alert alert-danger">
		      You do not have permission to access this page.</div>';
	}
?>
<div class="container">
	<div class="row">
		<div  class="module form-module form loginForm">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="login">
				<form action="<?php echo htmlentities("new-password"); ?>" method="post" class="ajax">
					<div>
						<input type="password" name="password" placeholder="Set a New Password" maxlength="30">
					</div>
					<div>
						<input type="password" name="password2" placeholder="Retype Password" maxlength="30"><br/>
						<small class="errorText"><?php echo $error['passwords']; ?></small>
					</div>
					<button type="submit"  class="animated zoomIn">Submit</button>
				</form>
			</div>
		</div>
	</div><!--row end-->
</div>

<?php
	require_once 'php-includes/footer.php';
?>