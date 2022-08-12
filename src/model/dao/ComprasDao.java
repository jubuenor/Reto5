package model.dao;

import model.vo.ComprasVo;
import util.JDBCUtilities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComprasDao {

    public List<ComprasVo> consulta() throws SQLException{
        var respuesta= new ArrayList<ComprasVo>();
        try(
                var connection = JDBCUtilities.getConnection();
                var statement=connection.prepareStatement(
                        "SELECT c.ID_Compra,p.Constructora , Banco_Vinculado FROM  Compra c\n" +
                                "INNER JOIN Proyecto p \n" +
                                "ON p.ID_Proyecto = c.ID_Proyecto \n" +
                                "WHERE Proveedor ='Homecenter';"
                );
                var rset=statement.executeQuery();
                ){
            while(rset.next()){
                respuesta.add(new ComprasVo(
                        rset.getInt("ID_Compra"),
                        rset.getString("Constructora"),
                        rset.getString("Banco_Vinculado")
                ));
            }
        }
        return respuesta;
    }
}
