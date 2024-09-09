package com.ssg.hhassignment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateContentRequestDto {

    private String username;

    private String title;

    private String content;

    private Integer price;
}
