package com.example.ad37_nguyendacthang_day04;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterInformation extends BaseAdapter {
    List<Phonebook> phonebookList;

    public AdapterInformation(List<Phonebook> phoneBook) {
        this.phonebookList = phoneBook;
    }

    @Override
    public int getCount() {
        return phonebookList.size();
    }

    @Override
    public Object getItem(int i) {
        return phonebookList.get(i);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.item_listview_information, parent, false);

        TextView tvDateItem = convertView.findViewById(R.id.tvDateItem);
        TextView tvPhoneNumberItem = convertView.findViewById(R.id.tvPhoneNumberItem);


        Phonebook phonebook = phonebookList.get(i);
        tvDateItem.setText(phonebook.getDate());
        tvPhoneNumberItem.setText(phonebook.getPhoneNumber());
        return convertView;
    }
}

