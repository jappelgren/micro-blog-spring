package com.test.springboot.controller;

import com.test.springboot.entity.MicroBlog;
import com.test.springboot.services.MicroBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MicroBlogController {
    @Autowired
    MicroBlogService microBlogService;

    @GetMapping("")
        public ResponseEntity<Iterable<MicroBlog>> getAllMicroBlogs() {
            return new ResponseEntity<>(microBlogService.getAllMicroBlogs(), HttpStatus.OK);
        }

    @PostMapping("")
        public ResponseEntity<MicroBlog> postMicroBLog(@RequestBody MicroBlog microBlog) {
            return new ResponseEntity<>(microBlogService.postMicroBlog(microBlog), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatus> deleteMicroBlog(@PathVariable Integer id) {
            return new ResponseEntity<>(microBlogService.deleteMicroBlog(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
        public ResponseEntity<MicroBlog> editMicroBlog(@RequestBody MicroBlog microBlog, @PathVariable Integer id) {
            return new ResponseEntity<>(microBlogService.editMicroBlog(microBlog, id), HttpStatus.OK);
    }


}
