package com.example.threadex.board.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.threadex.board.dto.PostDto;
import com.example.threadex.board.service.PostService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RequiredArgsConstructor
@Controller
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public String list(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<PostDto> postPage = postService.getPosts(PageRequest.of(page, 10)); // Fetch posts with pagination
        model.addAttribute("paging", postPage);
        return "post_list"; // Return the view name for displaying the list of posts
    }
    
    @GetMapping("/new")
    public String createForm(Model model) {
        return "post_form"; // Return the view name for creating a new post
    }

    @PostMapping("/new")
    public String create(PostDto postDto) {
        PostDto createdPost = postService.createPost(postDto);
        return "redirect:/posts/" + createdPost.getId(); // Redirect to the newly created post's detail page
    }

    @GetMapping("/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        PostDto postDto = postService.getPost(id);
        model.addAttribute("post", postDto);
        return "post_detail"; // Return the view name for displaying the post details
    }

    @GetMapping("/{id}/edit")
    public String editForm(Model model, @PathVariable("id") Long id) {
        PostDto postDto = postService.getPost(id);
        model.addAttribute("post", postDto);
        return "post_edit"; // Return the view name for editing the post
    }
    @PostMapping("/{id}/edit")
    public String edit(@PathVariable("id") Long id, PostDto postDto) {
        postDto.setId(id); // Set the ID to ensure the correct post is updated
        PostDto updatedPost = postService.updatePost(id, postDto);
        return "redirect:/posts/" + updatedPost.getId(); // Redirect to the updated post's detail page
    }
    
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable("id") Long id) {
        postService.deletePost(id); // Call the service to delete the post
        return "redirect:/posts"; // Redirect to the list of posts after deletion
    }

    @GetMapping("/search")
    public String search(Model model, @RequestParam("query") String query, @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<PostDto> postPage = postService.searchPosts(query, PageRequest.of(page, 10)); // Search posts with pagination
        model.addAttribute("paging", postPage);
        return "post_search"; // Return the view name for displaying the search results
    }
    
    
    
}
