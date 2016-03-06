import java.util.Scanner;

public class Main {

	public static String[][] candidatos;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.printf("Bem vindo ao sistema de eleicoes presidenciais de ultima geracao\n\n- antes de começar eh necessario que informe quantos candidatos participarão desta eleicao.\n insira o numero de candidatos: ");
		int qtd = input.nextInt();
		if (qtd>0) {
			System.out.println("Quantidade salva com sucesso!!");
		}
		else {
			while (qtd<=0) {
				System.out.println("Quantidade invalida. Insira um numero valido:");
				qtd=input.nextInt();
			}
		}
		candidatos= new String[qtd][5];
		
		System.out.printf("Bem vindo ao menu do sistema\n (para acessar um menu digite o numero correspondente a ele)");
		System.out.println("1 - Cadastrar candidato.");
		System.out.println("2 - Listar candidato.");
		System.out.println("3 - Deletar candidato.");
		System.out.println("4 - Cadastrar eleitor.");
		System.out.println("5 - Listar eleitor.");
		System.out.println("6 - Deletar eleitor.");
		System.out.println("7 - Iniciar Eleicao");		
	}
}
