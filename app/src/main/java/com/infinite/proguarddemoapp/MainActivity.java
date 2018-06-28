package com.infinite.proguarddemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.infinite.aesjnilib.AESEncrypt;
import com.infinite.aesjnilib.SignatureTool;
import com.infinite.proguarddemoapp.entity.MusicEntity;
import com.infinite.proguarddemoapp.entity.VideoEntity;
import com.infinite.proguarddemoapp.utils.CommenUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final String str = "123abcABC*%!~#+_/中文测试";
    private final String ecode = "SkiDk/JC5F/BXKf/np7rWNub7ibxzYMjKwkQ7A6AqPw=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<VideoEntity> videoEntities = createVideos();
        List<MusicEntity> musicEntities = createMusics();

        Log.e(TAG, "createVideos: " + CommenUtil.printList(videoEntities));
        Log.e(TAG, "createMusics: " + CommenUtil.printList(musicEntities));

        Log.e(TAG, "videoEntities to string: " + JSON.toJSONString(videoEntities));
        Log.e(TAG, "musicEntities to string: " + JSON.toJSONString(musicEntities));

        int signature = SignatureTool.getSignature(this);
        Log.e(TAG, "signature: " + signature);


        String code = AESEncrypt.decode(this, ecode);

        Log.d(TAG + "aescode1", "source code:" + ecode + "\t decode code:" + code);

    }

    private List<VideoEntity> createVideos() {
        List<VideoEntity> list = new ArrayList<>(10);
        for (int i = 0; i < 2; i++) {
            VideoEntity video = new VideoEntity("http://www.video" + i + ".com");
            list.add(video);
        }
        return list;
    }

    private List<MusicEntity> createMusics() {
        List<MusicEntity> list = new ArrayList<>(10);
        for (int i = 0; i < 2; i++) {
            MusicEntity music = new MusicEntity("http://www.music" + i + ".com");
            list.add(music);
        }
        return list;
    }
}
