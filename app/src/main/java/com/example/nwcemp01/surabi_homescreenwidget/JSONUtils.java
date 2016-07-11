package com.example.nwcemp01.surabi_homescreenwidget;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nwcemp01 on 11/7/16.
 */
public class JSONUtils {


    public static String mgold_bid, mgold_ask, mgold_desc;


    // private static final Gson gson = new Gson();

    private JSONUtils() {
    }
/*
    public static boolean isJSONValid(String jsonString) {
        try {
            gson.fromJson(jsonString, Object.class);
            return true;
        } catch (com.google.gson.JsonSyntaxException ex) {
            return false;
        }
    }

    public static void updateUserDetails(String response, PreferencesManager myPref) {
        if (response != null) {
            try {
                JSONObject json = new JSONObject(response);
                boolean responseStatus = json.getBoolean(ResponseUtils.RES_RESPONSE);
                String message = "";
                if (responseStatus) {
                    message = json.getString(ResponseUtils.RES_MSG_SUCCESS);
                    JSONObject innerObj = json.getJSONObject(ResponseUtils.Settings.S_SUCCESS);
                    String fName = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_FNAME));
                    String lName = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_LANME));
                    String phone = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_PHONE));
                    String email = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_EMAIL));
                    String city = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_CITY));

                    String sCustomerId = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_CUSTOMER_ID));
                    String sCategory = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_CATEGORY));
                    String sMarketSmart = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_MARKET_SMART));
                    String sStatus = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_STATUS));
                    String sActivated = AppUtils.emptyString(innerObj.getString(ResponseUtils.Settings.S_ACTIVATED));
                    int cCategoryMax = innerObj.getInt(ResponseUtils.Settings.S_CATEGORY_MAX);
                    //sStatus = "1";
                    String fullName = "";
                    if (fName.length() > 0 || lName.length() > 0) {
                        fullName = fName + " " + lName;
                    }
                    myPref.setStringValue("firstName", fName);
                    myPref.setStringValue("fullName", fullName);
                    myPref.setStringValue("email", email);
                    myPref.setStringValue("city", city);
                    myPref.setStringValue("Phone_No", phone);
                    myPref.setStringValue("customerId", sCustomerId);
                    myPref.setStringValue("category", sCategory);
                    myPref.setStringValue("market_smart", sMarketSmart);
                    myPref.setStringValue("status", sStatus);
                    myPref.setIntValue("category_max", cCategoryMax);
                    myPref.setStringValue("Activated", sActivated);

                } else {
                    message = json.getString(ResponseUtils.RES_MSG_ERROR);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }*/
    //  }

    public static void saveSocketData(JSONObject jsonObject) {

        // Log.e("socketIO Response", jsonObject.toString());

        if (jsonObject != null) {
            if (jsonObject.length() > 0) {


                try {
                    JSONObject jobj = new JSONObject(jsonObject.toString());
                    System.out.println("Get Api data's ::"+jobj.toString());
                    mgold_bid = jobj.getString("gold_bid");
                    mgold_ask = jobj.getString("lastupdate");
                    mgold_desc = jobj.getString("app_message");

                    Api api = new Api();
                    api.setGoldAsk(mgold_ask);
                    api.setGoldBid(mgold_bid);
                    api.setGoldsesc(mgold_desc);

                    //     Log.e("mgold_bid Response", api.getGoldAsk());

                } catch (JSONException e) {
                    e.printStackTrace();
                }



                /*try {

                    float sellCheck = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_CHECK) ? jsonObject.getString(ResponseUtils.Home.H_S_CHECK) : ""));
                    String chBrBy = jsonObject.getString(ResponseUtils.Home.H_B_CHECK);
                    float buyCheck=0;
                    if (!chBrBy.equalsIgnoreCase("-")) {
                         buyCheck = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_CHECK) ? jsonObject.getString(ResponseUtils.Home.H_B_CHECK) : ""));
                    }
                    String chftsel=jsonObject.getString(ResponseUtils.Home.H_S_FT);
                    float sellFt=0;
                    if(!chftsel.equalsIgnoreCase("-")) {
                        sellFt = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_FT) ? jsonObject.getString(ResponseUtils.Home.H_S_FT) : ""));
                    }

                    String chftBy=jsonObject.getString(ResponseUtils.Home.H_B_FT);
                    float buyFt=0;
                    if(!chftBy.equalsIgnoreCase("-")){
                         buyFt = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_FT) ? jsonObject.getString(ResponseUtils.Home.H_B_FT) : ""));

                    }

                    String unfxSell=jsonObject.getString(ResponseUtils.Home.H_S_CASH);
                    float sellCash=0;
                    if(!unfxSell.equalsIgnoreCase("-")){
                         sellCash = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_CASH) ? jsonObject.getString(ResponseUtils.Home.H_S_CASH) : ""));

                    }
                    String unfxByRt=jsonObject.getString(ResponseUtils.Home.H_B_CASH);
                    float buyCash=0;
                    if(!unfxByRt.equalsIgnoreCase("-")){
                         buyCash = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_CASH) ? jsonObject.getString(ResponseUtils.Home.H_B_CASH) : ""));

                    }

                    float sellWRLocal = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_L_WR) ? jsonObject.getString(ResponseUtils.Home.H_S_L_WR) : ""));
                    float buyWRLocal = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_L_WR) ? jsonObject.getString(ResponseUtils.Home.H_B_L_WR) : ""));

                    float sellGold = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_GOLD) ? jsonObject.getString(ResponseUtils.Home.H_S_GOLD) : ""));
                    float buyGold = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_GOLD) ? jsonObject.getString(ResponseUtils.Home.H_B_GOLD) : ""));

                    float sellSilver = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_SILVER) ? jsonObject.getString(ResponseUtils.Home.H_S_SILVER) : ""));
                    float buySilver = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_SILVER) ? jsonObject.getString(ResponseUtils.Home.H_B_SILVER) : ""));

                    float sellInr = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_INR) ? jsonObject.getString(ResponseUtils.Home.H_S_INR) : ""));
                    float buyInr = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_B_INR) ? jsonObject.getString(ResponseUtils.Home.H_B_INR) : ""));

                    float goldLtp = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_GOLD_LTP) ? jsonObject.getString(ResponseUtils.Home.H_GOLD_LTP) : ""));
                    float inrLtp = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_INR_LTP) ? jsonObject.getString(ResponseUtils.Home.H_INR_LTP) : ""));

                    float marketOpenRate = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_M_MARKET_OPEN_RATE) ? jsonObject.getString(ResponseUtils.Home.H_M_MARKET_OPEN_RATE) : ""));
                    float marketOpenRateFt = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_FT) ? jsonObject.getString(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_FT) : ""));
                    float marketOpenRateBar = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_BAR) ? jsonObject.getString(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_BAR) : ""));
                    float marketOpenRateUnifix = convertStringToFloat(AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_UNIFIX) ? jsonObject.getString(ResponseUtils.Home.H_M_MARKET_OPEN_RATE_UNIFIX) : ""));

                    String timeStamp = AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_M_TIME_STAMP) ? jsonObject.getString(ResponseUtils.Home.H_M_TIME_STAMP) : "");

                    String marketStatus = AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_MARKET_STATUS) ? jsonObject.getString(ResponseUtils.Home.H_S_MARKET_STATUS) : "");

                    String infraDayMarket = AppUtils.emptyString(jsonObject.has(ResponseUtils.Home.H_S_INTRADAY_MARKET) ? jsonObject.getString(ResponseUtils.Home.H_S_INTRADAY_MARKET) : "");

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_CHECK, sellCheck);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_CHECK, buyCheck);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_FT, sellFt);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_FT, buyFt);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_CASH, sellCash);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_CASH, buyCash);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_WR_LOCAL, sellWRLocal);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_WR_LOCAL, buyWRLocal);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_GOLD, sellGold);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_GOLD, buyGold);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_SILVER, sellSilver);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_SILVER, buySilver);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_SELL_INR, sellInr);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_BUY_INR, buyInr);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_GOLD_LTP, goldLtp);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_INR_LTP, inrLtp);

                    myPref.setFloatValue(ResponseUtils.Pref.PRE_MARKET_OPEN_RATE, marketOpenRate);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_MARKET_OPEN_RATE_FT, marketOpenRateFt);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_MARKET_OPEN_RATE_BAR, marketOpenRateBar);
                    myPref.setFloatValue(ResponseUtils.Pref.PRE_MARKET_OPEN_RATE_UNIFIX, marketOpenRateUnifix);

                    myPref.setStringValue(ResponseUtils.Pref.PRE_TIMESTAMP, timeStamp);
                    myPref.setStringValue(ResponseUtils.Pref.PRE_MARKET_STATUS, marketStatus);
                    myPref.setStringValue(ResponseUtils.Pref.PRE_INFRADAY_STATUS, infraDayMarket);

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }


    public static float getPercentageValue(float currentRate, float OpenRate) {
        float value = 0;
        value = (100 - ((OpenRate / currentRate) * 100));
        return value;
    }


    public static float convertStringToFloat(String myString) {
        float f1 = 0;
        try {
            if (myString.trim().length() > 0) {
                f1 = Float.parseFloat(myString);
                //f1 = (int) Math.ceil(f1);//round a float value

            }
        } catch (Exception ex) {

        }

        return f1;
    }


}
