package test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TankTest {

    @Test
    void test() {
        try {
            BufferedImage image = ImageIO.read(new File("D:\\Project\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(new Object());
        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
//        所谓的断言就是判断条件成不成立，如果成立就是测试通过，如果不成立就是测试没通过。

    }
    @Test
    void getDir() {
    }

    @Test
    void setDir() {
    }

    @Test
    void isMoving() {
    }

    @Test
    void setMoving() {
    }

    @Test
    void paint() {
    }

    @Test
    void fire() {
    }
}