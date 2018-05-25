import com.swetake.util.Qrcode;
import gui.ava.html.image.generator.HtmlImageGenerator;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class test {
    @Test
    public void testmethod() throws IOException {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        String jsp = "jsp成绩单";
        String html = "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>test</title>\n" +
                "    <style>\n" +
                "\n" +
                "        table,table tr th, table tr td { border:1px solid black;}\n" +
                "        table { width: 500px; min-height: 53px; line-height: 53px; border-collapse: collapse;}  \n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"ab\" style=\"width: 500px;height: 800px;\">\n" +
                "        <table class=\"table\">\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">物流公司名称</td>\n" +
                "                <td>产品类型</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\">大头笔</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">集包地名称</td>\n" +
                "                <td>集包地编码</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\">收件人信息</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\">寄件人信息</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"3\">面单号</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td style=\"width: 100px;word-break: break-all;\">面单打印时间</td>\n" +
                "                <td style=\"width: 300px;word-break: break-all;\">签收说***************************8</td>\n" +
                "                <td style=\"width: 100px\">合成的二维码</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td>物流公司名称</td>\n" +
                "                <td colspan=\"2\">面单号</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">收件人信息</td>\n" +
                "                <td rowspan=\"2\"><img style=\"width:20px;height:20px;\" src=\"http://localhost:8080/html2img/img/qrcode.png\"/></td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">寄件人信息</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td rowspan=\"5\">喜来快递+二维码</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">客服电话:10086</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">面单号：4576421211</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">物品类型：日用品</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "                <td colspan=\"2\">已验视</td>\n" +
                "            </tr>\n" +
                "        </table>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";
//        "<td rowspan=\"2\"><img style=\"width: 120px;height: 120px;\" src=\"C:/Users/suowa/Desktop/timg.jpg\"/></td>";
        imageGenerator.loadHtml(html);
        imageGenerator.saveAsImage("hello-world.png");

        imageGenerator.saveAsHtmlWithMap("hello-world.html", "hello-world.png");


//        JEditorPane ed = null;
//        ed = new JEditorPane("http://localhost:8080/html2img/html/html2/test2.html");
//
//        ed.setSize(600, 300);
//
//        //create a new image
//        BufferedImage image = new BufferedImage(ed.getWidth(), ed.getHeight(),
//                BufferedImage.TYPE_INT_ARGB);
//
//        //paint the editor onto the image
//        SwingUtilities.paintComponent(image.createGraphics(),
//                ed,
//                new JPanel(),
//                0, 0, image.getWidth(), image.getHeight());
//        //save the image to file
//        ImageIO.write((RenderedImage) image, "png", new File("html.png"));
    }

    @Test
    public void wei() throws Exception {
        Qrcode qrcode = new Qrcode();
        qrcode.setQrcodeErrorCorrect('M');//纠错等级（分为L、M、H三个等级）
        qrcode.setQrcodeEncodeMode('B');//N代表数字，A代表a-Z，B代表其它字符
        qrcode.setQrcodeVersion(7);//版本
        //生成二维码中要存储的信息
        String qrData = "http://www.baidu.com";
        //设置一下二维码的像素
        int width = 120;
        int height = 120;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //绘图
        Graphics2D gs = bufferedImage.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.setColor(Color.BLACK);
        gs.clearRect(0, 0, width, height);//清除下画板内容

        //设置下偏移量,如果不加偏移量，有时会导致出错。
        int pixoff = 2;

        byte[] d = qrData.getBytes("gb2312");
        if (d.length > 0 && d.length < 120) {
            boolean[][] s = qrcode.calQrcode(d);
            for (int i = 0; i < s.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if (s[j][i]) {
                        gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
                    }
                }
            }
        }
        gs.dispose();
        bufferedImage.flush();
        ImageIO.write(bufferedImage, "png", new File("E:/code/qrcode.png"));
    }


}
