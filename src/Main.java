import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        Votacao[] eleitores=new Votacao[200];
        for(int i=0;i < 200;i++){
            eleitores[i]=new Votacao();
        }
        cadastrarVotacao(eleitores);
        eleitoresPorSecao(eleitores);
        maiormenorEleitoresPorSecao(eleitores);
        votosPorCandidatos(eleitores);
    }

    public static void cadastrarVotacao(Votacao[] eleitores){
        Random aleatorio=new Random();
        int i;
        for(i=0;i < 200;i++){
            eleitores[i].numeroSecao=aleatorio.nextInt(11);
            eleitores[i].numeroCandidato=aleatorio.nextInt(301);
        }
    }
    public static void eleitoresPorSecao(Votacao[] eleitores){
        int [] ordenSecao=new int[200];
        int [] eleitoresPorSecao=new int [11];
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
        for(j=0;j < 11;j++) {
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
        int i,j;
        int numEleitores=0;
        int secaoMaior=0,secaoMenor=0;
        int maior=0,menor=0;
        for(i=0;i<11;i++) {
            for (j = 0; j < 200; j++) {
                if (eleitores[j].numeroSecao == i) {
                    numEleitores += 1;
                }
            }
            if (maior < numEleitores){
                secaoMaior = i;
                maior=numEleitores;
            }
            if(i==0){
                menor=numEleitores;
            }
            if(menor>numEleitores) {
                secaoMenor = i;
                menor=numEleitores;
            }
            numEleitores=0;
        }
        System.out.println("Secao com maior numero de eleitores:"+secaoMaior);
        System.out.println(("Secao com menor numero de eleitores:"+secaoMenor));
    }

    public static void votosPorCandidatos(Votacao[] eleitores){
        int i,j;
        int numCandidatos=0;
        for(j=0;j<300;j++){
            for(i=0;i<200;i++) {
                if (eleitores[i].numeroCandidato == j) {
                    numCandidatos += 1;
                }
            }
            System.out.println("Votos do candidato " + j + ": " + numCandidatos);
            numCandidatos = 0;
        }
    }
}