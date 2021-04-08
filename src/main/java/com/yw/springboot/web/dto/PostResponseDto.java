package com.yw.springboot.web.dto;

import com.yw.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Posts entity) {
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.id = entity.getId();
        this.author = entity.getAuthor();
    }



}
