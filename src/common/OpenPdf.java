/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author aniru
 */
public class OpenPdf {
    public static void openById(String id){
        try{
            if(new File("P:\\"+id+".pdf").exists()){
                Process p=Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler P:\\"+id+".pdf");
        }
            else
                JOptionPane.showMessageDialog(null, "File does not exist");
      }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
}
