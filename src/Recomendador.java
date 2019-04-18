import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Recomendador {

	/**
	 * @param args
	 * @throws IOException
	 */
	
	// Para simplificar, a leitura de usuarios foi omitida
	// e a inferencia é feita dado um determinado conjunto 
	// de regras
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		// leitura de usuarios de arquivo
		Scanner scanner = new Scanner(new FileReader(
				"/home/familia1/workspace3/IA1/src/arq.txt"))
				.useDelimiter(" x ");

		Usuario user = null;
		LinkedList<Usuario> listaUser = new LinkedList<Usuario>();
		LinkedList<Local> listaLocais = new LinkedList<Local>();

		/*
		while (scanner.hasNext()) {
			try {
				user = new Usuario(scanner.next(), scanner.next(),
						scanner.next(), scanner.next(), scanner.next(),
						scanner.nextDouble(), scanner.nextDouble(),
						scanner.nextDouble());

			} catch (Exception io) {
				System.out.println("\nNao pode ler");
			}
		}
		*/
		

		scanner = new Scanner(new FileReader(
				"/home/familia1/workspace3/IA1/src/locais.txt"))
				.useDelimiter(" x ");
		Local local = null;

		// leitura de locais de arquivo .txt
		while (scanner.hasNext()) {

			try {
				local = new Local(scanner.next(), scanner.next(),
						scanner.next(), scanner.next(), scanner.next(),
						scanner.next(), scanner.nextDouble(),
						scanner.nextDouble());
				listaLocais.add(local);

			} catch (Exception e) {
				System.out.println("");
				// e.printStackTrace();
			}
		}
		

		LinkedList<Local> listaRecomendada = new LinkedList<Local>();
		listaRecomendada = ((LinkedList<Local>) listaLocais.clone());

		// definir regra a ser satisfeita
		// cada instancia de usuario representa operadores 'ou'
		// cada campo do usuario representa operadores 'e'
		// ex: (maceio e cidade e noite e solteiro) ou (10)
		Usuario usuario;
		LinkedList<Usuario> listaAtributos = new LinkedList<Usuario>();
		listaAtributos.add(new Usuario(null, "Maceio-AL", "cidade", "noite","solteiro", 0.0, 0.0, 0.0));
		listaAtributos.add(new Usuario(null, null, null, null, null, 30.0, 0.0, 0.0));
		listaAtributos.add(new Usuario(null, "Piranhas-AL", "educativo",null, null, 0.0, 0.0, 0.0));

		LinkedList<Local> listaAux = new LinkedList<Local>();
		LinkedList<Local> listaParcial = new LinkedList<Local>();

		while (!listaAtributos.isEmpty()) {

			usuario = (Usuario) listaAtributos.get(0);

			// caso o parametro nao seja nulo, execute
			if (usuario.getCidade() != null) {
				// para todos os elementos da lista de possiveis recomendados
				// procure se ha elemento que seja igual ao parametro
				// caso verdeiro, coloque esse elemento numa lista
				for (int i = 0; i < listaRecomendada.size(); i++) {
					if (usuario.getCidade().equals(
							listaRecomendada.get(i).getCidade())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}
				// faz a lista de recomendados conter somente os elementos
				// que casam com a lista auxiliar
				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();
			}

			// como para local, procura se paramentros sao satisfeitos
			// caso verdadeiro, coloque esse elemento numa lista
			if (usuario.getLocalidade() != null) {
				for (int i = 0; i < listaRecomendada.size(); i++) {
					if (usuario.getLocalidade().equals(
							listaRecomendada.get(i).getLocalidade())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}
				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();
			}

			// como para local, procura se paramentros sao satisfeitos
			// caso verdadeiro, coloque esse elemento numa lista
			if (usuario.getHorario() != null) {
				for (int i = 0; i < listaRecomendada.size(); i++) {
					if (usuario.getHorario().equals(
							listaRecomendada.get(i).getHorario())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}

				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();
			}
			
			
			// como para local, procura se paramentros sao satisfeitos
			// caso verdadeiro, coloque esse elemento numa lista
			if (usuario.getEstadoCivil() != null) {
				for (int i = 0; i < listaRecomendada.size(); i++) {

					if (listaRecomendada.get(i).getEstadoCivil()
							.contains(usuario.getEstadoCivil())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}
				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();

			}
			
			// como para local, procura se paramentros sao satisfeitos
			// caso verdadeiro, coloque esse elemento numa lista
			// aplica uma margem de erro para esse valor
			if (usuario.getValor() > 0) {
				for (int i = 0; i < listaRecomendada.size(); i++) {

					if (usuario.getValor() >= (listaRecomendada.get(i)
							.getValor() - listaRecomendada.get(i).getMEValor())
							&& usuario.getValor() <= (listaRecomendada.get(i)
									.getValor() + listaRecomendada.get(i)
									.getMEValor())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}
				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();
			}
			// como para local, procura se paramentros sao satisfeitos
			// caso verdadeiro, coloque esse elemento numa lista
			// aplica uma margem de erro para esse valor
			if (usuario.getNAcompanhantes() > 0) {
				for (int i = 0; i < listaRecomendada.size(); i++) {

					if (usuario.getNAcompanhantes() >= (listaRecomendada.get(i)
							.getNAcompanhantes() - listaRecomendada.get(i)
							.getMEAcompanhante())

							&& usuario.getNAcompanhantes() <= (listaRecomendada
									.get(i).getNAcompanhantes() + listaRecomendada
									.get(i).getMEAcompanhante())) {
						listaAux.add(listaRecomendada.get(i));
					}
				}
				listaRecomendada = (LinkedList<Local>) listaAux.clone();
				listaAux.clear();

			}

			listaAtributos.remove();

			for (int i = 0; i < listaRecomendada.size(); i++) {
				listaParcial.add(listaRecomendada.get(i));
			}
			listaRecomendada = listaLocais;

		}
		

		System.out.println(listaParcial);
		scanner.close();
	}
}
