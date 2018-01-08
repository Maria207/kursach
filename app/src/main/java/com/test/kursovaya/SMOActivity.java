package com.test.kursovaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.content.Intent;
import android.util.Log;
import android.content.Context;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class SMOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smo);

        WebView webView = (WebView) findViewById(R.id.webView);

        Intent intent = getIntent();
        //получаем строку и формируем имя ресурса
        String resName = "n" + intent.getIntExtra("head", 0);
        Log.i("name", resName);
        Context context = getBaseContext(); //получаем контекст

        //читаем текстовый файл из ресурсов по имени
        String text = readRawTextFile(context, getResources().getIdentifier(resName, "raw", "com.test.kursovaya"));

        webView.loadDataWithBaseURL(null, text, "text/html", "en_US", null);
    }

    //читаем текст из raw-ресурсов
    public static String readRawTextFile(Context context, int resId)
    {
        InputStream inputStream = context.getResources().openRawResource(resId);

        InputStreamReader inputReader = new InputStreamReader(inputStream);
        BufferedReader buffReader = new BufferedReader(inputReader);
        String line;
        StringBuilder builder = new StringBuilder();

        try {
            while (( line = buffReader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return builder.toString();

    }
}
