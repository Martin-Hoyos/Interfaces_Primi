<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
<link rel="stylesheet" href="Estilos.css"> 
</head>
<body>
	<section class="main">
		<div class="conte">
			<div class="box">
				<h3 class="Bienvenidos">Bienvenidos</h3>
				<form action="Registrocontrol" method="post">
					<div class="input-box">
						<input type="email" id="email" name="email" placeholder="Email" class="control-input" required>
					</div>
					<div class="input-box">
						<input type="password" id="password" name="password" placeholder="Contraseña" class="control-input" required>
					</div>
					<div class="botones">
						<p><button type="submit" class="ingresar">Ingresar</button></p>
					</div>
						<p class="separador">———————————》✧《———————————</p>
						</form>
				<form action="Registro.jsp"  method="post">
					<div class="botones">
  						<p><button type="submit" class="nueva">Crear cuenta nueva</button></p>
					</div>
				</form>
			</div>
		</div>	
	</section>
</body>
</html>