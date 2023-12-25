package com.workintech.s18.dto;


public record BookResponse(Long id, String name, String categoryName, AuthorResponse authorResponse) {
}
