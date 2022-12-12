package supportsystem.models;

public class Produto {
    
    private int id_item;
    private String nome_item;
    private float preco;
    private int qtd;
    private int id_operador;

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

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    public Produto(int id_item, String nome_item, float preco, int qtd, int id_operador) {
        this.id_item = id_item;
        this.nome_item = nome_item;
        this.preco = preco;
        this.qtd = qtd;
        this.id_operador = id_operador;
    }
    
    public Produto(){
        
    }
}
