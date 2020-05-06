package br.edu.fasam.applista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.edu.fasam.applista.Adapter.PostAdapter;
import br.edu.fasam.applista.Api.ApiCliente;
import br.edu.fasam.applista.Model.Post;
import br.edu.fasam.applista.Resource.PostResource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Home extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    }

    public void listar(View view) {

        Retrofit retrofit = ApiCliente.getClient();

        //Fazer bind instancia retrofit com interface resource
        PostResource postResource = retrofit.create(PostResource.class);

        Call<List<Post>> get = postResource.get(); //faz o consumo do serviço

        get.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> request, Response<List<Post>> response) {

                List<Post> posts = response.body();

                for(Post p: posts){
                    Log.i("post",String.valueOf(p.getId()));
                    Log.i("post", p.getTitle());
                    Log.i("post",String.valueOf(p.getId()));
                }


                //Exercicio: Concluir esse app e exibir os dados de posts na listView
                //Preparar os dados com o Adapter

                PostAdapter adapter = new PostAdapter(getApplicationContext(),posts);

                //Pegar a referencia da listView
                listView = findViewById(R.id.listView);

                //informa a listview o adapter com o conjunto de dados a serem exibidos
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Post>> request, Throwable t) {

                Log.e("Erro","Erro ao executar app"+t.getMessage());

            }
        });
    }
}