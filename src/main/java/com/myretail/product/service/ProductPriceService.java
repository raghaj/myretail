package com.myretail.product.service;


import com.myretail.product.client.ProductLookupClient;
import com.myretail.product.domain.ProductPrice;
import com.myretail.product.domain.ProductPriceResponse;
import com.myretail.product.domain.ProductPriceUpsertRequest;
import com.myretail.product.repositories.ProductPriceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class ProductPriceService {

	private static final Logger log = LoggerFactory.getLogger(ProductPriceService.class);

	@Autowired
	private ProductPriceRepository productPriceRepository;

	@Autowired
	private ProductLookupClient productLookupClient;

	@Autowired
	RestTemplate restTemplate;


	public String getHealth() {
 		return "I am running";
	}


	public ProductPriceResponse getProductById(long id) {
		String productTitle = productLookupClient.findProductTitlebyId(id);
		ProductPrice price = productPriceRepository.findById(id);
		ProductPriceResponse response = new ProductPriceResponse();
		response.setPrice(price);
		response.setId(id);
		response.setName(productTitle);
   		return response;
	}

	public ResponseEntity upsertPrice(long id, ProductPriceUpsertRequest productPriceUpsertRequest) {
		log.info("upsert price - " + id);
		ProductPrice pp = productPriceRepository.findById(id);
		if (pp == null) {
			 pp = new ProductPrice(Long.toString(id));
		}
		pp.setValue(productPriceUpsertRequest.getValue());
		pp.setCurrCode(productPriceUpsertRequest.getCurrency_code());
		productPriceRepository.save(pp);
		return new ResponseEntity(getProductById(id), HttpStatus.OK);

	}

}
