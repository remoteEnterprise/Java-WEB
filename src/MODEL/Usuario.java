package MODEL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="primeiro_nome")
	private String primeiroNome;
	
	@Column(name="ultimo_nome")
	private String ultimoNome;
	
	@Column(name="idade")
	private int idade;
	
	@Column(name="nascimento")
	private String nascimento;
	
	@Column(name="cpf")
	private String cpf;
	
	public Usuario(String pn, String un, int idade, String nascimento, String cpf) {
		this.primeiroNome = pn;
		this.ultimoNome = un;
		this.idade = idade;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}
	
	public Usuario() {
		this("unknown", "unknown", 0, "0000-00-00", "unknown");
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Usuario [primeiroNome=" + primeiroNome + ",\nultimoNome=" + ultimoNome + ",\nidade=" + idade
				+ ",\nnascimento=" + nascimento + ",\ncpf=" + cpf + "]";
	}
	
	public String toStringGET() {
		return "primeiroNome=" + this.primeiroNome + "&ultimoNome=" + this.ultimoNome + "&idade=" + this.idade
				+ "&nascimento=" + this.nascimento + "&cpf=" + this.cpf;
	}
}
