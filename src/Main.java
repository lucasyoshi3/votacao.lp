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
        int [] ordenCandidatos=new int[200];
        int numCand=0,maior=0;
        int troca=0;
        int i,j;
        for(i=0;i < 199; i++) ordenCandidatos[i]=eleitores[i].numeroSecao;
        for(i=0;i < 199;i++){
            if(ordenCandidatos[i]>ordenCandidatos[i+1]){
                troca=ordenCandidatos[i];
                ordenCandidatos[i]=ordenCandidatos[i+1];
                ordenCandidatos[i+1]=troca;
                i=-1;
            }
        }
        for (i = 0; i < 200; i++) {
            System.out.println(ordenCandidatos[i]);
        }
        for(j=0;j < 10;j++) {
            for (i = 0; i < 200; i++) {
                if(ordenCandidatos[i]==j) numCand = numCand + 1;
            }
            System.out.println(numCand);
            if(j==0){
                maior=numCand;
            }else{
                if(maior<numCand){
                    maior=numCand;
                }
            }
            numCand=0;
        }
        System.out.println(maior);
    }
}