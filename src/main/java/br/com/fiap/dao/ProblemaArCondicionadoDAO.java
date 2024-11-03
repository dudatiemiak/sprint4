package br.com.fiap.dao;

import br.com.fiap.to.ProblemaArCondicionadoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaArCondicionadoDAO extends Repository{
    public ArrayList<ProblemaArCondicionadoTO> findAll() {
        ArrayList<ProblemaArCondicionadoTO> problemas_ar = new ArrayList<>();
        String sql = "SELECT * FROM ddd_problemas_ar ORDER BY problema_ar";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null){
                while (rs.next()) {
                    ProblemaArCondicionadoTO prob = new ProblemaArCondicionadoTO();
                    prob.setProblema_ar(rs.getString("problema_ar"));
                    prob.setDiagnostico(rs.getString("diagnostico"));
                    prob.setOrcamento(rs.getDouble("orcamento"));
                    problemas_ar.add(prob);
                }
            }else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return problemas_ar;
    }

    public ProblemaArCondicionadoTO findByCodigo(String problema_ar) {
        ProblemaArCondicionadoTO prob = null;
        String sql = "SELECT * FROM ddd_problemas_ar WHERE problema_ar = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, problema_ar);
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    prob = new ProblemaArCondicionadoTO();
                    prob.setProblema_ar(rs.getString("problema_ar"));
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

    public ProblemaArCondicionadoTO save(ProblemaArCondicionadoTO prob) {
        String sql = "INSERT INTO ddd_problemas_ar (diagnostico, orcamento) VALUES (?, ?)";
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

    public ProblemaArCondicionadoTO update(ProblemaArCondicionadoTO prob) {
        String sql = "UPDATE ddd_problemas_ar SET diagnostico = ?, orcamento = ? WHERE problema_ar = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, prob.getDiagnostico());
            ps.setDouble(2, prob.getOrcamento());
            ps.setString(3, prob.getProblema_ar());

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
