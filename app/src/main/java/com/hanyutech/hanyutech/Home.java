package com.hanyutech.hanyutech;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Home extends Fragment {
    private boolean ERF = true;
    private ImageView img;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("主頁");
        changeimg();
        img = getView().findViewById(R.id.home_imagev);

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home,container,false);
    }
    private void changeimg(){
        new Thread(new Runnable() {
            private int i = 0 ;
            @Override
            public void run() {
                while(ERF) {
                    i++;
                    if(i>6) i=1;
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            switch (i){
                                case 1:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd1));
                                    break;
                                case 2:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd2));
                                    break;
                                case 3:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd3));
                                    break;
                                case 4:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd4));
                                    break;
                                case 5:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd5));
                                    break;
                                case 6:
                                    img.setImageDrawable(getResources().getDrawable(R.drawable.pd6));
                                    break;
                            }
                        }
                    });
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    @Override
    public void onDestroy() {
        ERF = false;
        super.onDestroy();
    }
}
