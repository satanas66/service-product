package es.java.service.domain;

import java.util.List;

public interface ProductDetailService {

    ProductDetail getProductDetailByProductId(String productId);

    List<String> getAllSimilarProductByProductId(String productId);
}
