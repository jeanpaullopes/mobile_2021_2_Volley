package br.edu.uniritter.mobile.segundprojeto_2021_2.model;

import java.util.List;

public class Personagem {
    private String nome;
    private String classe;
    private String raca;
    private int bonusProficiencia;
    private int inspiracao;
    private int forcaSalvagarda;
    private int forcaAtletismo;
    private int destrizaAcrobacia;
    private int classeArmadura;
    private int pontosVidaMax;
    private int pontosVidaAtual;
    private int pontosVidaTemp;
    private String tracosPersonalidade;
    private String ideias;
    private List<String> ataques;


    public Personagem(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getBonusProficiencia() {
        return bonusProficiencia;
    }

    public void setBonusProficiencia(int bonusProficiencia) {
        this.bonusProficiencia = bonusProficiencia;
    }

    public int getInspiracao() {
        return inspiracao;
    }

    public void setInspiracao(int inspiracao) {
        this.inspiracao = inspiracao;
    }

    public int getForcaSalvagarda() {
        return forcaSalvagarda;
    }

    public void setForcaSalvagarda(int forcaSalvagarda) {
        this.forcaSalvagarda = forcaSalvagarda;
    }

    public int getForcaAtletismo() {
        return forcaAtletismo;
    }

    public void setForcaAtletismo(int forcaAtletismo) {
        this.forcaAtletismo = forcaAtletismo;
    }

    public int getDestrizaAcrobacia() {
        return destrizaAcrobacia;
    }

    public void setDestrizaAcrobacia(int destrizaAcrobacia) {
        this.destrizaAcrobacia = destrizaAcrobacia;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getPontosVidaMax() {
        return pontosVidaMax;
    }

    public void setPontosVidaMax(int pontosVidaMax) {
        this.pontosVidaMax = pontosVidaMax;
    }

    public int getPontosVidaAtual() {
        return pontosVidaAtual;
    }

    public void setPontosVidaAtual(int pontosVidaAtual) {
        this.pontosVidaAtual = pontosVidaAtual;
    }

    public int getPontosVidaTemp() {
        return pontosVidaTemp;
    }

    public void setPontosVidaTemp(int pontosVidaTemp) {
        this.pontosVidaTemp = pontosVidaTemp;
    }

    public String getTracosPersonalidade() {
        return tracosPersonalidade;
    }

    public void setTracosPersonalidade(String tracosPersonalidade) {
        this.tracosPersonalidade = tracosPersonalidade;
    }

    public String getIdeias() {
        return ideias;
    }

    public void setIdeias(String ideias) {
        this.ideias = ideias;
    }

    public List<String> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<String> ataques) {
        this.ataques = ataques;
    }
}
