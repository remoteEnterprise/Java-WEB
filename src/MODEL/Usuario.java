package MODEL;

public class Usuario {
	private String primeiroNome;
	private String ultimoNome;
	private int idade;
	private Date nascimento;
	private String cpf;
	
	public Usuario(String pn, String un, int idade, Date nascimento, String cpf) {
		this.primeiroNome = pn;
		this.ultimoNome = un;
		this.idade = idade;
		this.nascimento = nascimento;
		this.cpf = cpf;
	}
	
	public Usuario() {
		this("unknown", "unknown", 0, new Date("0000-00-00"), "unknown");
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
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
