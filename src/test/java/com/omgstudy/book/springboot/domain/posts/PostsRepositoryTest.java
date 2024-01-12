package com.omgstudy.book.springboot.domain.posts;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    
    // PostRepository 객체 주입
    @Autowired
    PostsRepository postsRepository;

    // Junit 단위 테스트가 끝날 떄 수행되는 메소드
    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "test_title";
        String content = "test_content";

        // 테이블 posts에 insert/update 쿼리를 실행합니다.
        // id 값이 있다면 update가, 없다면 insert 쿼리가 실행됩니다.
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("cagim30@gmail.com")
                .build()
        );

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }

}
