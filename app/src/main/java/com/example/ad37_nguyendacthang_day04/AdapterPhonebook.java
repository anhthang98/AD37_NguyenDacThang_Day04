package com.example.ad37_nguyendacthang_day04;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterPhonebook extends BaseAdapter {
    List<Phonebook> phonebookList;

    public AdapterPhonebook(List<Phonebook> phoneBook) {
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
        convertView = inflater.inflate(R.layout.item_listview, parent, false);

        TextView tvPhoneNumber = convertView.findViewById(R.id.tvPhoneNumber);
        TextView tvLocation = convertView.findViewById(R.id.tvLocation);
        TextView tvDate = convertView.findViewById(R.id.tvDate);
        ImageView imgContact = convertView.findViewById(R.id.imgContact);
        ImageView imgTypeCall = convertView.findViewById(R.id.imgTypeCall);


        Phonebook phonebook = phonebookList.get(i);
        tvPhoneNumber.setText(phonebook.getPhoneNumber());
        tvLocation.setText(phonebook.getLocation());
        tvDate.setText(phonebook.getDate());

        imgContact.setImageResource(R.drawable.ic_info_outline_black_24dp);
        if (phonebook.getLocation().equals("Messenger video")) {
            imgTypeCall.setImageResource(R.drawable.ic_video_call_black_24dp);
        } else {
            imgTypeCall.setImageResource(R.drawable.ic_call_black_24dp);
        }
        return convertView;
    }
}
