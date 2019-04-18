
public class Usuario {

	private String nome;
	private String cidade;
	private String localidade;
	private String preferenciaHorario;
	private String estadoCivil;
	private double IntervaloValor;
	private double n_deAcompanhantes;
	private double idade;
	
	public Usuario(String nome, String cidade, String localidade,
			String preferenciaHorario, String estadoCivil, Double valor,
			Double n_deAcompanhantes, Double idade) {
		
		this.nome = nome;
		this.cidade = cidade; //cidade
		this.localidade = localidade; 	//praia, cidade, campo, spa 	
		this.preferenciaHorario = preferenciaHorario; // dia, noite, 24h
		this.estadoCivil = estadoCivil;	//solteiro, casado
		this.IntervaloValor = valor;	//valor geralmente gasto
		this.n_deAcompanhantes = n_deAcompanhantes;	// numero de acompanhantes
		this.idade = idade;
	
	}
	
	public String toString(){
		String s = nome + ", " + cidade + " "+ preferenciaHorario + ", " + localidade;
		s += ", " + IntervaloValor + ", " + estadoCivil + ", " + n_deAcompanhantes +
		" " + idade;
		return s;
	}
	
	public String getNome(){
		return nome;
	}
	
	
	public String getCidade(){
		return cidade;
	}
	
	public String getLocalidade(){
		return localidade;
	}
	
	public String getHorario(){
		return preferenciaHorario;
	}
	
	public String getEstadoCivil(){
		return estadoCivil;
	}
	
	public double getValor(){
		return IntervaloValor;
	}
	
	public double getNAcompanhantes(){
		return n_deAcompanhantes;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
