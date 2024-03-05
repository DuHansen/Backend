package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioVO {

	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	private String login;
	private String senha;
	

	public UsuarioVO(int idUsuario, String nome, String cpf, String email, LocalDate dataNascimento, String login,
			String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioVO() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
    public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataNasc = (this.dataNascimento!=null)?this.dataNascimento.format(formatador):"00/00/0000";
		return "Código da Pessoa: " + this.getIdUsuario()
             + "\nNome: " + this.nome 
             + "\nCPF: " + this.cpf 
             + "\nIdade: " + dataNasc
             + "\nLogin: " + this.login
             + "\nSenha: " + this.senha;
		}
	

	
}