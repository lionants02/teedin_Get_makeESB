/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nectec.ssi.max.teedin1;

import _55._49._164._110.dolparcel2ega.ArrayOfParcel;
import _55._49._164._110.dolparcel2ega.Parcel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Max
 */
public class getTeedinService {
    
    public C_myParcel my_getValue(String provincecode,String amphoecode, String ns4No) throws Exception{
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String datecurr=dateFormat.format(date); 
        
        Parcel out;
        try{
        out=getParcel(provincecode, amphoecode, ns4No).getParcel().get(0);
        if(out.getAMPHURNAME().getValue().length()<1 || out.getAMPHURNAME().getValue().equals("null"))throw new Exception();
        }catch(Exception e){
            out=null;
        }
        
        
        
        if(out==null && out.getAreaRai()!=null){
            String str="";
            str += out.getAreaRai() + "\t";
            str += out.getAreaNang()+ "\t";
            str += out.getAreaWa();
            throw new Exception("ไม่มีข้อมูลที่ตั่ง\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+str+"\t"+datecurr);
        }
        else if (out.getAreaRai()==null && out==null) {
            throw new Exception("ไม่พบข้อมูล\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }else if(out!=null && out.getAreaRai()==null){
            String str = "";
            str += out.getAMPHURNAME().getValue() + "\t";
            str += out.getLANDOFFICENAME().getValue() + "\t";
            str += out.getLANDOFFICEX() + "\t";
            str += out.getLANDOFFICEY() + "\t";
            str += out.getMAPX() + "\t";
            str += out.getMAPY() + "\t";
            str += out.getPARCELNO().getValue() + "\t";
            str += out.getPIN().getValue() + "\t";
            str += out.getPROVINCENAME().getValue() + "\t";
            str += out.getSURVEYNO() + "\t";
            str += out.getTAMBOLNAME().getValue() + "\t";
            str += out.getUTMLANDNO() + "\t";
            str += out.getUTMMAP().getValue() + "\t";
            throw new Exception(str+"ไม่มีข้อมูลเนื้อที่\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"\t"+datecurr);
        }
        C_myParcel outruturn=new C_myParcel(out);
        outruturn.time_stamp=datecurr;
        return outruturn;
    }    

    private static ArrayOfParcel getParcel(java.lang.String provincecode, java.lang.String amphoecode, java.lang.String ns4No) {
        _55._49._164._110.dolparcel2ega.DolParcelAll service = new _55._49._164._110.dolparcel2ega.DolParcelAll();
        _55._49._164._110.dolparcel2ega.DolParcelAllPortType port = service.getDolParcelAllHttpSoap11Endpoint();
        return port.getParcel(provincecode, amphoecode, ns4No);
    }     
    
    
    
}
