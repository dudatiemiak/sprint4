package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaSuspensaoDAO;
import br.com.fiap.to.ProblemaSuspensaoTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaSuspensaoBO {
    private ProblemaSuspensaoDAO problemaSuspensaoDAO;

    public ArrayList<ProblemaSuspensaoTO> findAll() {
        problemaSuspensaoDAO = new ProblemaSuspensaoDAO();
        //aqui se implementa a regra de negócios
        return  problemaSuspensaoDAO.findAll();
    }

    public ProblemaSuspensaoTO findByCodigo(String problema_suspensao) {
        problemaSuspensaoDAO = new ProblemaSuspensaoDAO();
        // aqui se implementa a regra de negócios
        return problemaSuspensaoDAO.findByCodigo(problema_suspensao);
    }

    public ProblemaSuspensaoTO save(ProblemaSuspensaoTO prob) {
        problemaSuspensaoDAO = new ProblemaSuspensaoDAO();
        //aqui se implementa a regra de negócios
        return problemaSuspensaoDAO.save(prob);
    }

    public ProblemaSuspensaoTO update(ProblemaSuspensaoTO prob) throws SQLException {
        problemaSuspensaoDAO = new ProblemaSuspensaoDAO();
        //aqui se implementa a regra de negócios
        return problemaSuspensaoDAO.update(prob);
    }
}
