package com.ssg.hhassignment.dto;

import com.ssg.hhassignment.entity.Item;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateContentResponseDto {

    private Long id;

    private String username;

    private String title;

    private String content;

    private Integer price;


    public static CreateContentResponseDto from(Item entity) {
        return CreateContentResponseDto.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .title(entity.getTitle())
                .content(entity.getContent())
                .price(entity.getPrice())
                .build();
    }
}
