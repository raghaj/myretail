package com.myretail.product.repositories;

import com.myretail.product.domain.ProductPrice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPriceRepository extends MongoRepository<ProductPrice, String> {

    ProductPrice findById(long id);


}
