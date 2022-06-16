package com.shop.mall.controller;

import com.shop.mall.dto.ProductResponseDto;
import com.shop.mall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    //8번 API 상품 전체 목록
    @Cacheable(value = "product_id", cacheManager = "productCacheManager")
    @GetMapping("/products/pages/{pageId}")
    public List<ProductResponseDto.ProductList> findAllProduct(@PathVariable Long pageId) throws InterruptedException {
        return productService.productList(pageId);
    }
    //9번 API 상품 상세 데이터
    @Cacheable(value = "productdetail_id", cacheManager = "productCacheManager")
    @GetMapping("/products/{productId}")
    public ProductResponseDto.ProductsDetail productDetail(@PathVariable Long productId) throws InterruptedException {
        return productService.productsDetail(productId);
    }

    //10번 API 상품 카테고리 및 검색
    @GetMapping("/products/search")
    public ProductResponseDto.ProductPage findConditionsProduct(@PageableDefault(size = 20) Pageable pageable, @RequestParam(value = "sort") String sort, @RequestParam(value = "category") String category, @RequestParam(value = "searchKeyword") String searchKeyword){
        return productService.conditionProductList(pageable,sort,category,searchKeyword);
    }

}