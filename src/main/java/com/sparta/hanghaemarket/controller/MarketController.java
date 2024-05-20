package com.sparta.hanghaemarket.controller;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    // 판매 게시글을 작성하는 API
    @PostMapping
    public MarketResponseDto createItem(@RequestBody MarketRequestDto marketRequestDto) {
        return marketService.createItem(marketRequestDto);
    }

    // 판매 게시글을 전체 조회하는 API
    @GetMapping
    public List<MarketResponseDto> getAllItems() {
        return marketService.getAllItems();
    }

    // 판매 게시글을 수정하는 API
    @PutMapping("/{id}")
    public Long updateItem(@PathVariable Long id, @RequestBody MarketRequestDto marketRequestDto) {
        return marketService.updateItem(id, marketRequestDto);
    }

    // 판매 게시글을 삭제하는 API
    @DeleteMapping("/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return marketService.deleteItem(id);
    }

}
