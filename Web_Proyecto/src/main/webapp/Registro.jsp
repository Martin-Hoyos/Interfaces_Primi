<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Estilo_Registro.css"> 
</head>
<body>
		<section class="contenedor">
		<div class="conten">
		<div class="box">
		<h3 class="registro">Registro</h3>
			<form action="LoginControler" method="post">	
			<p>╔══════════════  ≪ °❈° ≫ ══════════════╗</p>
			<div class="input-box">
			<input type="text" id="nombre" name="nombre" placeholder="Nombre Completo"  class="control-input" required>
			</div>
			<div class="input-box">
			<input type="email" id="Email" name="email" placeholder="Email" class="control-input" required>
			</div>
			<div class="input-box">
			<input type="password" id="password" name="password" placeholder="Contraseña" class="control-input" required>
			</div>
			<div class="boton">
				<p><button type="submit" class="registar">Registar</button></p>
			</div>
			<p>╚══════════════ ≪ °❈° ≫ ══════════════╝</p>
			</form>
		</div>
		</div>
		</section>
</body>
</html>