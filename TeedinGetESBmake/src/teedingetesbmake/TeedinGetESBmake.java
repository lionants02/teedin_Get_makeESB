/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teedingetesbmake;

import com.nectec.ssi.max.teedin1.C_WriteTeedinToFile;
import com.nectec.ssi.max.teedin1.C_myParcel;
import com.nectec.ssi.max.teedin1.C_readLine;
import com.nectec.ssi.max.teedin1.getTeedinService;
import getpradirect.TrustAllX509TrustManager;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SSI
 */
public class TeedinGetESBmake {

       
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String provincecode="13";
        String ampercode="03"; 
        TrustAllX509TrustManager.my_passCer();
        getTeedinService func=new getTeedinService();
        //ArrayOfParcel result=getParcel("13", "01", "99999");
        C_myParcel out;
        C_readLine readline;
        
        try {
            readline=new C_readLine("C:\\Users\\Administrator\\Desktop\\data.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TeedinGetESBmake.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String currentn4 = readline.my_readline().trim();
        //String[] data=linedata.split("\t");asdfsadf
        //String currentn4=data[2].trim();
        //System.out.println(data[2].trim());
        /*for (String data1 : data) {
            System.out.println(data1.trim());
        }*/
        
        C_WriteTeedinToFile writeerfi = new C_WriteTeedinToFile("C:\\Users\\Administrator\\Desktop\\data_res.txt");
        while (currentn4 != null) {
            
            try {
                out=null;
                out = func.my_getValue(provincecode, ampercode, currentn4);
                writeerfi.writeToFile(provincecode, ampercode, currentn4, out);
            } catch (Exception ex) {
                
                try {
                    out=null;
                    out = func.my_getValue(provincecode, ampercode, currentn4);
                    writeerfi.writeToFile(provincecode, ampercode, currentn4, out);
                } catch (Exception ex1) {
                    try {
                        out=null;
                        out = func.my_getValue(provincecode, ampercode, currentn4);
                        writeerfi.writeToFile(provincecode, ampercode, currentn4, out);
                    } catch (Exception ex2) {
                        Logger.getLogger(TeedinGetESBmake.class.getName()).log(Level.SEVERE, null, ex2);
                        writeerfi.writeToFileErr(provincecode, ampercode, currentn4,ex2.getMessage());
                    }                    
                }                
                //writeerfi.writeToFileErr("40", "01", currentn4);
            }finally{
                currentn4 = readline.my_readline().trim();
                
            }
        }
        readline.my_closebuff();


        
      
    }
    
}
