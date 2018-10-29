/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.URL;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * @author skate
 */
public class JasperGenerate {

    public void gerar(String layout, Map parametros, String titleWindow) throws JRException, SQLException, ClassNotFoundException {

//gerando o jasper design
//        JasperDesign desenho = JRXmlLoader.load(layout);

//compila o relat�rio
  //      JasperReport relatorio = JasperCompileManager.compileReport(desenho);

//estabelece conex�o
        URL arquivo = getClass().getResource("/reports/Recibo.jasper");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        Connection con = new Conexao().conectar();
        /*Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(query);
        
//implementa��o da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);*/

//executa o relat�rio
        /*Map parametros = new HashMap();
        parametros.put("nota", new Double(10));*/
        JasperPrint impressao = JasperFillManager.fillReport(jasperReport, parametros, con);

//exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        viewer.setTitle(titleWindow);
        viewer.setExtendedState(6);
        viewer.setVisible(true);
    }
}
