<?php

$server = "localhost";
$user = "root";
$pass = "clave";
$bd = "BDJorge";

//Creamos la conexión
$conexion = mysqli_connect($server, $user, $pass,$bd)
or die("Ha sucedido un error inexperado en la conexion de la base de datos");

//generamos la consulta
$nombre = $_GET["NOMBRE"];
$telefono = $_GET["TELEFONO"];
$poblacion = $_GET["POBLACION"];
$marca = $_GET["MARCA"];
$modelo= $_GET["MODELO"];
$matricula = $_GET["MATRICULA"];
$estado = $_GET["ESTADO"];

  $sql = "INSERT INTO CLIENTES (NOMBRE, TELEFONO, POBLACION, MARCA, MODELO, MATRICULA,ESTADO) VALUES ('$nombre', '$telefono', '$poblacion','$marca','$modelo','$matricula',$estado)";
echo $sql;

mysqli_set_charset($conexion, "utf8"); //formato de datos utf8
if (mysqli_query($conexion, $sql)) {
      echo "New record created successfully";
} else {
      echo "Error: " . $sql . "<br>" . mysqli_error($conexion);
}

//desconectamos la base de datos
$close = mysqli_close($conexion)
or die("Ha sucedido un error inexperado en la desconexion de la base de datos");




?>