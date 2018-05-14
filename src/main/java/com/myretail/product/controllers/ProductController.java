package com.myretail.product.controllers;

import com.myretail.product.domain.ProductPriceResponse;
import com.myretail.product.domain.ProductPriceUpsertRequest;
import com.myretail.product.exception.NotFoundException;
import com.myretail.product.service.ProductPriceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/products")
public class ProductController
{

    private final ProductPriceService productPriceService;

    public ProductController(ProductPriceService productPriceService)  throws IOException {
        this.productPriceService = productPriceService;
    }

    /**
     * Health Check service
     *
     * Raghavi
     * @return
     */
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String getHealth()  {

        return "I am running";
    }

    /** to find the Product information by the productId
     *
     * @param id
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductbyId(@PathVariable long id) throws IOException {

        ProductPriceResponse pr = productPriceService.getProductById(id);
        if (pr == null) {
                throw new NotFoundException();
        }
        return new ResponseEntity<ProductPriceResponse>( pr, HttpStatus.OK);
    }

    /**
     * To Update the product price details for a given product ID
     * @param id
     * @param productPriceUpdateRequest
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@PathVariable Long id,
                                 @RequestBody @Valid ProductPriceUpsertRequest productPriceUpdateRequest) {
         return productPriceService.upsertPrice(id, productPriceUpdateRequest);

    }

}
