package br.edu.uniritter.mobile.segundprojeto_2021_2.presenters;

import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.adapters.Todo2Adapter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.adapters.TodoAdapter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Todo;
import br.edu.uniritter.mobile.segundprojeto_2021_2.ui.LoginActivity;

public class TodoPresenter implements TodoPresenterContrato.presenter,
        Response.ErrorListener{

    private List<Todo> todos = new ArrayList<>();
    private TodoPresenterContrato.view activity;
    private int adp = 1;
    private String urlBase;

    public TodoPresenter(TodoPresenterContrato.view act, String urBase) {
        this.activity = act;
        this.urlBase = urBase;
    }

    @Override
    public void buscaJsons() {
        //Aqui começa o uso do Volley
        RequestQueue queue = Volley.newRequestQueue(activity.getContexto());
        //https://jsonplaceholder.typicode.com/todos/1

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                urlBase+"/todos", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponseTodo(response);
                    }
                }, this);
        queue.add(requisicao);
        requisicao = new JsonArrayRequest(Request.Method.GET,
                urlBase+"/posts", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        onResponsePosts(response);
                    }
                }, this);
        queue.add(requisicao);
    }


    public void onResponseTodo(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        todos.clear();

        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    todos.add(new Todo(response.getJSONObject(i)));
                }
            }
            RecyclerView.Adapter adapter;
            if (adp == 1) {
                adapter = new TodoAdapter(todos);
                adp = 2;
            }else {
                adapter = new Todo2Adapter(todos);
                adp = 1;
            }

            activity.preparaRecylerView(adapter);
            //olhar depois Button btn = findViewById(R.id.button3);
            //olhar depois btn.setText("feito!!!!");


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
    public void onResponsePosts(JSONArray response) {
        //ScrollView sv = findViewById(R.id.scroll);
        //LinearLayout ll = findViewById(R.id.leiauteVertical);
        todos.clear();

        try {
            for (int x = 0; x <30; x++) {
                for (int i = 0; i < response.length(); i++) {
                    todos.add(new Todo(response.getJSONObject(i)));
                }
            }
            RecyclerView.Adapter adapter;
            if (adp == 1) {
                adapter = new TodoAdapter(todos);
                adp = 2;
            }else {
                adapter = new Todo2Adapter(todos);
                adp = 1;
            }

            activity.preparaRecylerView(adapter);
            //olhar depois Button btn = findViewById(R.id.button3);
            //olhar depois btn.setText("feito!!!!");


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
