package com.test.springboot.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroBlog {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String user_name;

    String message;

    @CreationTimestamp
    @Column(name = "posted", nullable = false)
    private Date posted;


    }
