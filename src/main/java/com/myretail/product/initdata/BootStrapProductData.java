package com.myretail.product.initdata;


import com.myretail.product.domain.ProductPrice;
import com.myretail.product.repositories.ProductPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/1/17.
 */
@Component
public class BootStrapProductData implements CommandLineRunner {

    private final ProductPriceRepository productPriceRepository;

    public BootStrapProductData(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    /**
     * Initialize the MongoDB with few initial recordsd
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        //clear old data
        //15117729, 16483589, 16696652, 16752456, 15643793
        productPriceRepository.deleteAll();
        long id = 13860428L;
        ProductPrice p = new ProductPrice(new Long(id).toString());
        productPriceRepository.save(p);

    }
}

