package testris;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public Connection getConexao(){
		String servidor = "localhost";
		String banco = "bdtetris";
		String root = "root";
		String senha = "";
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			String path = "jdbc:mysql://"+servidor+":3306/"+banco;
			Connection con = DriverManager.getConnection(path,root,senha);
			return con;
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}
	public void Fechar(Connection con){
		if(con!=null){
			try{
				con.close();
			}catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
	}
}