package Modelo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


@WebServlet("/Consulta")
public class Consulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		// tipo_servidor // local_onde_esta_Servidor : porta_acesso / nome_banco_dados
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "";
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
	
		String sql = "SELECT * FROM Controle ORDER BY id asc;";
		PreparedStatement stmt = conn.prepareStatement(sql);
	
		ResultSet resultado = stmt.executeQuery();
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Lista de cadastrados</h1>");
		while(resultado.next()) {
			
			out.println("<!DOCTYPE html>");
			out.println("<html lang=pt-br>");
			out.println("<head>");
			out.println("<meta charset=\"ISO-8859-1\">");
			out.println("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
			out.println("<title>Lista</title>");
			out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"Arquivo.css\">");
			out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n" + 
					"    <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\"\r\n" + 
					"        integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"\r\n" + 
					"        integrity=\"sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV\"\r\n" + 
					"        crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					"    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n" + 
					"        integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" crossorigin=\"anonymous\">\r\n" + 
					"\r\n" + 
					"    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js\"\r\n" + 
					"        integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"\r\n" + 
					"        crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					"    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\"\r\n" + 
					"        integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"\r\n" + 
					"        crossorigin=\"anonymous\"></script>\r\n" + 
					"\r\n" + 
					"\r\n" + 
					"    <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\"\r\n" + 
					"        integrity=\"sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=\" crossorigin=\"anonymous\"></script>\r\n" + 
					"");
			out.println("</head>");
			out.println("<body>");
			out.println("<table class=\"table table-dark table-bordered\">\r\n" + 
					"  <thead>\r\n" + 
					"    <tr>\r\n" + 
					"      <th scope=\"col\">Id</th>\r\n" + 
					"      <th scope=\"col\">Nome</th>\r\n" + 
					"      <th scope=\"col\">Sobre_Nome</th>\r\n" + 
					"      <th scope=\"col\">Usuário</th>\r\n" + 
					"      <th scope=\"col\">Cidade</th>\r\n" + 
					"      <th scope=\"col\">estado</th>\r\n" + 
					"      <th scope=\"col\">Cep</th>\r\n" + 
					"    </tr>\r\n" + 
					"  </thead>\r\n" + 
					"  <tbody>\r\n" + 
					"    <tr>\r\n" + 
					"      <th scope=\"row\">"+resultado.getString("id")+"</th>\r\n" + 
					"      <td>"+resultado.getString("nome")+"</td>\r\n" + 
					"      <td>"+resultado.getString("sobreNome")+"</td>\r\n" + 
					"      <td>"+resultado.getString("usuario")+"</td>\r\n" + 
					"      <td>"+resultado.getString("cidade")+"</td>\r\n" + 
					"      <td>"+resultado.getString("estado")+"</td>\r\n" + 
					"      <td>"+resultado.getString("cep")+"</td>\r\n" + 
					"    </tr>\r\n" + 					
					"  </tbody>\r\n" + 
					"</table>");
			out.println("</body>");
			out.println("</html>");
		}		
		out.println("<a href=\"index.html\" class=\"btn btn-success btn-lg\" role=\"button\">Início</a>");			 
		 conn.close();
		}catch(SQLException e) {
			System.out.println("Erro "+ e.toString());
		}
	}

}
