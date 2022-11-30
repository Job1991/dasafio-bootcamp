package br.com.dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate data;
    private double pontos;

    public void setTeste(String a){}
    public Mentoria(String titulo, String descricao) {
        super(titulo, descricao);
    }
    public Mentoria(String titulo, String descricao, LocalDate data) {
        super(titulo, descricao);
        this.setData(data);
    }

    @Override
    public double calcularXp() {
        return super.XP_Padrao + 20;//super.setPontos(Conteudo.XP_Padrao);
    }

    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + super.getTitulo() /*+ '\'' +
                ", descricao='" + super.getDescricao() + '\'' +
                ", data=" + data */+
                "'}";
    }


    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }
}
