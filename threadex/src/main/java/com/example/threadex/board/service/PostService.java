package com.example.threadex.board.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.threadex.board.dto.PostDto;
import com.example.threadex.board.entity.Post;
import com.example.threadex.board.repository.PostRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    
    public Page<PostDto> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable).map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        });
    }

    public List<PostDto> getPosts() {
        return postRepository.findAll().stream().map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        }).toList();
    }

    public PostDto getPost(Long id) {
        return postRepository.findById(id).map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        }).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }

    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAuthor(postDto.getAuthor());
        post = postRepository.save(post);
        
        postDto.setId(post.getId());
        return postDto;
    }

    public PostDto updatePost(Long id, PostDto postDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setAuthor(postDto.getAuthor());
        post = postRepository.save(post);
        
        postDto.setId(post.getId());
        return postDto;
    }
    
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
        postRepository.delete(post);
    }

    public List<PostDto> findByTitle(String title) {
        return postRepository.findByTitleContaining(title).stream().map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        }).toList();
    }

    public PostDto findById(Long id) {
        return postRepository.findById(id).map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        }).orElseThrow(() -> new RuntimeException("Post not found with id: " + id));
    }
    public Page<PostDto> searchPosts(String query, Pageable pageable) {
        return postRepository.findByTitleContaining(query, pageable).map(post -> {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setContent(post.getContent());
            postDto.setAuthor(post.getAuthor());
            return postDto;
        });
    }
    
}
