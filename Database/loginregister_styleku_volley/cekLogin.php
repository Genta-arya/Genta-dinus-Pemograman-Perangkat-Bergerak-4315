<?php
require_once 'koneksi.php';
if ($con){
	$username_Users = $_POST['username_User'];
	$password_User = $_POST['password_User'];
	

	$query_user = "SELECT * FROM tb_user WHERE username_user = '$username_Users' AND password_user = '$password_User' ";
	
	
	$result = mysqli_query($con,$query_user);
	$response = array();
	$row = mysqli_num_rows($result);
	
	if ($row > 0){
		array_push($response, array(
			'status' => 'OK'
		));
	}else {
		array_push($response, array(
			'status' => 'FAILED'
		));
	}
}else {
		array_push($response, array(
			'status' => 'FAILED'
		));
	}
echo json_encode(array("server_response" => $response));
mysqli_close($con);
?>
