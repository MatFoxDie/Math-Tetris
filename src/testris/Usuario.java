
package testris;

public class Usuario {
	int id;
	String nome, login, dificuldade;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return login;
	}
	
	public void setDificuldade(String dificuldade) {
		this.dificuldade = dificuldade;
	}
	public String getDificuldade() {
		return dificuldade;
	}
}
