

import java.util.Scanner;


public class Eleicao {
	
	static Scanner input = new Scanner(System.in);
	
	public static void setarValores(){
		for (int i = 0; i < Main.candidatos.length; i++) {
			for (int j = 0; j < Main.candidatos[0].length; j++) {
				Main.candidatos[i][j]="0";
			}
		}
		for (int i = 0; i < Main.eleitores.length; i++) {
			for (int j = 0; j < Main.eleitores[0].length; j++) {
				Main.eleitores[i][j]="0";
			}
		}
	}
	
	//metodo q cria candidato
	public static void cadastrarCandidato(){
		
		
		for (int i = 0; i < Main.candidatos.length; i++) {
			if (i==Main.candidatos.length-1 && Integer.parseInt(Main.candidatos[i][4])==1) {
				System.out.println("Não ha mais vagas para candidatos nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
			}
			else if (Integer.parseInt(Main.candidatos[i][4])==0) {
				
			
			System.out.println("Insira o numero do candidato:");
			Main.candidatos[i][0]= input.next();
			if(Integer.parseInt(Main.candidatos[i][0])>0){
			//tranquilo favoravel
			}
			else {
				System.out.println("numero invalido ou ja cadastrado. Insira o numero do candidato: ");
				while(input.nextInt()<=0){
				Main.candidatos[i][0]=input.next();
				}
			}
			System.out.println("Insira o nome do candidato:");
			Main.candidatos[i][1]= input.next();
			if (Main.candidatos[i][1]!=null) {
				//tranquilo	
			}
			else {
				while(Main.candidatos[i][1]==null){
					System.out.println("Nome invalido. Insira o nome do candidato:");
					Main.candidatos[i][1]= input.next();	
				}
				}
			System.out.println("Insira o partido do candidato:");
			Main.candidatos[i][2]= input.next();	
			if (Main.candidatos[i][2]!=null) {
				//tranquilo
			}
			else {
				System.out.println("Partido invalido. Insira o partido do candidato:");
				while(input.next()==null || input.next()==""){
					Main.candidatos[i][1]= input.next();	
				}
			
			
			
			}
			Main.candidatos[i][4]="1";
			System.out.println("Candidato inserido com sucesso");
			break;
			}
			
		}
		
	}	
	// metodo para listar candidatos
	public static void listarCandidato(){
		int numero;
		System.out.println("Insira o numero do candidato que quer ver:");
		System.out.println("(insira 0 para ver todos)");
		System.out.println("Insira o numero: ");
		numero=input.nextInt();
		if (numero>0) {
			for (int i = 0; i < Main.candidatos.length; i++) {
				if (Integer.parseInt(Main.candidatos[i][0])==numero && Integer.parseInt(Main.candidatos[i][4])==1) {
					System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.candidatos[i][0],Main.candidatos[i][1],Main.candidatos[i][2]);
				}
				
			}
		}
		else if (numero==0) {
			for (int i = 0; i < Main.candidatos.length; i++) {
				if (Integer.parseInt(Main.candidatos[i][4])==1) {
					System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.candidatos[i][0],Main.candidatos[i][1],Main.candidatos[i][2]);
				}
		}
		
	}
		else {
			System.out.println("Numero invalido ou não cadastrado");
		}
	
	

}
	public static void deletarCandidato () {
		System.out.println("Insira o numero do candidato que deseja excluir: ");
		int numero =input.nextInt();
		if (numero>0) {
			for (int i = 0; i < Main.candidatos.length; i++) {
				if (Integer.parseInt(Main.candidatos[i][0])==numero && Integer.parseInt(Main.candidatos[i][4])==1) {
					Main.candidatos[i][4]="0";
					System.out.printf("Candidato excluido com sucesso");
					break;
				}
			else {
				System.out.println("Numero invalido ou não cadastrado");
			}
				
			}
		}
	
	}

public static void cadastrarEleitor(){
		
		
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (i==Main.eleitores.length-1 && Integer.parseInt(Main.eleitores[i][2])==1) {
				System.out.println("Não ha mais vagas para eleitores nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
			}
			else if (Integer.parseInt(Main.eleitores[i][2])==0) {
				System.out.println("Insira o nome do eleitor:");
				Main.eleitores[i][0]= input.next();
				if (Main.eleitores[i][0]!=null) {
					//tranquilo	
				}
				else {
					while(Main.eleitores[i][0]==null){
						System.out.println("Nome invalido. Insira o nome do eleitor:");
						Main.eleitores[i][0]= input.next();	
					}
					}
			
			System.out.println("Insira o CPF do eleitor:");
			Main.eleitores[i][1]= input.next();
			if(Long.parseLong(Main.eleitores[i][1])>0){
			//tranquilo favoravel
			}
			else {
				System.out.println("CPF invalido ou ja cadastrado. Insira o CPF do eleitor: ");
				while(input.nextInt()<=0){
				Main.eleitores[i][1]=input.next();
				}
			}
			
			
			Main.eleitores[i][2]="1";
			System.out.println("Eleitor inserido com sucesso");
			break;
			}
			
		}
		
	}	


/*public static void cadastrarEleitor(){
	
	
	for (int i = 0; i < Main.eleitores.length; i++) {
		if (i==Main.eleitores.length-1 && Integer.parseInt(Main.eleitores[i][2])==1) {
			System.out.println("Não ha mais vagas para eleitores nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
		}
		else if (Integer.parseInt(Main.eleitores[i][2])==0) {
			
			System.out.println("Insira o nome do eleitor:");
			if (input.next()!=null && input.next()!="") {
				Main.eleitores[i][1]= input.next();	
			}
			else {
				while(input.next()==null || input.next()==""){
					Main.eleitores[i][1]= input.next();	
				}
				}
		System.out.println("Insira opf do eleitor:");
		Main.eleitores[i][0]= input.next();
		if(Main.eleitores[i][0].length()>Integer.parseInt("9999999999")){
		Main.eleitores[i][0]= input.next();
		}
		else {
			System.out.println("cpf invalido. Insira o cpf do eleitor: ");
			while(input.nextInt()<=0){
			Main.eleitores[i][0]=input.next();
			}
		}
		}
		Main.eleitores[i][2]="1";
		System.out.println("Eleitor inserido com sucesso");
		break;
		}
		
	}
*/
// metodo para listar eleitores
public static void listarEleitor(){
	Long numero;
	System.out.println("Insira o CPF do eleitor que quer ver:");
	System.out.println("(insira 0 para ver todos)");
	System.out.println("Insira o CPF: ");
	numero=input.nextLong();
	if (numero>0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Long.parseLong(Main.eleitores[i][1])==numero && Long.parseLong(Main.eleitores[i][2])==1) {
				System.out.printf("Nome: %s\nCPF: %s\n\n", Main.eleitores[i][0],Main.eleitores[i][1]);
			}
			
		}
	}
	else if (numero==0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Long.parseLong(Main.eleitores[i][2])==1) {
				System.out.printf("Nome: %s\nCPF: %s\n\n", Main.eleitores[i][0],Main.eleitores[i][1]);
			}
	}
	
}
	else {
		System.out.println("Cpf invalido ou não cadastrado");
	}



}
public static void deletarEleitor () {
	System.out.println("Insira o CPF do eleitor que deseja excluir: ");
	Long numero =input.nextLong();
	if (numero>0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Long.parseLong(Main.eleitores[i][1])==numero && Integer.parseInt(Main.eleitores[i][2])==1) {
				Main.eleitores[i][2]="0";
				System.out.printf("Eleitor excluido com sucesso\n\n");
				break;
			}
		else if (i==Main.eleitores.length-1 && Long.parseLong(Main.eleitores[i][0])!=numero) {
			System.out.println("CPF invalido ou nao cadastrado\n\n");
		}
			
		}
	}

}

public static boolean validaCandidato(int num){
	int i =0;
	for (i = 0; i < Main.candidatos.length; i++) {
		if (Integer.parseInt(Main.candidatos[i][0])==num) {
			break;
		}
	}
	return Integer.parseInt(Main.candidatos[i][0])==num;
	
}
public static int retornaIndice(int num){
	int i =0;
	for (i = 0; i < Main.candidatos.length; i++) {
		if (Integer.parseInt(Main.candidatos[i][0])==num) {
			break;
		}
	}
	return i;
	
}


public static Long iniciarVotacao(){
	System.out.println("Insira seu CPF: ");
	String numero=input.next();
	
	if (Long.parseLong(numero)!=-1 ) {
		
			System.out.println("Insira o numero do candidato que deseja votar: ");
			int numCandidato=input.nextInt();
			if (validaCandidato(numCandidato)==true) {
				int ind =retornaIndice(numCandidato);
				Main.candidatos[ind][3]=Integer.toString(Integer.parseInt(Main.candidatos[ind][3])+1);
				System.out.println("Voto computado com sucesso!!!");
				System.out.println();
				
			}
			if(validaCandidato(numCandidato)==false) {
				System.out.println("Voto nao computado. verifique CPF e numero do candidato");
				return (long) 0;
			}
		
			
	}
	return Long.parseLong(numero);
	
	
	
}
public static void vencedor (int num, boolean unico){
	if (unico==true) {
		for (int i = 0; i < Main.candidatos.length && num!=0; i++) {
			if (Integer.parseInt(Main.candidatos[i][3])==num) {
				System.out.printf("O novo presidente eh: %s com %s votos!!!\n\n",Main.candidatos[i][1],Main.candidatos[i][3]);
				
			}
		}
	}
	else {
		System.out.printf("A eleicao empatou. mais de um candidato teve %d votos\nCandidatos empatados:\n",num);
		for (int i = 0; i < Main.candidatos.length; i++) {
			if (Integer.parseInt(Main.candidatos[i][3])==num) {
				System.out.printf("%s\n",Main.candidatos[i][1]);
			}
		}
		
	}

}



}




