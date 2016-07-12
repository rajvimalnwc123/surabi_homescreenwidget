package com.example.nwcemp01.surabi_homescreenwidget;

/**
 * Created by nwcemp01 on 11/7/16.
 */
public class Api {
    public static String Chebarsellingrate,Chebarbuyingrate,Cheftsellingrate,Cheftbarbuyingrate;

    public static void setChebarsellingrate(String chesellingrate) {
        Chebarsellingrate = chesellingrate;
    }
    public static void setChebarbuyingrate(String chebarbuyingrate) {
        Chebarbuyingrate = chebarbuyingrate;
    }
    public static void setCheftsellingrate(String cheftsellingrate) {
        Cheftsellingrate = cheftsellingrate;
    }

    public static void setCheftbarbuyingrate(String cheftbarbuyingrate) {
        Cheftbarbuyingrate = cheftbarbuyingrate;
    }

    public static String GoldBid;

    public String getGoldBid() {
        return GoldBid;
    }

    public void setGoldBid(String goldBid) {
        GoldBid = goldBid;
    }

    public String getGoldAsk() {
        return GoldAsk;
    }

    public void setGoldAsk(String goldAsk) {
        GoldAsk = goldAsk;
    }

    public static String GoldAsk;

    public static String getGoldsesc() {
        return Goldsesc;
    }

    public static void setGoldsesc(String goldsesc) {
        Goldsesc = goldsesc;
    }

    public static String Goldsesc;


}
