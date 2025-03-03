package br.com.psouza.dao;

import br.com.psouza.domain.Product;

public class ProductDAO extends GenericDAO<Product, Long>{
    public ProductDAO(Class<Product> persistentClass, String persistenceUnitName) {
        super(Product.class);
    }
}
