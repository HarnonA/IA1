import java.util.*;
import java.io.*;

/*
 * o simbolo & representa a operaçao logica 'e'
 * o simbolo # representa a operaçao logica "ou"
 * 
 * É definido um conjunto de regras, base de conhecimento (fatos)
 * e um alvo o qual se deseja provar por inferencia
 * O sistema define se uma regra é verdadeira ou falsa, 
 * caso verdadeira, seu consequente é adicionado na BC.
 * Se o alvo o qual se deseja provar estiver na base de conhecimento
 * entao a resposta é verdadeira, caso contrario é falsa
 */

class ForwardFinal {

	public static String alvo;
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> regras = new ArrayList<String>();
	public static LinkedList<String> contemAlvo = new LinkedList<String>();
	public static LinkedList<Boolean> bool = new LinkedList<Boolean>();
	public static LinkedList<String> eou = new LinkedList<String>();

	public static boolean estado;
	public static boolean mudouBC;

	public ForwardFinal(String a, String t) {
	}

	public static void main(String[] args) {

		// regras
		regras.add("d&e->f");
		regras.add("c#f&j->k");
		regras.add("n->j");

		// base de conhecimento
		fatos.add("d");
		fatos.add("c");
		fatos.add("n");

		// alvo a ser provado
		alvo = "k";

		int k = 0;

		while (!regras.isEmpty()) {
			estado = false;

			// procura se alvo esta na base de conhecimento
			// se estiver na BC, busca acabou, retorna verdadeiro
			for (int i = 0; i < fatos.size(); i++) {
				if (alvo.equals(fatos.get(i))) {
					estado = true;
					break;
				}
			}
			if (estado) {
				bool.addFirst(true);
				break;
			}

			// caso contrario varra as regras a procura de novos dados
			else {
				// separa os atomos e operadores de uma regra
				String[] strg = (regras.get(k).split(""));
				for (int i = 1; i < strg.length; i++)
					contemAlvo.add(strg[i]);

				// destrincha a regra
				// nao verifica o consequente da regra
				for (int i = 0; i < contemAlvo.size() - 3; i++) {

					boolean contidoNaBase = false;
					// verifica se é um atomo ou operador
					if (contemAlvo.get(i).equals("&"))
						eou.add("&");
					else if (contemAlvo.get(i).equals("#")) {
						eou.add("#");
					}

					// verifica se o elemento pesquisado esta
					// contido na BC
					else {

						// se estiver na BC, encerra o loop
						// utiliza flag para determinar se esta contido ou nao
						// na BC
						for (int j = 0; j < fatos.size(); j++) {

							if (contemAlvo.get(i).equals(fatos.get(j))) {
								contidoNaBase = true;
								break;
							} else {
								contidoNaBase = false;
							}

						}

						// se o elemento esta na BC, coloque como verdadeiro
						// numa lista para representar a regra
						if (contidoNaBase == true)
							bool.add(true);
						else
							bool.add(false);
					}

				}

				// compara se o consequente da regra V ou F
				// utilizando a lista de operadores e de elementos V/F
				while (bool.size() > 1) {
					boolean b1, b2;
					b1 = bool.remove(0);
					b2 = bool.remove(0);

					// verifica o operador e dá o resultado para
					// tal operaçao
					// da esquerda para direita
					if (eou.get(0).equals("&")) {
						if (b1 == b2)
							bool.addFirst(b1);
						else
							bool.addFirst(false);

					}

					if (eou.get(0).equals("#")) {
						if (b1 == true || b2 == true)
							bool.addFirst(true);
						else
							bool.addFirst(false);

					}
					eou.remove();

				}
				// se verdadeiro, entao consequente pode ser alcançado
				// e é colocado na base de conhecimentos
				// e a regra é removida da pesquisa
				if (bool.get(0) == true) {
					fatos.add(contemAlvo.get(contemAlvo.size() - 1));
					regras.remove(k);
					mudouBC = true;
				} else
					k++;

			}

			// quando varrer todas as regras e houver mudança
			// na BC, significa que novos dados foram adicionados
			// caso nenhum novo dado seja adicionado e ainda
			// houver regras, entao entraria em loop
			if (k >= regras.size()) {
				if (mudouBC == true) {
					k = 0;
					mudouBC = false;
				} else {
					break;
				}

			}

			contemAlvo.clear();
			bool.clear();

		}
		
		// procura alvo na BC
		estado = false;
		for (int i = 0; i < fatos.size(); i++) {
			if (alvo.equals(fatos.get(i))) {
				estado = true;
				break;
			}

		}
		System.out.println("[" + estado + "]");

	}

}