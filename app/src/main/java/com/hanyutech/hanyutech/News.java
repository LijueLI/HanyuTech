package com.hanyutech.hanyutech;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class News extends Fragment {
    private TextView DataT;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DataT = getView().findViewById(R.id.news_Data);
        getActivity().setTitle("最新消息");
        getwebsite();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.news,container,false);
    }
    private void getwebsite() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder Data = new StringBuilder();
                try {
                    Document document = Jsoup.connect("http://hanyutech.com/%E6%9C%80%E6%96%B0%E6%B6%88%E6%81%AF/").get();
                    Elements Text=document.select("div#wb_element_instance74").select("ul.vmenu").select("li");
                    for(Element T : Text){
                        Data.append(T.text()+"\n\n");
                    }

                }
                catch (IOException e) {
                    Data.append("Error,No Internet Connection!!\n");
                }
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        DataT.setText(Data.toString());
                    }
                });
            }
        }).start();
    }
}
