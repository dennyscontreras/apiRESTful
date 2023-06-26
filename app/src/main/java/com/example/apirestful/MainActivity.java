package com.example.apirestful;

import static java.lang.invoke.VarHandle.AccessMode.GET;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebServices.Asynchtask;
import WebServices.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://dummyjson.com/users",

                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");*/

    }
    public void btnenviar(View view){
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService(
                "https://dummyjson.com/users",

                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");


    }

    @Override
    public void processFinish(String result) throws JSONException {
       TextView txtdatos=( TextView) findViewById(R.id.txtdatos);
        //TextView txt2=( TextView) findViewById(R.id.txt2);
      //txtdatos.setText("es" + result);
      String lst="";
        JSONObject objeto =new JSONObject(result);
        JSONArray JSONlista=objeto.getJSONArray("users");
        for (int i=0;i<JSONlista.length();i++){
            JSONObject objb=JSONlista.getJSONObject(i);lst=lst+"\n" + objb.getString("firstName")+ objb.getString("age")+ objb.getString("email").toString();}
        txtdatos.setText("listado"+lst);
    }
}