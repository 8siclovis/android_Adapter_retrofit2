package br.edu.fasam.applista.Resource;

import java.util.List;

import br.edu.fasam.applista.Model.Post;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostResource {

    @GET("posts")
    Call<List<Post>> get();

    @GET("posts/{id}")
    Call<Post> get(Integer id);
}
