package org.example.post_ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private Integer postId;
    private String title;
    private String body;
    private int likes;
    private String userId;
}
