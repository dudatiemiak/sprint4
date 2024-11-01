package br.com.fiap.dao;

import br.com.fiap.to.ProblemaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaDAO extends Repository{
    public ArrayList<ProblemaTO> findAll() {
        ArrayList<ProblemaTO> problemas = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas ORDER BY problema";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaTO prob = new ProblemaTO();
                    prob.setProblema(rs.getString("problema"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas;
    }

    public ProblemaTO findByCodigo(String problema) {
        ProblemaTO prob = null;
        String sql = "SELECT * FROM ddd_problemas WHERE problema = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaTO();
                    prob.setProblema(rs.getString("problema"));
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

    public ProblemaTO save(ProblemaTO problema) {
        String sql = "INSERT INTO ddd_problemas (diagnostico, orcamento) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema.getDiagnostico());
            ps.setDouble(2, problema.getOrcamento());
            if (ps.executeUpdate() > 0) {
                return problema;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProblemaTO update(ProblemaTO problema) {
        String sql = "UPDATE ddd_problemas SET diagnostico = ?, orcamento = ? WHERE problema = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema.getDiagnostico());
            ps.setDouble(2, problema.getOrcamento());
            ps.setString(3, problema.getProblema());

            if (ps.executeUpdate() > 0) {
                return problema;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
