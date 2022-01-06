<?php
require_once 'koneksi.php';
if ($con){
	$username_Seller = $_POST['username_Seller'];
	$password_Seller = $_POST['password_Seller'];
	$email_Seller = $_POST['email_Seller'];

	$cek_username = mysqli_num_rows(mysqli_query($con, "SELECT * FROM tb_seller WHERE username_seller= '$username_Seller'"));
	$insert_user = "INSERT INTO tb_seller(username_seller,password_seller,email_seller) VALUES('$username_Seller','$password_Seller','$email_Seller')";
	if ( $cek_username > 0){
		echo "username telah di pakai";
	}else{
		if ($username_Seller != "" && $password_Seller != "" && $email_Seller != ""){
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
