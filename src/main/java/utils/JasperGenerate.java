/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.net.URL;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        URL arquivo = getClass().getResource(layout);
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

    public void gerarComConsulta(String layout, Map parametros, String titleWindow) throws JRException, SQLException, ClassNotFoundException {

//gerando o jasper design
//        JasperDesign desenho = JRXmlLoader.load(layout);
//compila o relat�rio
        //      JasperReport relatorio = JasperCompileManager.compileReport(desenho);
//estabelece conex�o
        URL arquivo = getClass().getResource(layout);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        Connection con = new Conexao().conectar();
        Statement stm = con.createStatement();
        String query = "select f.nome as funcionario, s.descricao as servico, count(sa.id) as qtde, "
                + "(count(sa.id)*s.valor) as valor_total, ((count(sa.id)*s.valor)/2) as valor_comissao "
                + " from agendamento as a"
                + " inner join servico_agendamento as sa on sa.id_agendamento = a.id"
                + " inner join servico as s on s.id = sa.id_servico"
                + " inner join funcionario as f on f.id = sa.id_funcionario"
                + " where cast(data_hora as date) between ('" + parametros.get("data_inicial") + "') and (last_day('" + parametros.get("data_inicial") + "'))"
                + " " + parametros.get("where_funcionario")
                + " group by f.nome, s.descricao"
                + " order by f.nome, s.descricao";
        ResultSet rs = stm.executeQuery(query);

//implementa��o da interface JRDataSource para DataSource ResultSet
        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

//executa o relat�rio
        /*Map parametros = new HashMap();
        parametros.put("nota", new Double(10));*/
        JasperPrint impressao = JasperFillManager.fillReport(jasperReport, parametros, jrRS);

//exibe o resultado
        JasperViewer viewer = new JasperViewer(impressao, true);
        viewer.setTitle(titleWindow);
        viewer.setExtendedState(6);
        viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewer.setAlwaysOnTop(true);
        viewer.setVisible(true);
    }
}
