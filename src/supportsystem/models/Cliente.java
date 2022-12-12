package supportsystem.models;

public class Cliente {

    private int id_cliente;
    private String nome_cliente;
    private int id_tipo_cliente;
    private int id_operador;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getId_tipo_cliente() {
        return id_tipo_cliente;
    }

    public void setId_tipo_cliente(int id_tipo_cliente) {
        this.id_tipo_cliente = id_tipo_cliente;
    }

    @Override
    public String toString() {
        return this.getNome_cliente();
    }

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    
    public Cliente(int id_cliente, String nome_cliente, int id_tipo_cliente, int id_operador) {
        this.id_cliente = id_cliente;
        this.nome_cliente = nome_cliente;
        this.id_tipo_cliente = id_tipo_cliente;
        this.id_operador = id_operador;
    }

    public Cliente() {
    }
}
