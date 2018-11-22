<?php

$server = "localhost";
$user = "root";
$pass = "clave";
$bd = "BDJorge";

//Creamos la conexión
$conexion = mysqli_connect($server, $user, $pass,$bd)
or die("Ha sucedido un error inexperado en la conexion de la base de datos");

//generamos la consulta
$sql = "SELECT * FROM CLIENTES";
mysqli_set_charset($conexion, "utf8"); //formato de datos utf8

if(!$result = mysqli_query($conexion, $sql)) die();

$clientes = array(); //creamos un array

while($row = mysqli_fetch_array($result))
{
    $cnombre=$row['NOMBRE'];
    $telefono=$row['TELEFONO'];
    $poblacion=$row['POBLACION'];
    $marca=$row['MARCA'];
    $modelo=$row['MODELO'];
    $matricula=$row['MATRICULA'];
    $estado=$row['ESTADO'];

    $clientes[] = array('NOMBRE'=> $cnombre, 'TELEFONO'=> $telefono,'POBLACION'=> $poblacion,'MARCA'=> $marca,'MODELO'=> $modelo,'MATRICULA'=>$matricula,'ESTADO'=>$estado);

}

//desconectamos la base de datos
$close = mysqli_close($conexion)
or die("Ha sucedido un error inexperado en la desconexion de la base de datos");


//Creamos el JSON
$json_string = json_encode($clientes);
// Añadimos cabecera y final
// debe ser como el nombre del array en  class GuitarraArray

$json_string = '{ "clientes":' . $json_string . "}";
echo $json_string;

//Si queremos crear un archivo json, sería de esta forma:
/*
$file = 'clientes.json';
file_put_contents($file, $json_string);
*/


?>