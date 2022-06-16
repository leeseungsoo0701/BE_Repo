package com.shop.mall.service;

import com.shop.mall.domain.*;
import com.shop.mall.dto.ProductResponseDto;
import com.shop.mall.repository.ImgRepository;
import com.shop.mall.repository.Product.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired ProductService productService;
    @Autowired ProductRepository productRepository;
    @Autowired ImgRepository imgRepository;

    @Test
    @DisplayName("8번 API 첫번째 페이징 성공")
    public void productFirstList() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        List<ProductResponseDto.ProductList> productLists = productService.productList(10L);


        //then
        assertEquals(20, productLists.size());
        assertFalse(productLists.isEmpty());
    }

    @Test
    @DisplayName("9번 API 상품 상세보기")
    public void productsDetail() throws Exception {
        //given
        Member member = new Member("seanlee0701asdasd@naver.com","seanlee0701asdasd","중구","password",1000);

        List<Img> imgList = new ArrayList<>();
        Img img = new Img("first_img_url");
        imgList.add(img);

        List<ProductOption> productOptionList = new ArrayList<>();
        ProductOption productOption = new ProductOption("first_product_option");
        productOptionList.add(productOption);

        List<Review> reviewList = new ArrayList<>();
        Review review = new Review(member);
        reviewList.add(review);

        Long productId = productRepository.save(new Product(imgList,productOptionList,reviewList)).getId();

        //when
        ProductResponseDto.ProductsDetail productsDetail = productService.productsDetail(productId);


        //then
        assertEquals(productId,productsDetail.getProductId());
        assertEquals(productOptionList.get(0).getOptionContent(),productsDetail.getOptionList().get(0));
        assertEquals(imgList.get(0).getImgUrl(),productsDetail.getImgList().get(0));
        assertEquals(reviewList.size(),productsDetail.getReviewList().size());

    }

    @Test
    @DisplayName("10번 API searchProduct_제약조건 없음")
    public void searchProduct_전체보기() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,20);
        ProductResponseDto.ProductPage productPages = productService.conditionProductList(pageable,"recent",null,null);

        //then
        List<ProductResponseDto.ProductList> content = productPages.getProductLists();

        assertEquals(20, content.size());
        assertEquals(false, productPages.getIsLastPage());
    }


    @Test
    @DisplayName("10번 API searchProduct_제약조건_price순")
    public void searchProduct_제약조건_price순() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,20);
        ProductResponseDto.ProductPage productPages = productService.conditionProductList(pageable,"cost",null,null);

        //then
        List<ProductResponseDto.ProductList> content = productPages.getProductLists();

        assertEquals(20, content.size());
        assertEquals(false, productPages.getIsLastPage());
    }

    @Test
    @DisplayName("10번 API searchProduct_제약조건_검색어")
    public void searchProduct_제약조건_검색어() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,2);
        ProductResponseDto.ProductPage productPages = productService.conditionProductList(pageable,"review",null,"쇼츠");

        //then
        List<ProductResponseDto.ProductList> content = productPages.getProductLists();

        assertEquals(2, content.size());
        assertEquals(true, productPages.getIsLastPage());
    }

    @Test
    @DisplayName("10번 API searchProduct_제약조건_카테고리")
    public void searchProduct_제약조건_카테고리() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,2);
        Page<ProductResponseDto.ProductList> productPages = productRepository.searchByRecent(pageable,"하의",null);

        //then
        List<ProductResponseDto.ProductList> content = productPages.getContent();

        assertEquals(2, content.size());
        assertEquals(0, productPages.getNumber());
        assertTrue(productPages.isFirst());
    }

    @Test
    @DisplayName("10번 API searchProduct_제약조건_검색어_카테고리")
    public void searchProduct_제약조건_검색어_카테고리() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,2);
        Page<ProductResponseDto.ProductList> productPages = productRepository.searchByRecent(pageable,"하의","쇼츠");

        //then
        List<ProductResponseDto.ProductList> content = productPages.getContent();

        assertEquals(2, content.size());
        assertEquals(0, productPages.getNumber());
        assertTrue(productPages.isFirst());
    }

    @Test
    @DisplayName("10번 API searchProduct_제약조건_리뷰갯수순_검색어_카테고리")
    public void searchProduct_제약조건_리뷰갯수순_검색어_카테고리() throws Exception {
        //given
        for (int i=0;i<15;i++){
            List<Img> imgList = new ArrayList<>();
            Img img = new Img("img_url"+i);
            imgList.add(img);
            productRepository.save(new Product(imgList));
        }

        //when
        PageRequest pageable= PageRequest.of(0,2);
        Page<ProductResponseDto.ProductList> productPages = productRepository.searchByReviewCnt(pageable,"하의","쇼츠");

        //then
        List<ProductResponseDto.ProductList> content = productPages.getContent();

        assertEquals(2, content.size());
        assertEquals(0, productPages.getNumber());
        assertTrue(productPages.isFirst());
    }





}