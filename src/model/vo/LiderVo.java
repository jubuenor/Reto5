package model.vo;

public class LiderVo {
    private int Id_lider;
    private String Nombre;
    private String PrimerApellido;
    private String Ciudad;

    public LiderVo(int id_lider, String nombre, String primerApellido, String ciudad) {
        Id_lider = id_lider;
        Nombre = nombre;
        PrimerApellido = primerApellido;
        Ciudad = ciudad;
    }

    public int getId_lider() {return Id_lider;}

    public void setId_lider(int id_lider) {Id_lider = id_lider;}

    public String getNombre() {return Nombre;}

    public void setNombre(String nombre) {Nombre = nombre;}

    public String getPrimerApellido() {return PrimerApellido;}

    public void setPrimerApellido(String primerApellido) {PrimerApellido = primerApellido;}

    public String getCiudad() {return Ciudad;}

    public void setCiudad(String ciudad) {Ciudad = ciudad;}
}
