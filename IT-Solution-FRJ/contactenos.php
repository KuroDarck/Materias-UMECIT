<?php
session_start();
$DateAndTime2 = time();
$nombre=$_POST['nombre'];
$telefono=$_POST['telefono'];
$email=$_POST['email'];
$mensaje=$_POST['mensaje'];

$db_server ="localhost";
	$db_user= "root";
	$db_pass = "";
	$db_database = "bdclase2";
	$conexion =mysqli_connect($db_server,$db_user,$db_pass,$db_database);
	if (mysqli_connect_error()){
		$texto= "No se pudo establecer conexión a la base de datos";
	}else{
		$sql_insert = "INSERT INTO contactos(nombre, telefono,email,mensaje) 
		VALUES ('$nombre','$telefono','$email','$mensaje')";
	
		 $resultado = mysqli_query($conexion,$sql_insert);
		 if ($resultado == false){
      $texto="Error de insert";
		 }else {
      $texto="Guardado correctamente.";
		 } 
	}
 echo'<!DOCTYPE html>
 <html lang="en">
   <head>
     <meta charset="UTF-8" />
     <meta name="viewport" content="width=device-width, initial-scale=1.0" />
     <link rel="stylesheet" type="text/css" href="./contactenos.css" />
      <link rel="icon" href="./Imagenes/LogoItSolution.png">
     <title>Informacion</title>
   </head>
   <body>
     <header class="head">
       <img src="./Imagenes/LogoItSolution.png" alt="LogoIT" class="img" />
       <h2 class="Rption">
         <a class="Label" href="./index.html">INICIO</a>
         <a class="Label" href="./servicios.html" target="_blank">SERVICIOS</a>
         <a class="Label" href="./nosotros.html" target="_blank">NOSOTROS</a>
         <a class="Label" href="./contactenos.html">CONTACTENOS</a>
       </h2>
     </header>
     <h1 class= "enviado"> Enviado exitosamente </h1>
     '

     ;

     
 echo '    <footer id="foot">
       <img src="./Imagenes/ItSolucionSiguenos.png" id="posimg" />
 
       <a href="https://www.facebook.com/"
         ><img src="./Imagenes/ItSolucionFacebook.png" class="imgb" id="posimg1"
       /></a>
 
       <a href="https://www.instagram.com/"
         ><img src="./Imagenes/ItSolucionInstagram.png" class="imgb"id="posimg2"
       /></a>
 
       <a href="https://twitter.com/"
         ><img src="./Imagenes/ItSolucionTwitter.png" class="imgb" id="posimg3"
       /></a>
     </footer>
   </body>
 </html>
 ';
  ?>