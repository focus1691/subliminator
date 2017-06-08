<?php
function get_likes($url) {
 	$json_string = file_get_contents('https://api.facebook.com/method/links.getStats?urls=' . $url . '&format=json');
 	$json = json_decode($json_string, true);
 	if(isset($json[0]['total_count'])){
	 		return intval( $json[0]['total_count'] );
 	} else { return 0;}
}

function get_tweets($url) {
    $json_string = file_get_contents('http://urls.api.twitter.com/1/urls/count.json?url=' . $url);
    $json = json_decode($json_string, true);
 	if(isset($json['count'])){
 		return intval( $json['count'] );
 	} else {return 0;}
}
  
function get_plusones($url) {
    $curl = curl_init();
    curl_setopt($curl, CURLOPT_URL, "https://clients6.google.com/rpc");
    curl_setopt($curl, CURLOPT_POST, 1);
    curl_setopt($curl, CURLOPT_POSTFIELDS, '[{"method":"pos.plusones.get","id":"p","params":{"nolog":true,"id":"' . $url . '","source":"widget","userId":"@viewer","groupId":"@self"},"jsonrpc":"2.0","key":"p","apiVersion":"v1"}]');
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($curl, CURLOPT_HTTPHEADER, array('Content-type: application/json'));
    $curl_results = curl_exec ($curl);
    curl_close ($curl);
 
    $json = json_decode($curl_results, true);
 	if(isset($json[0]['result']['metadata']['globalCounts']['count'])){
 		return intval( $json[0]['result']['metadata']['globalCounts']['count'] );
 	} else {return 0;}
}
function get_stumble($url) {
	$json_string = file_get_contents('http://www.stumbleupon.com/services/1.01/badge.getinfo?url='.$url);
	$json = json_decode($json_string, true);
	if (isset($json['result']['views'])) {
		return intval($json['result']['views']);
	} else {return 0;}
}


if(isset($_GET["thisurl"])){
	$thisUrl=$_GET["thisurl"];
	$firstpart = substr("$thisUrl", 0, 32);
	// Change http://medialoot.com to your own domain!
	if ($firstpart == 'http://www.psychotechnology.com/') {
		$data = "{";
		$data .= '"facebook": '. json_encode(get_likes($thisUrl)) . ", ";
		$data .= '"twitter": ' . json_encode(get_tweets($thisUrl)) . ", ";
		$data .= '"gplus": ' . json_encode(get_plusones($thisUrl)) . ", ";
		$data .= '"stumble": ' . json_encode(get_stumble($thisUrl)) . "}";
	} else {
		//throw error
		$data = 'ERROR - you are trying to use this script for something outside of the allowed domain';
	}

} else {
	$data = 'no data yet';
}
		
	header('Content-Type: application/json');
	echo $data;
?>