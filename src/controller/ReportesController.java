package controller;
import model.dao.ComprasDao;
import model.dao.CasaCampestreDao;
import model.dao.LiderDao;
import model.vo.ComprasVo;
import model.vo.CasaCampestreVo;
import model.vo.LiderVo;

import java.sql.SQLException;
import java.util.List;


public class ReportesController {
    private final LiderDao liderDao;
    private final CasaCampestreDao casacampestreDao;
    private final ComprasDao comprasDao;

    public ReportesController(){
        this.liderDao=new LiderDao();
        this.casacampestreDao=new CasaCampestreDao();
        this.comprasDao=new ComprasDao();
    }

    public List<LiderVo> primerInforme() throws SQLException{
        return liderDao.informe();
    }

    public List<CasaCampestreVo> segundoInforme() throws SQLException{
        return casacampestreDao.consulta();
    }
    public List<ComprasVo> tercerInforme() throws SQLException{
        return comprasDao.consulta();
    }



}
