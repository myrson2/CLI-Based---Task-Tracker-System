package util;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class IDGeneratorUtil{
    private static Random random = new Random();
    private static Set<Integer> id = new HashSet<>();
    
    public static int generateId() {
        int num;
        // Keep generating until we find a unique positive ID
        do {
            // Generate positive ID (0 to Integer.MAX_VALUE)
            num = Math.abs(random.nextInt());
        } while (id.contains(num) && id.size() < Integer.MAX_VALUE);
        
        id.add(num);
        return num;
    }    
}