package com.example.demo;

import java.util.Scanner;
import java.util.Random;

public class wee {
    private static char[][] tahta = new char[3][3];
    private static char oyuncu = 'X';

    public static void main(String[] args) {
        tahtaOlustur();
        tahta();

        while (true){
            Oyuncu(oyuncu);
            tahta();

            if(kimKazandi()){
                break;
            }
            degisim();
        }
    }

    private static void tahtaOlustur(){
        for(int satir = 0; satir < 3 ; satir++){
            for(int sutun = 0; sutun < 3; sutun++){
                tahta[satir][sutun] = '-';
            }
        }
    }

    private static void tahta(){
        System.out.println("Oyun alani");
        for(int satir = 0;satir<3 ; satir++){
            for(int sutun = 0; sutun < 3; sutun++) {
                System.out.print( tahta[satir][sutun] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean kazanan(char oyuncu){
        for(int i= 0 ; i < 3 ; i++){
            if(tahta[i][0]==oyuncu && tahta[i][1] == oyuncu && tahta[i][2] == oyuncu ||
                    tahta[0][i]==oyuncu && tahta[1][i] == oyuncu && tahta[2][i] == oyuncu) {
                return true;
            }
        }
        return (tahta[0][0] == oyuncu && tahta[1][1] == oyuncu && tahta[2][2]==oyuncu ||
                tahta[0][2] == oyuncu && tahta[1][1] == oyuncu && tahta[2][0]==oyuncu);
    }

    private static boolean doluTahta(){
        for(int i = 0 ; i < 3 ; i++){
            for(int b = 0; b < 3 ; b++){
                if(tahta[i][b] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    private static void Oyuncu(char oyuncu){
        Scanner sc = new Scanner(System.in);
        int satir, sutun;
        do{
            System.out.println("Oyuncu " + oyuncu + " satir ve sutun secin:");
            satir = sc.nextInt() - 1;
            sutun = sc.nextInt() - 1;
        }
        while(!dogruAdim(satir , sutun));

        tahta[satir][sutun] = oyuncu;
    }

    private static boolean dogruAdim(int satir , int sutun){
        if(satir >= 3 || sutun < 0 || satir < 0 || sutun >= 3){
            System.out.println("Yanlis adim.Dogru numara yazin lutfen");
            return false;
        }
        if(tahta[satir][sutun] != '-'){
            System.out.println("Bu numara doludur!");
            return false;
    }
        return true;
    }

    private static boolean kimKazandi(){
        if(kazanan('X')){
            System.out.println("X kazandi,tebrikler");
            return true;
        }
        if(kazanan('O')){
            System.out.println("O kazandi,tebrikler");
            return true;
        }
        if(doluTahta()){
            System.out.println("Tahta doldu, oyun berabere bitti");
            return true;
        }
        return false;
    }

    private static void degisim(){
        oyuncu = (oyuncu == 'X') ? 'O':'X';
    }
}
