public class ContaBancaria {
    private float saldo;
    private float chequeEspecial;
    private final float limiteMaxChequeEspecial = 2000f;

    public ContaBancaria(float saldo, float chequeEspecial) {
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getChequeEspecial() {
        return chequeEspecial;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: " + this.saldo + " R$");
    }

    public void consultarChequeEspecial() {
        System.out.println("Cheque Especial: " + this.chequeEspecial + " R$");
    }

    public void pagarBoleto(float valorBoleto) {
        processarOperacao(valorBoleto, "Pagamento de boleto" );
    }

    public void sacarDinheiro(float valorSaque) {
        processarOperacao(valorSaque, "Saque" );
    }

    public void processarOperacao(float valor, String tipoOperacao) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println(tipoOperacao + " realizado com sucesso!");

        } else if (valor <= this.saldo + this.chequeEspecial) {
            float rest = valor - this.saldo;
            this.saldo = 0;
            float valorcomJuros = rest * 1.1f;
            chequeEspecial -= valorcomJuros;
            System.out.println(tipoOperacao + " realizado com sucesso usando saldo e cheque especial!");
            System.out.println("Valor de Cheque Especial (com juros): " + valorcomJuros);

        } else {
            System.out.println("Não foi possível realizar o " + tipoOperacao + " .Saldo insuficiente!");
        }

        consultarSaldo();
        consultarChequeEspecial();
    }

    public float deposito(float valor) {
        this.saldo += valor;
        if (valor <= 500){
            float bonus = 50;
            this.chequeEspecial = Math.min(this.chequeEspecial + bonus, limiteMaxChequeEspecial);
        }else if (valor > 500){
            float bonus = (valor * 0.5f);
            this.chequeEspecial = Math.min(this.chequeEspecial + bonus, limiteMaxChequeEspecial);
        }
        System.out.println("Depósito de " + valor + " R$ realizado com sucesso!");
        return saldo;
    }
}
