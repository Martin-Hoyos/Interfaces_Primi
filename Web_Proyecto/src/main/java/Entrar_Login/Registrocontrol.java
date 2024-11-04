package Entrar_Login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registrocontrol")
public class Registrocontrol extends HttpServlet {

		  private static final long serialVersionUID = 1L;

		    private static final String DB_URL = "jdbc:mysql://localhost:3306/registro";
		    private static final String DB_USER = "root";
		    private static final String DB_PASSWORD = "";

		    public Registrocontrol() {
		        super();
		    }

		    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        String email = request.getParameter("email");
		        String contrasenia = request.getParameter("password");

		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
 
		            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		            
		            String sql = "SELECT * FROM usuario WHERE Email = ? AND contrasenia = ?";
		            PreparedStatement stmt = conn.prepareStatement(sql);
		            stmt.setString(1, email);
		            stmt.setString(2, contrasenia);
		            ResultSet rs = stmt.executeQuery();

		            if (rs.next()) {
		            	response.sendRedirect("Princiapl.jsp");
		            } else {
		                response.getWriter().println("Aerolineas ");
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
		}
