package ua.roman.zozulia.kn304.massServiceSystems;

public class MssCalculator {

    private double[][] mass;
    private final Mss mss = new Mss();

    private final int beginAdmissionRange;
    private final int endAdmissionRange;
    private final int countOfCustomers;

    private final int beginServiceRange;
    private final int endServiceRange;

    public MssCalculator(int countOfCustomers,int beginAdmissionRange, int endAdmissionRange, int beginServiceRange, int endServiceRange) {
        this.countOfCustomers = countOfCustomers;
        this.beginAdmissionRange = beginAdmissionRange;
        this.endAdmissionRange = endAdmissionRange;
        this.beginServiceRange = beginServiceRange;
        this.endServiceRange = endServiceRange;
    }

    public double[][] calculate(){
        mass = new double[countOfCustomers][8];
        calculateFirstLine();
        calculateOtherLines();
        return mass;
    }

    private void calculateFirstLine(){
        mass[0][0] = 1;
        mass[0][1] = 0;
        mass[0][2] = mss.getT1OrT2(beginServiceRange,endServiceRange);
        mass[0][3] = mass[1][4] = 0.00;
        mass[0][5] = mss.getT5(mass[0][4],mass[0][2]);
        mass[0][6] = mss.getT6(mass[0][5],mass[0][3]);
        mass[0][7] = 0;
    }

    private void calculateOtherLines(){
        for (int i = 1; i < countOfCustomers; i++) {
            mass[i][0] = i+1;
            mass[i][1] = mss.getT1OrT2(beginAdmissionRange,endAdmissionRange);
            mass[i][2] = mss.getT1OrT2(beginServiceRange,endServiceRange);
            mass[i][3] = mss.getT3(mass[i-1][3],mass[i][1]);
            mass[i][4] = mss.getT4(mass[i-1][5],mass[i][3]);
            mass[i][5] = mss.getT5(mass[i][4],mass[i][2]);
            mass[i][6] = mss.getT6(mass[i][5],mass[i][3]);
            mass[i][7] = mss.getT7(mass[i][3],mass[i-1][5]);
        }
    }
}
