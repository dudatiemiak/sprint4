package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaArCondicionadoDAO;
import br.com.fiap.to.ProblemaArCondicionadoTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaArCondicionadoBO {
    private ProblemaArCondicionadoDAO problemaArCondicionadoDAO;

    public ArrayList<ProblemaArCondicionadoTO> findAll() {
        problemaArCondicionadoDAO = new ProblemaArCondicionadoDAO();
        //aqui se implementa a regra de negócios
        return  problemaArCondicionadoDAO.findAll();
    }

    public ProblemaArCondicionadoTO findByCodigo(String problema_ar) {
        problemaArCondicionadoDAO = new ProblemaArCondicionadoDAO();
        // aqui se implementa a regra de negócios
        return problemaArCondicionadoDAO.findByCodigo(problema_ar);
    }

    public ProblemaArCondicionadoTO save(ProblemaArCondicionadoTO prob) {
        problemaArCondicionadoDAO = new ProblemaArCondicionadoDAO();
        //aqui se implementa a regra de negócios
        return problemaArCondicionadoDAO.save(prob);
    }

    public ProblemaArCondicionadoTO update(ProblemaArCondicionadoTO prob) throws SQLException {
        problemaArCondicionadoDAO = new ProblemaArCondicionadoDAO();
        //aqui se implementa a regra de negócios
        return problemaArCondicionadoDAO.update(prob);
    }
}
