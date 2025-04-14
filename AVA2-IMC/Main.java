import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o peso (em kg): ");
        double peso = entrada.nextDouble();

        System.out.print("Digite a altura (em metros): ");
        double altura = entrada.nextDouble();

        Pessoa pessoa = new Pessoa(nome, peso, altura);

        double imc = pessoa.calcularIMC();
        String classificacao = pessoa.classificarIMC();

        System.out.println("\nResultado:");
        System.out.printf("Nome: %s\n", pessoa.getNome());
        System.out.printf("IMC: %.2f\n", imc);
        System.out.println("Análise: " + classificacao);

        entrada.close();
    }
}
