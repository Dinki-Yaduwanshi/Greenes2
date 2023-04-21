package com.example.pap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Retrieve extends AppCompatActivity {
  EditText input_minimal,input_maximal;
    Button btn_minimal ,btn_maximal;

    RecyclerView recyclerView;
    ArrayList<dataUser>list=new ArrayList<>();
    AdapterItem adapterItem;
    DatabaseReference database= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        input_minimal=findViewById(R.id.input_minimal);
        input_maximal=findViewById(R.id.input_maximal);
        btn_minimal=findViewById(R.id.btn_minimal);
        btn_maximal=findViewById(R.id.btn_maximal);

        recyclerView=findViewById(R.id.recyclerView);

        showData();

    }

    private void showData() {
    }
}