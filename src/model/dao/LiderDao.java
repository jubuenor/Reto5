package model.dao;

import model.vo.LiderVo;
import util.JDBCUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class LiderDao {

    public List<LiderVo> informe() throws SQLException{
        var respuesta=new ArrayList<LiderVo>();
        try(var connection = JDBCUtilities.getConnection();
                var statement = connection.prepareStatement(
                        "SELECT ID_Lider, Nombre , Primer_Apellido as Apellido, Ciudad_Residencia as Ciudad FROM Lider l \n" +
                                "ORDER BY ciudad;"
                );
                var rset = statement.executeQuery()){

            while(rset.next()){
                respuesta.add(new LiderVo(
                        rset.getInt("ID_Lider"),
                        rset.getString("Nombre"),
                        rset.getString("Apellido"),
                        rset.getString("Ciudad")));
            }
        }
        return respuesta;
    }


}

