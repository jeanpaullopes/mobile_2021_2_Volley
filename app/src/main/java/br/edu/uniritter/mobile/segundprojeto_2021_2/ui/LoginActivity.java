package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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

public class LoginActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
                                        Response.ErrorListener{

    private List<Todo> todos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




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
                buscaJsons();
            }
        });

        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerView rv = findViewById(R.id.rvTodos);
                TodoAdapter adapter = new TodoAdapter(todos);
                LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
                LinearLayoutManager llm1 =  new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(7,StaggeredGridLayoutManager.HORIZONTAL);
                rv.setLayoutManager(llm);
                rv.setAdapter(adapter);
            }
        });


    }

    private void buscaJsons() {
        //Aqui começa o uso do Volley
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        //https://jsonplaceholder.typicode.com/todos/1

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",null,
                this,this);
        queue.add(requisicao);
    }

    @Override
    public void onResponse(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        todos.clear();

        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    todos.add(new Todo(response.getJSONObject(i)));
                }
            }
            Button btn = findViewById(R.id.button3);
            btn.setText("feito!!!!");
            /*String txt = "";
                for (Todo td : todos) {
                    Button btn = new Button(this);
                    btn.setText("ID " + td.getId());
                    btn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(getApplicationContext(), DetalheTodoActivity.class);
                            intent.putExtra("obj", td);
                            startActivity(intent);
                        }
                    });
                    ll.addView(btn);
                }
        */
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /*
        try {
            ed.setText(response.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        //EditText ed = findViewById(R.id.resultado);
        //ed.setText(error.getMessage());

    }
}