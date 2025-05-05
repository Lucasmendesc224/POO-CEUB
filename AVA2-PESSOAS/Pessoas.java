public abstract class Pessoa {
    protected String nome;
    protected String documento; 
    protected String endereco;
    protected String telefone;
    protected String email;

    public Pessoa(String nome, String documento, String endereco, String telefone, String email) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public abstract void exibirDados();
}

public class Cliente extends Pessoa {
    private String dataCadastro;
    private String historicoCompras;

    public Cliente(String nome, String documento, String endereco, String telefone, String email, String dataCadastro, String historicoCompras) {
        super(nome, documento, endereco, telefone, email);
        this.dataCadastro = dataCadastro;
        this.historicoCompras = historicoCompras;
    }

    @Override
    public void exibirDados() {
        System.out.println("Cliente: " + nome + ", Histórico: " + historicoCompras);
    }
}

public class Fornecedor extends Pessoa {
    private String produtosFornecidos;

    public Fornecedor(String nome, String documento, String endereco, String telefone, String email, String produtosFornecidos) {
        super(nome, documento, endereco, telefone, email);
        this.produtosFornecidos = produtosFornecidos;
    }

    @Override
    public void exibirDados() {
        System.out.println("Fornecedor: " + nome + ", Produtos: " + produtosFornecidos);
    }
}

public class Empregado extends Pessoa {
    protected String matricula;
    protected String cargo;
    protected double salario;

    public Empregado(String nome, String documento, String endereco, String telefone, String email, String matricula, String cargo, double salario) {
        super(nome, documento, endereco, telefone, email);
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
    }

    @Override
    public void exibirDados() {
        System.out.println("Empregado: " + nome + ", Cargo: " + cargo + ", Salário: " + salario);
    }
}

public class Vendedor extends Empregado {
    private double comissao;
    private double metas;

    public Vendedor(String nome, String documento, String endereco, String telefone, String email, String matricula, String cargo, double salario, double comissao, double metas) {
        super(nome, documento, endereco, telefone, email, matricula, cargo, salario);
        this.comissao = comissao;
        this.metas = metas;
    }

    @Override
    public void exibirDados() {
        System.out.println("Vendedor: " + nome + ", Comissão: " + comissao + ", Metas: " + metas);
    }
}

public class UsuarioERP extends Pessoa {
    private String login;
    private String senha;
    private int nivelAcesso;

    public UsuarioERP(String nome, String documento, String endereco, String telefone, String email, String login, String senha, int nivelAcesso) {
        super(nome, documento, endereco, telefone, email);
        this.login = login;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public void exibirDados() {
        System.out.println("Usuário: " + nome + ", Acesso: " + nivelAcesso);
    }
}

