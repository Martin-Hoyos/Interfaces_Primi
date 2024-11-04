package Vuelos_pri;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vuelos")
public class Vuelos extends HttpServlet  {
	

	 private static final long serialVersionUID = 1L;

	    private static final String DB_URL = "jdbc:mysql://localhost:3306/Vuelos";
	    private static final String DB_USER = "root";
	    private static final String DB_PASSWORD = "";

	    public Vuelos() {
	        super();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String Origen = request.getParameter("Origen");
	        String Destino = request.getParameter("Destino");
	        String fechaString = request.getParameter("salida");
	        try {
	
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate fechaLocalDate = LocalDate.parse(fechaString, formatter);
	            
	 
	            Date sqlDate = Date.valueOf(fechaLocalDate);

	            
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	            
	            // Consulta SQL
	            String sql = "SELECT * FROM vuelos_pri WHERE Origen = ? AND Destino = ? AND Fecha = ?";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, Origen);
	            stmt.setString(2, Destino);
	            stmt.setDate(3, sqlDate); 
	            
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	            	
	                List<Vuelo> vuelos = new ArrayList<>();
	                do {
	                    String origen = rs.getString("Origen");
	                    String destino = rs.getString("Destino");
	                    Date fecha = rs.getDate("Fecha");
	                    int precio = rs.getInt("Precio");

	                    vuelos.add(new Vuelo(origen, destino, fecha, precio));
	                } while (rs.next());

	       
	                request.setAttribute("vuelos", vuelos);
	                request.getRequestDispatcher("Vuelo.jsp").forward(request, response);
	            } else {
	                response.getWriter().println("Vuelo no encontrado.");
	            }


	            rs.close();
	            stmt.close();
	            conn.close();

	        } catch (SQLException e) {
	            response.getWriter().println("Error en la base de datos: " + e.getMessage());
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	}