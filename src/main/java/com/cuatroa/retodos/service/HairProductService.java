package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.HairProduct;
import com.cuatroa.retodos.repository.HairProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author desaextremo
 */
@Service
public class HairProductService {

    @Autowired
    private HairProductRepository repository;

    public List<HairProduct> getAll() {
        return repository.getAll();
    }

    public Optional<HairProduct> getProduct(String reference) {
        return repository.getProduct(reference);
    }

    public HairProduct create(HairProduct accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public HairProduct update(HairProduct accesory) {

        if (accesory.getReference() != null) {
            Optional<HairProduct> accesoryDb = repository.getProduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {

                if (accesory.getBrand() != null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }

                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }

                if (accesory.getName() != null) {
                    accesoryDb.get().setName(accesory.getName());
                }

                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProduct(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    //Reto 5
    public List<HairProduct> productByPrice(double price) {
        return repository.productByPrice(price);
    }
    //Reto 5
    public List<HairProduct> findByDescriptionLike(String description) {
        return repository.findByDescriptionLike(description);
    }

}
