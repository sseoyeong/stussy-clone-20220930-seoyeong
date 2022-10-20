package com.stussy.stussyclone20220930seoyeong.api;

import com.stussy.stussyclone20220930seoyeong.aop.annotation.LogAspect;
import com.stussy.stussyclone20220930seoyeong.dto.CMRespDto;
import com.stussy.stussyclone20220930seoyeong.dto.RegisterReqDto;
import com.stussy.stussyclone20220930seoyeong.dto.validation.ValidationSequence;
import com.stussy.stussyclone20220930seoyeong.exception.CustomValidationException;
import com.stussy.stussyclone20220930seoyeong.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {
    private final AccountService accountService;

    @LogAspect
    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto,
                                      BindingResult bindingResult) throws Exception {

        accountService.duplicateEmail(registerReqDto);
        accountService.register(registerReqDto);

        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>("회원가입 성공", registerReqDto.getEmail()));
    }
}
