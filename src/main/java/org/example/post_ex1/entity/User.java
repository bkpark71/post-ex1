package org.example.post_ex1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String userId;
    private String password;
    private String name;
}
