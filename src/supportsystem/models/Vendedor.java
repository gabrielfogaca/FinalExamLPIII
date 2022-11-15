package supportsystem.models;

public class Vendedor {

    private int id_vendedor;
    private String nome_vendedor;
    private int pc_comissao;

    public int getPc_comissao() {
        return pc_comissao;
    }

    public void setPc_comissao(int pc_comissao) {
        this.pc_comissao = pc_comissao;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    @Override
    public String toString() {
        return this.getNome_vendedor();
    }

}
