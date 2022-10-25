package com.stussy.stussyclone20220930seoyeong.repository.admin;

import com.stussy.stussyclone20220930seoyeong.domain.OptionProductMst;
import com.stussy.stussyclone20220930seoyeong.domain.Product;
import com.stussy.stussyclone20220930seoyeong.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductManagementRepository {
    public List<ProductCategory> getCategoryList() throws Exception;

    public int saveProductMst(Product product) throws Exception;

    public List<OptionProductMst> getProductMstList() throws Exception;
}
