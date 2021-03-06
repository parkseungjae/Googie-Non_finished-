package com.example.reservations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private StadiumDBHelper dbHelper;
    public TextView st1_name, st1_address, st1_tel;
    Button weather_show_btn;
    private Button btn_move, chk_myloc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        st1_name = (TextView) findViewById(R.id.st1_name);
        st1_address = (TextView) findViewById(R.id.st1_address);
        st1_tel = (TextView) findViewById(R.id.st1_tel);

        weather_show_btn = findViewById(R.id.weather_show_btn);
        weather_show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, weatherActivity.class);
                startActivity(intent2);
            }
        });


        chk_myloc = findViewById(R.id.chk_myloc);
        chk_myloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(MainActivity.this, MylocActivity.class);
                startActivity(intent4);
            }
        });

        btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, informationActivity.class);
                startActivity(intent);
            }
        });

    /*    dbHelper = new StadiumDBHelper(this); // (??? ??????????????? ????????? ?????? ?????? ????????????)
        dbHelper.insertRecord("?????? ?????? ??????", "?????? ????????? ?????????551 ????????????????????????", "033-749=4700", 1);
        dbHelper.insertRecord("?????? ?????????", "?????? ????????? ????????? ??????1??? 77", "010-4084-5548", 2);
        dbHelper.insertRecord("?????? ?????????", "?????? ????????? ????????? ????????? 794", "0507-1415-9635", 3);
        dbHelper.insertRecord("?????????????????????", "?????? ????????? ??????????????? 56", "0507-1414-4884", 4);
        dbHelper.insertRecord("???????????????????????????", "?????? ????????? ????????? 127", "033-737-4641", 5);
        dbHelper.insertRecord("????????????????????????", "?????? ????????? ????????? ???36", "033-737-4309", 6);

        printTable(); */
    }

/*    private void printTable() {
        Cursor cursor = dbHelper.readRecordOrderByNum();
        String result = " ";

        result += "row ?????? : " + cursor.getCount() + "\n";
        while (cursor.moveToNext()) {
            int itemId = cursor.getInt(cursor.getColumnIndexOrThrow(StadiumContract.StadiumEntry._ID));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(StadiumContract.StadiumEntry.COLUMN_NAME));
            String address = cursor.getString(cursor.getColumnIndexOrThrow(StadiumContract.StadiumEntry.COLUMN_address));
            String telnum = cursor.getString(cursor.getColumnIndexOrThrow(StadiumContract.StadiumEntry.COLUMN_telnum));
            String num = cursor.getString(cursor.getColumnIndexOrThrow(StadiumContract.StadiumEntry.COLUMN_num));

            result += itemId + " " + name + " " + address + " " + telnum + " " + num + "\n";

        }
        st1_name.setText(result);
        cursor.close();
    }

    protected void onDestroy() {
        dbHelper.close();
        super.onDestroy();
    } */
}










