package com.omgstudy.book.springboot.service.posts;

import com.omgstudy.book.springboot.domain.posts.Posts;
import com.omgstudy.book.springboot.domain.posts.PostsRepository;
import com.omgstudy.book.springboot.web.dto.PostSaveRequestDto;
import com.omgstudy.book.springboot.web.dto.PostsListResponseDto;
import com.omgstudy.book.springboot.web.dto.PostsResponseDto;
import com.omgstudy.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostsRepository postsRepository;


    @Transactional
    public Long save(PostSaveRequestDto requestDto) {

        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
        IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));
        postsRepository.delete(posts);
    }

    @Transactional
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }
}
