package iii.com.tw.testuploadpage2;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static iii.com.tw.testuploadpage2.ScrollingActivity.requestCodeImgBtn1;
import static iii.com.tw.testuploadpage2.ScrollingActivity.requestCodeImgBtn2;
import static iii.com.tw.testuploadpage2.ScrollingActivity.requestCodeImgBtn3;
import static iii.com.tw.testuploadpage2.ScrollingActivity.requestCodeImgBtn4;
import static iii.com.tw.testuploadpage2.ScrollingActivity.requestCodeImgBtn5;

/**
 * Created by poloi on 2017/2/6.
 */

public class communicationWithDB {
    private ArrayList<String> iv_ArrayList_Dog;
    private ArrayList<String> iv_ArrayList_動物品種清單;






    //**********method
    public void create根據動物類別產生品種字串(OkHttpClient p_okHttpClient_client,String p_String_url) {

        if("".equals(p_String_url)){
            p_String_url = "http://twpetanimal.ddns.net:9487/api/v1/animalData_Type";
        }

                Request request = new Request.Builder()
                        .url(p_String_url)
                        .addHeader("Content-Type", "raw")
                        .get()
                        .build();

                Call call = p_okHttpClient_client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        String json = response.body().string();
                        JSONArray l_JSONArray_jObj = null;
                        try {
                            l_JSONArray_jObj = new JSONArray(json);
                            iv_ArrayList_動物品種清單 = new ArrayList<String>();
                           //**
                            for (int i =0;i<l_JSONArray_jObj.length();i+=1) {
                                JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);
                                if(!iv_ArrayList_動物品種清單.contains(l_JSONObject.getString("animalKind"))){
                                    iv_ArrayList_動物品種清單.add(l_JSONObject.getString("animalKind"));
                                }
                                Log.d("iv_ArrayList_動物品種清單",iv_ArrayList_動物品種清單.toString());

                            }
                            //**

                                /*
                                JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);

                                //判斷個物件什麼類別並將其加入各自的LIAST**
                                switch (l_JSONObject.getString("animalKind")) {
                                    case "CAT" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;
                                    case "" :
                                        break;


                                }


                                //**
                                */





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        // Log.d("http",json);
                        //textView.setText(json);


                    }
                });


                //*******************




        //****************
    }
}
