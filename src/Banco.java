import java.util.ArrayList;
import java.util.HashMap;

public class Banco {
    private ArrayList<Conta> contas;
    private HashMap<String, Conta> mapContas;

    public Banco() {
        contas = new ArrayList<>();
        mapContas = new HashMap<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
        mapContas.put(conta.getNumero(), conta);
    }

    public Conta buscarConta(String numero) {
        return mapContas.get(numero);
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
