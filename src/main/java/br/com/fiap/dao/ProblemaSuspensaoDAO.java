package br.com.fiap.dao;

import br.com.fiap.to.ProblemaSuspensaoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaSuspensaoDAO extends Repository{
    public ArrayList<ProblemaSuspensaoTO> findAll() {
        ArrayList<ProblemaSuspensaoTO> problemas_suspensao = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_suspensao ORDER BY problema_suspensao";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaSuspensaoTO prob = new ProblemaSuspensaoTO();
                    prob.setProblema_suspensao(rs.getString("problema_suspensao"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas_suspensao.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas_suspensao;
    }

    public ProblemaSuspensaoTO findByCodigo(String problema_suspensao) {
        ProblemaSuspensaoTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_suspensao WHERE problema_suspensao = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_suspensao);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaSuspensaoTO();
                    prob.setProblema_suspensao(rs.getString("problema_suspensao"));
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

    public ProblemaSuspensaoTO save(ProblemaSuspensaoTO problema_suspensao) {
        String sql = "INSERT INTO ddd_problemas_suspensao (diagnostico, orcamento) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_suspensao.getDiagnostico());
            ps.setDouble(2, problema_suspensao.getOrcamento());
            if (ps.executeUpdate() > 0) {
                return problema_suspensao;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProblemaSuspensaoTO update(ProblemaSuspensaoTO problema_suspensao) {
        String sql = "UPDATE ddd_problemas_suspensao SET diagnostico = ?, orcamento = ? WHERE problema_suspensao = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_suspensao.getDiagnostico());
            ps.setDouble(2, problema_suspensao.getOrcamento());
            ps.setString(3, problema_suspensao.getProblema_suspensao());

            if (ps.executeUpdate() > 0) {
                return problema_suspensao;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
