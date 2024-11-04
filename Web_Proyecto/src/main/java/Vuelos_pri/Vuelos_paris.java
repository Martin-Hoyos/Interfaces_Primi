package Vuelos_pri;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Vuelos_paris")
public class Vuelos_paris extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Vuelos";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public Vuelos_paris() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	
        	
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            
            // Consulta SQL para obtener todos los vuelos con destino a "París"
            String sql = "SELECT origen, destino, fecha, precio FROM vuelos_pri WHERE destino = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "Paris"); 
            
            ResultSet rs = stmt.executeQuery();

            List<Paris_vuelosClass> paris_vuelosClass = new ArrayList<>();

            while (rs.next()) { 
            	String origen = rs.getString("Origen");
                String destino = rs.getString("Destino");
                Date fecha = rs.getDate("Fecha");
                int precio = rs.getInt("Precio");


                paris_vuelosClass.add(new Paris_vuelosClass( origen, destino, fecha, precio));
            }


            if (!paris_vuelosClass.isEmpty()) {
                request.setAttribute("Paris_vuelosClass", paris_vuelosClass);
                request.getRequestDispatcher("Vuelos_Paris.jsp").forward(request, response);
            } else {
                response.getWriter().println("No se encontraron vuelos a París.");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            response.getWriter().println("Error en la base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
