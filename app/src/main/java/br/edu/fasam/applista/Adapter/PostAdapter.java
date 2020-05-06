package br.edu.fasam.applista.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fasam.applista.Model.Post;
import br.edu.fasam.applista.R;

public class PostAdapter extends BaseAdapter {

    Context context;
    List<Post> colecao;
    LayoutInflater inflater;

    public  PostAdapter(final Context context, final List<Post> colecao){
        this.context = context;
        this.colecao = colecao;
    }
    @Override
    public int getCount() {
        return this.colecao != null ? this.colecao.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return this.colecao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view , ViewGroup parent) {

        //inflate - pega o layout xml e valida se ele é nulo, se não valida o objeto

        // cria a instancia da view
        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.item,
                    parent, false);
        }

        // Para cada registro da coleção pega um item da posiçao
        Post post = (Post) this.getItem(position);

        //informar valores para os campos do tipo TextView para serem exibidos na view do tipo Item

        TextView id,title;

        id =  view.findViewById(R.id.txt_id);
        title = view.findViewById(R.id.txt_title);


        id.setText(post.getId());
        title.setText(post.getTitle());

        return view; // retorna um item da lista preenchido
    }
}