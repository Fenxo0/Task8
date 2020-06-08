package com.company;

public class Logic {
    public static int[][] process(int[][] arr) {
        int k = 0, znack = 0, k1 = 0, znack1 = 0;
        int [][] mas = arr;
        int [][] mas1 = new int [arr.length][arr.length];
        /*mas [0][0] = 5;
        mas [0][1] = 5;
        mas [0][2] = 5;
        mas [1][0] = 7;
        mas [1][1] = 6;
        mas [1][2] = 8;
        mas [2][0] = 5;
        mas [2][1] = 5;
        mas [2][2] = 5;

         */
	    /*for (int i = 0; i < n; i++)
	        for (int j = 0; j < n; j++){
	            mas[i][j] = rnd.nextInt(9) + 1;
            }*/
        for (int g = 0; g < mas.length; g++){
            System.out.println();
            for (int j = 0; j < mas.length; j++)
                System.out.print(mas[g][j]);
        }
        System.out.println();
        for (int i = 0; i < mas.length; i++) {
            znack1 = mas[i][0];
            znack = mas[i][0];
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > znack) {
                    znack = mas[i][j];
                    k = j;
                }
                if (znack1 > mas[i][j]){
                    znack1 = mas[i][j];
                    k1 = j;
                }
            }
            mas1 = Sedl1(mas, znack, k, mas.length, i, mas1);
            mas1 = Sedl(mas, znack1, k1, mas.length, i, mas1);
        }
        return mas1;
    }

    static int[][] Sedl1 (int[][] mas,int znack, int k, int n, int i, int[][] mas1){
        boolean flag = true;
        for (int g = 0; g < n; g++){
            if (znack < mas[g][k]){
                flag = true;
                continue;
            }
            else{
                flag = false;
            }
        }
        if (flag == true) {

            for (int j = 0; j < n; j++){
                if (j == k) mas1[i][j] = 1;
            }
        }
        return mas1;
    }

    static int[][] Sedl (int[][] mas,int znack, int k1, int n, int i, int[][] mas1){
        boolean flag = true;
        for (int g = 0; g < n; g++){
            if (znack > mas[g][k1]){
                flag = true;
                continue;
            }
            else{
                flag = false;
            }
        }
        if (flag == true) {
            mas1[i][k1] = 1;
        }
        return mas1;
    }
}

