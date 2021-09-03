package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;

public class LoginActivity extends AppCompatActivity implements Response.Listener<JSONArray>,
                                        Response.ErrorListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Aqui começa o uso do Volley
        RequestQueue queue = Volley.newRequestQueue(this);
        //https://jsonplaceholder.typicode.com/todos/1

        JsonArrayRequest requisicao = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos",null,
                this,this);
        queue.add(requisicao);


        //tratando o botão
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResponse(JSONArray response) {
        EditText ed = findViewById(R.id.resultado);

        try {
            ed.setText(response.length()+"\n"+response.getJSONObject(50).toString());
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
        EditText ed = findViewById(R.id.resultado);
        ed.setText(error.getMessage());

    }
}