package ua.roman.zozulia.kn304.generator;

import java.util.Random;

public class Generator {
    private static final Random random = new Random();
    public static int generate(int from, int to){
        return from+random.nextInt(to-from);
    }
}
