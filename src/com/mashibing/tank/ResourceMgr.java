package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    //建立这个类的目的是管理资源
//    定义tank图片的静态变量
    public static BufferedImage tankL,tankR,tankU,tankD;
    //    定义bullet图片
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    static {
        try {
//            getResourceAsStream是当成Stream读进来，再把这个Stream交给ImageIO请它转换成图片。
//            要用类点.class就是找到了它放到内存里的对象
//            tankL = ImageIO.read(BufferedImage.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
