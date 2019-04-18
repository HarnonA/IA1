
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ParaTras4 {

	public static String alvo;
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> proposicao = new ArrayList<String>();
	public static boolean resposta;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String s = "";

		// ==================================================

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
		
		System.out.println(procurar(alvo));
	}

	
	
	// ==================================================

	public static boolean procurar(String a) {
		boolean resposta = false;
		LinkedList<String> contemAlvo = new LinkedList<String>();
		contemAlvo.add(a);
		// enquanto tiver alvos para procurar
		while (!contemAlvo.isEmpty()) {

			// se alvo estiver no banco
			if (estaNoBanco(contemAlvo.get(0))) {
				contemAlvo.remove();
				resposta = true;
			}

			// se alvo nao estiver no banco
			else {
				LinkedList<String> aux = new LinkedList<String>();
				String conclusao = null;
				String temp = null;

				// procurar por todas as consequencias
				for (int i = 0; i < proposicao.size(); i++) {
					// verifica se existe a substring "->" na proposicao
					if (proposicao.get(i).contains("->")) {
						temp = proposicao.get(i);
						// recebe consequencia
						conclusao = temp.split("->")[1];
					}
					// verifica se consequencia eh igual ao alvo
					if (conclusao.equals(contemAlvo.get(0))) {
						// se sim, adiciona a lista de alvos
						aux.add(temp.split("->")[0]);
					}

				}

				if (aux.isEmpty())
					return false;
				else {
					//contemAlvo.remove();
					for (int i = aux.size()-1; i >= 0; i--)
						contemAlvo.addFirst(aux.get(i));
				}

				System.out.println("alvos: " + contemAlvo);

				// alvo nao pode ser obtido pelas regras
				if (contemAlvo.isEmpty())
					return false;
				else {
					// alvo pode ser obtido, substitua por antecedentes
					contemAlvo.remove();
					if (!contemAlvo.isEmpty()) {
						// procurar por &
						if (contemAlvo.get(0).contains("&")) {
							String[] conjuncts = contemAlvo.get(0).split("&");
							// System.out.println("X" + contemAlvo);
							// se tiver condiçao &, retire a&b
							if (conjuncts.length >= 0) {
								contemAlvo.remove();

								// adicione os atomos
								for (int i = conjuncts.length - 1; i >= 0; i--) {
									contemAlvo.addFirst(conjuncts[i]);

								}
							}
						}
					}
				}
			}
			System.out.println("Y" + contemAlvo);

		}
		System.out.println(fatos);
		return resposta;

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