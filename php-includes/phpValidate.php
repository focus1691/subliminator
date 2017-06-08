<?php

function activateUser($dir) {

    include $dir;

    if ($_SERVER['REQUEST_METHOD'] == "GET") {
        $email = $_GET['email'];
        $code = $_GET['code'];
        if (!isset($email) || !isset($code)) {
            echo 'no';
            alertUnauthorisedAccess();
        } else {
            if (userExists($email, $dir) || fbUserExists($email, $dir)) {
                if (isUserActivated($email, $dir)) {
                    alertUnauthorisedAccess();
                } else {
                    $result = mysqli_prepare($Connection, "SELECT UserID FROM Users WHERE email = ? AND verificationCode = ?");
                    mysqli_stmt_bind_param($result, 'ss', $email, $code);
                    mysqli_stmt_bind_result($result, $UserID);
                    mysqli_stmt_execute($result);
                    mysqli_stmt_store_result($result);
                    if (mysqli_stmt_num_rows($result) == 1) {
                        if (mysqli_stmt_fetch($result)) {
                            $active = 1;
                            echo '<div style="text-align: center"; class="alert alert-success">
								  Your account has been activated.</div>';
                            $sql = "UPDATE Users SET active = ? WHERE UserID = ?";
                            $stmt = $Connection->prepare($sql);
                            $stmt->bind_param('ii', $active, $UserID);
                            $stmt->execute();
                            $stmt->close();
                            mysqli_stmt_close($result);
                        }
                    } else {
                        echo '<div style="text-align: center"; class="alert alert-danger">
							  Wrong activation code</div>';
                    }
                }
            } else {
                alertUnauthorisedAccess();
            }
        }
        mysqli_close($Connection);
    }
}

function alertUnauthorisedAccess() {
    echo '<div style="text-align: center"; class="alert alert-danger">
		  Unauthorised access</div>';
}

function isUserActivated($email, $dir) {
    include $dir;
    $active = false;
    $accountActivated = 1;
    if (isset($email)) {
        $stmt = $Connection->prepare("SELECT email FROM Users WHERE email = ? AND active = ?");
        $stmt->bind_param('si', $email, $accountActivated);
        $stmt->execute();
        if ($stmt->fetch()) {
            $active = true;
        }
        $stmt->close();
    }
    mysqli_close($Connection);
    return $active;
}

function isFBUserActivated($email, $dir) {
    include $dir;
    $active = false;
    $accountActivated = 1;
    if (isset($email)) {
        $stmt = $Connection->prepare("SELECT email FROM facebookUsers WHERE email = ?");
        $stmt->bind_param('s', $email, $accountActivated);
        $stmt->execute();
        if ($stmt->fetch()) {
            $active = true;
        }
        $stmt->close();
        mysqli_close($Connection);
    }
    return $active;
}

function getVerificationCode() {
    return md5(uniqid(rand(), true));
}

function addUser($firstName, $lastName, $email, $password, $country, $verificationCode, $dir) {
    include $dir;
    if (isset($firstName) && isset($lastName) && isset($email) && isset($password) && isset($country) && isset($verificationCode)) {
        $stmt = $Connection->prepare("INSERT INTO Users (firstName, lastName, email, password, country, verificationCode) VALUES (?, ?, ?, ?, ?, ?)");
        $stmt->bind_param('ssssss', $firstName, $lastName, $email, $password, $country, $verificationCode);
        $stmt->execute();
        $stmt->close();
        mysqli_close($Connection);
    }
}

function addFacebookUser($firstName, $lastName, $email, $gender, $locale, $dir) {
    include $dir;
    if (isset($firstName) && isset($lastName) && isset($email) && isset($gender) && isset($locale)) {
        $stmt = $Connection->prepare("INSERT INTO facebookUsers (fname, lname, email, gender, locale) VALUES (?, ?, ?, ?, ?)");
        $stmt->bind_param('sssss', $firstName, $lastName, $email, $gender, $locale);
        $stmt->execute();
        $stmt->close();
        mysqli_close($Connection);
    }
}

function isValidated($error) {
    foreach ($error as $element) {
        if (!(empty($element))) {
            return false;
        }
    }
    return true;
}

function login($email, $password, $dir) {
    include $dir;
    if (isset($email) && isset($password)) {
        $stmt = $Connection->prepare("SELECT email, password FROM Users WHERE email = ?");
        $stmt->bind_param('s', $email);
        $stmt->execute();
        $stmt->bind_result($email_, $hashAndSalt);
        if ($stmt->fetch()) {
            if (password_verify($password, $hashAndSalt)) {
                return true;
            } else {
                return false;
            }
        }
        $stmt->close();
        mysqli_close($Connection);
    }
    return false;
}

function userExists($email, $dir) {
    $exists = false;
    include $dir;
    if (isset($email)) {
        $stmt = $Connection->prepare("SELECT email FROM Users WHERE email = ?");
        $stmt->bind_param('s', $email);
        $stmt->execute();
        if ($stmt->fetch()) {
            $exists = true;
        } else {
            $exists = false;
        }
        $stmt->close();
        mysqli_close($Connection);
    }
    return $exists;
}

function fbUserExists($email, $dir) {
    $exists = false;
    include $dir;
    if (isset($email)) {
        $stmt = $Connection->prepare("SELECT email FROM facebookUsers WHERE email = ?");
        $stmt->bind_param('s', $email);
        $stmt->execute();
        if ($stmt->fetch()) {
            $exists = true;
        } else {
            $exists = false;
        }
        $stmt->close();
        mysqli_close($Connection);
    }
    return $exists;
}

function codeMatches($email, $code, $dir) {
    include $dir;
    $matches = false;
    if (isset($email) && isset($code)) {
        $result = mysqli_prepare($Connection, "SELECT UserID FROM Users WHERE email = ? AND verificationCode = ?");
        mysqli_stmt_bind_param($result, 'ss', $email, $code);
        mysqli_stmt_bind_result($result, $UserID);
        mysqli_stmt_execute($result);
        mysqli_stmt_store_result($result);
        if (mysqli_stmt_num_rows($result) == 1) {
            $matches = true;
        } else {
            $matches = false;
        }
    }
    return $matches;
}

function changeCode($email, $validationCode, $dbDir) {
    include $dbDir;
    if (isset($email)) {
        $stmt = $Connection->prepare("update Users set verificationCode = ?  where email = ?");
        $stmt->bind_param('ss', $validationCode, $email);
        $stmt->execute();
        $stmt->close();
    }
}

function mailResetLink($email, $validationCode) {
    $subject = "Please reset your password";
    $message = "Click the link below to reset your password:<br/>
	<a href='http://www.psychotechnology.com/code.php?email=$email&code=$validationCode'>Reset My Password</a><br/>
	If you didn't request for a reset please ignore this email.<br/>";
	
	if (!sendEmail($email, $subject, $message)) {
			echo '<div style="text-align: center"; class="alert alert-danger">
				  Unable to send activation email.</div>';
		} else {
			echo '<div style="text-align: center"; class="alert alert-info">
				  A link to reset your password has been sent to your email address.
				  </div>';
		}
}

function sendEmail($email, $subject, $message) {
    require_once('class.phpmailer.php');
    $mail = new PHPMailer();
    $senderEmail = "noreply@psychotechnology.com";
    $senderName = "Psychotechnology";
    $mail->AddReplyTo($senderEmail, $senderName);
    $mail->SetFrom($senderEmail, $senderName);
    $mail->AddAddress($email);
    $mail->Subject = $subject;
    $mail->MsgHTML($message);
    if ($mail->send()) {
        return true;
    }
    return false;
}

function tokenGenerator() {
    $token = $_SESSION['token'] = md5(uniqid(rand(), true));
    return $token;
}

function validPasswordLength($password) {
    if (isset($password)) {
        if (strlen($password > 6)) {
            return true;
        } else {
            return false;
        }
    }
    return false;
}

function validateNumeric($postVar, $minV = null, $maxV = null) {
    if (isset($postVar) and is_numeric($postVar)) {
        if (isset($minV) and $postVar < $minV) {
            return null;
        }
        if (isset($maxV) and $postVar > $maxV) {
            return null;
        }
        return $postVar;
    } else {
        return null;
    }
}

function validateStrPattern($regex, $postVar) {
    if (isset($postVar) and preg_match($regex, $postVar)) {
        return true;
    } else {
        return false;
    }
}

function validateEmail($email) {
    $regex = '/^[_a-zA-Z0-9-]+(\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*(\.[a-zA-Z]{2,3})$/';

    if (!preg_match($regex, $email)) {
        return false;
    } else {
        return true;
    }
}
