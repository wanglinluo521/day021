package com.example.dell.day02_git2;


import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
        String url="http://pic29.photophoto.cn/20131204/0034034499213463_b.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.main_bt);
            bt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    OkHttpClient Client = new OkHttpClient();
                    Request build = new Request.Builder().url(url).build();
                    Call call = Client.newCall(build);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.d("TAG","失败");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                                Log.d("TAG","成------------");
                        }
                    });
                }
            });
    }
}
