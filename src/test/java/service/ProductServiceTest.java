
package service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import com.myretail.product.client.ProductLookupClient;
import com.myretail.product.domain.ProductPrice;
import com.myretail.product.domain.ProductPriceResponse;
import com.myretail.product.domain.ProductPriceUpsertRequest;
import com.myretail.product.repositories.ProductPriceRepository;
import com.myretail.product.service.ProductPriceService;
import lombok.Getter;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
@Getter
@Setter
public class ProductServiceTest {

    @InjectMocks
    ProductPriceService productPriceService ;

    @Mock
    ProductPriceRepository productrepositoryMock;

    @Mock
    private ProductLookupClient productInfoClient;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }




   @Test
    public void getProductByIdTest() throws Exception {
        // Repository data from mock

       long id = 13860428L;
     ProductPrice price = new ProductPrice("13860428");

       ProductPriceResponse productResponse1=new ProductPriceResponse();
       productResponse1.setId(id);
       productResponse1.setName("The Test Prod Name");
       productResponse1.setPrice(price);


    }




/*    @Test(expected = NullPointerException.class)
    public void getProductInfoTest_wrongProductId() throws Exception {

        long id = 13860428L;
        ProductPriceUpsertRequest req = new ProductPriceUpsertRequest();
        req.setCurrency_code("USD");
        req.setValue(100.00);

        ProductPrice mockProductPrice = new ProductPrice("13860428");
        mockProductPrice.setCurrCode("USD");
        mockProductPrice.setValue(10.00);

        Mockito.when(productrepositoryMock.findById(Mockito.anyLong())).thenReturn(mockProductPrice);

        // Mockito.when(productrepositoryMock.getProductByproductId(Mockito.anyString())).thenThrow(new
        // Exception());
        productPriceService.getProductById(Long.valueOf(12345678));
    }*/
}
