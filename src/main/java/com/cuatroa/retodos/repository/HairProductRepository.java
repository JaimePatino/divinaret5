package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.HairProductCrudRepository;

/**
 *
 * @author desaextremo
 */
@Repository
public class HairProductRepository {

    @Autowired
    private HairProductCrudRepository repository;

    public List<HairProduct> getAll() {
        return repository.findAll();
    }

    public Optional<HairProduct> getProduct(String reference) {
        return repository.findById(reference);
    }

    public HairProduct create(HairProduct clothe) {
        return repository.save(clothe);
    }

    public void update(HairProduct clothe) {
        repository.save(clothe);
    }

    public void delete(HairProduct clothe) {
        repository.delete(clothe);
    }
    //Reto 5
    public List<HairProduct> productByPrice(double precio) {
        return repository.findByPriceLessThanEqual(precio);
    }
    
     //Reto 5
    public List<HairProduct> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }
}
