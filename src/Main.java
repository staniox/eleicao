import java.util.Scanner;

public class Main {

    public static Candidato[] candidatos;
    public static Eleitor[] eleitores;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        candidatos = new Candidato[1];
        candidatos[0]=new Candidato();
        eleitores = new Eleitor[1];
        eleitores[0]= new Eleitor();
        
        
        int menu = 0;
        while (menu != 8) {
            System.out.printf("Bem vindo ao menu do sistema\n (para acessar um menu digite o numero correspondente a ele)\n");
            System.out.println("1 - Cadastrar candidato.");
            System.out.println("2 - Listar candidato.");
            System.out.println("3 - Deletar candidato.");
            System.out.println("4 - Cadastrar eleitor.");
            System.out.println("5 - Listar eleitor.");
            System.out.println("6 - Deletar eleitor.");
            System.out.println("7 - Iniciar Eleicao");
            System.out.println("8 - Encerrar programa");
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
                    System.out.println("para a eleicao funcionar corretamente eh necessario que tenha cadastrado ao menos 2 candidatos e 3 eleitores. se deseja cadastrar cadastrar algum desses digite -1");
                    System.out.println("A eleicao esta preste a comecar, para iniciar digite 1 e para encerrar digite -1 no campo CPF ");
                    Long caso = input.nextLong();
                    if (caso == 1) {

                        caso = Eleicao.iniciarVotacao();
                        while (caso != -1) {
                            caso = Eleicao.iniciarVotacao();
                        }
                    }
                    if (caso == -1) {
                    	Eleicao.verificaVencedor();
                       

                    }


                    break;
                case 8:
                    menu = 8;
                    System.out.println("Fim de eleicao!!!");
                    break;

                default:
                    System.out.println("Opção invalida. Insira uma opção do menu: ");
                    break;
            }
        }
    }
}
