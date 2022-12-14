package com.stussy.stussyclone20220930seoyeong.api;

import com.stussy.stussyclone20220930seoyeong.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930seoyeong.dto.CMRespDto;
import com.stussy.stussyclone20220930seoyeong.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductApi {

    private final ProductService productService;

    @LogAspect
    @GetMapping("/collections/{category}")
    public ResponseEntity<?> getCollections(@PathVariable String category, int page) throws Exception {

        return ResponseEntity.ok(new CMRespDto<>("Successfully", productService.getProductList(category, page)));
    }

    @GetMapping("/product/{pdtId}")
    public ResponseEntity<?> getProduct(@PathVariable int pdtId) throws Exception {
        return ResponseEntity.ok(new CMRespDto<>("Successfully", productService.getProduct(pdtId)));
    }

}
