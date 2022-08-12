package model.vo;

public class CasaCampestreVo {
    private int Id_proyecto;
    private String Constructora;
    private int N_habitaciones;
    private String Ciudad;

    public CasaCampestreVo(int id_proyecto, String constructora, int n_habitaciones, String ciudad) {
        Id_proyecto = id_proyecto;
        Constructora = constructora;
        N_habitaciones = n_habitaciones;
        Ciudad = ciudad;
    }

    public int getId_proyecto() {return Id_proyecto;}

    public void setId_proyecto(int id_proyecto) {Id_proyecto = id_proyecto;}

    public String getConstructora() {return Constructora;}

    public void setConstructora(String constructora) {Constructora = constructora;}

    public int getN_habitaciones() {return N_habitaciones;}

    public void setN_habitaciones(int n_habitaciones) {N_habitaciones = n_habitaciones;}

    public String getCiudad() {return Ciudad;}

    public void setCiudad(String ciudad) {Ciudad = ciudad;}
}
