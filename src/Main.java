import java.util.Scanner;

public class Main {

	public static String[][] candidatos;
	public static String[][] eleitores;

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		System.out.printf("Bem vindo ao sistema de eleicoes presidenciais de ultima geracao\n\n- antes de começar eh necessario que informe quantos candidatos participarão desta eleicao.\n insira o numero de candidatos: ");
		int qtd = input.nextInt();
		if (qtd>0) {
			System.out.println("Quantidade salva com sucesso!!");
		}
		else {
			while (qtd<=0) {
				System.out.println("Quantidade invalida. Insira um numero valido: ");
				qtd=input.nextInt();
			}
		}
		System.out.printf("insira o numero maximo de eleitores que esta eleição pode ter: ");
		int qtdEleitor = input.nextInt();
		if (qtdEleitor>0) {
			System.out.println("Quantidade salva com sucesso!!");
		}
		else {
			while (qtdEleitor<=0) {
				System.out.println("Quantidade invalida. Insira um numero valido: ");
				qtd=input.nextInt();
			}
		}
		candidatos= new String[qtd][5];
		eleitores =new String [qtdEleitor][3];
		Eleicao.setarValores();
		int menu =0;
		while(menu!=8){
		System.out.printf("Bem vindo ao menu do sistema\n (para acessar um menu digite o numero correspondente a ele)\n");
		System.out.println("1 - Cadastrar candidato.");
		System.out.println("2 - Listar candidato.");
		System.out.println("3 - Deletar candidato.");
		System.out.println("4 - Cadastrar eleitor.");
		System.out.println("5 - Listar eleitor.");
		System.out.println("6 - Deletar eleitor.");
		System.out.println("7 - Iniciar Eleicao");
		menu = input.nextInt();
		switch (menu) {
		case 1:
			Eleicao.cadastrarCandidato();
			break;
		case 2:
			Eleicao.listarCandidato();
			break;
		case 3:
			Eleicao.deletarCandidato();
			break;
		case 4:
			Eleicao.cadastrarEleitor();
			break;
		case 5:
			Eleicao.listarEleitor();
			break;
		case 6:
			Eleicao.deletarEleitor();
			break;
		case 7:
			System.out.println("A eleicao esta preste a comecar, para iniciar digite 1 e para encerrar digite -1");
			Long caso =input.nextLong();
			if(caso==1){
			
				caso =Eleicao.iniciarVotacao();
				while(caso!=-1){
				caso=Eleicao.iniciarVotacao();
				}}
			else if (caso==-1) {
					int vencedor=0;
					boolean unicoVencedor=true;
					for (int i = 0; i < candidatos.length; i++) {
						if (Integer.parseInt(candidatos[i][3])>vencedor) {
							vencedor=Integer.parseInt(candidatos[i][3]);
							unicoVencedor=true;
						}
						else if (Integer.parseInt(candidatos[i][3])==vencedor && vencedor>0) {
							vencedor=Integer.parseInt(candidatos[i][3]);
							unicoVencedor=false;
						}
						
					}
					Eleicao.vencedor(vencedor, unicoVencedor);
					
				}
			
			
			break;

		default:
			break;
		}
	}
	}
}
