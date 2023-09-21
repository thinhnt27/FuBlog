package tech.fublog.FuBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.fublog.FuBlog.entity.BlogPostEntity;
import tech.fublog.FuBlog.repository.BlogPostRepository;

import java.util.List;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public List<BlogPostEntity> getAllBlogPost(int page, int size){
        Pageable pageable = PageRequest.of(page-1,size);
        return  blogPostRepository.findAll(pageable).get().toList();
    }

    public List<BlogPostEntity> getAllBlogPostByTitle(String title,int page, int size){
        Pageable pageable = PageRequest.of(page-1,size);
        return  blogPostRepository.getBlogPostEntitiesByTitle(title, pageable);
    }


}
