package com.demo.gestiondestock.dto;

import com.demo.gestiondestock.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String designation;

    @JsonIgnore
    private List<ArticleDto> articles;

    //construction de l'objet dto
    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
            //todo throw on exception
        }

        //mapping de CategoryDto vers -> Category
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .designation(category.getDesignation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
            //todo throw on exception
        }

        //pour puvoir set l'id créer une nouvelle instanciation de category
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesignation(categoryDto.getDesignation());

        return category;
    }
}
