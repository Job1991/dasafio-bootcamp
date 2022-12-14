package br.com.dio.desafio.dominio;

public abstract class Conteudo {

    protected static final double XP_Padrao = 10d;
    private String titulo;
    private String descricao;

    protected Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

     protected abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
