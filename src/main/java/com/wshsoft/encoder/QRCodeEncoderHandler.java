package com.wshsoft.encoder;
/**
 * @package 
 * @title: QRCodeEncoderHandler.java
 * @company: �����Ա�
 * @copyright: Copyright (c) 2012
 * @version V1.0
 */

/**
 * @className: QRCodeEncoderHandler
 * @description: TODO
 * @author: л��
 * @email: xiejian@hitao.com
 * @date 2013-2-27
 *
 */

import java.awt.Color;   
import java.awt.Graphics2D;   
import java.awt.image.BufferedImage;   
import java.io.File;   
  
import javax.imageio.ImageIO;   
 
import com.swetake.util.Qrcode;   
 
/**  
 * ��ά��������  
 * @blog http://sjsky.iteye.com  
 * @author Michael  
 */  
public class QRCodeEncoderHandler {   
  
    /**  
     * ���ɶ�ά��(QRCode)ͼƬ  
     * @param content  
     * @param imgPath  
     */  
    public void encoderQRCode(String content, String imgPath) {   
        try {   
  
           Qrcode qrcodeHandler = new Qrcode();   
            qrcodeHandler.setQrcodeErrorCorrect('M');   
            qrcodeHandler.setQrcodeEncodeMode('B');   
            qrcodeHandler.setQrcodeVersion(7);   
  
            System.out.println(content);   
            byte[] contentBytes = content.getBytes("UTF-8");   
  
            BufferedImage bufImg = new BufferedImage(140, 140,   
                    BufferedImage.TYPE_INT_RGB);   
  
            Graphics2D gs = bufImg.createGraphics();   
  
            gs.setBackground(Color.WHITE);   
            gs.clearRect(0, 0, 140, 140);   
  
            // �趨ͼ����ɫ > BLACK   
            gs.setColor(Color.BLACK);   
 
           // ����ƫ���� �����ÿ��ܵ��½�������   
            int pixoff = 2;   
            // ������� > ��ά��   
            if (contentBytes.length > 0 && contentBytes.length < 120) {   
                boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);   
                for (int i = 0; i < codeOut.length; i++) {   
                    for (int j = 0; j < codeOut.length; j++) {   
                        if (codeOut[j][i]) {   
                            gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);   
                        }   
                    }   
                }   
            } else {   
                System.err.println("QRCode content bytes length = "  
                        + contentBytes.length + " not in [ 0,120 ]. ");   
           }   
  
           gs.dispose();   
            bufImg.flush();   
 
            File imgFile = new File(imgPath);   
  
           // ���ɶ�ά��QRCodeͼƬ   
           ImageIO.write(bufImg, "png", imgFile);   
 
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
  
    }   
  
    /**  
     * @param args the command line arguments  
     */  
    public static void main(String[] args) {   
        String imgPath = "D:/Michael_QRCode.png";   
  
       String content = "���ɶ�ά�뱱������������ŵ�½��ǾͿ���";   
 
        QRCodeEncoderHandler handler = new QRCodeEncoderHandler();   
        handler.encoderQRCode(content, imgPath);   
  
       System.out.println("encoder QRcode success");   
    }   
}  

