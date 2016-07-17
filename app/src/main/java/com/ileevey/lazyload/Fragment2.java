package com.ileevey.lazyload;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends BaseLazyFragment {

    @BindView(R.id.tv_content)
    TextView mTvContent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onFirstUserVisible() {

        Thread t = new MyThread();
        t.start();
    }

    @Override
    public void onUserVisible() {

    }

    @Override
    public void onFirstUserInvisible() {

    }

    @Override
    public void onUserInvisible() {

    }

    class MyThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(3000);
                Message msgMessage=new Message();
                msgMessage.arg1=1;
                mHandler.sendMessage(msgMessage);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    Handler mHandler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.arg1) {
                case 1:
                    mTvContent.setTextColor(getResources().getColor(R.color.colorAccent));
                    break;
                default:
                    break;
            }
        }
    };
}
