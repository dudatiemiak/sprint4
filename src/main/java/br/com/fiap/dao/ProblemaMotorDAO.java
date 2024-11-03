package br.com.fiap.dao;

import br.com.fiap.to.ProblemaMotorTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaMotorDAO extends Repository{
    public ArrayList<ProblemaMotorTO> findAll() {
        ArrayList<ProblemaMotorTO> problemas_motor = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_motor ORDER BY problema_motor";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaMotorTO prob = new ProblemaMotorTO();
                    prob.setProblema_motor(rs.getString("problema_motor"));
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

    public ProblemaMotorTO findByCodigo(String problema_motor) {
        ProblemaMotorTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_motor WHERE problema_motor = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_motor);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaMotorTO();
                    prob.setProblema_motor(rs.getString("problema_motor"));
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

    public ProblemaMotorTO save(ProblemaMotorTO prob) {
        String sql = "INSERT INTO ddd_problemas_motor (diagnostico, orcamento) VALUES (?, ?)";
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

    public ProblemaMotorTO update(ProblemaMotorTO prob) {
        String sql = "UPDATE ddd_problemas_motor SET diagnostico = ?, orcamento = ? WHERE problema_motor = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, prob.getDiagnostico());
            ps.setDouble(2, prob.getOrcamento());
            ps.setString(3, prob.getProblema_motor());

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
