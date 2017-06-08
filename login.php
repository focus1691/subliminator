<?php
ob_start();
$pageTitle = "PsychoTechnology | Login to your Account";
$pageDescription = "Login to your Account to Download and Play our Psychology Apps and Games. Learn More About your Mind Today!";
require_once 'php-includes/header.php';

if (isset($_SESSION['email'])) {
    header("Location: ../");
}

include 'php-includes/phpValidate.php';

$error = array(
    "email" => "",
    "password" => ""
);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $sqlDir = "MySQL/config.php";
    include $sqlDir;
    $_POST['email'] = mysqli_real_escape_string($Connection, $_POST['email']);
    $_POST['password'] = mysqli_real_escape_string($Connection, $_POST['password']);

    if (userExists($_POST['email'], $sqlDir)) {
        if (login($_POST['email'], $_POST['password'], $sqlDir)) {
            $_SESSION['email'] = $_POST['email'];
            $_SESSION['password'] = $_POST['password'];
            setcookie('email', $_SESSION['email'], time() + 3600 * 2, "/");
            setcookie('password', $_SESSION['password'], time() + 3600 * 2, "/");
            header('Location: ./');
        } else {
            $error['password'] = "Wrong password";
        }
    } else {
        $error['email'] = "Email not found";
    }
    mysqli_close($Connection);
    ob_end_flush();
}
?>
<div class="container">
    <div class="row">
        <div id="fb-root"></div>
        <script type="text/javascript" src="fbapp/fb.js"></script>
        <div class="module form-module form loginForm">
            <div class="toggle"></div>
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" id="login">
                <h2>Login to your account</h2>
                <form action="<?php echo htmlentities("login"); ?>" method="post" class="ajax">
                    <div>
                        <input type="text" name="email" placeholder="Username"/>
                        <small class="errorText"><?php echo $error['email']; ?></small>
                    </div>
                    <div>
                        <input type="password" name="password" placeholder="Password"/>
                        <small class="errorText"><?php echo $error['password']; ?></small>
                    </div>
                    <div>
                        <button class="animated zoomIn">Login</button>
                    </div>
                    <?php if (!isset($_COOKIE['email'])) { ?>
                        <div class="fb-login-button" data-scope="public_profile, email" onlogin="checkLoginState();" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false"></div>
                    <?php } ?>
                </form>
                <div class="cta"><a href="recover">Forgot your password?</a></div>
            </div>
        </div>

        <p>
            <?php
            if (isset($_SESSION['email'])) {
                echo $_SESSION['email'];
            }
            ?> 
        </p>

        <p>
            <?php
            if (isset($_COOKIE['email'])) {
                echo "LOGGED IN, to log out <a href='logout.php'>click here</a>.<br/>";
            }
            ?>
        </p>
    </div>
</div>



<?php
require_once 'php-includes/footer.php';
