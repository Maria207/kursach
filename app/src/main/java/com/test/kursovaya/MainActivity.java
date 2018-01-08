package com.test.kursovaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity {

    //Создаем массив разделов:
    private String head_array[] = {
            "00. Введение",
            "01. Системы массового обслуживания.",
            "02. Понятие СМО.",
            "03. Основные элементы смо.",
            "04. Классификация смо.",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                // Получим идентификатор ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        //устанавливаем массив в ListView
        listView.setAdapter(
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, head_array));
        listView.setTextFilterEnabled(true);

        //Обрабатываем щелчки на элементах ListView:
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SMOActivity.class);

                intent.putExtra("head", position);

                //запускаем вторую активность
                startActivity(intent);
            }
        });
    }



}
