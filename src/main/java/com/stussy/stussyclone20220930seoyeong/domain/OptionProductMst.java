package com.stussy.stussyclone20220930seoyeong.domain;

import com.stussy.stussyclone20220930seoyeong.dto.admin.ProductMstOptionRespDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OptionProductMst {
    private int pdt_id;
    private String category;
    private String pdt_name;

    public ProductMstOptionRespDto toDto() {
        return ProductMstOptionRespDto.builder()
                .pdtId(pdt_id)
                .category(category)
                .pdtName(pdt_name)
                .build();
    }
}
