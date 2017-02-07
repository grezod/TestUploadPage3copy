package iii.com.tw.testuploadpage2;

import android.util.Log;

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

/**
 * Created by poloi on 2017/2/6.
 */

public class Factory_DynamicAnimalTypeListCreator {
    //****
    private ArrayList<String>[] iv_Array_動物品種清單;
    private ArrayList<String> iv_ArrayList_動物類別清單;
    //*******



    //********method

    public void show(){
        Log.d("",iv_ArrayList_動物類別清單.toString());
        Log.d("",iv_Array_動物品種清單.toString());
    }

    private void switch英文的動物類別轉換為中文(ArrayList<String> p_ArrayList_動物類別清單){
        for (int i = 0;i<p_ArrayList_動物類別清單.size();i+=1){

            switch (p_ArrayList_動物類別清單.get(i).toLowerCase()){
                case "cat":
                    p_ArrayList_動物類別清單.set(i,"貓");
                    break;
                case "dog":
                    p_ArrayList_動物類別清單.set(i,"狗");
                    break;
                case "bird":
                    p_ArrayList_動物類別清單.set(i,"鳥");
                    break;
                case "reptile":
                    p_ArrayList_動物類別清單.set(i,"蛇");
                    break;
                case "rabbit":
                    p_ArrayList_動物類別清單.set(i,"兔子");
                    break;
                case "mice":
                    p_ArrayList_動物類別清單.set(i,"老鼠");
                    break;

            }
        }
        Log.d("轉換後類別清單",iv_ArrayList_動物類別清單.toString());
        this.setIv_ArrayList_動物類別清單(iv_ArrayList_動物類別清單);

    }



    public  Factory_DynamicAnimalTypeListCreator(String p_String_url) {
        OkHttpClient l_okHttpClient_client = new OkHttpClient();

        if("".equals(p_String_url)){
            p_String_url = "http://twpetanimal.ddns.net:9487/api/v1/animalData_Type";
        }

        Request request = new Request.Builder()
                .url(p_String_url)
                .addHeader("Content-Type", "raw")
                .get()
                .build();

        Call call = l_okHttpClient_client.newCall(request);
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
                    iv_ArrayList_動物類別清單 = new ArrayList<String>();
                    //**
                    for (int i =0;i<l_JSONArray_jObj.length();i+=1) {
                        JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);
                        if(!iv_ArrayList_動物類別清單.contains(l_JSONObject.getString("animalKind"))){
                            iv_ArrayList_動物類別清單.add(l_JSONObject.getString("animalKind"));
                            Log.d("l_JSString(animalType)",l_JSONObject.getString("animalType"));
                        }
                    }
                    Log.d("iv_ArrayList_動物類別清單",iv_ArrayList_動物類別清單.toString()+"共"+iv_ArrayList_動物類別清單.size()+"種");
                    iv_Array_動物品種清單 = new ArrayList[iv_ArrayList_動物類別清單.size()];
                    for (int j =1;j<=iv_ArrayList_動物類別清單.size();j+=1) {
                        iv_Array_動物品種清單[j-1]=new ArrayList<String>();
                    }


                    for (int i =0;i<l_JSONArray_jObj.length();i+=1) {
                        JSONObject l_JSONObject = (JSONObject) l_JSONArray_jObj.get(i);
                        for (int j =1;j<=iv_ArrayList_動物類別清單.size();j+=1) {

                            //Log.d("1",l_JSONObject.getString("animalKind"));
                            // Log.d("2",iv_ArrayList_動物類別清單.get(j-1));

                            if(l_JSONObject.getString("animalKind").equals(iv_ArrayList_動物類別清單.get(j-1))){
                                //iv_Array_動物品種清單[j-1].add(l_JSONObject.getString("animalType"));
                                iv_Array_動物品種清單[j-1].add(l_JSONObject.getString("animalType"));
                            }

                        }
                    }

                    for (int i =1;i<=iv_ArrayList_動物類別清單.size();i+=1) {
                        //iv_Array_動物品種清單[i-1].toString();
                        Log.d("第"+i+"份動物品種清單",iv_Array_動物品種清單[i-1].toString());
                    }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
                switch英文的動物類別轉換為中文(iv_ArrayList_動物類別清單);
            }
        });



    }
    //**g/setter****************
    public ArrayList<String>[] getIv_Array_動物品種清單() {
        return this.iv_Array_動物品種清單;
    }public void setIv_Array_動物品種清單(ArrayList<String>[] iv_Array_動物品種清單) {
        this.iv_Array_動物品種清單 = iv_Array_動物品種清單;
    }public ArrayList<String> getIv_ArrayList_動物類別清單() {
        return this.iv_ArrayList_動物類別清單;
    }public void setIv_ArrayList_動物類別清單(ArrayList<String> iv_ArrayList_動物類別清單) {
        this.iv_ArrayList_動物類別清單 = iv_ArrayList_動物類別清單;
    }


    //****************
}
