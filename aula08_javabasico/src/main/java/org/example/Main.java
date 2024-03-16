package org.example;

public class Main {
    public static void main(String[] args) {

        Produto produto1 = new Produto("Arroz", 45.00, 60);

        produto1.exibirInformacoes();

        produto1.negociar();

        Fornecedor fornecedor1 = new Fornecedor(1L, "Ambev", "0800000000");
        FornecedorPremium fornecedorPremium = new FornecedorPremium(fornecedor1.getId(), fornecedor1.getNome(), fornecedor1.getTelefone(), 12.00);

        System.out.println("Taxa de desconto do fornecedor premium: "+fornecedorPremium.getTaxaDesconto());
    }
}