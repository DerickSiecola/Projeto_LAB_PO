import java.util.ArrayList;

public class Jogador {
    // Atributos do jogador
    private String nome;
    private String clube;
    private double salario;
    private double valor;
    private int idade;
    private String posicao;

    // Construtor

    public Jogador(String nome, String clube, double salario, double valor, int idade, String posicao) {
        this.nome = nome;
        this.clube = clube;
        this.salario = salario;
        this.valor = valor;
        this.idade = idade;
        this.posicao = posicao;
    }

    // Criando os getters

    public String getNome() {
        return nome;
    }
    public String getClube() {
        return clube;
    }

    public double getSalario() {
        return salario;
    }
    public double getValor() {
        return valor;
    }

    public int getIdade() {
        return idade;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}