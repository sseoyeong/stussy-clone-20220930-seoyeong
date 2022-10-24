package com.stussy.stussyclone20220930seoyeong.repository;

import com.stussy.stussyclone20220930seoyeong.domain.CollectionsProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ProductRepository {
    public List<CollectionsProduct> getProductList(HashMap<String, Object> map) throws Exception;
}
