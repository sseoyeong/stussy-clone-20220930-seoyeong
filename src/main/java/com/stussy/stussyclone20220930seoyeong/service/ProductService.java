package com.stussy.stussyclone20220930seoyeong.service;

import com.stussy.stussyclone20220930seoyeong.domain.Product;
import com.stussy.stussyclone20220930seoyeong.dto.CollectionListRespDto;

import java.util.List;

public interface ProductService {
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception;

    public Product getProduct(int pdtId) throws Exception;
}
