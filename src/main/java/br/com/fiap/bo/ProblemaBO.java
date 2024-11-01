package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaDAO;
import br.com.fiap.to.ProblemaTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaBO {
    private ProblemaDAO problemaDAO;

    public ArrayList<ProblemaTO> findAll() {
        problemaDAO = new ProblemaDAO();
        //aqui se implementa a regra de negócios
        return  problemaDAO.findAll();
    }

    public ProblemaTO findByCodigo(String problema) {
        problemaDAO = new ProblemaDAO();
        // aqui se implementa a regra de negócios
        return problemaDAO.findByCodigo(problema);
    }

    public ProblemaTO save(ProblemaTO prob) {
        problemaDAO = new ProblemaDAO();
        //aqui se implementa a regra de negócios
        return problemaDAO.save(prob);
    }

    public ProblemaTO update(ProblemaTO prob) throws SQLException {
        problemaDAO = new ProblemaDAO();
        //aqui se implementa a regra de negócios
        return problemaDAO.update(prob);
    }
}
