package com.mashibing.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    //建立这个类的目的是管理资源
//    定义tank图片的静态变量
    public static BufferedImage goodTankL,goodTankR,goodTankU,goodTankD; //我方坦克
    public static BufferedImage badTankL,badTankR,badTankU,badTankD; //敌方坦克
    //    定义bullet图片
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //    定义爆炸图片数组,注意：定义数组时候需要new对象确定数组大小。
    public static BufferedImage[] explodes = new BufferedImage[16];
    static {
        try {
//            getResourceAsStream是当成Stream读进来，再把这个Stream交给ImageIO请它转换成图片。
//            要用类点.class就是找到了它放到内存里的对象
//            tankL = ImageIO.read(BufferedImage.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankR = ImageUtil.rotateImage(badTankU,90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);;
            bulletD = ImageUtil.rotateImage(bulletU,180);
            for (int i = 0; i < 16; i++)
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i + 1) + ".gif"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
