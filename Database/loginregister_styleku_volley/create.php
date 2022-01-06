<?php
require_once 'koneksi.php';
if ($con){
	$username_User = $_POST['username_User'];
	$password_User = $_POST['password_User'];
	$email_User = $_POST['email_User'];

	$cek_username = mysqli_num_rows(mysqli_query($con, "SELECT * FROM tb_user WHERE username_user= '$username_User'"));
	$insert_user = "INSERT INTO tb_user(username_user,password_user,email_user) VALUES('$username_User','$password_User','$email_User')";
	if ( $cek_username > 0){
		echo "username telah di pakai";
	}else{
		if ($username_User != "" && $password_User != "" && $email_User != ""){
			$result = mysqli_query($con,$insert_user);
			$response = array();
			
			if ($result){
				array_push($response, array(
				'status' => 'OK'
				));
			}else{
				array_push($response, array(
				'status' => 'FAILED'
				));
			}
		}else {
			array_push($response, array(
				'status' => 'FAILED'
			));	
		}
	}	
}else{
	array_push($response, array(
		'status' => 'FAILED'
	));
}
echo json_encode(array("server_response" => $response));
mysqli_close($con);
?>
