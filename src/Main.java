import java.io.*;
import java.util.*;
public class Main {
    int [] eleitoresPorSecao=new int [10];
    public static void main(String[] args) throws IOException {
        Votacao[] eleitores=new Votacao[200];
        for(int i=0;i < 200;i++){
            eleitores[i]=new Votacao();
        }
        cadastrarVotacao(eleitores);
        eleitoresPorSecao(eleitores);
        maiormenorEleitoresPorSecao(eleitores);
    }

    public static void cadastrarVotacao(Votacao[] eleitores){
        Random aleatorio=new Random();
        int i;
        for(i=0;i < 200;i++){
            eleitores[i].numeroSecao=aleatorio.nextInt(10);
            eleitores[i].numeroCandidato=aleatorio.nextInt(300);
        }
    }
    public static void eleitoresPorSecao(Votacao[] eleitores){
        int [] ordenSecao=new int[200];
        int [] eleitoresPorSecao=new int [10];
        int numCand=0,secaoMaiorEleitores=0,secaoMenorEleitores=0;
        int troca=0;
        int i,j;
        for(i=0;i < 199; i++) ordenSecao[i]=eleitores[i].numeroSecao;
        for(i=0;i < 199;i++){
            if(ordenSecao[i]>ordenSecao[i+1]){
                troca=ordenSecao[i];
                ordenSecao[i]=ordenSecao[i+1];
                ordenSecao[i+1]=troca;
                i=-1;
            }
        }
        for (i = 0; i < 200; i++) {
            System.out.println(ordenSecao[i]);
        }
        for(j=0;j < 10;j++) {
            for (i = 0; i < 200; i++) {
                if(ordenSecao[i]==j) numCand = numCand + 1;
            }
            eleitoresPorSecao[j]=numCand;
            System.out.println("Numero de eleitores na secao "+j+":"+eleitoresPorSecao[j]);
            if(j==0){
                secaoMaiorEleitores=numCand;
                secaoMenorEleitores=numCand;
            }else{
                if(secaoMaiorEleitores<numCand){
                    secaoMaiorEleitores=numCand;
                }
                if(secaoMenorEleitores>numCand){
                    secaoMenorEleitores=numCand;
                }
            }
            numCand=0;
        }
        System.out.println(secaoMaiorEleitores);
        System.out.println((secaoMenorEleitores));
    }
    public static void maiormenorEleitoresPorSecao(Votacao[] eleitores){
        int [] ordenSecao=new int[200];
        int numCand=0,secaoMaiorEleitores=0,secaoMenorEleitores=0;
        int troca=0;
        int i,j;
        for(i=0;i < 199; i++) ordenSecao[i]=eleitores[i].numeroSecao;
        for(i=0;i < 199;i++){
            if(ordenSecao[i]>ordenSecao[i+1]){
                troca=ordenSecao[i];
                ordenSecao[i]=ordenSecao[i+1];
                ordenSecao[i+1]=troca;
                i=-1;
            }
        }
        for (i = 0; i < 200; i++) {
            System.out.println(ordenSecao[i]);
        }
        for(j=0;j < 10;j++) {
            for (i = 0; i < 200; i++) {
                if(ordenSecao[i]==j) numCand = numCand + 1;
            }
            if(j==0){
                secaoMaiorEleitores=numCand;
                secaoMenorEleitores=numCand;
            }else{
                if(secaoMaiorEleitores<numCand){
                    secaoMaiorEleitores=numCand;
                }
                if(secaoMenorEleitores>numCand){
                    secaoMenorEleitores=numCand;
                }
            }
            numCand=0;
        }
    }
}