package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

public class Coisinha extends Coisa{
    @Override
    protected void oi() {
        System.out.println("não quero dizer o olá mundo!");
    }
    protected void oi(String msg) {

    }
    protected void oi(String msg1, String msg2) {

    }
    public void oVelhoOi() {
        super.oi();
    }

}
