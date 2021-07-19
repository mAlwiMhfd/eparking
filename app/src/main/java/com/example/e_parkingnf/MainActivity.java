package com.example.e_parkingnf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Button bScan;

    AFragment f1;
    B1Fragment f2;
    B2Fragment f3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bScan=(Button)findViewById(R.id.btnScan);
        bScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ScanActivity.class);
                startActivity(i);
            }
        });

        Spinner dropdown = findViewById(R.id.pilihGedung);
        f1 = new AFragment();
        f2 = new B1Fragment();
        f3 = new B2Fragment();

        String[] items = new String[]{"Gedung A", "Gedung B1", "Gedung B2"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.custom_spinner,
                getResources().getStringArray(R.array.fragments));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                switch (i){
                    case 0 :
                        setFragment(f1);
                        break;

                    case 1:
                        setFragment(f2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
        .replace(R.id.fr,fragment);
        fragmentTransaction.commit();
    }

}