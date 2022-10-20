package com.stussy.stussyclone20220930seoyeong.service.admin;

import com.stussy.stussyclone20220930seoyeong.dto.admin.CategoryResponseDto;
import com.stussy.stussyclone20220930seoyeong.dto.admin.ProductRegisterReqDto;
import com.stussy.stussyclone20220930seoyeong.exception.CustomInternalServerErrorException;
import com.stussy.stussyclone20220930seoyeong.repository.admin.ProductManagementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManagementServiceImpl implements ProductManagementService{
    private final ProductManagementRepository productManagementRepository;

    @Override
    public List<CategoryResponseDto> getCategoryList() throws Exception {
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<CategoryResponseDto>();
        productManagementRepository.getCategoryList().forEach(category -> {

        });
        return null;
    }

    @Override
    public void registerMst(ProductRegisterReqDto productRegisterReqDto) throws Exception {
    if(productManagementRepository.saveProductMst(productRegisterReqDto.toEntity()) == 0) {
        throw new CustomInternalServerErrorException("상품 등록 실행");
        }
    }
}
