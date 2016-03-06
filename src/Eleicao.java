
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Eleicao {

    static Scanner input = new Scanner(System.in);

    public static void setarValores() {
        for (int i = 0; i < Main.candidatos.length; i++) {
            for (int j = 0; j < Main.candidatos[0].length; j++) {
                Main.candidatos[i][j] = "0";
            }
        }
        for (int i = 0; i < Main.eleitores.length; i++) {
            for (int j = 0; j < Main.eleitores[0].length; j++) {
                Main.eleitores[i][j] = "0";
            }
        }
    }

    //metodo q cria candidato
    public static void cadastrarCandidato() {
        int posicaoInsercao = 0; // Posi��o na matriz na qual o pr�ximo candidato deve ser inserido.

        // Verifica qual � a pr�xima posi��o vazia na matriz de candidatos.
        // Se a posi��o 4 do vetor do candidato for diferente de nulo e igual a 1, sabemos que h� um candidato armazenado nela.
        while(posicaoInsercao < Main.candidatos.length && Main.candidatos[posicaoInsercao][4] != null && Main.candidatos[posicaoInsercao][4].equals("1")) {
            posicaoInsercao++;
        }

        if(posicaoInsercao > Main.candidatos.length) {
            // N�o h� mais posi��es dispon�veis. Portanto, devemos sair imediatamente do m�todo com o comando return.
            System.out.println("N�o ha mais vagas para candidatos nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
            return;
        }

        System.out.println("Insira o numero do candidato:");
        Main.candidatos[posicaoInsercao][0] = input.next();
        if (Integer.parseInt(Main.candidatos[posicaoInsercao][0]) > 0) {
            //tranquilo favoravel
        } else {
            System.out.println("numero invalido ou ja cadastrado. Insira o numero do candidato: ");
            while (input.nextInt() <= 0) {
                Main.candidatos[posicaoInsercao][0] = input.next();
            }
        }

        System.out.println("Insira o nome do candidato:");
        Main.candidatos[posicaoInsercao][1] = input.next();
        if (Main.candidatos[posicaoInsercao][1] != null) {
            //tranquilo
        } else {
            while (Main.candidatos[posicaoInsercao][1] == null) {
                System.out.println("Nome invalido. Insira o nome do candidato:");
                Main.candidatos[posicaoInsercao][1] = input.next();
            }
        }

        System.out.println("Insira o partido do candidato:");
        Main.candidatos[posicaoInsercao][2] = input.next();
        if (Main.candidatos[posicaoInsercao][2] != null) {
            //tranquilo
        } else {
            System.out.println("Partido invalido. Insira o partido do candidato:");
            while (input.next() == null || input.next() == "") {
                Main.candidatos[posicaoInsercao][1] = input.next();
            }


        }

        Main.candidatos[posicaoInsercao][4] = "1";
        System.out.println("Candidato inserido com sucesso");
    }

    // metodo para listar candidatos
    public static void listarCandidato() {
        int numero;
        System.out.println("Insira o numero do candidato que quer ver:");
        System.out.println("(insira 0 para ver todos)");
        System.out.println("Insira o numero: ");
        numero = input.nextInt();
        if (numero > 0) {
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Integer.parseInt(Main.candidatos[i][0]) == numero && Integer.parseInt(Main.candidatos[i][4]) == 1) {
                    System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.candidatos[i][0], Main.candidatos[i][1], Main.candidatos[i][2]);
                }

            }
        } else if (numero == 0) {
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Integer.parseInt(Main.candidatos[i][4]) == 1) {
                    System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.candidatos[i][0], Main.candidatos[i][1], Main.candidatos[i][2]);
                }
            }

        } else {
            System.out.println("Numero invalido ou n�o cadastrado");
        }


    }

    public static void deletarCandidato() {
        System.out.println("Insira o numero do candidato que deseja excluir: ");

        int numero = input.nextInt();

        if (numero > 0) {
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Integer.parseInt(Main.candidatos[i][0]) == numero && Integer.parseInt(Main.candidatos[i][4]) == 1) {
                    Main.candidatos[i][4] = "0";
                    System.out.printf("Candidato excluido com sucesso", Main.candidatos[i][0], Main.candidatos[i][1], Main.candidatos[i][2]);
                } else {
                    System.out.println("Numero invalido ou n�o cadastrado");
                }

            }
        }

    }


    public static void cadastrarEleitor() {


        for (int i = 0; i < Main.eleitores.length; i++) {
            if (i == Main.eleitores.length - 1 && Integer.parseInt(Main.eleitores[i][2]) == 1) {
                System.out.println("N�o ha mais vagas para eleitores nessa eleicao. por favor delete um usuario ou inicie outra eleicao.");
            } else if (Integer.parseInt(Main.eleitores[i][2]) == 0) {

                System.out.println("Insira o nome do eleitor:");
                if (input.next() != null && input.next() != "") {
                    Main.eleitores[i][1] = input.next();
                } else {
                    while (input.next() == null || input.next() == "") {
                        Main.eleitores[i][1] = input.next();
                    }
                }
                System.out.println("Insira opf do eleitor:");
                Main.eleitores[i][0] = input.next();
                if (Main.eleitores[i][0].length() > Integer.parseInt("9999999999")) {
                    Main.eleitores[i][0] = input.next();
                } else {
                    System.out.println("cpf invalido. Insira o cpf do eleitor: ");
                    while (input.nextInt() <= 0) {
                        Main.eleitores[i][0] = input.next();
                    }
                }
            }
            Main.eleitores[i][2] = "1";
            System.out.println("Eleitor inserido com sucesso");
            break;
        }

    }

    // metodo para listar eleitores
    public static void listarEleitor() {
        int numero;
        System.out.println("Insira o numero do eleitor que quer ver:");
        System.out.println("(insira 0 para ver todos)");
        System.out.println("Insira o numero: ");
        numero = input.nextInt();
        if (numero > 0) {
            for (int i = 0; i < Main.eleitores.length; i++) {
                if (Integer.parseInt(Main.eleitores[i][0]) == numero && Integer.parseInt(Main.eleitores[i][4]) == 1) {
                    System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.eleitores[i][0], Main.eleitores[i][1], Main.eleitores[i][2]);
                }

            }
        } else if (numero == 0) {
            for (int i = 0; i < Main.eleitores.length; i++) {
                if (Integer.parseInt(Main.eleitores[i][2]) == 1) {
                    System.out.printf("Numero: %s\nNome: %s\nPartido: %s\n\n", Main.eleitores[i][0], Main.eleitores[i][1], Main.eleitores[i][2]);
                }
            }

        } else {
            System.out.println("Numero invalido ou n�o cadastrado");
        }


    }

    public void deletarEleitor() {
        System.out.println("Insira o numero do eleitor que deseja excluir: ");
        int numero = input.nextInt();
        if (numero > 0) {
            for (int i = 0; i < Main.eleitores.length; i++) {
                if (Integer.parseInt(Main.eleitores[i][0]) == numero && Integer.parseInt(Main.eleitores[i][2]) == 1) {
                    Main.eleitores[i][2] = "0";
                    System.out.printf("Eleitor excluido com sucesso", Main.eleitores[i][0], Main.eleitores[i][1], Main.eleitores[i][2]);
                } else {
                    System.out.println("Numero invalido ou nao cadastrado");
                }

            }
        }

    }

    public static boolean validaCpf(String cpf) {
        int i = 0;
        for (i = 0; i < Main.eleitores.length; i++) {
            if (Main.eleitores[i][1] == cpf) {
                break;
            }
        }
        return Main.eleitores[i][1] == cpf;
    }

    public static boolean validaCandidato(int num) {
        int i = 0;
        for (i = 0; i < Main.eleitores.length; i++) {
            if (Integer.parseInt(Main.eleitores[i][1]) == num) {
                break;
            }
        }
        return Integer.parseInt(Main.eleitores[i][1]) == num;

    }

    public static int retornaIndice(int num) {
        int i = 0;
        for (i = 0; i < Main.eleitores.length; i++) {
            if (Integer.parseInt(Main.eleitores[i][1]) == num) {
                break;
            }
        }
        return i;

    }


    public static int iniciarVotacao() {
        System.out.println("Insira seu CPF: ");
        String numero = input.next();
        if (Integer.parseInt(numero) != -1) {
            if (validaCpf(numero) == true) {
                System.out.println("Insira o numero do candidato que deseja votar: ");
                int numCandidato = input.nextInt();
                if (validaCandidato(numCandidato)) {
                    int ind = retornaIndice(numCandidato);
                    Main.candidatos[ind][3] += 1;
                }
            }

        }
        return Integer.parseInt(numero);

    }

    public static void vencedor(int num, boolean unico) {
        if (unico == true) {
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Integer.parseInt(Main.candidatos[i][3]) == num) {
                    System.out.printf("O novo presidente eh: %s com %d votos!!!\n", Main.candidatos[i][1], num);
                }
            }
        } else {
            System.out.printf("A eleicao empatou. mais de um candidato teve %d votos\nCandidatos empatados:\n", num);
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Integer.parseInt(Main.candidatos[i][3]) == num) {
                    System.out.printf("%s\n", Main.candidatos[i][1]);
                }
            }

        }

    }


}




