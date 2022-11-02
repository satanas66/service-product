package es.java.service.infraestructure;

import es.java.service.domain.ProductDetail;
import es.java.service.domain.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="product")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping(value="/{productId}/similar")
    public ResponseEntity<List<ProductDetail>> getAllSimilarProductsByProductId(@PathVariable("productId") String productId){
        List<String> producIds = productDetailService.getAllSimilarProductByProductId(productId);
        if(producIds.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List<ProductDetail> productDetails = new ArrayList<>();
        for(String id : producIds){
            ProductDetail productDetail = productDetailService.getProductDetailByProductId(id);
            if(productDetail != null){
                productDetails.add(productDetail);
            }
        }
        if(productDetails.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDetails);
    }
}
