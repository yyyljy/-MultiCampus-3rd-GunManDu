package com.project.platooning;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.project.platooning.adapter.Link_List_Adpater;
import com.project.platooning.item.Carnum;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    Link_List_Adpater linkListAdapter;
    ArrayList<Carnum> carnumlist = new ArrayList<Carnum>();
    CardView btn_search_car;
    CardView btn_to_platoon;
    RecyclerView carnum_list;
    Carnum carnum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        btn_search_car = findViewById(R.id.btn_search_car);
        btn_to_platoon = findViewById(R.id.btn_to_plat);
        carnum_list = findViewById(R.id.carnum_list);

        //연결가능 차량리스트 보여주기
        btn_search_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    carnumlist.clear();
                    linkListAdapter();

            }
        });

        //군집주행모드 시작하기
        btn_to_platoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //통신 연결 여부 파악
                //군집모드 실행하려면 군집모드 실행버튼 클릭
                //  |_ 연결된 차량이 없을 때, 화면 안넘어감
                Toast.makeText(mContext,"연결된 차량이 없습니다.",Toast.LENGTH_SHORT).show();

                //  |_ 연결된 차량이 있을 때, 화면 넘어감
                Toast.makeText(mContext,"대의 차량과 군집 주행을 시작합니다.",Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(mContext,"다른 액티비티");

            }
        });

    }

    //블루투스 리스트 어댑터
       private void linkListAdapter(){
        //블루투스 연결 가능 차량 리스트
        //통신 서버가 오픈되어서 주변 차량 검색하면
        for(int i=0;i<5;i++){
            carnum = new Carnum();
            carnum.setCarnum("69머 5882");
            carnumlist.add(carnum);
        }
        linkListAdapter = new Link_List_Adpater(mContext,R.layout.bluetooth_list,carnumlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        carnum_list.setLayoutManager(linearLayoutManager);


        carnum_list.setAdapter(linkListAdapter);
    }



}
