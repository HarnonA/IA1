import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Reading {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(new FileReader(
				"/home/familia1/workspace3/IA1/src/arq.txt"))
				.useDelimiter(" x ");
		
		Usuario user = null;
		LinkedList listaUser = new LinkedList<>();
		LinkedList<Local> listaLocais = new LinkedList<Local>();
		

		/*while (scanner.hasNext()) {
			try {
				user = new Usuario(scanner.next(),scanner.next(),scanner.next(), null, null,null);
				listaUser.add(user);
				//String nome = scanner.next();
				//String cidade = scanner.next();
				//String compras = scanner.next();
				//System.out.print(nome + "x ");
				//System.out.print(cidade + "y ");
				//System.out.print(compras + "z ");
				
				
			} catch (Exception io) {
				System.out.println("\nNao pode ler");
			}
		}*/
		
		
		scanner = new Scanner(new FileReader(
				"/home/familia1/workspace3/IA1/src/locais.txt"))
				.useDelimiter(" x ");
		Local local = null;

		while (scanner.hasNext()) {
			
			try {
				local = new Local(scanner.next(), scanner.next(),
						scanner.next(), scanner.next(), scanner.next(),
						scanner.next(), scanner.nextDouble(),
						scanner.nextDouble());
				listaLocais.add(local);
				
				
			} catch (Exception e) {
				System.out.println("\nNao pode ler");
				//e.printStackTrace();
			}
		}

		LinkedList<Local> listaRecomendada = new LinkedList<Local>();
		listaRecomendada = (LinkedList<Local>) listaLocais.clone();
		
		//Usuario usurario = new Usuario(null, "Maceio-AL", null, null, null, null, null);
		
		LinkedList listaAtributos = new LinkedList<>();
		//listaAtributos.add("/hotel");
		//listaAtributos.add("1/hotel");
		listaAtributos.add("2/Piranhas-AL");
		//listaAtributos.add("2#Maceio-AL");
		//listaAtributos.add("1/boate");
		

		
		// para toda a lista de atributos a ser verificados
		// veja se a lista de locais os contem, caso contrario, remova
		// esse local da lista auxiliar
		// repita ate todos os atributos serem verificados ou
		// se a lista de locais nao condizer com os atributos
		while(!listaAtributos.isEmpty()){
			LinkedList<Local> listaAux = new LinkedList<Local>();
			
			String x = (String) listaAtributos.get(0);
			
			int n_operao = opcaoProcurar(x);
			String string = new String();
			
			
			if(x.contains("/")){
				x = x.split("/")[1];
				//System.out.println("aaa " + x);
				
				/*
				for(int i = 0; i < listaLocais.size(); i++){
					String string = listaLocais.get(i).getLocal();
					if(string.equals(x)){						
						listaRecomendada.add(listaLocais.get(i));
					}
				}*/
				for(int i = 0; i < listaRecomendada.size(); i++){
					if(n_operao == 1)
						string = listaRecomendada.get(i).getDescricao();	
					else if(n_operao == 2)
						string = listaRecomendada.get(i).getLocal();
					else if(n_operao == 3)
						string = listaRecomendada.get(i).getLocalidade();
					else if(n_operao == 4)
						string = listaRecomendada.get(i).getHorario();
					else if(n_operao == 5)
						string = listaRecomendada.get(i).getEstadoCivil();
					
					/*
					else if(n_operao == 6)
						string = listaRecomendada.get(i).getValor();
					else if(n_operao == 7)
						string = listaRecomendada.get(i).getNAcompanhantes();
						*/
//					System.out.println(string + " " + x + "  "+i);
					if(string.equals(x))
						//System.out.println(i);
							listaAux.add(listaRecomendada.get(i));
				}
				
				for(int i = 0; i < listaAux.size(); i++){
					listaRecomendada.add(listaAux.get(i));
				}
				//listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux = null;
				
				
				
			}
			
			else if(x.contains("#")){
				x = x.split("#")[1];
			for(int i = 0; i < listaLocais.size(); i++){
				if(n_operao == 1)
					string = listaLocais.get(i).getDescricao();	
				else if(n_operao == 2)
					string = listaLocais.get(i).getLocal();
				else if(n_operao == 3)
					string = listaLocais.get(i).getLocalidade();
				else if(n_operao == 4)
					string = listaLocais.get(i).getHorario();
				else if(n_operao == 5)
					string = listaLocais.get(i).getEstadoCivil();
				
				if(string.equals(x)){						
					listaRecomendada.add(listaLocais.get(i));
				}
			}
			}
			/*
			else if(x.startsWith("+")){
				LinkedList<Local> listaAux = new LinkedList<Local>();
				listaAux = (LinkedList<Local>) listaLocais.clone();
				
				for(int i = 0; i < listaAux.size(); i++){
					String string = listaAux.get(i).toString();
					if(string.contains(listaAtributos.get(0).toString()))
						listaAux.remove(i);
				}
				
				for(int i = 0; i < listaAux.size(); i++){
					listaRecomendada.add(listaAux.get(i));
				}
				
				
			}*/
			
			
			
			
			
			listaAtributos.remove(0);
		}
		
		
		System.out.println("lista" + listaRecomendada + " ");
		System.out.println(listaRecomendada.size());
		
		
		
		
		

	}
	
	public static int opcaoProcurar(String x){
		String string;
		if(x.startsWith("1"))
			return 1;
		else if(x.startsWith("2"))
			return 2;
		else if(x.startsWith("3"))
			return 3;
		else if(x.startsWith("4"))
			return 4;
		else if(x.startsWith("5"))
			return 5;
		else if(x.startsWith("6"))
			return 6;
		else if(x.startsWith("7"))
			return 7;
		return 0;
	}
	
	
	
	
}
