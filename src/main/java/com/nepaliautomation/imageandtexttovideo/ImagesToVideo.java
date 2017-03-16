/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nepaliautomation.imageandtexttovideo;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import javax.imageio.ImageIO;
import org.jcodec.api.awt.SequenceEncoder;

/**
 *
 * @author dixya
 */
public class ImagesToVideo {
    
    public static void main(String... args) throws Exception {
        String imageFilename = "/home/dixya/Desktop/dad.JPG";
        String lyricsFilename = "/home/dixya/Desktop/nepte-naak-ma.txt";
        String outputVideoFilename = "/home/dixya/Desktop/NepteNaakMa.mp4";
        
        SequenceEncoder enc = new SequenceEncoder(new File(outputVideoFilename));
        List<String> fileLines = Files.readAllLines(new File(lyricsFilename).toPath(), StandardCharsets.UTF_8);
        
        //BufferedImage image = ImageIO.read(new File(imageFilename));
        // GOP size will be supported in 0.2
        //enc.getEncoder().setKeyInterval(25);
        
        // This need to be modified to set the frame param
        // This will be the function of the time
        int frameParam = 10;
        
        for(String line: fileLines) {
            //TODO can we do one time init?
            BufferedImage image = ImageIO.read(new File(imageFilename));

            BufferedImage imageWithText = getImageWithText(image, line);
            for(int i=0; i<=frameParam; i++) {
                enc.encodeImage(imageWithText);
            }
        }
        enc.finish();
    }
    
    public static BufferedImage getImageWithText(BufferedImage image, String text) throws Exception{
        Graphics g = image.getGraphics();
        g.setFont(g.getFont().deriveFont(30f));
        g.drawString(text, 100, 100);
        g.dispose();
        //TODO can we return new image without mutating it?
        return image;
    }
}
