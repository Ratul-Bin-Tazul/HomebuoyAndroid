package com.ratulbintazul.homebuoyandroid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Listing {

    @SerializedName("LISTING_ID")
    @Expose
    private String lISTINGID;
    @SerializedName("TITLE")
    @Expose
    private String tITLE;
    @SerializedName("DESCRIPTION")
    @Expose
    private String dESCRIPTION;
    @SerializedName("TYPE")
    @Expose
    private String tYPE;
    @SerializedName("MEDIA_URL")
    @Expose
    private String mEDIAURL;
    @SerializedName("MEDIA_TYPE")
    @Expose
    private String mEDIATYPE;
    @SerializedName("TIME")
    @Expose
    private String tIME;
    @SerializedName("PRICE_PER_UNIT")
    @Expose
    private String pRICEPERUNIT;
    @SerializedName("URL")
    @Expose
    private String uRL;

    public String getLISTINGID() {
        return lISTINGID;
    }

    public void setLISTINGID(String lISTINGID) {
        this.lISTINGID = lISTINGID;
    }

    public String getTITLE() {
        return tITLE;
    }

    public void setTITLE(String tITLE) {
        this.tITLE = tITLE;
    }

    public String getDESCRIPTION() {
        return dESCRIPTION;
    }

    public void setDESCRIPTION(String dESCRIPTION) {
        this.dESCRIPTION = dESCRIPTION;
    }

    public String getTYPE() {
        return tYPE;
    }

    public void setTYPE(String tYPE) {
        this.tYPE = tYPE;
    }

    public String getMEDIAURL() {
        return mEDIAURL;
    }

    public void setMEDIAURL(String mEDIAURL) {
        this.mEDIAURL = mEDIAURL;
    }

    public String getMEDIATYPE() {
        return mEDIATYPE;
    }

    public void setMEDIATYPE(String mEDIATYPE) {
        this.mEDIATYPE = mEDIATYPE;
    }

    public String getTIME() {
        return tIME;
    }

    public void setTIME(String tIME) {
        this.tIME = tIME;
    }

    public String getPRICEPERUNIT() {
        return pRICEPERUNIT;
    }

    public void setPRICEPERUNIT(String pRICEPERUNIT) {
        this.pRICEPERUNIT = pRICEPERUNIT;
    }

    public String getURL() {
        return uRL;
    }

    public void setURL(String uRL) {
        this.uRL = uRL;
    }

}