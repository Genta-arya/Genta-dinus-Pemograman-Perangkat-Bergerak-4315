<?php
require_once 'koneksi.php';
if ($con){	
	$username_Seller = $_POST['username_Seller'];
	$password_Seller = $_POST['password_Seller'];

	$query_seller = "SELECT * FROM tb_seller WHERE username_seller = '$username_Seller' AND password_seller = '$password_Seller'";

	$result_seller = mysqli_query($con,$query_seller);
	$response = array();
	$rows = mysqli_num_rows($result_seller);

	if ($rows > 0){
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