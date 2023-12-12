package ua.roman.zozulia.kn304.massServiceSystems;

import ua.roman.zozulia.kn304.generator.Generator;

import static java.lang.Math.*;

public class Mss {

    public double getT1OrT2(int from, int to){
        return Generator.generate(from,to);
    }

    public double getT3(double old_t3, double t1){
        return convertToHours(old_t3+(t1*0.01));
    }

    public double getT4(double old_t5, double t3){
        return convertToHours(max(old_t5,t3));
    }

    public double getT5(double t4, double t2){
        return convertToHours(t4+(t2*0.01));
    }

    public double getT6(double t5, double t3){
        return subtractUseHours(t5,t3);

    }

    public double getT7(double t3, double old_t5){
        if (t3 > old_t5){
            return subtractUseHours(t3,old_t5);
        }else{
            return 0;
        }
    }

    public static double convertToHours(double number){
        double wholePart = floor(number);
        double fractionPart = number-wholePart;
        if (fractionPart>=0.60)
            return 1+wholePart+(fractionPart-0.60);
        else
            return number;
    }

    public static double subtractUseHours(double firstNumber, double secondNumber){
        double result = round(100*((firstNumber-secondNumber)));
        return result - (40 * (floor(firstNumber) - floor(secondNumber)));
    }
}
