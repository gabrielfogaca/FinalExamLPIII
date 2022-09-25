package supportsystem.dao;

public class VendaDTO {
    private String nome_cliente;
    private String nome_vendedor;
    private String nome_item;
    private int valor_venda;

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public int getValor_venda() {
        return valor_venda;
    }

    public void setValor_venda(int valor_venda) {
        this.valor_venda = valor_venda;
    }
    
    
}
