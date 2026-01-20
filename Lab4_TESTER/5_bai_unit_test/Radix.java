import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Radix {
    private int number;
    
    public Radix(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Incorrect Value");
        }
        this.number = number;
    }
    
    public String convertDecimalToAnother(int radix) {
        if (radix < 2 || radix > 16) {
            throw new IllegalArgumentException("Invalid Radix");
        }
        
        if (number == 0) {
            return "0";
        }
        
        int n = this.number;
        List<String> result = new ArrayList<>();
        
        while (n > 0) {
            int value = n % radix;
            if (value < 10) {
                result.add(String.valueOf(value));
            } else {
                switch (value) {
                    case 10: result.add("A"); break;
                    case 11: result.add("B"); break;
                    case 12: result.add("C"); break;
                    case 13: result.add("D"); break;
                    case 14: result.add("E"); break;
                    case 15: result.add("F"); break;
                }
            }
            n /= radix;
        }
        
        Collections.reverse(result);
        return String.join("", result);
    }
}