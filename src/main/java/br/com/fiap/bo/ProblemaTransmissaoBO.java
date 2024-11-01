package br.com.fiap.bo;

import br.com.fiap.dao.ProblemaTransmissaoDAO;
import br.com.fiap.to.ProblemaTransmissaoTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProblemaTransmissaoBO {
    private ProblemaTransmissaoDAO problemaTransmissaoDAO;

    public ArrayList<ProblemaTransmissaoTO> findAll() {
        problemaTransmissaoDAO = new ProblemaTransmissaoDAO();
        //aqui se implementa a regra de negócios
        return  problemaTransmissaoDAO.findAll();
    }

    public ProblemaTransmissaoTO findByCodigo(String problema_transmissao) {
        problemaTransmissaoDAO = new ProblemaTransmissaoDAO();
        // aqui se implementa a regra de negócios
        return problemaTransmissaoDAO.findByCodigo(problema_transmissao);
    }

    public ProblemaTransmissaoTO save(ProblemaTransmissaoTO prob) {
        problemaTransmissaoDAO = new ProblemaTransmissaoDAO();
        //aqui se implementa a regra de negócios
        return problemaTransmissaoDAO.save(prob);
    }

    public ProblemaTransmissaoTO update(ProblemaTransmissaoTO prob) throws SQLException {
        problemaTransmissaoDAO = new ProblemaTransmissaoDAO();
        //aqui se implementa a regra de negócios
        return problemaTransmissaoDAO.update(prob);
    }
}
