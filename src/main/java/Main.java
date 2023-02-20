import java.util.Objects;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numbers = sc.nextLine();
        if(numbers.length() > 7){
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            System.exit(0);
        }
        String answer = calc(numbers);
        System.out.print(answer);
    }


    public static String calc(String numbers){
        String[] ls = numbers.split("\\s");
        String otvet = "", num1 = "";
        String [] rome = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        try{
            num1 = ls[0];
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("строка не является математической операцией");
        }
        try {
            char oper = ls[1].charAt(0);
            String num2 = ls[2];
            int answer = 0;
            int fst = 0, snd = 0, check = 0;


            try {
                fst = Integer.parseInt(num1);
            } catch (NumberFormatException e) {
                check++;
                for (int i = 0; i < rome.length; i++) {
                    if (Objects.equals(num1, rome[i])) {
                        fst = i + 1;
                    }
                }
            }

            try {
                snd = Integer.parseInt(num2);
            } catch (NumberFormatException e) {
                check++;
                for (int i = 0; i < rome.length; i++) {
                    if (Objects.equals(num2, rome[i])) {
                        snd = i + 1;
                    }
                }
            }

            switch (oper) {
                case '+' -> answer = fst + snd;
                case '-' -> answer = fst - snd;
                case '*' -> answer = fst * snd;
                case '/' -> answer = fst / snd;
            }
            otvet = Integer.toString(answer);


            if(check != 0) {
                if (answer < 0 && check % 2 == 0) {
                    System.out.println(" В римской системе нет отрицательных чисел");
                    System.exit(0);
                } else if (check % 2 == 0) {
                    for (int i = 0; i < rome.length; i++) {
                        if (answer == i ) {
                            otvet = rome[i - 1];
                        }
                    }
                } else {
                    System.out.println("используются одновременно разные системы счисления");
                    System.exit(0);
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("строка не является математической операцией");
            System.exit(0);
        }
        return otvet;
    }
}
