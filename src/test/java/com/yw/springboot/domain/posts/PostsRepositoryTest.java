package com.yw.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void test() {

        String title = "posts 테스트";
        String content = "내용";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("park@naver.com")
                .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getTitle()).isEqualTo(title);

    }

    @Test
    public void BestEntity() {
        LocalDateTime now = LocalDateTime.of(2021, 2, 17, 0, 0, 0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author").build()
        );

        List<Posts> postsList = postsRepository.findAll();
        Posts posts = postsList.get(0);

        System.out.printf("cr = "+posts.getCreatedDate());
        System.out.printf("md = "+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}
