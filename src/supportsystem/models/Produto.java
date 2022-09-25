package supportsystem.models;

public class Produto {
    
    private int id_item;
    private String nome_item;
    private int preco;
    private int qtd;

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

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
    @Override
    public String toString(){
        return this.getNome_item();
    }
    public int toInt(){
        return this.getPreco();
    }
}
