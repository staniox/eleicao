

import java.util.Scanner;


public class Eleicao {

    static Scanner input = new Scanner(System.in);

    
    /**
     * Aumenta o tamanho do array de candidatos.
     */
    public static void gravarNovoCandidato(Candidato novo) {
        

        Candidato[] novoArray = new Candidato[Main.candidatos.length + 1];

        for(int i = 0; i < Main.candidatos.length; i++) {
        	if (Main.candidatos[i].numero==-1) {
        		novoArray[i] = new Candidato();
            	Main.candidatos[i]= new Candidato();
                novoArray[i] = Main.candidatos[i];	
			}
        	
        }

        Main.candidatos = novoArray;

        Main.candidatos[Main.candidatos.length - 1] = novo;
    }
    public static void gravarNovoEleitor(Eleitor novo) {
        if(novo.cpf == "-1") {
            
            Main.eleitores[0] = novo;
            return;
        }

        Eleitor[] novoArray = new Eleitor[Main.eleitores.length + 1];

        for(int i = 0; i < Main.eleitores.length; i++) {
        	novoArray[i] = new Eleitor();
        	novoArray[i] = Main.eleitores[i];
        }

        Main.eleitores = novoArray;

        Main.eleitores[Main.eleitores.length - 1] = novo;
    }

    /**
     * Cadastra um novo candidato.
     */
    public static void cadastrarCandidato() {
        Candidato novoRegistro = new Candidato();

        System.out.println("Insira o numero do candidato:");
        novoRegistro.numero = input.nextInt();
        while(novoRegistro.numero<10 && novoRegistro.numero>99){
        	System.out.println("Numero invalido."+"\n"+"numeros de presidente deve conter 2 algarismos."+"\n"+" Insira o numero do candidato: ");
            novoRegistro.numero = input.nextInt();
        }

        System.out.println("Insira o nome do candidato:");
        novoRegistro.nome = input.next();

        System.out.println("Insira o partido do candidato:");
        novoRegistro.partido = input.next();

        for (int i = 0; i < Main.candidatos.length; i++) {
            if (Main.candidatos[i].numero == novoRegistro.numero) {
                System.out.println("Candidato já cadastrado com o número " + novoRegistro.numero);
                return;
            }
        }

        gravarNovoCandidato(novoRegistro);
        System.out.println("Candidato inserido com sucesso");
    }

    /**
     * Método para listar candidatos.
     */
    public static void listarCandidato() {
        int numero;
        System.out.println("Insira o numero do candidato que quer ver:");
        System.out.println("(insira 0 para ver todos)");
        System.out.println("Insira o numero: ");
        numero = input.nextInt();
        if (numero > 0) {
        	for(int i = 0; i < Main.candidatos.length; i++) {
        		if (numero==Main.candidatos[i].numero) {
        			Candidato candidato = Main.candidatos[i];
                    System.out.println("Número: " + candidato.numero);
                    System.out.println("Nome: " + candidato.nome+"\n");	
                    System.out.println("Partido: " + candidato.partido+"\n");
                    return;
				}
                
            }
        } else if (numero == 0) {
        	 //array com a classe Candidato.
            for(int i = 0; i < Main.candidatos.length; i++) {
                
            	if (Main.candidatos[i].numero!=-1) {
            		Candidato candidato = new Candidato();
                    candidato=Main.candidatos[i];
                    System.out.println("Número: " + candidato.numero);
                    System.out.println("Nome: " + candidato.nome);
                    System.out.println("Partido: " + candidato.partido+"\n");
				}
            	
            }

        } else {
            System.out.println("Numero invalido ou não cadastrado"+"\n");
        }


    }

    public static void deletarCandidato() {
        System.out.println("Insira o numero do candidato que deseja excluir: ");
        int numero = input.nextInt();
        if (numero > 0) {
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Main.candidatos[i].numero == numero) {
                    Main.candidatos[i]= null;
                    System.out.printf("Candidato excluido com sucesso");
                    break;
                } else {
                    System.out.println("Numero invalido ou não cadastrado");
                }

            }
        }

    }
    public static void cadastrarEleitor() {
        Eleitor novoRegistro = new Eleitor();

        System.out.println("Insira o nome do eleitor:");
        novoRegistro.nome = input.next();
        
        System.out.println("Insira o cpf do eleitor:");
        novoRegistro.cpf = input.next();
        while(novoRegistro.cpf.length()<11){
        	System.out.println("CPF invalido."+"\n"+"CPF deve conter 11 algarismos."+"\n"+" Insira o CPF do eleitor: ");
            novoRegistro.cpf = input.next();
        }

        

        for (int i = 0; i < Main.eleitores.length; i++) {
            if (Main.eleitores[i].cpf == novoRegistro.cpf) {
                System.out.println("Eleitor já cadastrado com o cpf " + novoRegistro.cpf);
                return;
            }
        }
        novoRegistro.votou=false;
        gravarNovoEleitor(novoRegistro);
        System.out.println("Eleitor inserido com sucesso");
    }

// metodo para listar eleitores
    public static void listarEleitor() {
        String cpf;
        System.out.println("Insira o cpf do eleitor que quer ver:");
        System.out.println("(insira 0 para ver todos)");
        System.out.println("Insira o cpf: ");
        cpf = input.next();
        if (Long.parseLong(cpf) >0) {
        	for(int i = 0; i < Main.eleitores.length; i++) {
        		if (cpf==Main.eleitores[i].cpf) {
        			Eleitor eleitor = Main.eleitores[i];
                    
                    System.out.println("Nome: " + eleitor.nome);
                    System.out.println("Número: " + eleitor.cpf+"\n");
                    return;
				}
                
            }
        } else if (Long.parseLong(cpf) ==0) {
        	 //array com a classe Eleitor.
            for(int i = 0; i < Main.eleitores.length; i++) {
                Eleitor eleitor = Main.eleitores[i];
                
                System.out.println("Nome: " + eleitor.nome);
                System.out.println("CPF: " + eleitor.cpf+"\n");
            }

        } else {
            System.out.println("Numero invalido ou não cadastrado"+"\n");
        }


    }




    public static void deletarEleitor() {
        System.out.println("Insira o CPF do eleitor que deseja excluir: ");
        String numero = input.next();
        if (Long.parseLong(numero) > 0) {
            for (int i = 0; i < Main.eleitores.length; i++) {
                if (Main.eleitores[i].cpf == numero) {
                    Main.eleitores[i]= null;
                    System.out.printf("Eleitor excluido com sucesso\n\n");
                    break;
                } else if (i == Main.eleitores.length - 1 ) {
                    System.out.println("CPF invalido ou nao cadastrado\n\n");
                }

            }
        }

    }

    public static int validaCandidato(int num) {
        int i = 0;
        for (i = 0; i < Main.candidatos.length; i++) {
            if (Main.candidatos[i].numero == num) {
                return i;
            }
        }
        return -2;

    }
    public static int validaEleitor(String cpf) {
        int i = 0;
        for (i = 0; i < Main.candidatos.length; i++) {
            if (Main.eleitores[i].cpf == cpf) {
                return i;
            }
        }
        return -2;

    }

   


    public static Long iniciarVotacao() {
        System.out.println("Insira seu CPF: ");
        String numero = input.next();
        int indiceEleitor = validaEleitor(numero);

        if (indiceEleitor >=0 && Main.eleitores[indiceEleitor].votou==false &&indiceEleitor!=-2) {

            System.out.println("Insira o numero do candidato que deseja votar: ");
            int numCandidato = input.nextInt();
            int ind=validaCandidato(numCandidato);
            if ( ind>=0) {
                
                Main.candidatos[ind].votos += 1;
                Main.eleitores[indiceEleitor].votou=true;
                System.out.println("Voto computado com sucesso para"+Main.candidatos[ind].nome+"!!!");
                System.out.println();

            }
            if (validaCandidato(numCandidato) == -2) {
                System.out.println("Voto nao computado. verifique onumero do candidato");
                return (long) 0;
            }


        }
        return Long.parseLong(numero);


    }

    public static void vencedor(int num, boolean unico) {
        if (unico == true) {
            for (int i = 0; i < Main.candidatos.length && num != 0; i++) {
                if (Main.candidatos[i].votos == num) {
                    System.out.printf("O novo presidente eh: %s com %s votos!!!\n\n", Main.candidatos[i].nome, Main.candidatos[i].votos);

                }
            }
        } else {
            System.out.printf("A eleicao empatou. mais de um candidato teve %d votos\nCandidatos empatados:\n", num);
            for (int i = 0; i < Main.candidatos.length; i++) {
                if (Main.candidatos[i].votos == num) {
                    System.out.printf("%s\n", Main.candidatos[i].nome);
                }
            }

        }

    }
    public static void verificaVencedor(){
    	int vencedor = 0;
        boolean unicoVencedor = true;
        for (int i = 0; i < Main.candidatos.length; i++) {
            if (Main.candidatos[i].votos > vencedor) {
                vencedor = Main.candidatos[i].votos;
                unicoVencedor = true;
            } else if (Main.candidatos[i].votos == vencedor && vencedor > 0) {
                
                unicoVencedor = false;
            }

        }
        System.out.println();
        Eleicao.vencedor(vencedor, unicoVencedor);

    }


}




