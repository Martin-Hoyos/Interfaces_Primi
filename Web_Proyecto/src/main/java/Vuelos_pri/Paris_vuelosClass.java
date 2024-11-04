package Vuelos_pri;

import java.sql.Date;

public class Paris_vuelosClass {
	 private String origen;
	    private String destino;
	    private Date fecha;
	    private int precio;

	    public Paris_vuelosClass(String origen, String destino, Date fecha, int precio) {
	        this.origen = origen;
	        this.destino = destino;
	        this.fecha = fecha;
	        this.precio = precio;
	    }

	    public String getOrigen() {
	        return origen;
	    }

	    public String getDestino() {
	        return destino;
	    }

	    public Date getFecha() {
	        return fecha;
	    }

	    public int getPrecio() {
	        return precio;
	    }
	}