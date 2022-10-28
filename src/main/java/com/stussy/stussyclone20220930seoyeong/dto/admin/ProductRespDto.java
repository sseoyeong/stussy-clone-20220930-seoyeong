package com.stussy.stussyclone20220930seoyeong.dto.admin;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class ProductRespDto {

    private int pdtId;
    private String pdtName;
    private String pdtPrice;
    private String pdtSimpleInfo;
    private String pdtDetailInfo;
    private String pdtOptionInfo;
    private String pdtManagementInfo;
    private String shippingInfo;
    private Map<String, List<Map<String, String>>> pdtColors;
    private List<String> pdtImgs;
}
