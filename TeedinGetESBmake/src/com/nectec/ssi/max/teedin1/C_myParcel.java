/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nectec.ssi.max.teedin1;

import _55._49._164._110.dolparcel2ega.Parcel;

/**
 *
 * @author SSI
 */
public class C_myParcel extends Parcel{
    public String time_stamp;

    public C_myParcel(Parcel parcel,String time_stamp) {
        this(parcel);
        this.time_stamp=time_stamp;
    }
    
    
    public C_myParcel(Parcel parcel) {
        amphurname = parcel.getAMPHURNAME();
        landofficename = parcel.getLANDOFFICENAME();
        landofficex = parcel.getLANDOFFICEX();
        landofficey = parcel.getLANDOFFICEY();
        mapx = parcel.getMAPX();
        mapy = parcel.getMAPY();
        parcelno = parcel.getPARCELNO();
        pin = parcel.getPIN();
        provincename = parcel.getPROVINCENAME();
        surveyno = parcel.getSURVEYNO();
        tambolname = parcel.getTAMBOLNAME();
        utmlandno = parcel.getUTMLANDNO();
        utmmap = parcel.getUTMMAP();
        utmscale = parcel.getUTMSCALE();
    }

}
