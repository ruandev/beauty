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

        URL arquivo = getClass().getResource(layout);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        Connection con = new Conexao().conectar();

        JasperPrint impressao = JasperFillManager.fillReport(jasperReport, parametros, con);

        JasperViewer viewer = new JasperViewer(impressao);
        viewer.setTitle(titleWindow);
        viewer.setExtendedState(6);
        viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewer.setAlwaysOnTop(true);
        viewer.setVisible(true);
    }

    public void gerarComissaoMensal(String layout, Map parametros, String titleWindow) throws JRException, SQLException, ClassNotFoundException {

        URL arquivo = getClass().getResource(layout);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(arquivo);
        Connection con = new Conexao().conectar();
        Statement stm = con.createStatement();
        String query;
        if((parametros.get("where_funcionario")) != null){
            query = "select f.nome as funcionario, s.descricao as servico, count(sa.id) as qtde, "
                + "(count(sa.id)*(if(sa.valor IS NULL, s.valor, sa.valor))) as valor_total, ((count(sa.id)*(if(sa.valor IS NULL, s.valor, sa.valor)))/2) as valor_comissao "
                + " from agendamento as a"
                + " inner join servico_agendamento as sa on sa.id_agendamento = a.id"
                + " inner join servico as s on s.id = sa.id_servico"
                + " inner join funcionario as f on f.id = sa.id_funcionario"
                + " where cast(data_hora as date) between ('" + parametros.get("data_inicial") + "') and (last_day('" + parametros.get("data_inicial") + "'))"
                + " " + parametros.get("where_funcionario")
                + " group by f.nome, s.descricao"
                + " order by f.nome, s.descricao";
        } else {
            query = "select f.nome as funcionario, s.descricao as servico, count(sa.id) as qtde, "
                + "(count(sa.id)*sa.valor) as valor_total, ((count(sa.id)*sa.valor)/2) as valor_comissao "
                + " from agendamento as a"
                + " inner join servico_agendamento as sa on sa.id_agendamento = a.id"
                + " inner join servico as s on s.id = sa.id_servico"
                + " inner join funcionario as f on f.id = sa.id_funcionario"
                + " where cast(data_hora as date) between ('" + parametros.get("data_inicial") + "') and (last_day('" + parametros.get("data_inicial") + "'))"
                + " group by f.nome, s.descricao"
                + " order by f.nome, s.descricao";
        }
        ResultSet rs = stm.executeQuery(query);

        JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);

        JasperPrint impressao = JasperFillManager.fillReport(jasperReport, parametros, jrRS);

        JasperViewer viewer = new JasperViewer(impressao);
        viewer.setTitle(titleWindow);
        viewer.setExtendedState(6);
        viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewer.setAlwaysOnTop(true);
        viewer.setVisible(true);
    }
}
