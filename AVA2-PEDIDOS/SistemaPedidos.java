import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Vendedor {
    private String nome;
    private String matricula;

    public Vendedor(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    
    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
}

class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;

    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
    public String getTelefone() { return telefone; }
}

class ItemPedido {
    private String codigoProduto;
    private String descricao;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(String codigoProduto, String descricao, int quantidade, double precoUnitario) {
        this.codigoProduto = codigoProduto;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    
    public String getCodigoProduto() { return codigoProduto; }
    public String getDescricao() { return descricao; }
    public int getQuantidade() { return quantidade; }
    public double getPrecoUnitario() { return precoUnitario; }

    public double calcularSubtotal() {
        return quantidade * precoUnitario;
    }
}

class Pedido {
    private int id;
    private Date dataHora;
    private Vendedor vendedor;
    private Cliente cliente;
    private String status;
    private List<ItemPedido> itens;
    private double valorTotal;

    public Pedido(int id, Vendedor vendedor, Cliente cliente) {
        this.id = id;
        this.dataHora = new Date();
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.status = "Processando";
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
        calcularValorTotal();
    }

    public void removerItem(String codigoProduto) {
        itens.removeIf(item -> item.getCodigoProduto().equals(codigoProduto));
        calcularValorTotal();
    }

    public void calcularValorTotal() {
        valorTotal = 0.0;
        for (ItemPedido item : itens) {
            valorTotal += item.calcularSubtotal();
        }
    }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }

    public void aplicarDesconto(double percentual) {
        double desconto = valorTotal * (percentual / 100.0);
        valorTotal -= desconto;
    }

    
    public int getId() { return id; }
    public String getStatus() { return status; }
    public double getValorTotal() { return valorTotal; }
    public List<ItemPedido> getItens() { return itens; }
}

public class SistemaPedidos {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Carlos Silva", "12345");
        Cliente cliente = new Cliente("Ana Souza", "111.222.333-44", "Rua das Flores, 123", "(11) 99999-9999");
        
        Pedido pedido = new Pedido(1, vendedor, cliente);
        
        ItemPedido item1 = new ItemPedido("P001", "Notebook", 1, 3500.00);
        ItemPedido item2 = new ItemPedido("P002", "Mouse", 2, 150.00);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        System.out.println("Valor total do pedido: R$" + pedido.getValorTotal());
        
        pedido.aplicarDesconto(10); // 10% de desconto
        System.out.println("Valor total com desconto: R$" + pedido.getValorTotal());

        pedido.atualizarStatus("Enviado");
        System.out.println("Status atual do pedido: " + pedido.getStatus());
    }
}
