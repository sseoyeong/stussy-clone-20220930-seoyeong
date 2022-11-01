package com.stussy.stussyclone20220930seoyeong.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentProduct {
    private int pdt_dtl_id;
    private int pdt_id;
    private String pdt_name;
    private int pdt_price;
    private String pdt_color;
    private int size_id;
    private String size_name;
    private String save_name;
}
