
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ParaTras5 {

	public static String alvo;
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> proposicao = new ArrayList<String>();
	public static boolean resposta;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String s = "";
		proposicao.add("a&b->c");
		
		fatos.add("c");
		alvo = "c";

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

		// ==================================================
		*/
		//System.out.println(procurar(alvo));
		System.out.println(1*1+2*2);
	}

	
	
	// ==================================================

	public static boolean procurar(String a) {
		boolean resposta = false;
		LinkedList<String> contemAlvo = new LinkedList<String>();
		contemAlvo.add(a);
		// enquanto tiver alvos para procurar
		while (!contemAlvo.isEmpty()) {
			
		}

		
		return true;
	}
			
			
			/*
			if(estaNoBanco(contemAlvo.get(0)))
				System.out.println("PASSOU");
				//contemAlvo.remove();
			else{
			String conclusao = null;
			String temp = null;
			
			// procurar por todas as consequencias
			for (int i = 0; i < proposicao.size(); i++) {
				// verifica se existe a substring "->" na proposicao
				if (proposicao.get(i).contains("->")) {
					temp = proposicao.get(i);
					conclusao = temp.split("->")[1];

					// se alvo pode ser alcancado pela proposicao
					if (conclusao.equals(alvo)) {
						contemAlvo.add(temp.split("->")[0]);
					}
				}
			}
			// alvo nao pode ser obtido pelas regras
			if (contemAlvo.isEmpty())
				return false;
			
			//se alvo pode ser obtido pelas regras
			else {
				ArrayList<String> procure = new ArrayList<String>();
				String[] x = contemAlvo.get(0).split("&");
				// atomos necessario para obter alvo
				//for (int i = 0; i < x.length; i++) {
					//procure.add(x[i]);
				//}
				
				ArrayList<Boolean> resp = new ArrayList<Boolean>();
				//for (int i = 0; i < procure.size(); i++) {
				//	if(procurar(procure.get(i)))
						//	fatos.add(procure.get(i));
					//resposta = procurar(procure.get(i));

				//}

			}
				
			
		}
		fatos.add(contemAlvo.remove());
		}
		return resposta;
		
	}
	*/
	
	// ==================================================
	
	public static boolean estaNoBanco(String a) {
		for (int i = 0; i < fatos.size(); i++) {
			if (a.equals(fatos.get(i)))
				return true;
		}
		return false;
	}
	
	
	
}