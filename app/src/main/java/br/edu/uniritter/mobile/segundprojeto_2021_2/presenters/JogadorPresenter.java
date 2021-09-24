package br.edu.uniritter.mobile.segundprojeto_2021_2.presenters;

import java.util.ArrayList;
import java.util.List;

import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Personagem;

public class JogadorPresenter implements JogadorPresenterContrato.presenter{
    private List<JogadorPresenterContrato.view> activitiesJogador = new ArrayList<>();
    private Personagem personagem;
    private static JogadorPresenter instancia;

    public static JogadorPresenter getInstance(Personagem person) {
        if (instancia == null) {
            instancia = new JogadorPresenter(person);
        }
        return instancia;
    }
    public static JogadorPresenter getInstance() {
        return instancia;
    }


    private JogadorPresenter(Personagem personagem) {
        this.personagem = personagem;
    }
    @Override
    public void addView(JogadorPresenterContrato.view activity) {
        activitiesJogador.add(activity);

    }

    @Override
    public void getDados(JogadorPresenterContrato.view activity) {
        activity.setPersonagem(personagem);
    }
}
