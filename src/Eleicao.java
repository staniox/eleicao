
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Eleicao {
	
	Scanner input = new Scanner(System.in);
	
	//metodo q cria candidato
	public void cadastrarCandidato(){
		
		
		for (int i = 0; i < Main.candidatos.length; i++) {
			if (i==Main.candidatos.length-1 && Integer.parseInt(Main.candidatos[i][4])==1) {
				System.out.println("Não ha mais vagas para candidatos nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
			}
			else if (Integer.parseInt(Main.candidatos[i][4])==0) {
				
			
			System.out.println("Insira o numero do candidato:");
			if(input.nextInt()>0){
			Main.candidatos[i][0]= input.next();
			}
			else {
				System.out.println("numero invalido. Insira o numero do candidato: ");
				while(input.nextInt()<=0){
				Main.candidatos[i][0]=input.next();
				}
			}
			System.out.println("Insira o nome do candidato:");
			if (input.next()!=null && input.next()!="") {
				Main.candidatos[i][1]= input.next();	
			}
			else {
				while(input.next()==null || input.next()==""){
					Main.candidatos[i][1]= input.next();	
				}
				}
			System.out.println("Insira o partido do candidato:");
			if (input.next()!=null) {
				Main.candidatos[i][2]= input.next();	
			}
			else {
				while(input.next()==null || input.next()==""){
					Main.candidatos[i][1]= input.next();	
				}
			
			
			
			}
			Main.candidatos[i][4]="1";
			System.out.println("Candidato inserido com sucesso");
			}
			
		}
	}	
	// metodo para listar candidatos
	public void listarCandidato(){
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
	public void deletarCandidato () {
		System.out.println("Insira o numero do candidato que deseja excluir: ");
		int numero =input.nextInt();
		if (numero>0) {
			for (int i = 0; i < Main.candidatos.length; i++) {
				if (Integer.parseInt(Main.candidatos[i][0])==numero && Integer.parseInt(Main.candidatos[i][4])==1) {
					Main.candidatos[i][4]="0";
					System.out.printf("Candidato excluido com sucesso", Main.candidatos[i][0],Main.candidatos[i][1],Main.candidatos[i][2]);
				}
			else {
				System.out.println("Numero invalido ou não cadastrado");
			}
				
			}
		}
	
	}

public class Eleitor {
String nome;
String cpf;
///////////////////////////////////////////////////////////////////////////////////////////////

public void cadastrarEleitor(){
	
	
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
		}
		
	}
}	
// metodo para listar eleitores
public void listarEleitor(){
	int numero;
	System.out.println("Insira o numero do eleitor que quer ver:");
	System.out.println("(insira 0 para ver todos)");
	System.out.println("Insira o numero: ");
	numero=input.nextInt();
	if (numero>0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Integer.parseInt(Main.eleitores[i][0])==numero && Integer.parseInt(Main.eleitores[i][4])==1) {
				System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.eleitores[i][0],Main.eleitores[i][1],Main.eleitores[i][2]);
			}
			
		}
	}
	else if (numero==0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Integer.parseInt(Main.eleitores[i][2])==1) {
				System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.eleitores[i][0],Main.eleitores[i][1],Main.eleitores[i][2]);
			}
	}
	
}
	else {
		System.out.println("Numero invalido ou não cadastrado");
	}



}
public void deletarEleitor () {
	System.out.println("Insira o numero do eleitor que deseja excluir: ");
	int numero =input.nextInt();
	if (numero>0) {
		for (int i = 0; i < Main.eleitores.length; i++) {
			if (Integer.parseInt(Main.eleitores[i][0])==numero && Integer.parseInt(Main.eleitores[i][2])==1) {
				Main.eleitores[i][2]="0";
				System.out.printf("Eleitor excluido com sucesso", Main.eleitores[i][0],Main.eleitores[i][1],Main.eleitores[i][2]);
			}
		else {
			System.out.println("Numero invalido ou nao cadastrado");
		}
			
		}
	}

}
public boolean validaCpf(String cpf){
	int i =0;
	for (i = 0; i < Main.eleitores.length; i++) {
		if (Main.eleitores[i][1]==cpf) {
			break;
		}
	}
	return Main.eleitores[i][1]==cpf;
}
public boolean validaCandidato(int num){
	int i =0;
	for (i = 0; i < Main.eleitores.length; i++) {
		if (Integer.parseInt(Main.eleitores[i][1])==num) {
			break;
		}
	}
	return Integer.parseInt(Main.eleitores[i][1])==num;
	
}
public int retornaIndice(int num){
	int i =0;
	for (i = 0; i < Main.eleitores.length; i++) {
		if (Integer.parseInt(Main.eleitores[i][1])==num) {
			break;
		}
	}
	return i;
	
}


public void iniciarVotacao(String numero){
	System.out.println("Insira seu CPF: ");
	numero=input.next();
	if (Integer.parseInt(numero)!=-1) {
		if (validaCpf(numero)==true) {
			System.out.println("Insira o numero do candidato que deseja votar: ");
			int numCandidato=input.nextInt();
			if (validaCandidato(numCandidato)) {
				int ind =retornaIndice(numCandidato);
				Main.candidatos[ind][3]+=1;
			}
		}
	}
	
}



}




