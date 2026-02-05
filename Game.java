import java.util.Scanner;

public class Game {

   public static String embaralhar(String palavra){
       char[] letras=palavra.toCharArray();

       for (int i=letras.length -1; i>0; i--) {
           int j=(int) (Math.random()*(i+1));
           //Abaixo, trocas de letras
           char temp=letras[i];
           letras[i] = letras[j];
           letras[j] = temp;
       }
       return new String(letras);
   }

//Execução
    public static void jogar( ListaDupla lista) {
       Scanner scanner = new Scanner(System.in);
       Node atual = lista.getInicio();
       int pontuacao = 0;

       while (atual != null){
           String original = atual.palavra;
           String embaralhada = embaralhar(original);


            System.out.println("Adivinhe a palavra: " + embaralhada);

            boolean acertou=false;
            for (int tentativa = 1; tentativa <= 3; tentativa++) {
            System.out.println("Nova tentativa " + tentativa + ":");
            System.out.println("Digite 'sair' a qualquer momento para encerrar o jogo.");
            String resposta = scanner.nextLine();

                // Verifica se o jogador quer sair
                if (resposta.equalsIgnoreCase("sair")) {
                    System.out.println("Você escolheu sair do jogo. Até mais!");
                    return;  // Interrompe o jogo e volta ao menu
                }

                if (resposta.equalsIgnoreCase(original)){
                    switch (tentativa) {
                        case 1-> pontuacao += 20;
                        case 2-> pontuacao += 10;
                        case 3-> pontuacao += 5;
                    }
                    System.out.println("Parabéns! Você acertou!");
                    acertou = true;
                    break;
                }else{
                    System.out.println("Errado!");
                }
            }


        if (!acertou) {
            System.out.println("A respopsta certa seria: " + original);
        }
        System.out.println("Pontuação atual:" + pontuacao);
        System.out.println("------------------------------");
        atual=atual.proximo;

       }
        System.out.println("Jogo encerrado! Pontuação final: " + pontuacao);
    }
    // Menu de opções
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- MENU INICIAL ---");
            System.out.println("1. Iniciar Jogo");
            System.out.println("2. Instruções");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    // Criação da lista de palavras
                    ListaDupla lista = new ListaDupla();
                    lista.adicionar("Teclado");
                    lista.adicionar("Monitor");
                    lista.adicionar("Computador");
                    lista.adicionar("Internet");
                    lista.adicionar("Conexão");

                    // Inicia o jogo
                    jogar(lista);
                    break;

                case 2:
                    System.out.println("\n--- REGRAS DO JOGO ---");
                    System.out.println("1. O objetivo do jogo é adivinhar a palavra embaralhada.");
                    System.out.println("2. O jogador terá 3 tentativas para adivinhar a palavra, pontuando de forma decrescente(20; 10; 5).");
                    System.out.println("3. Caso não consigo o acerto nas tentativas, a palavra correta será apresentada, e o jogador não acumulará pontos.");
                    System.out.println("4. A rodada consiste em um número de palavras(5) e o jogador terá sua pontuação final revelada ao fim da rodada");
                    break;

                case 3:
                    System.out.println("Saindo do jogo... Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
    }
}

