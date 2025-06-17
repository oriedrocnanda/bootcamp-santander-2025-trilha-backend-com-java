import java.util.Scanner; 

// Fernanda Spilotros Costa Cordeiro
// Sintaxe - Desafio (Santander 2025 - Back-End com Java) 
public class ContaTerminal {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Informe o seu nome:");
        var nome = scanner.next();          // Variável do tipo texto

        System.out.println("Informe a sua agência no formato XXX-X:");
        var agencia = scanner.next();       // Variável do tipo texto

        System.out.println("Informe o seu número da conta bancária:");
        var numero = scanner.nextInt();     // Variável do tipo inteiro

        System.out.println("Insira o seu saldo disponível para saque:");
        var saldo = scanner.nextFloat();   // Variável do tipo decimal 

        System.out.printf("Olá, %s! Obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s " + 
                          "e seu saldo %s já está disponível para saque.", nome, agencia, numero, saldo);
    }
}
