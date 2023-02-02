<?php
	$nombre = $_POST['fname'];
	$cedula = $_POST['cedula'];
	$email = $_POST['email'];
	$fecha = $_POST['fecha'];
	$sucursal = $_POST['sucursal'];
	$genero = $_POST['genero'];
	$clave = $_POST['clave'];
	echo '<!DOCTYPE html><html lang="es"><head>	
	<meta charset="UTF-8">	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./EstiloFormulario.css">
	<title>Datos del Empleado</title>
	</head> <body id="pHp">';
	echo  '<h1 id="Titulo">Información Recibida del Empleado</h1>';
	echo   '<h3 id="PHp">Nuevo Empleado: '.$nombre.'</h3>';
	echo   '<h3 id="PHp">Cédula: '.$cedula.'</h3>';
	echo  '<h3 id="PHp">Correo Electrónico: '.$email.'</h3>';
	echo  '<h3 id="PHp">Cumpleaños: '.$fecha.'</h3>';
	echo   '<h3 id="PHp">Sucursal: '.$sucursal.'</h3>';
	echo   '<h3 id="PHp">Género: '.$genero.'</h3>';
			
	echo '<img src="./LOGO_umecit.png" alt="Logo" width="30%">
	<h4 class="inte">Johana Sierra</h4>
	<h4 class="inte">Francisco Romaña</h4>
	<h4 class="inte">Ricardo Herrera</h4>
	</body></html>	';	
	$db_server ="localhost";
	$db_user= "root";
	$db_pass = "";
	$db_database = "bdclase2";
	$conexion =mysqli_connect($db_server,$db_user,$db_pass,$db_database);
	if (mysqli_connect_error()){
		echo "No se pudo establecer conexión a la base de datos";
	}else{
		$sql_insert = "INSERT INTO empleados(nombre, cedula,correo,clave,
		sucursal,fecha_nac,genero) 
		VALUES ('$nombre','$cedula','$email','$clave','$sucursal','$fecha','$genero')";
	
		 $resultado = mysqli_query($conexion,$sql_insert);
		 if ($resultado == false){
			 echo "Error de insert";
		 }else {
			 echo "Guardado correctamente.";
		 } 
	}

			
			 
?>


