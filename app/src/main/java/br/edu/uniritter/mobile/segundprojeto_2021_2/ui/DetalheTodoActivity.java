package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Todo;

public class DetalheTodoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_todo);
        Intent intent =  getIntent();
        TextView tv = findViewById(R.id.tvId);
        Todo todo = intent.getParcelableExtra("obj");
        tv.setText(""+todo.getId());
        tv = findViewById(R.id.tvTitulo);
        tv.setText(todo.getTitle());

    }
}