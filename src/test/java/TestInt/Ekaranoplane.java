package TestInt;

import org.junit.jupiter.api.Test;

public class Ekaranoplane extends Plane implements Move.fly, Move.swimm {

    @Test
    public void Be_200() {
        System.out.println(swimm.Приводнение);
        flying();

    }

    @Override
    public void flying() {
        String полет = Полет;
        System.out.println(полет);


    }
}
