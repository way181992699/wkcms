package org.wkidt.wkcms.web.controller;
//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wkidt.wkcms.common.BaseController;
import org.wkidt.wkcms.conf.Config;

/**
 * Description
 * <p>
 * Created by zcm on 2017/7/24. version 1.0
 */
@Controller
public class VerifyCotroller extends BaseController {

    private final String fontName = "Times New Roman";
    private final int fotnSize = 20;
    private final Font mFont = new Font(fontName, Font.PLAIN, fotnSize);
    private final int IMG_WIDTH = 100;
    private final int IMG_HEIGTH = 18;

    /**
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping("/verifyCode")
    public void authImg() throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(1, 1, IMG_WIDTH - 1, IMG_HEIGTH - 1);
        g.setColor(new Color(102, 102, 102));
        g.drawRect(0, 0, IMG_WIDTH - 1, IMG_HEIGTH - 1);
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(IMG_WIDTH - 1);
            int y = random.nextInt(IMG_HEIGTH - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x, y, x + xl, y + yl);
        }
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 30; i++) {
            int x = random.nextInt(IMG_WIDTH - 1);
            int y = random.nextInt(IMG_HEIGTH - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x, y, x - xl, y - yl);
        }
        g.setFont(mFont);
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String tmp = getRandomChar();//CODE_STR_ARR[rand];
            sRand += tmp;
            g.setColor(new Color(20 + random.nextInt(110)
                    , 20 + random.nextInt(110)
                    , 20 + random.nextInt(110)));
            g.drawString(tmp, 15 * i + 10, 15);
        }
        session.setAttribute(Config.CODE_VERIFY, sRand);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

    private String getRandomChar() {
        return String.valueOf((int) (Math.random() * 10));
    }

    private Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }


}
