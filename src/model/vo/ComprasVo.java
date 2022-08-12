package model.vo;

public class ComprasVo {
    private int Id_compra;
    private String Constructora;
    private String Banco;

    public ComprasVo(int id_compra, String constructora, String banco) {
        Id_compra = id_compra;
        Constructora = constructora;
        Banco = banco;
    }

    public int getId_compra() {return Id_compra;}

    public void setId_compra(int id_compra) {Id_compra = id_compra;}

    public String getConstructora() {return Constructora;}

    public void setConstructora(String constructora) {Constructora = constructora;}

    public String getBanco() {return Banco;}

    public void setBanco(String banco) {Banco = banco;}
}
