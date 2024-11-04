package Controlador;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginControler")
public class LoginControler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/registro";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public LoginControler() {
        super();
    }	

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombreCompleto = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasenia = request.getParameter("password");

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            String sql = "INSERT INTO usuario (Nombre_completo, Email, contrasenia) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreCompleto);
            stmt.setString(2, email);
            stmt.setString(3, contrasenia);

            int rowsInserted = stmt.executeUpdate();

            if (rowsInserted > 0) {
                response.getWriter().println("¡Registro exitoso!");
            } else {
                response.getWriter().println("Error: No se pudo registrar el usuario.");
            }

        } catch (ClassNotFoundException e) {
            response.getWriter().println("Error: Driver de MySQL no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            response.getWriter().println("Error: No se pudo conectar a la base de datos o insertar los datos.");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                response.getWriter().println("Error al cerrar la conexión a la base de datos.");
                e.printStackTrace();
            }
        }
    }
}

