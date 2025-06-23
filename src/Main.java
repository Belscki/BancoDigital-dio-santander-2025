import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        inserirFakeData(banco);
        menuLoop(banco);
    }

    private static void inserirFakeData(Banco banco) {
        banco.adicionarConta(new ContaCorrente("123", "2025-01-01"));
        banco.adicionarConta(new ContaPoupanca("456", "2025-01-02"));
    }

    private static void menuLoop(Banco banco) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1 - Depositar\n2 - Sacar\n3 - Transferir\n4 - Verificar Saldo\n0 - Sair");
            opcao = sc.nextInt();

            System.out.print("Digite número da conta: ");
            String numero = sc.next();
            Conta conta = banco.buscarConta(numero);

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depósito: ");
                    conta.depositar(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Valor para saque: ");
                    conta.sacar(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Conta destino: ");
                    Conta destino = banco.buscarConta(sc.next());
                    System.out.print("Valor da transferência: ");
                    conta.transferir(destino, sc.nextDouble());
                    break;
                case 4:
                    System.out.println("Saldo: " + conta.getSaldo());
                    break;
            }
        } while (opcao != 0);

        sc.close();
    }
}
