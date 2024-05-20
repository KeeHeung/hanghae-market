package com.sparta.hanghaemarket.service;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import com.sparta.hanghaemarket.dto.MarketResponseDto;
import com.sparta.hanghaemarket.entity.Item;
import com.sparta.hanghaemarket.repository.MarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createItem(MarketRequestDto marketRequestDto) {
        // RequestDto -> Entity
        Item item = new Item(marketRequestDto);

        // DB 저장
        Item saveItem = marketRepository.save(item);

        // Entity -> ResponseDto
        MarketResponseDto marketResponseDto = new MarketResponseDto(saveItem);

        return marketResponseDto;
    }

    public List<MarketResponseDto> getAllItems() {
        // DB 조회
        return marketRepository.findAllByOrderByModifiedAtDesc().stream().map(MarketResponseDto::new).toList();
    }

    @Transactional
    public Long updateItem(Long id, MarketRequestDto marketRequestDto) {
        // 해당 item이 DB에 존재하는지 확인
        Item item = findItem(id);

        // memo 내용 수정
        item.update(marketRequestDto);

        return id;
    }

    public Long deleteItem(Long id) {
        // 해당 item이 DB에 존재하는지 확인
        Item item = findItem(id);

        // item 삭제
        marketRepository.delete(item);

        return id;
    }

    // item 존재 여부 확인 공용 Method
    private Item findItem(Long id) {
        return marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 아이템은 존재하지 않습니다.")
        );
    }

}
