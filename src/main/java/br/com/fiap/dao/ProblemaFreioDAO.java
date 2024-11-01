package br.com.fiap.dao;

import br.com.fiap.to.ProblemaFreioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaFreioDAO extends Repository{
    public ArrayList<ProblemaFreioTO> findAll() {
        ArrayList<ProblemaFreioTO> problemas_motor = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_freio ORDER BY problema_freio";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaFreioTO prob = new ProblemaFreioTO();
                    prob.setProblema_freio(rs.getString("problema_freio"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas_motor.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas_motor;
    }

    public ProblemaFreioTO findByCodigo(String problema_freio) {
        ProblemaFreioTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_freio WHERE problema_freio = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_freio);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaFreioTO();
                    prob.setProblema_freio(rs.getString("problema_freio"));
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

    public ProblemaFreioTO save(ProblemaFreioTO problema_freio) {
        String sql = "INSERT INTO ddd_problemas_freio (diagnostico, orcamento) VALUES (?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_freio.getDiagnostico());
            ps.setDouble(2, problema_freio.getOrcamento());
            if (ps.executeUpdate() > 0) {
                return problema_freio;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public ProblemaFreioTO update(ProblemaFreioTO problema_freio) {
        String sql = "UPDATE ddd_problemas_freio SET diagnostico = ?, orcamento = ? WHERE problema_freio = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_freio.getDiagnostico());
            ps.setDouble(2, problema_freio.getOrcamento());
            ps.setString(3, problema_freio.getProblema_freio());

            if (ps.executeUpdate() > 0) {
                return problema_freio;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
