package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaSistemaEletricoDAO;
import br.com.fiap.to.ProblemaSistemaEletricoTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaSistemaEletricoBO {
    private ProblemaSistemaEletricoDAO problemaSistemaEletricoDAO;

    public ArrayList<ProblemaSistemaEletricoTO> findAll() {
        problemaSistemaEletricoDAO = new ProblemaSistemaEletricoDAO();
        //aqui se implementa a regra de negócios
        return  problemaSistemaEletricoDAO.findAll();
    }

    public ProblemaSistemaEletricoTO findByCodigo(String problema_se) {
        problemaSistemaEletricoDAO = new ProblemaSistemaEletricoDAO();
        // aqui se implementa a regra de negócios
        return problemaSistemaEletricoDAO.findByCodigo(problema_se);
    }

    public ProblemaSistemaEletricoTO save(ProblemaSistemaEletricoTO prob) {
        problemaSistemaEletricoDAO = new ProblemaSistemaEletricoDAO();
        //aqui se implementa a regra de negócios
        return problemaSistemaEletricoDAO.save(prob);
    }

    public ProblemaSistemaEletricoTO update(ProblemaSistemaEletricoTO prob) throws SQLException {
        problemaSistemaEletricoDAO = new ProblemaSistemaEletricoDAO();
        //aqui se implementa a regra de negócios
        return problemaSistemaEletricoDAO.update(prob);
    }
}
