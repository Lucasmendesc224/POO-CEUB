import java.util.Scanner;
import java.util.Locale;

public class IMCApp {

    public static void main(String[] args) {
        // Força o Scanner a usar ponto (.) como separador decimal
        Locale.setDefault(Locale.US);
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o peso (em kg, use ponto): ");
        double peso = entrada.nextDouble();

        System.out.print("Digite a altura (em metros, use ponto): ");
        double altura = entrada.nextDouble();

        Pessoa pessoa = new Pessoa(nome, peso, altura);

        double imc = pessoa.calcularIMC();
        String classificacao = pessoa.classificarIMC();

        System.out.println("\nResultado:");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.printf("IMC: %.2f\n", imc);
        System.out.println("Análise: " + classificacao);

        entrada.close();
    }
}

class Pessoa {
    private String nome;
    private double peso;
    private
