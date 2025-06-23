public abstract class Conta {
    protected String numero;
    protected double saldo;
    protected String dataAbertura;

    public Conta(String numero, String dataAbertura) {
        this.numero = numero;
        this.dataAbertura = dataAbertura;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }
}
