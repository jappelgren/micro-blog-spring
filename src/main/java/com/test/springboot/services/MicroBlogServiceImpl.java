package com.test.springboot.services;

import com.sun.deploy.net.HttpResponse;
import com.test.springboot.entity.MicroBlog;
import com.test.springboot.repository.MicroBlogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Slf4j
public class MicroBlogServiceImpl implements MicroBlogService{
    @Autowired
    MicroBlogRepository microBlogRepository;

    @Override
    public Iterable<MicroBlog> getAllMicroBlogs() {
        log.info("Retrieving all posts");
        return microBlogRepository.findAll(Sort.by(Sort.Direction.DESC, "posted"));
    }

    @Override
    public MicroBlog postMicroBlog(MicroBlog microBlog) {
        log.info("Recording blog in database");
        return microBlogRepository.save(microBlog);
    }

    @Override
    public MicroBlog editMicroBlog(MicroBlog microBlog, Integer id) {
        Optional<MicroBlog> selectedBlog =  microBlogRepository.findById(id);

        log.info(microBlog.getMessage());
        log.info(microBlog.getId().toString());
        log.info(microBlog.getUser_name());

        if(!microBlogRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such micro blog exists.");
        }
        log.info("Updating " + microBlog.getUser_name() + ":" + microBlog.getMessage());
        return microBlogRepository.save(microBlog);
    }


    @Override
    public HttpStatus deleteMicroBlog(Integer id) {
        if(microBlogRepository.existsById(id)) {
            log.info("Deleting blog #" + id);
            microBlogRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such micro blog exists.");
        }

        return HttpStatus.OK;
    }
}
