package br.com.psouza.dao;

import br.com.psouza.domain.Sale;

public class SaleDAO extends GenericDAO<Sale, Long>{
    public SaleDAO(Class<Sale> persistentClass, String persistenceUnitName) {
        super(Sale.class);
    }
}
