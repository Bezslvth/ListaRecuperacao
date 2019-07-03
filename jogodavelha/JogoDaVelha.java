package jogodavelha;

public class JogoDaVelha {

    private Status[][] grade;
    private String resultado;

    public JogoDaVelha() {
        grade = new Status[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grade[i][j] = Status.VAZIA;
            }
        }
    }
    
    public JogoDaVelha(Status[][] tabuleiro) {
        this.grade = tabuleiro;
    }
    
    public String exibeGrade(){
        String retorno = "";
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                retorno += count + retornaCasa(grade[i][j]) + " ";
                count++;
            }
            retorno += "\n";
        }
        return retorno;
    }
    
    private String retornaCasa(Status o){
        String casa = "";
        if(Status.VAZIA == o){
            casa = "[   ]";
        }else if(Status.JOGADOR_1 == o){
            casa = "[ X ]";
        }else if(Status.JOGADOR_2 == o){
            casa = "[ O ]";
        }
        return casa;
    }

    public boolean realidaJogada(int jogada, Status o){
        boolean jogadaValida = true;
        switch (jogada) {
            case 1:
                if(grade[0][0] == Status.VAZIA){
                    grade[0][0] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 2:
                if(grade[0][1] == Status.VAZIA){
                    grade[0][1] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 3:
                if(grade[0][2] == Status.VAZIA){
                    grade[0][2] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 4:
                if(grade[1][0] == Status.VAZIA){
                    grade[1][0] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 5:
                if(grade[1][1] == Status.VAZIA){
                    grade[1][1] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 6:
                if(grade[1][2] == Status.VAZIA){
                    grade[1][2] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 7:
                if(grade[2][0] == Status.VAZIA){
                    grade[2][0] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 8:
                if(grade[2][1] == Status.VAZIA){
                    grade[2][1] = o;
                }else{
                    jogadaValida = false;
                }
                break;
            case 9:
                if(grade[2][2] == Status.VAZIA){
                    grade[2][2] = o;
                }else{
                    jogadaValida = false;
                }
                break;
        }
        return jogadaValida;
    }
    
    public boolean gradeCheia(){
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grade[i][j] != Status.VAZIA){
                    count++;
                }
            }
        }
        
        if(count >= 9){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean fimDeJogo(){
        boolean fim = false;
        if(gradeCheia()){
            fim = true;
            resultado = "VELHA";
        }
        
        if(jogadorVenceu(Status.JOGADOR_1)){
            fim = true;
            resultado = "VITORIA JOGADOR 1";
        }
        
        if(jogadorVenceu(Status.JOGADOR_2)){
            fim = true;
            resultado = "VITORIA JOGADOR 2";
        }
        
        return fim;
    }
    
    public boolean jogadorVenceu(Status o){
        boolean venceu = false;
        int countColuna = 0;
        int countLinha = 0;
        int countDiagonal1 = 0;
        int countDiagonal2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {                
                //COLUNA
                if(grade[i][j] == o){
                    countColuna++;
                }
                //LINHA
                if(grade[j][i] == o){
                    countLinha++;
                }
                //DIAGONAL
                if(i == j && grade[i][j] == o){
                    countDiagonal1++;
                }
                if((i == 2 && j == 0 && grade[i][j] == o) || (i == 1 && j == 1 && grade[i][j] == o) || (i == 0 && j == 2 && grade[i][j] == o)){
                    countDiagonal2++;
                }
            }
            if(countColuna >= 3 || countLinha >= 3 || countDiagonal1 >= 3 || countDiagonal2 >= 3){
                venceu = true;
                break;
            }
            
            countColuna = 0;
            countLinha = 0;            
        }                       
        return venceu;
    }
    
    public Status[][] getGrade() {
        return grade;
    }

    public void setGrade(Status[][] grade) {
        this.grade = grade;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
        
}