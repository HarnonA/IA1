import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class ParaFrente {

	public static ArrayList<String> fatos = new ArrayList<String>();
	public static LinkedList<String> regras = new LinkedList<String>();
	public static LinkedList<String> contemAlvo = new LinkedList<String>();
	public static LinkedList<Boolean> bool = new LinkedList<Boolean>();
	public static boolean resposta;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String s = "";

		regras.add("a&b%c&d->e");
		regras.add("d&b->a");
		regras.add("d->e");
		regras.add("h->a");
		
		fatos.add("h");
		fatos.add("b");
		
		String[] strg = null;
		LinkedList<String> newAlvos = new LinkedList<>();
		LinkedList y = new LinkedList<>();
		
		
		strg = (regras.get(0).split(""));
		for (int i = 0; i < strg.length; i++)
			newAlvos.add(strg[i]);
		newAlvos.remove();
		regras.remove();
		//regras.addAll(newAlvos);
		y.add(newAlvos);
		System.out.println(y);
		
		// separa os atomos da primeira regra
		for (int i = regras.get(0).length()-1; i >= 0; i--)
			regras.addFirst(newAlvos.get(i));
		//System.out.println(regras);
		//System.out.println(regras);

		// verifica se o primeiro da lista de regras esta no banco
		for (int i = 0; i < fatos.size(); i++){
			if (regras.get(0).equals(fatos.get(i))){
				bool.add(true);
			}
			
		}
		if(bool.isEmpty())
			bool.add(false);
		
		
		
		regras.remove();
		regras.remove();
		for (int i = 0; i < fatos.size(); i++){
			
			if (regras.get(0).equals(fatos.get(i)))
				bool.add(true);
			
		}
		if(bool.isEmpty())
			bool.add(false);
		
		/*
		// para condiçao &
		if(bool.get(0).equals(bool.get(1)))
			bool.remove();
		*/
		
		// para condiçao %
		if(bool.get(0).equals(true) || bool.get(1).equals(true)){
			bool.remove(0);
			bool.remove(0);
			bool.add(true);
		}
		System.out.println(bool);
		
	}
	
}
