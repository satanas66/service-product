package es.java.service.application;

import es.java.service.domain.ProductDetail;
import es.java.service.domain.ProductDetailRepository;
import es.java.service.domain.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductDetailDetailServiceImpl implements ProductDetailService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Override
    public ProductDetail getProductDetailByProductId(String productId) {
        return productDetailRepository.findById(productId).orElse(null);
    }

    public List<String> getAllSimilarProductByProductId(String productId){
        ResponseEntity<String[]> response = restTemplate.getForEntity("http://localhost:3001/product/"+productId+"/similarids",
                String[].class);
        String[] productDetails = response.getBody();
        return Arrays.asList(productDetails);
    }
}
