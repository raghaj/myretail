package controllers;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.product.controllers.ProductController;
import com.myretail.product.domain.ProductPrice;
import com.myretail.product.domain.ProductPriceResponse;
import com.myretail.product.domain.ProductPriceUpsertRequest;
import com.myretail.product.exception.NotFoundException;
import com.myretail.product.service.ProductPriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

   @Mock
    ProductPriceService productPriceService;

    @InjectMocks
     ProductController mockProductController;

    private MockMvc mockMvc;

    private ObjectMapper mapper;

    ProductPriceUpsertRequest productPriceUpsertRequest;

    ProductPriceResponse productResponse;



    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mapper = new ObjectMapper(new JsonFactory());
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.mockProductController).build();


        long id = 13860428L;
        ProductPrice p = new ProductPrice(new Long(id).toString());
        p.setValue(100.0);
        p.setCurrCode("USD");

        productResponse=new ProductPriceResponse();
        productResponse.setId(id);
        productResponse.setName("The Test Prod Name");
        productResponse.setPrice(p);


    }


    @Test
    public void testUpdate() {
        long id = 13860428L;
        ProductPriceUpsertRequest req = new ProductPriceUpsertRequest();
        req.setCurrency_code("USD");
        req.setValue(100.00);

        ProductPrice price = new ProductPrice("1");

        ProductPriceResponse productResponse1=new ProductPriceResponse();
        productResponse1.setId(id);
        productResponse1.setName("The Test Prod Name");
        productResponse1.setPrice(price);

        ResponseEntity<String> outputresults= new ResponseEntity<String>("Success", HttpStatus.OK);

         when(mockProductController.update(id, req)).thenReturn(outputresults);

         mockProductController.update( id,req);


    }


/*   @Test
    public void testGetProduct() throws Exception {

        long id = 13860428L;
        ProductPrice p = new ProductPrice(new Long(id).toString());
        p.setValue(100.0);
        p.setCurrCode("USD");
        ProductPriceResponse productResponse=new ProductPriceResponse();
        productResponse.setId(id);
        productResponse.setName("The Test Prod Name");
        productResponse.setPrice(p);

        Mockito.when(productPriceService.getProductById(Mockito.anyLong())).thenThrow(new NullPointerException());

        //when(productPriceRepository.findById(any())).thenReturn(p);
        //when(productPriceService.getProductById(13860428L)).thenReturn(productResponse);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/products/13860428");
        MvcResult result = this.mockMvc.perform(builder).andExpect(status().isOk()).andReturn();
        String content = result.getResponse().getContentAsString();
        ProductPriceResponse productPriceResponse = mapper.readValue(content, new TypeReference<ProductPrice>() {});
        assert (productResponse.getId() == 13860428);
        assert (productResponse.getPrice().getValue() == 100.0);
        assert (productResponse.getPrice().getCurrCode().equals("USD"));
        assert (productResponse.getName().equals("The Test Prod Name"));

    }*/

/* @Test
    public void getProductInfoTest_wrongProductId() throws Exception {
        Mockito.when(productPriceService.getProductById(Mockito.anyLong())).thenThrow(new NullPointerException());

        try {
            String url = "/products/123456";
            RequestBuilder requestBuilder = MockMvcRequestBuilders.get(url).accept(MediaType.APPLICATION_JSON_VALUE);
            mockMvc.perform(requestBuilder).andReturn();
        } catch (NotFoundException e) {
            // indicates a success negative test;
        }
    }*/


}
