package com.stussy.stussyclone20220930seoyeong.service;

import com.stussy.stussyclone20220930seoyeong.domain.Product;
import com.stussy.stussyclone20220930seoyeong.dto.CheckoutRespDto;
import com.stussy.stussyclone20220930seoyeong.dto.CollectionListRespDto;
import com.stussy.stussyclone20220930seoyeong.dto.admin.ProductRespDto;
import com.stussy.stussyclone20220930seoyeong.exception.CustomValidationException;
import com.stussy.stussyclone20220930seoyeong.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<CollectionListRespDto> getProductList(String category, int page) throws Exception {
        List<CollectionListRespDto> productList = new ArrayList<CollectionListRespDto>();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("category", category);
        map.put("index", (page - 1) * 16);

        productRepository.getProductList(map).forEach(collectionsProduct -> {
            productList.add(collectionsProduct.toDto());
        });

        return productList;
    }

    @Override
    public CheckoutRespDto getCheckoutProduct() throws Exception {
        return null;
    }

    @Override
    public ProductRespDto getProduct(int pdtId) throws Exception {
        Product product = (Product) productRepository.getProduct(pdtId);

        if(product == null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("error", "등록되지 않은 상품입니다.");
            throw new CustomValidationException("Get Product Error", errorMap);
        }

        Map<String, List<Map<String, Object>>> pdtColors = new HashMap<String, List<Map<String, Object>>>();
        List<String> pdtImgs = new ArrayList<String>();

        product.getPdt_dtls().forEach(dtl -> {
            if(!pdtColors.containsKey(dtl.getPdt_color())) {
                pdtColors.put(dtl.getPdt_color(), new ArrayList<Map<String, Object>>());
            }

        });

        product.getPdt_imgs().forEach(img -> {
            pdtImgs.add(img.getSave_name());
        });

        ProductRespDto dto = ProductRespDto.builder()
                .pdtId(product.getId())
                .pdtName(product.getPdt_name())
                .pdtPrice(product.getPdt_price())
                .pdtSimpleInfo(product.getPdt_simple_info())
                .pdtDetailInfo(product.getPdt_detail_info())
                .pdtOptionInfo(product.getPdt_option_info())
                .pdtManagementInfo(product.getPdt_management_info())
                .pdtShippingInfo(product.getPdt_shipping_info())
                .pdtColors(pdtColors)
                .pdtImgs(pdtImgs)
                .build();
        return dto;


    }
}
