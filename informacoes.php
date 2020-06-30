<?php
$user_name = "vinicius";
$password = "Projeto@Filmes2";
$host = "%";
$db_name = "movies";
$con = mysqli_connect($host,$user_name,$password,$db_name);
$sql = "select * from tbUsuario where nome like '%gente%';";
$result = mysqli_query($con,$sql);
if(mysqli_num_rows($result)>0){

	$row = mysqli_fetch_assoc($result);

	echo json_encode(array("Nome"=>$row["nome"],"Genero"=>$row["genero"],"Descricao"=>$row["descricao"]));
}
?>