package com.sparta.hanghaemarket.dto;

import lombok.Getter;

@Getter
public class MarketRequestDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;
}
