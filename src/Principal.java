/**
 * Classe principal da aplicação.
 */
public class Principal {

    private static Eleicao eleicao = new Eleicao();

    /**
     * Método main.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("== Eleições 2016 - Sistema de Controle");
        System.out.println("============================================================");
        exibirMenuOpcoes();

        int opcao = Utilitarios.lerInteiroTelado();

        while(opcao != 5) {
            switch (Integer.valueOf(opcao)) {
                case 1:
                    executarCadastroCandidato();
                    break;

                case 2:
                    executarBuscaCandidatoPeloNumero();
                    break;

                case 3:
                    executarListagemCandidatos();
                    break;

                case 4:
                    executarAcaoExcluirCandidato();
                    break;
            }

            exibirMenuOpcoes();
            opcao = Utilitarios.lerInteiroTelado();
        }

        System.out.println();
        System.out.println("ENCERRANDO O PROGRAMA.");
        System.out.println(">>> OBRIGADO POR UTILIZAR. (PT FOREVER) <<<");
    }

    /**
     * Exibe o menu com as opções disponíveis para o usuário.
     */
    public static void exibirMenuOpcoes() {
        System.out.println("");
        System.out.println(">> Escolha um opção. Digite o número da opção e pressione ENTER:");
        System.out.println("1 - Cadastrar Candidato; ");
        System.out.println("2 - Buscar candidato pelo número; ");
        System.out.println("3 - Listar candidatos; ");
        System.out.println("4 - Excluir candidato; ");
        System.out.println("----------------------------------");
        System.out.println("5 - Sair do programa; ");
    }

    /**
     * Solicita as informações para cadastrar um novo candidato.
     */
    private static void executarCadastroCandidato() {
        Candidato candidato = new Candidato();

        System.out.print("Digite o número do candidato. > ");
        candidato.numero = Utilitarios.lerInteiroTelado();

        System.out.print("Digite o nome do candidato. > ");
        candidato.nome = Utilitarios.lerStringTeclado();

        System.out.print("Digite o nome/sigla do partido do candidato. > ");
        candidato.partido = Utilitarios.lerStringTeclado();

        if(eleicao.cadastrarCandidato(candidato)) {
            System.out.println(">>> CANDIDATO CADASTRADO COM SUCESSO! <<<");
        } else {
            System.out.println("<<< CANDIDATO NÃO CADASTRADO. >>>");
        }

        Utilitarios.pausarPrograma(2); // Pausa o programa por 2 segundos.
        System.out.println();
    }

    /**
     * Executa a ação da opção de busca de candidato.
     */
    private static void executarBuscaCandidatoPeloNumero() {
        System.out.print("Digite o número do candidato. > ");
        int numero = Utilitarios.lerInteiroTelado();

        Candidato candidato = eleicao.buscarCandidatoPorNumero(numero);

        if(candidato == null) {
            System.out.println("<<< CANDIDATO COM O NÚMERO " + numero + " NÃO ENCONTRADO. >>>");
            eleicao.listarCandidatos();
            Utilitarios.pausarPrograma(2);
            return;
        }

        System.out.println(">>> CANDIDATO ENCONTRADO. <<<");
        System.out.println("Número: " + candidato.numero);
        System.out.println("Nome: " + candidato.nome);
        System.out.println("Partido: " + candidato.partido);

        Utilitarios.pausarPrograma(2); // Pausa o programa por 2 segundos.
        System.out.println();
    }

    /**
     * Executa a ação da opção de listagem de candidatos.
     */
    private static void executarListagemCandidatos() {
        if(eleicao.candidatos.size() == 0) {
            System.out.println("<<< NENHUM CANDIDATO FOI CADASTRADO ATÉ O MOMENTO. >>>");
            Utilitarios.pausarPrograma(2);
            System.out.println();
            return;
        }

        System.out.println(">>> CANDIDATOS CADASTRADOS ATÉ O MOMENTO. <<<");
        eleicao.listarCandidatos();
        Utilitarios.pausarPrograma(2);
        System.out.println();
    }

    /**
     * Executa a ação da opção de exclusão de candidatos.
     */
    private static void executarAcaoExcluirCandidato() {
        System.out.print("Digite o número do candidato. > ");
        int numero = Utilitarios.lerInteiroTelado();

        if(eleicao.buscarCandidatoPorNumero(numero) == null) {
            System.out.println("<<< CANDIDATO COM NÚMERO " + numero + " NÃO ENCONTRADO. >>>");
            eleicao.listarCandidatos();
            Utilitarios.pausarPrograma(2);
            return;
        }

        if(eleicao.excluirCandidatoPorNumero(numero)) {
            System.out.println(">>> CANDIDATO EXCLUÍDO COM SUCESSO. <<<");
        } else {
            System.out.println("<<< CANDIDATO NÃO EXCLUÍDO. >>>");
        }

        eleicao.listarCandidatos();
        Utilitarios.pausarPrograma(2);
    }
}
