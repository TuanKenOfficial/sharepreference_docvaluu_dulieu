package com.example.sharepreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String tenSharePreference="trangthai";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void xuLyLuuTrangThai(View view) {
        SharedPreferences preferences=getSharedPreferences(tenSharePreference,MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("b",true);
        editor.putFloat("f",25.5f);
        editor.putInt("i",107);
        editor.putLong("l",250l);
        editor.putString("s","Obama");
        Set<String> dsChuoi=new HashSet<>();
        dsChuoi.add("Putin");
        dsChuoi.add("Kim Jong Un");
        dsChuoi.add("Trump");
        dsChuoi.add("Bush");
        editor.putStringSet("dschuoi",dsChuoi);
        editor.commit();//xác nhận lưu
    }

    public void xuLyDocTrangThai(View view) {
        SharedPreferences preferences=getSharedPreferences(tenSharePreference,MODE_PRIVATE);
        boolean b=preferences.getBoolean("b",false);
        float f=preferences.getFloat("f",0.0f);
        int i=preferences.getInt("i",0);
        long l=preferences.getLong("l",0l);
        String s=preferences.getString("s","");
        Set<String>dsChuoi= preferences.getStringSet("dschuoi",null);
        TextView txtTrangThai= (TextView) findViewById(R.id.txtTrangThai);
        txtTrangThai.append("b="+b+"\n");
        txtTrangThai.append("f="+f+"\n");
        txtTrangThai.append("i="+i+"\n");
        txtTrangThai.append("l="+l+"\n");
        txtTrangThai.append("s="+s+"\n");
        StringBuilder builder=new StringBuilder();
        for (String x: dsChuoi)
        {
            builder.append(x+"\n");
        }
        txtTrangThai.append("Danh sách từ set:\n");
        txtTrangThai.append(builder.toString());
    }
}