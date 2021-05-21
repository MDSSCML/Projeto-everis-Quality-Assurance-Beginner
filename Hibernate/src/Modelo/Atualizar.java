package Modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;


@WebServlet("/Atualizar")
public class Atualizar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String nome = request.getParameter("nome");
			String sobreNome = request.getParameter("sobreNome");
			String usuario = request.getParameter("usuario");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String cep = request.getParameter("cep");
			String idt = request.getParameter("idt");
			
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		String sql = "UPDATE Controle SET nome=?, sobreNome=?, usuario=?, cidade=?, estado=?,cep=? where id=?;";
		PreparedStatement stmt;
		stmt = (PreparedStatement) conn.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.setString(2, sobreNome);
		stmt.setString(3, usuario);
		stmt.setString(4, cidade);
		stmt.setString(5, estado);
		stmt.setString(6, cep);
		stmt.setString(7, idt);
		stmt.executeUpdate();
		
		}catch(SQLException e) {
			System.out.println("Erro"+ e.toString());
		}
	}

}
