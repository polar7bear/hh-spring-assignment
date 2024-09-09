package com.ssg.hhassignment.entity;

import com.ssg.hhassignment.dto.CreateContentRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String title;

    private String content;

    private Integer price;


    public static Item from(CreateContentRequestDto dto) {
        return Item.builder()
                .username(dto.getUsername())
                .title(dto.getTitle())
                .content(dto.getContent())
                .price(dto.getPrice())
                .build();
    }

    public void updateItem(String username, String title, String content, Integer price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
