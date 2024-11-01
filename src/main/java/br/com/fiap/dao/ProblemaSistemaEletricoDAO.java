package br.com.fiap.dao;

import br.com.fiap.to.ProblemaSistemaEletricoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaSistemaEletricoDAO extends Repository{
    public ArrayList<ProblemaSistemaEletricoTO> findAll() {
        ArrayList<ProblemaSistemaEletricoTO> problemas_se = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_sist_eletrico ORDER BY problema_se";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaSistemaEletricoTO prob = new ProblemaSistemaEletricoTO();
                    prob.setProblema_se(rs.getString("problema_se"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas_se.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas_se;
    }

    public ProblemaSistemaEletricoTO findByCodigo(String problema_se) {
        ProblemaSistemaEletricoTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_sist_eletrico WHERE problema_se = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_se);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaSistemaEletricoTO();
                    prob.setProblema_se(rs.getString("problema_se"));
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

    public ProblemaSistemaEletricoTO save(ProblemaSistemaEletricoTO problema_se) {
        String sql = "INSERT INTO ddd_problemas_sist_eletrico (diagnostico, orcamento) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_se.getDiagnostico());
            ps.setDouble(2, problema_se.getOrcamento());
            if (ps.executeUpdate() > 0) {
                return problema_se;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProblemaSistemaEletricoTO update(ProblemaSistemaEletricoTO problema_se) {
        String sql = "UPDATE ddd_problemas_sist_eletrico SET diagnostico = ?, orcamento = ? WHERE problema_se = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_se.getDiagnostico());
            ps.setDouble(2, problema_se.getOrcamento());
            ps.setString(3, problema_se.getProblema_se());

            if (ps.executeUpdate() > 0) {
                return problema_se;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
