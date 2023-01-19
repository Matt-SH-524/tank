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
 /*           图片路径写死了，以后打包发布，没法改路径。
            BufferedImage image = ImageIO.read(new File("D:\\Project\\tank\\src\\images\\bulletD.gif"));
            assertNotNull(new Object());*/
//            涉及到getClassLoader概念：Java的Class文件会静静的放到内存上，等着被调用，
//            其实这一个一个Class相当于对象，那么这些Class可以被看做Class类，ClassLoader就是把这些Class放到内存里。
//            ImageTest.class就是找到了它放到内存里的对象了。ImageTest.class.getClassLoader()就找到到底是谁把ImageTest.class Load到内存，
//            然后既然你能Load到内存，那请你在ClassPath里面找个文件，并且当成Stream读进来，再把这个Stream交给ImageIO请它转换成图片。
            BufferedImage image2 = ImageIO.read(TankTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
                    assertNotNull(image2);
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