import java.util.ArrayList;
import java.util.LinkedList;


public class ParaFrente2 {

	public static ArrayList<String> fatos = new ArrayList<String>();
	public static LinkedList<String> regras = new LinkedList<String>();
	public static LinkedList<String> l = new LinkedList<String>();
	public static LinkedList<Boolean> bool = new LinkedList<Boolean>();
	public static boolean resposta;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int op = 0;
		LinkedList regras2 = new LinkedList<String>();
		
		regras.add("a&b%c&d->e");
		regras.add("d&b->a");
		regras.add("d->c");
		regras.add("h->a");
		fatos.add("a");
		fatos.add("d");
		
		
		// para todas as regras,separe os atomos e faça uma lista de uma regra
		// ex: [a&b->c; d->f] = [ [a,&,b,->,c], [d,->,f] ]
		for (int j = 0; j < regras.size(); j++) {
			String[] strg = null;
			String s = (regras.get(j).split("->")[1]);
			String r = (regras.get(j).split("->")[0]);
			LinkedList<String> newAlvos = new LinkedList<>();
			
			strg = (r.split(""));
			for (int i = 0; i < strg.length; i++)
				newAlvos.add(strg[i]);
			newAlvos.remove();
			newAlvos.add("->");
			newAlvos.add(s);
			regras2.add(newAlvos);
			
		}
		//System.out.println(regras2);
		/*
		for (int j = 0; j < regras2.size(); j++) {
			LinkedList l = (LinkedList) regras2.get(j);
			String str = (String) l.get(l.size()-1);
			
					for(int k = 0; k < fatos.size(); k++){
					if(str.equals(fatos.get(k)))
						regras2.remove(j);
					
					
					}
		}
		*/
	
		LinkedList aux = regras2;
		// retire as regras que consequente é um fato
		for (int j = 0; j < regras2.size(); j++) {
			LinkedList l = (LinkedList) regras2.get(j);

			for (int i = 0; i < fatos.size(); i++) {
				if (l.get(l.size() - 1).equals(fatos.get(i))) {
					aux.remove(j);
				}
			}
		}
		regras2 = aux;
		System.out.println(regras2);
		
			
		
		
		for (int j = 0; j < regras2.size(); j++) {
			LinkedList l = (LinkedList) regras2.get(j);
			
			for (int i = 0; i < l.size()-2; i++){
				op = 0;
				
				if(l.get(i).equals("&")){
					op = 1;
					l.remove(i);
				}
				
				else if(l.get(i).equals("%")){
					op = 2;
					l.remove(i);
				}

				for (int k = 0; k < fatos.size() - 1; k++) {
					bool.add(checarNoBanco(l.get(i)));
				}

				
				
				if(op==1){
					
					if(bool.get(0).equals(bool.get(1)))
						bool.remove(1);
					else{
						bool.remove();
						bool.remove();
						bool.add(false);
					}
				}
				
				if(op==2){
					
					if (bool.get(0).equals(true)){
						
						bool.remove();
						bool.remove();
						bool.add(true);
					}
					else if( bool.get(1).equals(true)) {
						
						bool.remove();
						bool.remove();
						bool.add(true);
					}
					else{
						
						bool.remove();
						bool.remove();
						bool.add(false);
						
					}
				}
				System.out.println(bool);
			}
			
			if(bool.get(0) == true){
				fatos.add((String) l.get(l.size()-1));
				regras2.remove(j);
				
			}
			bool.clear();
			
			
			/*
			// para uma regra, faça
			for (int i = 0; i < l.size(); i++) {

				if (l.get(i).equals("&")) {
					op = 1;
				} else if (l.get(i).equals("%")) {
					op = 2;
				}

				for (int k = 0; k < fatos.size() - 1; k++)
					if (l.get(i).equals(fatos.get(k)))
						bool.add(true);
					else
						bool.add(false);

				if (i > 2) {
					if (op == 1) {
						if (bool.get(0).equals(bool.get(1))) {
							bool.remove(0);
						} else {
							bool.remove();
							bool.remove();
							bool.addFirst(false);
						}

					} else if (op == 2) {
						if (bool.get(0).equals(true))
							bool.remove(1);
						else if (bool.get(1).equals(true))
							bool.remove(0);
						else {
							bool.remove();
							bool.remove();
							bool.addFirst(false);
						}
					}

				}
			}
			System.out.println(bool);
		}*/
		}
		System.out.println(fatos);
	}
	
	public static boolean checarNoBanco(Object object) {
		for (int i = 0; i < fatos.size(); i++) {
			if (object.equals(fatos.get(i)))
				return true;
		}

		return false;
	}

}
