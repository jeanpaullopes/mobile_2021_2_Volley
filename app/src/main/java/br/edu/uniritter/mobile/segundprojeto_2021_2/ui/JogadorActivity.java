package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Personagem;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.JogadorPresenter;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.JogadorPresenterContrato;

public class JogadorActivity extends AppCompatActivity implements JogadorPresenterContrato.view {
    JogadorPresenterContrato.presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);
        presenter = JogadorPresenter.getInstance();
        presenter.getDados(this);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JogadorDetalheActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void setPersonagem(Personagem person) {
        TextView tv = findViewById(R.id.tvNomeJogador);
        tv.setText(person.getNome());
        tv = findViewById(R.id.tvClasse);
        tv.setText(person.getClasse());

    }
}