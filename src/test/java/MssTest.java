import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import ua.roman.zozulia.kn304.massServiceSystems.Mss;

public class MssTest {

    private static Mss mss;

    @BeforeAll
     static void beforeAll(){
        mss = new Mss();
    }

    @Test
    void getT1orT2Test(){
        double value = mss.getT1OrT2(10,20);
        Assertions.assertTrue((value <= 20 && value >= 10));
    }

    @Test
    void getT3Test(){
        Assertions.assertEquals(mss.getT3(0.43,2),0.45);
    }

    @Test
    void getT4Test(){
        Assertions.assertEquals(mss.getT4(0.02,0.32),0.32);
    }

    @Test
    void getT5Test(){
        Assertions.assertEquals(mss.getT5(0.02,4),0.06);
    }

    @Test
    void getT6Test(){
        Assertions.assertEquals(mss.getT6(0.32,0.03),29);
    }

    @Test
    void getT7Test(){
        Assertions.assertEquals(mss.getT7(0.32,0.77),0);
        Assertions.assertEquals(mss.getT7(0.32,0.22),10);
    }


}

