package tech.fublog.FuBlog.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.fublog.FuBlog.entity.BlogPostEntity;

import java.util.List;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPostEntity,Long> {
    public List<BlogPostEntity> getBlogPostEntitiesByTitle(String title, Pageable pageable);
}
