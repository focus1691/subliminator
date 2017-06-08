<?php
session_start();
include_once("php-includes/analyticstracking.php");
ini_set('session.cookie_httponly', 1);
ini_set('session.use_only_cookies', 1);
ini_set('session.cookie_secure', 1);
?>

<!DOCTYPE html>
<html lang="en">
    <head>
		<script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
		<script>
		  (adsbygoogle = window.adsbygoogle || []).push({
			google_ad_client: "ca-pub-1038793067071777",
			enable_page_level_ads: true
		  });
		</script>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="<?php echo $pageDescription?>" />
        <meta name="keywords" content="psychology, psych, psychology tools, psychology games, subliminal messages" />

        <title><?php echo $pageTitle?></title>

        <!--IE10 viewport hack for Surface/desktop Windows 8 bug-->
        <link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

        <!--favicon-->
		
		<!-- IOS versions 7 and 6 -->
		<link rel="apple-touch-icon" sizes="57x57" href="favicons/apple-touch-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="114x114" href="favicons/apple-touch-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="72x72" href="favicons/apple-touch-icon-72x72.png">    
		<link rel="apple-touch-icon" sizes="144x144" href="favicons/apple-touch-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="60x60" href="favicons/apple-touch-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="120x120" href="favicons/apple-touch-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="76x76" href="favicons/apple-touch-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="152x152" href="favicons/apple-touch-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="favicons/apple-touch-icon-180x180.png">
		
		<!-- Chrome home screen icon -->
		<link rel="icon" href="favicons/android-chrome-192x192.png">
		
        <link rel="icon" href="favicons/favicon-32x32.png">

        <!-- Bootstrap Core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/animate.css" rel="stylesheet">

        <!--FontAwesome CSS-->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		
        <!--Main CSS-->
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <!--Media Queries CSS-->
        <link href="css/media.css" rel="stylesheet" type="text/css"/>
		
		<link href="css/subscribe.css" rel="stylesheet" type="text/css"/>

        <!--Media Queries CSS-->
        <link href="css/custom.css" rel="stylesheet" type="text/css"/>
		
		<!--Cross-browser Consistency CSS-->
		<link href="css/normalize.css" rel="stylesheet" type="text/css"/>
		
		<!-- JQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    </head>
	
    <body>
        <div class="container-fluid">
            <div class="row">
                <!-- navbar -->
                <nav class="navbar navbar-default wrapper">
                    <div class="container">
                        <div class="navbar-header">
                            <div class="navLogo">
                                <a href="./" title="PsychoTechnology Home"><img src="images/logo.png" class="img-responsive" id="logo" alt="Logo"/></a>
                            </div>
                            <button type="button" class="navbar-toggle collapsed navButton" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                        </div><!--navbar header-->
                        <div id="navbar" class="collapse navbar-collapse pull-left navMenu">
                            <ul class="nav navbar-nav">
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Psychology Apps&nbsp;&nbsp;<span class="caret manuCaret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="mind-booster" title="Mind Booster">Mind Booster</a></li>
                                        <li><a href="attentional-network-task" title="Attentional Network Task">Attentional Network Task</a></li>
                                    </ul>
                                </li>
                                <li><a href="about" title="About us">About</a></li>
                            </ul><!--navbar nav end-->
                        </div><!--/.nav-collapse -->
                        <!--Login & Register Buttons-->
                        <div class="menuRightBtn">
							<?php
								if (!isset($_SESSION['email'])) {
									echo '<div class="log">';
									echo '<a href="login"><button class="loginBtn"><span class="glyphicon glyphicon-log-in"></span> LOGIN</button></a>';
									echo '</div>';
									echo '<div class="reg">';
									echo '<a href="register"><button class="registerBtn"><span class="glyphicon glyphicon-user"></span> REGISTER</button></a>';
									echo '</div>';
								} else {
									echo '<div class="log">';
									echo '<a href="logout"><button class="loginBtn"><span class="glyphicon glyphicon-log-in"></span> LOGOUT</button></a>';
									echo '</div>';
								}
							?>
                        </div>
                    </div><!--container end-->
                </nav><!--navbar end-->
            </div>
        </div>
        <!--Header Container-fluid End-->

        <noscript>
			<style>
				#site {
					display: none;
				}
				header, footer {
					opacity: 0.65;
				}
			</style>
			<div class="noscript">
				<h1>JavaScript is not enabled in your browser</h1>
				<p>You must enable JavaScript for the site to run properly.</p>
			</div>
        </noscript>

        <!--Begin page content -->
        <div class="container-fluid contentWrapper" id="site">
            <div class="row">