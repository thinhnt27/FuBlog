package tech.fublog.FuBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tech.fublog.FuBlog.entity.BlogPostEntity;
import tech.fublog.FuBlog.service.BlogPostService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BlogPostController {

    @Autowired
    BlogPostService blogPostService;

    @GetMapping("getAllBlog/{page}/{size}")
    public List<BlogPostEntity> getAllBlog(@PathVariable int page, @PathVariable int size){
        return  blogPostService.getAllBlogPost(page, size);
    }

    @GetMapping("getByTitle/{title}/{page}/{size}")
    public List<BlogPostEntity> getBlogByTitle(@PathVariable String title,@PathVariable int page, @PathVariable int size){
        return  blogPostService.getAllBlogPostByTitle(title,page,size);
    }
}
