package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaMotorDAO;
import br.com.fiap.to.ProblemaMotorTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaMotorBO {
    private ProblemaMotorDAO problemaMotorDAO;

    public ArrayList<ProblemaMotorTO> findAll() {
        problemaMotorDAO = new ProblemaMotorDAO();
        //aqui se implementa a regra de negócios
        return  problemaMotorDAO.findAll();
    }

    public ProblemaMotorTO findByCodigo(String problema_motor) {
        problemaMotorDAO = new ProblemaMotorDAO();
        // aqui se implementa a regra de negócios
        return problemaMotorDAO.findByCodigo(problema_motor);
    }

    public ProblemaMotorTO save(ProblemaMotorTO prob) {
        problemaMotorDAO = new ProblemaMotorDAO();
        //aqui se implementa a regra de negócios
        return problemaMotorDAO.save(prob);
    }

    public ProblemaMotorTO update(ProblemaMotorTO prob) throws SQLException {
        problemaMotorDAO = new ProblemaMotorDAO();
        //aqui se implementa a regra de negócios
        return problemaMotorDAO.update(prob);
    }
}
