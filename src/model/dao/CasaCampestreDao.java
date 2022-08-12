package model.dao;

import model.vo.CasaCampestreVo;
import util.JDBCUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CasaCampestreDao {

    public List<CasaCampestreVo> consulta() throws SQLException{
        var respuesta= new ArrayList<CasaCampestreVo>();
        try(
                var connection= JDBCUtilities.getConnection();
                var statement=connection.prepareStatement(
                        "SELECT ID_Proyecto, Constructora ,Numero_Habitaciones,Ciudad  FROM Proyecto\n" +
                                "WHERE Clasificacion ='Casa Campestre' AND (Ciudad ='Santa Marta' OR Ciudad ='Cartagena' OR Ciudad ='Barranquilla');"
                );

                var rset=statement.executeQuery();){
            while(rset.next()){
                respuesta.add(new CasaCampestreVo(
                        rset.getInt("ID_Proyecto"),
                        rset.getString("Constructora"),
                        rset.getInt("Numero_Habitaciones"),
                        rset.getString("Ciudad")
                ));
            }
        }
        return respuesta;

    }

}
