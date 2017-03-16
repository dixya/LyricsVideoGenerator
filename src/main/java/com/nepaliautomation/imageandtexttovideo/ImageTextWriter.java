/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepaliautomation.imageandtexttovideo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author dixya
 */
public class ImageTextWriter {
    public static void main(String[] args) throws Exception {
        final BufferedImage image = ImageIO.read(new File("/home/dixya/Desktop/dad.JPG"));

        Graphics g = image.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString("Nepte Naak ma", 100, 100);
        g.dispose();

        ImageIO.write(image, "png", new File("/home/dixya/Desktop/dad-with-text.JPG"));
    }    
}
