package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.TodoPresenter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.TodoPresenterContrato;

public class SplashActivity extends AppCompatActivity implements TodoPresenterContrato.view {
    private TodoPresenterContrato.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        presenter = new TodoPresenter(this, "https://jsonplaceholder.typicode.com");
        presenter.buscaJsons();
        ImageView iv = findViewById(R.id.imageView);
        Picasso.get().load("https://www.uniritter.edu.br/assets/images/logo_uniritter.jpg").into(iv);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Thread timer = new Thread() {
            public void run()
            {
                try {
                    //Display for 3 seconds
                    sleep(10000);
                    System.out.println("acordei");
                }
                catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
       timer.start();
    }

    @Override
    public void preparaRecylerView(RecyclerView.Adapter adapter) {
        RecyclerView rv = findViewById(R.id.recylerSplash);
        LinearLayoutManager llm =  new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    @Override
    public void limpaRecycler() {

    }

    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }
}