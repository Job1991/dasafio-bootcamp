import br.com.dio.desafio.dominio.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static <T> void imprimirListaNoConsole(List<T>  lista, String msg){
        System.out.println(msg);
        for(Object object : lista){
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        List<Curso> listaCurso = new ArrayList<>(){{
            add(new Curso("Curso Java - Iffod",
                    "Curso de java com participação do ifood",1));
            add(new Curso("Curso HTML ",
                    "Curso de HTML com participação do guanabara",2));
            add(new Curso("Curso JQuery - Inês Barbosa",
                    "Curso de JQuery ministrado pela Tia Inês",3));
            add(new Curso("Curso CSS - Bootstrap",
                    "Curso de bootstrap",4));
        }};
        List<Mentoria> listaMentoria = new ArrayList<>(){{
            add(new Mentoria("Mentoria1","descrição11"){{
                setData(LocalDate.now().plusDays(5));
            }});
            add(new Mentoria("Mentoria2","descrição2"){{
                setData(LocalDate.now().plusDays(10));
            }});


            add(new Mentoria("Mentoria3",
                    "descrição3",
                        LocalDate.now().plusDays(12)));
            LocalDate localDate = LocalDate.now().plusDays(15);
            add(new Mentoria("Mentoria4","descrição4",localDate));
        }};


        imprimirListaNoConsole(listaCurso,"Lista de cursos:");
        imprimirListaNoConsole(listaMentoria,"Lista de mentorias:");


        Bootcamp bootcamp = new Bootcamp(){{
            this.setNome("Bootcamp java developer");
            setDescricao("Descrição do bootcamp java developer");
            getConteudos().add(listaCurso.get(0));
            getConteudos().add(listaMentoria.get(0));
            getConteudos().add(listaMentoria.get(1));
            getConteudos().add(listaCurso.get(2));
        }};

        imprimirListaNoConsole(new ArrayList<>(bootcamp.getConteudos()),
                "Conteudos do "+ bootcamp.getNome());

        Dev joao = new Dev(){{
            setNome("João Silva");
        }};

        Dev lucas = new Dev(){{
            setNome("Lucas Job");
            String nome = getNome();
            System.out.println(nome +" escrito em:"+this.getConteudosInscritos());
            this.inscreverBootcamp(bootcamp);
            System.out.println(nome + " se inscreveu no bootcamp "+bootcamp.getNome());
            System.out.println("Lucas escrito nos conteudos: "+this.getConteudosInscritos());
            System.out.println("Lucas concluiu: "+this.getConteudosConcluidos());
            System.out.println("Lucas XP: "+this.calcularTotalXp());
            for(int i=0; i<2 ;i++){
                this.progredir();
                System.out.println("Lucas Progrediu!");
                System.out.println("Lucas escrito no conteudos: "+this.getConteudosInscritos());
                System.out.println("Lucas concluiu: "+this.getConteudosConcluidos());
                System.out.println("Lucas XP: "+this.getTotalXp());
            }
            /*
            this.progredir();
            System.out.println("Lucas Progrediu!");
            System.out.println("Lucas escrito no conteudos: "+this.getConteudosInscritos());
            System.out.println("Lucas concluiu: "+this.getConteudosConcluidos());
            System.out.println("Lucas XP: "+this.calcularTotalXp());
            this.progredir();
            System.out.println("Lucas Progrediu!");
            System.out.println("Lucas escrito no conteudos: "+this.getConteudosInscritos());
            System.out.println("Lucas concluiu: "+this.getConteudosConcluidos());
            System.out.println("Lucas XP: "+this.calcularTotalXp());*/
        }};


        imprimirListaNoConsole(
                joao.
                        getConteudosInscritos().
                            parallelStream().
                                toList(), "Conteudos de joão:"
        );



    }
}