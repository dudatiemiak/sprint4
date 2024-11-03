package br.com.fiap.dao;

import br.com.fiap.to.ProblemaTransmissaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaTransmissaoDAO extends Repository{
    public ArrayList<ProblemaTransmissaoTO> findAll() {
        ArrayList<ProblemaTransmissaoTO> problemas_transmissao = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_transmissao ORDER BY problema_transmissao";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaTransmissaoTO prob = new ProblemaTransmissaoTO();
                    prob.setProblema_transmissao(rs.getString("problema_transmissao"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas_transmissao.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas_transmissao;
    }

    public ProblemaTransmissaoTO findByCodigo(String problema_transmissao) {
        ProblemaTransmissaoTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_transmissao WHERE problema_transmissao = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_transmissao);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaTransmissaoTO();
                    prob.setProblema_transmissao(rs.getString("problema_transmissao"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return prob;
    }

    public ProblemaTransmissaoTO save(ProblemaTransmissaoTO prob) {
        String sql = "INSERT INTO ddd_problemas_transmissao (diagnostico, orcamento) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, prob.getDiagnostico());
            ps.setDouble(2, prob.getOrcamento());
            if (ps.executeUpdate() > 0) {
                return prob;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProblemaTransmissaoTO update(ProblemaTransmissaoTO prob) {
        String sql = "UPDATE ddd_problemas_transmissao SET diagnostico = ?, orcamento = ? WHERE problema_transmissao = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, prob.getDiagnostico());
            ps.setDouble(2, prob.getOrcamento());
            ps.setString(3, prob.getProblema_transmissao());

            if (ps.executeUpdate() > 0) {
                return prob;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
