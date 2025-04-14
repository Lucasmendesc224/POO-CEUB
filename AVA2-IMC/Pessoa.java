public class Pessoa {
    private String nome;
    private double peso;
    private double altura;

    public Pessoa(String nome, double peso, double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String classificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) {
            return "Baixo peso. Procure um médico para avaliação.";
        } else if (imc < 25) {
            return "Peso adequado. Avalie outros parâmetros corporais.";
        } else if (imc < 30) {
            return "Sobrepeso. Risco de doenças como diabetes e hipertensão.";
        } else if (imc < 35) {
            return "Obesidade grau I. Busque orientação médica e nutricional.";
        } else if (imc < 40) {
            return "Obesidade grau II. Quadro mais evoluído, procure ajuda.";
        } else {
            return "Obesidade grau III. Alta chance de doenças associadas.";
        }
    }

    public String getNome() {
        return nome;
    }
}
