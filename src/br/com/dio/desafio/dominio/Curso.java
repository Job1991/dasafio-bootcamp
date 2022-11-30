package br.com.dio.desafio.dominio;

public class Curso extends  Conteudo{

    private int cargaHoraria;

    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo,descricao);
        this.setCargaHoraria(cargaHoraria);
    }

    @Override
    public double calcularXp() {
        return super.XP_Padrao * this.cargaHoraria;//super.setPontos(Conteudo.XP_Padrao);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + super.getTitulo() /*+ '\'' +
                ", descricao='" + super.getDescricao() + '\'' +
                ", cargaHoraria=" + cargaHoraria */+
                "'}";
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
