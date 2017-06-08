<?php
	session_start();
	require_once __DIR__ . '/src/Facebook/autoload.php';
	include('../php-includes/phpValidate.php');

	$fb = new Facebook\Facebook([
	  'app_id' => '528492550672430',
	  'app_secret' => '30dd65c17b931aa8fa80353cbaee8638',
	  'default_graph_version' => 'v2.5'
	]);

	$helper = $fb->getJavaScriptHelper();

	try {
	  $accessToken = $helper->getAccessToken();
	  } catch(Facebook\Exceptions\FacebookResponseException $e) {
		// When Graph returns an error
		echo 'Graph returned an error: ' . $e->getMessage();
	} catch(Facebook\Exceptions\FacebookSDKException $e) {
		// When validation fails or other local issues
		echo 'Facebook SDK returned an error: ' . $e->getMessage();
	}

	if (isset($accessToken)) {
	   $fb->setDefaultAccessToken($accessToken);

	  try {
	  
		$requestProfile = $fb->get("/me?fields=name,email,first_name,last_name,gender,locale,picture,id");
		$profile = $requestProfile->getGraphNode()->asArray();
	  } catch(Facebook\Exceptions\FacebookResponseException $e) {
		// When Graph returns an error
		echo 'Graph returned an error: ' . $e->getMessage();
	  } catch(Facebook\Exceptions\FacebookSDKException $e) {
		// When validation fails or other local issues
		echo 'Facebook SDK returned an error: ' . $e->getMessage();
	  }
	  $sqlDir = "../MySQL/config.php";
	  if (!userExists($profile['email'], $sqlDir) && !fbUserExists($profile['email'], $sqlDir)) {
		  addFacebookUser($profile['first_name'], $profile['last_name'], $profile['email'], $profile['gender'], $profile['locale'], $sqlDir);
	  }
	  
	  if (!isset($_SESSION['email'])) {
		  $_SESSION['email'] = $profile['email'];
		  setcookie('email', $profile['email'], time() + 3600 * 2, "/");
		  setcookie('firstName', $profile['first_name'], time() + 3600 * 2, "/");
		  setcookie('lastName', $profile['last_name'], time() + 3600 * 2, "/");
		  setcookie('gender', $profile['gender'], time() + 3600 * 2, "/");
		  setcookie('locale', $profile['locale'], time() + 3600 * 2, "/");
		  setcookie('picture', $profile['picture'], time() + 3600 * 2, "/");
		  setcookie('id', $profile['id'], time() + 3600 * 2, "/");
	  }

	  header('location: ../');
	  exit;
	} else {
		echo "Unauthorized access!!!";
		exit;
	}
