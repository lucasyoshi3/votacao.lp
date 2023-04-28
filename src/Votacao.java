class Votacao {
    int votacao;
    int numeroSecao;
    int numeroCandidato;

    Votacao(){
        this(0,0,0);
    }

    Votacao(int voto, int secao, int candidato){
        votacao=voto;
        numeroSecao=secao;
        numeroCandidato=candidato;
    }
}
