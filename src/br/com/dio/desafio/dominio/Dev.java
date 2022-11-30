package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private double totalXp;

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            this.totalXp = this.calcularTotalXp();
        }else{
            System.err.println("Voçê não tem conteudo inscrito para poder concluir");
        }
    }
    public double calcularTotalXp(){
        return this.conteudosConcluidos
                .stream()
                    .mapToDouble(conteudo -> conteudo.calcularXp())
                        .sum();
    }

    public double getTotalXp() {
        return totalXp;
    }

    public void setTotalXp(double totalXp) {
        this.totalXp = totalXp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

}
