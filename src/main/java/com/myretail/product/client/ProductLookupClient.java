package com.myretail.product.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;



@Slf4j
@Setter
@Component
@ConfigurationProperties("product-lookup")
public class ProductLookupClient {

	private static final Logger log = LoggerFactory.getLogger(ProductLookupClient.class);

	private static final String PRODUCT_NAME_FIELD = "productName";

	@Autowired
	RestTemplate restTemplate;

	private String baseUrlPrefix;
	private String baseUrlSuffix;


	/**
	 * findProductTitlebyId :  Retrieves the product title using an external Rest call
	 *
	 * Raghavi
	 * @param id
	 * @return
	 */
	public String findProductTitlebyId(long id) {

		String idstr = new Long(id).toString();
		String url = baseUrlPrefix + idstr + baseUrlSuffix;
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("id", idstr) ;

		ObjectMapper infoMapper = new ObjectMapper();
		Map<String, Map> productInfoMap;

		try {

			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, urlVariables);
			productInfoMap = infoMapper.readValue(response.getBody(), Map.class);


			Map<String, Map> productMap = productInfoMap.get("product");
			Map<String, Map> itemMap = productMap.get("item");
			Map<String, String> prodDescrMap = itemMap.get(("product_description"));
			return prodDescrMap.get("title");
		} catch (Exception e) {
			//throw new ProductNotFoundException();
			//hrow new Exception();
			log.error(e.getMessage());
			return null;
		}
	}

}



