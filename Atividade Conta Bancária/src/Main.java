
public class Main {
    public static void main(String[] args) {

        ContaBancaria conta = new ContaBancaria(500, 100);

        conta.deposito(1000);
        System.out.println(conta.getSaldo());
        System.out.println(conta.getChequeEspecial());
        conta.pagarBoleto(2000);

    }
}