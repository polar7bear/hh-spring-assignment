package com.ssg.hhassignment.controller;

import com.ssg.hhassignment.dto.CreateContentRequestDto;
import com.ssg.hhassignment.dto.CreateContentResponseDto;
import com.ssg.hhassignment.repository.ItemRepository;
import com.ssg.hhassignment.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    @PostMapping
    public CreateContentResponseDto createContent(@RequestBody CreateContentRequestDto dto) {
        return itemService.createContent(dto);
    }

    @GetMapping
    public List<CreateContentResponseDto> getContentList() {
        return itemService.getContentList();
    }

    @PutMapping("/{id}")
    public CreateContentResponseDto updateContent(@PathVariable Long id, @RequestBody CreateContentRequestDto dto) {
        return itemService.updateContent(id, dto);
    }

    @DeleteMapping("/{id}")
    public Map<String, String> deleteContent(@PathVariable Long id) {
        return itemService.deleteContent(id);
    }

}
