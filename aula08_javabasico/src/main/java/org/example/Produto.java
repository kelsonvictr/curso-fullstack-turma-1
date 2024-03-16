package org.example;

public class Produto implements Negociavel {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: "+ nome+ ", Preço: "+preco+", Estoque:"+quantidadeEmEstoque);
    }

    @Override
    public void negociar() {
        if (quantidadeEmEstoque > 0)  {
            quantidadeEmEstoque--;
            System.out.println("Produto negociado. Estoque atual: " + quantidadeEmEstoque);
        } else {
            System.out.println("Não há estoque suficiente para negociar.");
        }
    }
}
