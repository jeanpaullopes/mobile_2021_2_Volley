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

public class JogadorDetalheActivity extends AppCompatActivity implements JogadorPresenterContrato.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador_detalhe);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JogadorActivity.class);
                startActivity(intent);
            }
        });
        JogadorPresenter.getInstance().getDados(this);
    }

    @Override
    public void setPersonagem(Personagem person) {
        TextView tv = findViewById(R.id.tvNomeJogador2);
        tv.setText(person.getNome());
        tv = findViewById(R.id.tvClasse2);
        tv.setText(person.getClasse());
    }
}