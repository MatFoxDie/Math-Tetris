package testris;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import testris.Usuario;


public class Cadastro {
	
	public boolean cadastar(Usuario usuario){
		Connection conn = null;
		Conexao conexao = new Conexao();
		
		try {
			String sql = "Insert into tbtetris (nome,pontos,dificuldade) values (?, ?, ?)";
			conn = conexao.getConexao();
			PreparedStatement pstm = conn.prepareCall(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getLogin());
			pstm.setString(3, usuario.getDificuldade());
			pstm.execute();
			
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}finally{
			conexao.Fechar(conn);
		}
		
	}
	//select
	public ArrayList<Usuario> listar(){
		ArrayList<Usuario> usuario = new ArrayList<Usuario>();
		Connection conn = null;
		Conexao conexao = new Conexao();
		
		try{
			String sql = "select * from tblogin";
			conn = conexao.getConexao();
			PreparedStatement pstm = conn.prepareCall(sql);
			ResultSet rs =  pstm.executeQuery();
			while(rs.next()){
				Usuario c= new Usuario();
				c.setId(rs.getInt("idLogin"));
				c.setNome(rs.getString("nomeLogin"));
				c.setLogin(rs.getString("emailLogin"));
				usuario.add(c);
			}
			return usuario;
		}catch(Exception e){
			System.err.println(e.getMessage());
			
			return null;
		}finally{
			conexao.Fechar(conn);
		}
	}
}

