package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.adapters.TodoAdapter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Todo;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.TodoPresenter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.TodoPresenterContrato;

public class LoginActivity extends AppCompatActivity implements TodoPresenterContrato.view{

    TodoPresenterContrato.presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new TodoPresenter(this, "https://jsonplaceholder.typicode.com");
        //tratando o botão
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }
        });
        btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.buscaJsons();
            }
        });

        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
    public void preparaRecylerView(RecyclerView.Adapter adapter){
        RecyclerView rv = findViewById(R.id.rvTodos);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        LinearLayoutManager llm1 =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void limpaRecycler() {
        RecyclerView rv = findViewById(R.id.rvTodos);
        rv.setAdapter(null);
    }

    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }


}