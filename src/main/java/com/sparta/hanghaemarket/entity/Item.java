package com.sparta.hanghaemarket.entity;

import com.sparta.hanghaemarket.dto.MarketRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "price", nullable = false)
    private int price;

    public Item(MarketRequestDto marketRequestDto) {
        this.username = marketRequestDto.getUsername();
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.price = marketRequestDto.getPrice();
    }

    public void update(MarketRequestDto marketRequestDto) {
        this.username = marketRequestDto.getUsername();
        this.title = marketRequestDto.getTitle();
        this.content = marketRequestDto.getContent();
        this.price = marketRequestDto.getPrice();
    }

}
