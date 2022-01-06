
<?php 
	include "koneksi.php";
	$id = isset($_GET['nama_toko']) ? $_GET['nama_toko'] : '';
	class emp{}

	if (empty($id)){
		echo "toko tidak di temukans";
	}else{
		$sql = " SELECT tb_barang.id_barang,tb_barang.username_seller,tb_barang.nama_toko,tb_barang.nama_brg,tb_barang.harga_brg,tb_barang.qty FROM tb_barang,tb_toko where tb_barang.nama_toko = tb_toko.nama_toko and tb_barang.nama_toko = '".$id."'" ;
		$query = mysqli_query($con,$sql) or die(mysqli_error($con));
		$row = mysqli_fetch_array($query);

		if (!empty($row)){
			$response = new emp();
			$response->id = $row["id_barang"];
			$response->username = $row["username_seller"];
			$response->nm_toko = $row["nama_toko"];
			$response->nm_brg = $row["nama_brg"];
			$response->hrg_brg = $row["harga_brg"];
			$response->qty = $row["qty"];

			echo(json_encode($response));
		}else{
			echo("error mengambil data");
		}
	}
	mysqli_close($con);

?>
<!-- <?php
	// include 'koneksi.php';
	// $query = mysqli_query($con,"select * from tb_toko");
	// $json = array();

	// while($row = mysqli_fetch_assoc($query)){
	// 	$json[] = $row;
	// }
	// echo json_encode($json);
	// mysqli_close($con);
?> -->