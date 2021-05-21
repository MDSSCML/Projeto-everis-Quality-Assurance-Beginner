package Modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;



@WebServlet("/Deletar")
public class Deletar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		Connection conn =  (Connection) DriverManager.getConnection(url, user, password);
		
		String sql = "DELETE FROM Controle WHERE nome=?";
		PreparedStatement psmt = conn.prepareStatement(sql);
		String nome = request.getParameter("nome");
		
		psmt.setString(1,nome);
		
		psmt.executeUpdate();
		
		PrintWriter out=response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("<title>Document</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Arquivo.css\">");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<h1>Deletado</h1>");
		
		out.println("</body>");
		out.println("</html>");
		
		conn.close();
		}catch(SQLException e) {
			System.out.println("Erro "+ e.toString());
		}
	}
}
