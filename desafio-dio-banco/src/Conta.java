import java.util.ArrayList;
import java.util.List;

public abstract class Conta implements IConta{

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    private int agencia;

    protected int numero;

    private double saldo;

    protected Cliente cliente;

    private List<String> historico = new ArrayList<>();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= 0 || valor > saldo) {
            System.out.println("Operação inválida: o saldo é insuficiente ou valor é inválido.");
        }
        this.saldo = saldo - valor;      // this.saldo -= saldo
        historico.add(String.format("Saque realizado com sucesso: %.2f", valor));
    }

    @Override
    public void depositar(double valor) {
        if(valor <= 0) {
            System.out.println("Depósito inválido.");
        }
        this.saldo = saldo + valor;      // this.saldo += saldo
        historico.add(String.format("Depósito realizado com sucesso: %.2f", valor));
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor <= 0 || valor > saldo) {
            System.out.println("Não foi possível completar a transferência.");
        }
        this.sacar(valor);
        contaDestino.depositar(valor);
        historico.add(String.format("Transferência realizada com sucesso: %.2f para conta %d", valor, contaDestino.getNumero()));
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.getAgencia()));
        System.out.println(String.format("Número: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }

    public void imprimirExtrato(String tipoConta){
        System.out.printf("=== Extrato da conta %s === %n", tipoConta);
        imprimirInfosComuns();
    }

    public void imprimirHistorico(){
        System.out.println(" === Histórico de transações === ");
        for(String linha : historico){
            System.out.println(linha);
        }
    }

}
