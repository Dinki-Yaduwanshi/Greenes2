package com.example.pap;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import androidx.activity.result.ActivityResultLauncher;

public class MainActivity extends AppCompatActivity {
    Button btn_scan;
    Button btn_v;
    String str;
   TextView t4;
   Button save;
   AlertDialog.Builder builderAlert;
   Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        btn_scan=findViewById(R.id.btn_scan);
        btn_v=findViewById(R.id.see);
        t4=findViewById(R.id.site);
        save=findViewById(R.id.btn_save);
        builderAlert=new AlertDialog.Builder(context);

        btn_scan.setOnClickListener(view -> {
            scanCode();
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigation_View);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_home:
                    return  true;
                case R.id.bottom_history:
                    startActivity(new Intent(getApplicationContext(),HistoryActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;

                case R.id.bottom_setting:
                    startActivity(new Intent(getApplicationContext(),AppActivity.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                    finish();
                    return true;
            }

            return false;
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputData();
            }
        });



    }

    private void inputData() {

    }

    private void scanCode() {
        ScanOptions options= new ScanOptions();
        options.setPrompt("Scan your Bill");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barlauncher.launch(options);

    }

    ActivityResultLauncher<ScanOptions> barlauncher=registerForActivityResult(new ScanContract(),result -> {
        str=result.getContents();
        AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(str);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
        
        btn_v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoURL(str);
            }
        });
        
        t4.setText(str);
    });

    private void gotoURL(String str) {
        Uri uri= Uri.parse(str);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


}