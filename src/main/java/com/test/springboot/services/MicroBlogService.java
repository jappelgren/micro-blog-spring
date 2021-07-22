package com.test.springboot.services;

import com.test.springboot.entity.MicroBlog;
import org.springframework.http.HttpStatus;

public interface MicroBlogService {
    public Iterable<MicroBlog> getAllMicroBlogs();
    public MicroBlog postMicroBlog(MicroBlog microBlog);
    public HttpStatus deleteMicroBlog(Integer id);
    public MicroBlog editMicroBlog(MicroBlog microBlog, Integer id);
}
