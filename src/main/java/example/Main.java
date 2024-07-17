package example;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //so nhap vao co phai nam nhuan ko
        //nam nhuan chia hey cho 4 ma ko chia het cho 100
        carogam();


    }

    public static boolean isLeapYear(int y){
        boolean c = (y%4==0 && y%100!=0);
        return c;
    }

    public static boolean xacdinhchuoi(String text){
if (text ==null) return  false;
try{ Integer.parseInt(text);
    return true;
} catch (NumberFormatException e){
return false;}

    }

    //Tim so lon nhat va lon thu 2 cua mot mnag
    public static int[] timSoLonNhatSoHai(int[] input){
        if (input.length<3) throw new RuntimeException("Illegal array");
        int[] inputw = new int[]{1, 2};
        int soLonNhat = input[1];
        int soLonNhi = input[1];
        for(int c:input){
            if(c>soLonNhat){
                soLonNhi=soLonNhat;
                soLonNhat=c;
            }
        }
        Arrays.stream(inputw).sorted().toArray();
        return new int[]{soLonNhat, soLonNhi};
    }

    public  static void carogam(){
        Scanner input = new Scanner(System.in);
        System.out.println("Select a number between 1-9:");
        String cell1 = input.nextLine();
        System.out.println("You selected " + cell1);

        String[][] board = new String[3][3];

        int cellNumber = Integer.parseInt(cell1);
        int row = (cellNumber - 1) / 3;
        int col = (cellNumber - 1) % 3;

        board[row][col] = "x";

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(" " + (board[r][c] != null ? board[r][c] : " ") + " ");
                if (c < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (r < 2) {
                System.out.println("---------------");
            }
        }

        Random random = new Random();
        int[] mayselect = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int randomIndex = random.nextInt(mayselect.length);
        int randomElement = mayselect[randomIndex];
        System.out.println("Computer selected " + randomElement);

        int row2 = (randomElement - 1) / 3;
        int col2 = (randomElement - 1) % 3;
        board[row][col] = "x";
        board[row2][col2] = "o";

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(" " + (board[r][c] != null ? board[r][c] : " ") + " ");
                if (c < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (r < 2) {
                System.out.println("---------------");
            }
        }

    }
}