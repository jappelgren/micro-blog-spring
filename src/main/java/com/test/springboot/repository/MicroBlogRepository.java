package com.test.springboot.repository;

import com.test.springboot.entity.MicroBlog;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MicroBlogRepository extends CrudRepository<MicroBlog, Integer> {
    Iterable<MicroBlog> findAll(Sort posted);
}
