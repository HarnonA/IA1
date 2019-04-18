import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class ParaTras6 {

	public static String alvo;
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> regras = new ArrayList<String>();
	public static LinkedList<String> contemAlvo = new LinkedList<String>();
	public static LinkedList<String> verificar = new LinkedList<String>();
	public static LinkedList<Boolean> bool = new LinkedList<Boolean>();
	public static boolean resposta;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String s = "";
		
		
		regras.add("t->e");
		//regras.add("f->t");
		
		regras.add("a&b%c->e");
		//regras.add("g&f&c->h");
		//regras.add("h&e->t");
		//regras.add("t->e");

		fatos.add("a");
		fatos.add("b");

		alvo = "e";

		// ==================================================
/*
		while (!s.equals(";;")) {
			System.out.print("Sentenca: ");
			// leitura de sentenca
			s = scanner.nextLine();
			// adiciona na lista de proposicao
			if (!s.equals(";;"))
				proposicao.add(s);
		}

		// ==================================================

		s = "";
		while (!s.equals(";;")) {
			System.out.print("Fatos: ");
			// leitura de fato
			s = scanner.nextLine();
			// adiciona na lista de fatos
			if (!s.equals(";;"))
				fatos.add(s);
		}

		// ==================================================

		// define alvo a ser procurado
		System.out.print("Alvo: ");
		alvo = scanner.nextLine();
		
		*/
	
		
		contemAlvo.add(alvo);
		int op = 0;
		int contador = 0;
		// enquanto houver alvo a ser buscado
		while(!contemAlvo.isEmpty()){
			System.out.println("Alvo: "+contemAlvo);
		//for (int index = 0; index < 4; index++){
			//System.out.println("XXX " + contemAlvo);
			
			
			if(contemAlvo.get(0).equals("&")){
				op = 1;
				contemAlvo.remove();
			}
			else if(contemAlvo.get(0).equals("%")){

				op = 2;
				contemAlvo.remove();
			}
			else if(contemAlvo.get(0).equals("#")){
				op = 3;
				//contemAlvo.remove();
				
			}
								
			// alvo nao esta no banco
			if(!estaNoBanco(contemAlvo.get(0))){
				LinkedList<String> conclusao = new LinkedList<String>();
				String temp = new String();
				
				
				//para todas as regras verifique se possui consequente
				for (int i = 0; i < regras.size(); i++) {
					if(regras.get(i).contains("->")){
						temp = regras.get(i).split("->")[1];
						// verifique se o alvo pode ser obtido pelas regras
						if(contemAlvo.get(0).equals(temp)){
							conclusao.add(regras.get(i).split("->")[0]);
							conclusao.add("#");
							verificar.addFirst(temp);
							
						}
					}
					
					
				}
				
				// =========================
				/*
				// remove duplicata de '#'
				for (int i = 0; i < contemAlvo.size() - 1; i++) {
					if (contemAlvo.get(i).equals("#")
							&& contemAlvo.get(i + 1).equals("#")) {
						if (contemAlvo.get(i + 2).equals("&")
								|| contemAlvo.get(i + 2).equals("%")) {
							contemAlvo.remove(i + 1);
							contemAlvo.remove(i);
						}
					}
				}
				*/
				// =========================

				
				contemAlvo.remove();
				if(!conclusao.isEmpty()){
					
					
				
					//conclusao.add("#");
				for (int j = conclusao.size()-1; j >= 0; j--) 
					contemAlvo.addFirst(conclusao.get(j));
				
			//	System.out.println("x" + contemAlvo + " " + conclusao);
				
				String[] strg = null;
				LinkedList<String> newAlvos = new LinkedList<>();
				strg = (conclusao.get(0).split(""));
				for (int i = 0; i < strg.length ; i++)
					newAlvos.add(strg[i]);
				newAlvos.remove();
				
				conclusao.clear();
				for (int i = newAlvos.size()-1 ; i >= 0 ; i--)
					conclusao.addFirst(newAlvos.get(i));
				
				//conclusao.addAll(b);
				//System.out.println(b);
				//System.out.println(conclusao);
				contemAlvo.remove();
				
				
				for (int i = conclusao.size()-1 ; i >= 0 ; i--){
					contemAlvo.addFirst(conclusao.get(i));
				}
				
				//System.out.println("xxxxx"+ contemAlvo + "\n" +conclusao );	
				
				//contemAlvo = conclusao;
				
				//contemAlvo.addFirst(conclusao.get(0));
				conclusao = null;
				}
				else{
					if(op!=3)
					bool.add(false);
				}
				
			}
			else {
				contemAlvo.remove();
				bool.add(true);
				
			}
			
			
			//System.out.println(bool + " " + contemAlvo);
			if (!bool.isEmpty() && bool.size() > 1) {
				if (op == 1) {
					if (bool.get(0).equals(bool.get(1))) {
						bool.remove(0);
					} else {
						bool.remove();
						bool.remove();
						bool.addFirst(false);
					}

				}
				// System.out.println(bool);
				if (op == 2) {
					if (bool.get(0).equals(true))
						bool.remove(1);
					else if (bool.get(1).equals(true))
						bool.remove(0);
					else {
						bool.remove();
						bool.remove();
						bool.addFirst(false);
					}
					
				} else if (op == 3) {
					if (bool.get(0).equals(true))
						fatos.add(verificar.get(0));
					verificar.remove();
					bool.remove(0);
				}
			}
			
			/*
			if(contador > 1000){
				bool.clear();
				bool.add(false);
				break;
			}
			*/
			contador++;
	

		}
		System.out.println( bool);
		
		
	}
	
	public static boolean estaNoBanco(String a) {
		for (int i = 0; i < fatos.size(); i++) {
			if (a.equals(fatos.get(i)))
				return true;
		}
		return false;
	}
	
	
	


}
