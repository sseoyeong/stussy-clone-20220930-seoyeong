package com.stussy.stussyclone20220930seoyeong.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImg {
    private int pdt_id;
    private int pdt_name;
    private String origin_name;
    private String save_name;
}
