package Modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import HibernateUtil.HibernateUtil;


@WebServlet("/Inserir")
public class Cadastrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		try {
			String nome = request.getParameter("nome");
			String sobreNome = request.getParameter("sobreNome");
			String usuario = request.getParameter("usuario");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String cep = request.getParameter("cep");
			
			String driver = "com.mysql.jdbc.Driver";
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String url = "jdbc:mysql://localhost:3306/demo";
			String user = "root";
			String password = "";
			
			Connection conn = (Connection) DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO Controle( nome,sobreNome,usuario,cidade,estado,cep) VALUES (?,?,?,?,?,?);";
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(sql);
			stmt.setString(1,nome);
			stmt.setString(2,sobreNome);
			stmt.setString(3,usuario);
			stmt.setString(4,cidade);
			stmt.setString(5,estado);
			stmt.setString(6,cep);
			stmt.executeUpdate();
			
			conn.close();
			
			request.getRequestDispatcher("Sucesso.jsp").forward(request,response);
		}catch(SQLException e) {
			System.out.println("Erro"+ e.toString());
		}
		
			}
		
	}


