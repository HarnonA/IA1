import java.util.ArrayList;
import java.util.LinkedList;

/*
 * o simbolo & representa a operaçao logica 'e'
 * o simbolo % representa a operaçao logica "ou"
 * o simbolo # é utilizado para separar regras
 * 
 * É definido um conjunto de regras, base de conhecimento (fatos)
 * e um alvo o qual se deseja provar por inferencia
 * O sistema define se uma regra é verdadeira ou falsa,
 * caso verdadeira, seu consequente é adicionado na BC.
 * Se o alvo o qual se deseja provar estiver na base de conhecimento
 * entao a resposta é verdadeira, caso contrario é falsa
 */

public class BackwardFinal {

	public static String alvo;
	public static ArrayList<String> fatos = new ArrayList<String>();
	public static ArrayList<String> regras = new ArrayList<String>();
	public static LinkedList<String> contemAlvo = new LinkedList<String>();
	public static LinkedList<String> verificar = new LinkedList<String>();
	public static LinkedList<Boolean> bool = new LinkedList<Boolean>();
	public static boolean resposta;

	public static void main(String[] args) {

		// regras
		regras.add("a&b%c->e");
		regras.add("g&f&c->h");
		regras.add("h&e->t");

		// base de conhecimento
		fatos.add("a");
		fatos.add("b");
		fatos.add("g");
		fatos.add("f");

		// alvo
		alvo = "t";

		// ==================================================

		contemAlvo.add(alvo);
		int op = 0;

		// enquanto houver alvo a ser buscado
		while (!contemAlvo.isEmpty()) {
			op = intOperacao();

			// Se alvo nao esta no banco
			if (!estaNoBanco(contemAlvo.get(0))) {
				LinkedList<String> conclusao = new LinkedList<String>();
				String alvoDasRegras = new String();

				// para todas as regras verifique se possui consequente
				for (int i = 0; i < regras.size(); i++) {
					if (regras.get(i).contains("->")) {
						alvoDasRegras = regras.get(i).split("->")[1];

						// verifique se o alvo pode ser obtido pelas regras
						if (contemAlvo.get(0).equals(alvoDasRegras)) {
							conclusao.add(regras.get(i).split("->")[0]);
							conclusao.add("#");
							verificar.addFirst(alvoDasRegras);
							regras.remove(i);
						}
					}
				}

				contemAlvo.remove();

				// nao pode ser alcançado pelas regras
				if (!conclusao.isEmpty()) {

					// separa atomos e operadores de uma regras
					String[] strg = null;
					LinkedList<String> newAlvos = new LinkedList<>();
					strg = (conclusao.get(0).split(""));

					for (int i = 1; i < strg.length; i++)
						newAlvos.add(strg[i]);

					conclusao.clear();
					for (int i = newAlvos.size() - 1; i >= 0; i--)
						conclusao.addFirst(newAlvos.get(i));

					for (int i = conclusao.size() - 1; i >= 0; i--) {
						contemAlvo.addFirst(conclusao.get(i));
					}

					conclusao = null;
				} else {
					if (op != 3)
						bool.add(false);
				}

			}
			
			// alvo esta no banco
			else {
				contemAlvo.remove();
				bool.clear();
				bool.add(true);

			}
			
			// determina se uma regra é verdadeira ou falsa
			// de acordo com a regra
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
		}

		System.out.println(bool);


	}

	// atribui um inteiro que representa determinado
	// tipo de operaçao logica
	public static int intOperacao() {
		int op = 0;
		if (contemAlvo.get(0).equals("&")) {
			op = 1;
			contemAlvo.remove();
		} else if (contemAlvo.get(0).equals("%")) {
			op = 2;
			contemAlvo.remove();
		} else if (contemAlvo.get(0).equals("#")) {
			op = 3;
		}
		return op;
	}

	public static boolean estaNoBanco(String a) {
		for (int i = 0; i < fatos.size(); i++) {
			if (a.equals(fatos.get(i)))
				return true;
		}
		return false;
	}

}
