package br.edu.uniritter.mobile.segundprojeto_2021_2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Todo;

public class Todo2Adapter extends RecyclerView.Adapter<Todo2Adapter.ViewHolder> {

    private List<Todo> dados;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
        }
    }


    public Todo2Adapter(List<Todo> todos) {
        this.dados = new ArrayList<>();
        this.dados.add(todos.get(0));
        this.dados.add(todos.get(10));
        this.dados.add(todos.get(20));
        this.dados.add(todos.get(30));
        this.dados.add(todos.get(40));
    }

    @NonNull
    @Override
    public Todo2Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewGroup viewGroup;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.todo2_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Todo2Adapter.ViewHolder holder, int position) {
        Todo todo = dados.get(position);
        TextView tv = holder.view.findViewById(R.id.tvTodoTitulo);
        tv.setText(todo.getTitle());
        tv = holder.view.findViewById(R.id.tvTodoIdUser);
        tv.setText(""+todo.getUser_id());
        Switch sw = holder.view.findViewById(R.id.swTodoCompleto);
        sw.setChecked(todo.isCompleted());

    }

    @Override
    public int getItemCount() {
        return dados.size();
    }
}
