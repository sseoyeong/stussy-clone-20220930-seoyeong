package com.stussy.stussyclone20220930seoyeong.service;

import com.stussy.stussyclone20220930seoyeong.dto.CheckoutRespDto;
import com.stussy.stussyclone20220930seoyeong.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930seoyeong.dto.ProductRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;

    public ProductRespDto getProduct(int pdtId) throws Exception;

    public CheckoutRespDto getCheckoutProduct() throws Exception;
}
