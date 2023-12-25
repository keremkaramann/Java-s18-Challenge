package com.workintech.s18.dto;

import java.util.List;

public record AuthorResponseWithBooks(List<BookResponse> responseList) {
}
