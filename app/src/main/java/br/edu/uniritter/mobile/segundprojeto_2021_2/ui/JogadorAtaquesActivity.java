package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;
import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Personagem;
import br.edu.uniritter.mobile.segundprojeto_2021_2.presenters.JogadorPresenterContrato;

public class JogadorAtaquesActivity extends AppCompatActivity  implements JogadorPresenterContrato.view{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador_ataques);
    }

    @Override
    public void setPersonagem(Personagem person) {

    }
}