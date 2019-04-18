
public class Local {

	private String nome;
	private String descriçao;
	private String cidade;
	private String localidade;
	private String preferenciaHorario;
	private String estadoCivil;
	
	private double IntervaloValor;
	private double n_deAcompanhantes;
	
	// margem de erro
	private double ME_Valor = 30.00;
	private double ME_Acompanhante = 1;
	
	public Local(String nome, String descriçao, String cidade,
			String localidade, String preferenciaHorario,
			String estadoCivil, Double valor, Double n_deAcompanhantes) {
		
		this.nome = nome;
		this.descriçao = descriçao; //restaurante, bar, boate, museus, passeio, hotel...
		this.cidade = cidade; //cidade
		this.localidade = localidade; 	//praia, cidade, campo, educativo, turistico
		this.preferenciaHorario = preferenciaHorario; // dia, noite, 24h
		this.estadoCivil = estadoCivil;	//solteiro, casado, solteiro/casado
		this.IntervaloValor = valor;
		this.n_deAcompanhantes = n_deAcompanhantes;
	
	}
	
	public String toString(){
		return nome + ", " + descriçao + ", " + cidade + ", " + localidade
				+ ", " + preferenciaHorario + ", " + estadoCivil
				+ ", " + IntervaloValor + ", " + n_deAcompanhantes;
		
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getDescricao(){
		return descriçao;
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
	
	public double getMEValor(){
		return ME_Valor;
	}
	
	public double getMEAcompanhante(){
		return ME_Acompanhante;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}