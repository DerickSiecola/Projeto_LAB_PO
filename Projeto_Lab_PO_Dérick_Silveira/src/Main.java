import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criando um Arquivo
        Arquivo arq = new Arquivo();

        // Apresentando as informações dos jogadores
        ArrayList<Jogador> jogadoresEncontrados;

        // Criando um menu para deixar a aplicação dinâmica

        // Controladora do while
        boolean flag = true;

        // Opção de escolha do usuário
        int opcao;

        // Entrada e saída de dados
        Scanner sc = new Scanner(System.in);

        while(flag){
            jogadoresEncontrados = arq.lerArquivos();

            System.out.println("+++++++++++ BEM VINDO(A) AO MENU DO OLHEIRO(A) PARA OBSERVAÇÃO DE JOGADORES");
            System.out.println("1- Listar um novo jogador observado");
            System.out.println("2- Lista de jogadores observados");
            System.out.println("3- SAIR DA APLICAÇÃO");
            System.out.println("4- Remover jogador da lista");
            System.out.println("5- Atualizar salário e valor de mercado de um jogador da lista: ");
            opcao = sc.nextInt(); // Entrando com a opção do usuário
            sc.nextLine(); // Limpando o buffer

            switch (opcao){
                case 1:
                    // Adicionando um jogador no Arquivo
                    String nome;
                    String clube;
                    double salario;
                    double valor;
                    int idade;
                    String posicao;

                    System.out.println("Nome e Sobrenome: ");
                    nome = sc.nextLine();

                    System.out.println("Clube atual: ");
                    clube = sc.nextLine();

                    System.out.println("Posição: ");
                    posicao = sc.nextLine();

                    System.out.println("Salário: ");
                    salario = sc.nextDouble();

                    System.out.println("Valor de mercado: ");
                    valor = sc.nextDouble();

                    System.out.println("Idade: ");
                    idade = sc.nextInt();


                    // Criando o jogador
                    Jogador jog = new Jogador(nome, clube, salario, valor, idade, posicao);

                    // Escrevendo as informações deste jogador dentro do arquivo
                    arq.escreverArquivo(jog);
                    break;
                case 2:
                    // Apresentando as informações dos jogadores observados
                    for (int i = 0; i < jogadoresEncontrados.size(); i++) {
                        System.out.println("NOME: "+jogadoresEncontrados.get(i).getNome());
                        System.out.println("CLUBE ATUAL: "+jogadoresEncontrados.get(i).getClube());
                        System.out.println("SALÁRIO: "+jogadoresEncontrados.get(i).getSalario());
                        System.out.println("VALOR DE MERCADO: "+jogadoresEncontrados.get(i).getValor());
                        System.out.println("IDADE: "+jogadoresEncontrados.get(i).getIdade());
                        System.out.println("POSIÇÃO: "+jogadoresEncontrados.get(i).getPosicao());
                    }
                    break;
                case 3:
                    flag = false;
                    break;
                case 4:
                    // Remover jogador da lista
                    System.out.println("Digite o nome do jogador a ser excluído da lista:");
                    String nomeExcluir = sc.nextLine();

                    // Buscar o jogador a ser excluído
                    Jogador jogadorExcluir = null;
                    for (Jogador jogador : jogadoresEncontrados) {
                        if (jogador.getNome().equals(nomeExcluir)) {
                            jogadorExcluir = jogador;
                            break;
                        }
                    }

                    // Verificar se o jogador foi encontrado e removê-lo da lista
                    if (jogadorExcluir != null) {
                        jogadoresEncontrados.remove(jogadorExcluir);
                        arq.atualizarArquivo(jogadoresEncontrados);
                        System.out.println("Jogador excluído com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;

                case 5:
                    // Ajustar valor e salário de um jogador existente
                    System.out.println("Digite o nome do jogador a ser ajustado:");
                    String nomeAjustar = sc.nextLine();

                    // Buscar o jogador a ser ajustado
                    Jogador jogadorAjustar = null;
                    for (Jogador jogador : jogadoresEncontrados) {
                        if (jogador.getNome().equals(nomeAjustar)) {
                            jogadorAjustar = jogador;
                            break;
                        }
                    }

                    // Verificar se o jogador foi encontrado e ajustar os valores
                    if (jogadorAjustar != null) {
                        System.out.println("Digite o novo valor de mercado:");
                        double novoValor = sc.nextDouble();
                        jogadorAjustar.setValor(novoValor);

                        System.out.println("Digite o novo salário:");
                        double novoSalario = sc.nextDouble();
                        jogadorAjustar.setSalario(novoSalario);

                        // Atualizar o arquivo com as informações atualizadas do jogador
                        arq.atualizarArquivo(jogadoresEncontrados);
                        System.out.println("Jogador ajustado com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado.");
                    }
                    break;

            }
        }

        sc.close(); // Fechando a entrada de dados

    }
}