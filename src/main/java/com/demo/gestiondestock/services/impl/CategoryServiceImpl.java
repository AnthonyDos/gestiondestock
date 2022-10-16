package com.demo.gestiondestock.services.impl;

import com.demo.gestiondestock.dto.CategoryDto;
import com.demo.gestiondestock.exception.EntityNotFoundException;
import com.demo.gestiondestock.exception.ErrorCodes;
import com.demo.gestiondestock.exception.InvalidEntityException;
import com.demo.gestiondestock.model.Category;
import com.demo.gestiondestock.repository.CategoryRepository;
import com.demo.gestiondestock.services.CategoryService;
import com.demo.gestiondestock.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Category is not valid", dto);
            throw new InvalidEntityException("la category n'est pas valide", ErrorCodes.CATEGORY_NOT_FOUND, errors);
        }
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("Category Id is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findById(id);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(() -> new EntityNotFoundException(
                "Aucune categorie avec l'id" + id + "n'a été trouver dans la bdd",
                ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        if (!StringUtils.hasLength(codeCategory)) {
            log.error("Category code is null");
            return null;
        }
        Optional<Category> category = categoryRepository.findCategoryByCodeCategory(codeCategory);

        return Optional.of(CategoryDto.fromEntity(category.get())).orElseThrow(()-> new EntityNotFoundException(
                "Aucune categorie avec le code categorie " + codeCategory + "n'a été trouver dans la bdd",
                ErrorCodes.CATEGORY_NOT_FOUND)
        );
    }

    @Override
    public List<CategoryDto> findAll() {

        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Category Id is null");
            return;
        }

        categoryRepository.deleteById(id);
    }
}
