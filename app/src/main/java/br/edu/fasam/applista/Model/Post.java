package br.edu.fasam.applista.Model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class Post {

    private Integer userId;
    private Integer  id;
    private String title;
    private String body;

}