package br.edu.uniritter.mobile.segundprojeto_2021_2.presenters;

import br.edu.uniritter.mobile.segundprojeto_2021_2.model.Personagem;

public interface JogadorPresenterContrato {
    interface presenter{
        public void addView(JogadorPresenterContrato.view activity);
        public void getDados(JogadorPresenterContrato.view activity);

    }
    interface view {
        public void setPersonagem(Personagem person);
    }
}
