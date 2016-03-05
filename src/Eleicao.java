
import java.util.ArrayList;

public class Eleicao {
	ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
	//metodo q cria candidato
	public boolean cadastrarCandidato(int numero,String nome,String partido){
		boolean retorno=true;
		Candidato candidato = new Candidato();
		//verifica se o candidato eh repitido
		if(candidatos.contains(candidato)){
			return candidatos.contains(candidato.numero);
		}
		else{
		candidatos.add(candidato);
		return retorno;
		}
	}
	// metodo para listar candidatos
	public void listarCandidato(int numero){
		//verifica se 
		if (candidatos.contains(numero)) {
			System.out.println("ola"+candidatos.contains(numero));
		}
		else if (numero==-1) {
			
		}
	}
	
	public static void main(String[] args) {
		

	}

}
