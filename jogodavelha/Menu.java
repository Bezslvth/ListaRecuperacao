package jogodavelha;

import java.util.Scanner;


public class Menu {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        boolean jogadaValida;
        
        System.out.println("Bem Vindo");        
        do {            
            System.out.println(jogo.exibeGrade());
            do {                
                System.out.println("Jogador 1, faça a sua jogada : ");
                jogadaValida = jogo.realidaJogada(ler.nextInt(), Status.JOGADOR_1);
            } while (!jogadaValida);
            
            do{
                System.out.println("Jogador 2, faça a sua jogada : ");
                jogadaValida = jogo.realidaJogada(ler.nextInt(), Status.JOGADOR_2);
            } while (!jogadaValida);
        } while (!jogo.fimDeJogo());
        
        System.out.println(jogo.exibeGrade());
        System.out.println("Resultado: "+jogo.getResultado());        
    }
    
}
