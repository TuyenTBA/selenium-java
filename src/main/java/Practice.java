import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Practice {
    public static void main(String[] args) {
        countsonguyenam("Toi la Tuyen. Toi rat iu cac ban");

    }

    private static void returnFirstAlphabet(String string){
        String word = "";
        String [] split = string.split(" ");

        for(int i=0; i<split.length; i++){
            word = split[i];
            System.out.print(word.charAt(0));
        }
    }

    public static void countsonguyenam(String b){
        Map<Character, Integer> d = new HashMap<>();
        char[] list = {'a','e','o','u','i'};
        for(char f:list ){
            int count = 0;
            char[] a = b.toCharArray();
            for(char c:a){
                if (Objects.equals(c,f)){
                    count++;
                }
            }
            d.put(f,count);
            System.out.println("So nguyen am " + f + " so luong " + count);

        }
    }


}
