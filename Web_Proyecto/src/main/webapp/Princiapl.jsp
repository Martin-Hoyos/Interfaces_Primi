<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="pres.css">
</head>
<body>
<header>
        <nav>
            <a href="#">Inicio</a>
            <a href="#ofertas">Ofertas</a>
           	<form action="Vuelos_existentes" method="post" style="display: inline;">
		    <button type="submit" class="boton-enlace">Destinos</button>
			</form>
            <a href="#contacto">Contacto</a>
            <a href="NewFile.jsp">Iniciar Sesión</a>
        </nav>
        <section class="header">
            <h1>Bienvenido</h1>
            <h2>Descubre el mundo con precios increíbles</h2>
            <div class="barra-busqueda">
            	<form action="Vuelos" method="post">
                <input type="text" placeholder="Origen" id="Origen" name="Origen" required>
                <input type="text" placeholder="Destino" id="Destino" name="Destino" required>
                <input type="date" id="salida" name="salida" >
                <button type="submit">Buscar Vuelos</button>
                </form>
            </div>
        </section>
    </header>

    <main>
<section id="ofertas" class="contenido">
    <h2 class="titulo">Ofertas Exclusivas</h2>
    <div class="tarjetas-oferta">
        <div class="tarjeta-oferta">
            <form action="Viajes_London" method="post">
                <button type="submit" name="Destino" value="Londres" style="border: none; background: none; padding: 0; cursor: pointer;">
                    <img src="Imagenes/London.gif" alt="Londres" style="width: 100%; height: auto;">
                    <h4 style="color: inherit;">Londres</h4>
                    <p style="color: inherit;">Viaje ida y vuelta</p>
                </button>
            </form>
        </div>
        
        <div class="tarjeta-oferta">
            <form action="Vuelos_paris" method="post">
                <button type="submit" name="Destino" value="Paris" style="border: none; background: none; padding: 0; cursor: pointer;">
                    <img src="Imagenes/Paris.gif" alt="París" style="width: 100%; height: auto;">
                    <h4 style="color: inherit;">París</h4>
                    <p style="color: inherit;">Viaje ida y vuelta</p>
                </button>
            </form>
        </div>
        
        <div class="tarjeta-oferta">
            <form action="Viajes_EEUU" method="post">
                <button type="submit" name="Destino" value="Nueva York" style="border: none; background: none; padding: 0; cursor: pointer;">
                    <img src="Imagenes/new-york-city.gif" alt="Nueva York" style="width: 100%; height: auto;">
                    <h4 style="color: inherit;">Nueva York</h4>
                    <p style="color: inherit;">Viaje ida y vuelta</p>
                </button>
            </form>
        </div>
    </div>
</section>


        <section id="destinos" class="contenido">
            <h2 class="titulo">Destinos Populares</h2>
            <div class="galeria-destinos">
                <div class="imagen-destino">
                    <img src="Imagenes/Madrid.gif" alt="Madrid">
                    <p>Madrid</p>
                </div>
                <div class="imagen-destino">
                    <img src="Imagenes/Roma.gif" alt="Roma">
                    <p>Roma</p>
                </div>
                <div class="imagen-destino">
                    <img src="Imagenes/tokio.gif" alt="Tokio">
                    <p>Tokio</p>
                </div>
            </div>
        </section>
    </main>

    <footer>
        <div class="pie">
            <p>&copy; Todos los derechos reservados</p>
        </div>
    </footer>
</body>
</html>