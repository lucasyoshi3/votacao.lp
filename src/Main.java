import javax.sound.midi.SysexMessage;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        int i;
        int [] eleitoresPorSecao=new int [11];
        Votacao[] eleitores=new Votacao[200];

        String nomeArquivo="ArquivoDeVotação.txt";
        BufferedWriter escreva=new BufferedWriter(new FileWriter(nomeArquivo));

        for(i=0;i < 200;i++){
            eleitores[i]=new Votacao();
        }

        cadastrarVotacao(eleitores);
        eleitoresPorSecao=eleitoresPorSecao(eleitores);
        for(i=0;i<11;i++){
            escreva.write(Integer.toString(eleitoresPorSecao[i]));
            escreva.newLine();
        }
        escreva.write("maior num de eleitores"+Integer.toString(maiorEleitoresPorSecao(eleitores)));
        escreva.newLine();
        escreva.write("menor num de eleitores"+Integer.toString(menorEleitoresPorSecao(eleitores)));
        escreva.newLine();
        votosPorCandidatos(eleitores);

        escreva.close();
        System.exit(0);
    }

    public static void cadastrarVotacao(Votacao[] eleitores){
        Random aleatorio=new Random();
        int i;
        for(i=0;i < 200;i++){
            eleitores[i].numeroSecao=aleatorio.nextInt(11);
            eleitores[i].numeroCandidato=aleatorio.nextInt(301);
        }
    }
    public static int [] eleitoresPorSecao(Votacao[] eleitores){
        int [] eleitoresPorSecao=new int [11];
        int numCand=0;
        int i;
        int j;
        for(j=0;j < 11;j++) {
            for (i = 0; i < 200; i++) {
                if(eleitores[i].numeroSecao==j) numCand = numCand + 1;
            }
            eleitoresPorSecao[j]=numCand;
            numCand=0;
        }
        return eleitoresPorSecao;
    }
    public static int maiorEleitoresPorSecao(Votacao[] eleitores){
        int i,j;
        int numEleitores=0;
        int secaoMaior=0;
        int maior=0;
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
            numEleitores=0;
        }
        return secaoMaior;
    }
    public static int menorEleitoresPorSecao(Votacao[] eleitores){
        int i,j;
        int numEleitores=0;
        int secaoMenor=0;
        int maior=0,menor=0;
        for(i=0;i<11;i++) {
            for (j = 0; j < 200; j++) {
                if (eleitores[j].numeroSecao == i) {
                    numEleitores += 1;
                }
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
        System.out.println(("Secao com menor numero de eleitores:"+secaoMenor));
        return secaoMenor;
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