package com.omgstudy.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter // 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor // 선언된 모든 final 필드가 포홤된 생성자를 생성해 줍니다. final이 없는 필드는 생성자에 포함X
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
