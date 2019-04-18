import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class ParaTras {
	
	public static String alvo;
	public static String resposta = "Nao";
	
	
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> proposicao = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner( System.in );
		
		String s = "";
		//na forma: a&b->c
		// ;; para sair
		while(!s.equals(";;")){
			
			System.out.print("Sentenca: ");
			//leitura de sentenca
			s = scanner.nextLine();
			//adiciona na lista de clausulas
			if(!s.equals(";;"))
			proposicao.add(s);
		}
		
		s = "";
		while(!s.equals(";;")){
			
			System.out.print("Fatos: ");
			//leitura de fato
			s = scanner.nextLine();
			//adiciona na lista de clausulas
			if(!s.equals(";;"))
			fatos.add(s);
		}
		
		//define alvo a ser procurado
		System.out.print("Alvo: ");
		alvo = scanner.nextLine();
		
		//System.out.println(clausulas.toString());
		//System.out.println(fatos.toString());
		//System.out.println(alvo);
		
		
		
		
		//se alvo ja estiver no banco
		for(int i = 0 ; i < fatos.size() ; i++){
			if(alvo.equals(fatos.get(i)))
				resposta = "Sim";
		}
		
		//se alvo nao esta no banco
		if(resposta.equals("Nao")){
			String conclusao = null;
			String temp = null;
			LinkedList<String> contemAlvo = new LinkedList<String>();

			for(int i = 0 ; i < proposicao.size() ; i++){
				//verifica se existe a substring "->" nas clausulas
				if(proposicao.get(i).contains("->")){
					temp = proposicao.get(i);
					conclusao = temp.split("->")[1];
					if(conclusao.equals(alvo)){
						
						
						contemAlvo.add(temp.split("->")[0]);
						System.out.println("ok");
					}
					
				}
				System.out.println(contemAlvo);					
			}
	
			//se alvo nao pode ser alcançado pelas sentenças
			if(contemAlvo.isEmpty())
				System.out.println("Nao");
			
			
			
			else{
				for(int j = 0 ; j < contemAlvo.size() ; j++){
				
					
					
				}
				
			}
			
			
		}
		
		System.out.println(resposta);	
			
	
	
		
		
	}
	
	public static boolean test(){
		
		String conclusao = null;
		String temp = null;
		LinkedList<String> contemAlvo = new LinkedList<String>();
		
		for(int i = 0 ; i < proposicao.size() ; i++){
			//verifica se existe a substring "->" nas clausulas
			
			if(proposicao.get(i).contains("->")){
				temp = proposicao.get(i);
				conclusao = temp.split("->")[1];
				
				if(conclusao.equals(alvo)){
					contemAlvo.add(temp.split("->")[0]);
					return true;
				}
			}				
		}
		return false;
	}
	

}
