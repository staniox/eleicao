
import java.util.ArrayList;
import java.util.Scanner;

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
	}
