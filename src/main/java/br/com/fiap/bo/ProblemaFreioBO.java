package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaFreioDAO;
import br.com.fiap.to.ProblemaFreioTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaFreioBO {
    private ProblemaFreioDAO problemaFreioDAO;

    public ArrayList<ProblemaFreioTO> findAll() {
        problemaFreioDAO = new ProblemaFreioDAO();
        //aqui se implementa a regra de negócios
        return  problemaFreioDAO.findAll();
    }

    public ProblemaFreioTO findByCodigo(String problema_freio) {
        problemaFreioDAO = new ProblemaFreioDAO();
        // aqui se implementa a regra de negócios
        return problemaFreioDAO.findByCodigo(problema_freio);
    }

    public ProblemaFreioTO save(ProblemaFreioTO prob) {
        problemaFreioDAO = new ProblemaFreioDAO();
        //aqui se implementa a regra de negócios
        return problemaFreioDAO.save(prob);
    }

    public ProblemaFreioTO update(ProblemaFreioTO prob) throws SQLException {
        problemaFreioDAO = new ProblemaFreioDAO();
        //aqui se implementa a regra de negócios
        return problemaFreioDAO.update(prob);
    }
}
