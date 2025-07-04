import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        iPhone2007 iphone = new iPhone2007();
        Scanner scanner = new Scanner(System.in);
        int firstOption = 0;

        while (firstOption != 4) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Reprodutor Musical");
            System.out.println("2 - Aparelho Telefônico");
            System.out.println("3 - Navegador de Internet");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            firstOption = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (firstOption) {
                case 1:
                    ReprodutorMusical(iphone, scanner);
                    break;
                case 2:
                    AparelhoTelefonico(iphone, scanner);
                    break;
                case 3:
                    NavegadorInternet(iphone, scanner);
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    // Submenu para o reprodutor musical
    private static void ReprodutorMusical(iPhone2007 iphone, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n-- Reprodutor Musical --");
            System.out.println("1 - Tocar música");
            System.out.println("2 - Pausar música");
            System.out.println("3 - Selecionar música");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> iphone.tocar();
                case 2 -> iphone.pausar();
                case 3 -> {
                    System.out.print("Digite o nome da música: ");
                    String musica = scanner.nextLine();
                    iphone.selecionarMusica(musica);
                }
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Submenu para o aparelho telefônico
    private static void AparelhoTelefonico(iPhone2007 iphone, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n-- Aparelho Telefônico --");
            System.out.println("1 - Ligar");
            System.out.println("2 - Atender");
            System.out.println("3 - Correio de voz");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o número: ");
                    String numero = scanner.nextLine();
                    iphone.ligar(numero);
                }
                case 2 -> iphone.atender();
                case 3 -> iphone.iniciarCorreioDeVoz();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Submenu para o navegador de internet
    private static void NavegadorInternet(iPhone2007 iphone, Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n-- Navegador de Internet --");
            System.out.println("1 - Exibir página");
            System.out.println("2 - Adicionar nova aba");
            System.out.println("3 - Atualizar página");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a URL: ");
                    String url = scanner.nextLine();
                    iphone.exibirPagina(url);
                }
                case 2 -> iphone.adicionarNovaAba();
                case 3 -> iphone.atualizarPagina();
                case 0 -> System.out.println("Voltando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
