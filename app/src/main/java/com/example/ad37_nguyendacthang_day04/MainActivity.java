package com.example.ad37_nguyendacthang_day04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Phonebook> phonebookList;
    AdapterPhonebook adapterPhonebook;
    ListView lvPhonebook;
    Phonebook phonebook1, phonebook2, phonebook3, phonebook4, phonebook5, phonebook6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvPhonebook =findViewById(R.id.lvPhonebook);

        phonebookList = new ArrayList<>();
        phonebook1 = new Phonebook("","Luan", "Điện thoại", "16/2/2019");
        phonebookList.add(phonebook1);

        phonebookList.add(new Phonebook("","Tuan Anh", "Messenger video", "16/2/2019"));
        phonebookList.add(new Phonebook("","098999999", "Việt Nam", "16/2/2019"));
        phonebookList.add(new Phonebook("","Binh", "Việt Nam", "12/3/2019"));
        phonebookList.add(new Phonebook("","Quan", "Việt Nam", "19/6/2019"));
        phonebookList.add(new Phonebook("","Hiep", "Di động", "19/4/2019"));

        adapterPhonebook = new AdapterPhonebook(phonebookList);
        lvPhonebook.setAdapter(adapterPhonebook);

        lvPhonebook.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getBaseContext(), InformationActivity.class);
                intent.putExtra("phonebook", phonebookList.get(i));
                startActivity(intent);

                Toast.makeText(getBaseContext(), "Name: " + phonebookList.get(i).getPhoneNumber(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
