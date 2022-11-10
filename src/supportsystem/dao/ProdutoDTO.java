package supportsystem.dao;

public class ProdutoDTO {
private int id_item;
private String nome_item;
private float preco;
private int qtde_produto;

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtde_produto() {
        return qtde_produto;
    }

    public void setQtde_produto(int qtde_produto) {
        this.qtde_produto = qtde_produto;
    }
}
