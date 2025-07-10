import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static final Banco banco = new Banco();

    public static void main(String[] args) {

        banco.setNome("Banco");

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n === Página Principal - " + banco.getNome() + " ===");
            System.out.println("1 - Cadastrar cliente e criar uma conta");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Transferir");
            System.out.println("5 - Ver extrato bancário");
            System.out.println("6 - Ver histórico bancário");
            System.out.println("7 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção:");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> cadastrarConta();
                case 2 -> sacar();
                case 3 -> depositar();
                case 4 -> transferir();
                case 5 -> imprimirExtrato();
                case 6 -> imprimirHistorico();
                case 7 -> banco.listarContas();
                case 0 -> {
                    System.out.println("Encerrando o programa.");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarConta(){
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        System.out.print("Tipo de conta (1 => Corrente, 2 => Poupança): ");
        int tipo = Integer.parseInt(scanner.nextLine());

        Conta novaConta = (tipo == 1) ? new ContaCorrente(cliente) : new ContaPoupanca(cliente);

        banco.adicionarConta(novaConta);
        System.out.println("Conta criada de número: " + novaConta.getNumero());
    }

    private static Conta buscarConta() {
        System.out.print("Digite o número da conta:");
        int numero = Integer.parseInt(scanner.nextLine());
        Conta conta = banco.buscarContaPorNumero(numero);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
        }
        return conta;
    }

    private static void depositar() {
        Conta conta = buscarConta();
        if (conta == null) return;

        System.out.print("Valor do depósito:");
        double valor = Double.parseDouble(scanner.nextLine());
        conta.depositar(valor);
    }

    private static void sacar() {
        Conta conta = buscarConta();
        if (conta == null) return;

        System.out.print("Valor do saque:");
        double valor = Double.parseDouble(scanner.nextLine());
        conta.sacar(valor);
    }

    private static void transferir() {
        System.out.println("Conta de origem:");
        Conta origem = buscarConta();
        if (origem == null) return;

        System.out.println("Conta de destino:");
        Conta destino = buscarConta();
        if (destino == null) return;

        System.out.print("Valor da transferência: ");
        double valor = Double.parseDouble(scanner.nextLine());

        origem.transferir(valor, destino);
    }

    private static void imprimirExtrato() {
        Conta conta = buscarConta();
        if (conta != null) {
            conta.imprimirExtrato();
        }
    }

    private static void imprimirHistorico() {
        Conta conta = buscarConta();
        if (conta != null) {
            conta.imprimirHistorico();
        }
    }

}



