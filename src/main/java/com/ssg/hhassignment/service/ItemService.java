package com.ssg.hhassignment.service;

import com.ssg.hhassignment.dto.CreateContentRequestDto;
import com.ssg.hhassignment.dto.CreateContentResponseDto;
import com.ssg.hhassignment.entity.Item;
import com.ssg.hhassignment.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public CreateContentResponseDto createContent(CreateContentRequestDto dto) {
        Item entity = Item.from(dto);
        return CreateContentResponseDto.from(itemRepository.save(entity));
    }

    public List<CreateContentResponseDto> getContentList() {
        List<Item> entityList = itemRepository.findAll();
        return entityList.stream()
                .map(CreateContentResponseDto::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public CreateContentResponseDto updateContent(Long id, CreateContentRequestDto dto) {
        Optional<Item> finded = itemRepository.findById(id);
        Item item = finded.get();
        item.updateItem(dto.getUsername(), dto.getTitle(), dto.getContent(), dto.getPrice());
        return CreateContentResponseDto.from(item);
    }


    public Map<String, String> deleteContent(Long id) {
        itemRepository.deleteById(id);

        Map<String, String> response = new HashMap<>();
        response.put("msg", "삭제완료");

        return response;
    }
}
