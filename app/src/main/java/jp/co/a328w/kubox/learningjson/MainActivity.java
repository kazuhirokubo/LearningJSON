package jp.co.a328w.kubox.learningjson;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AuthApi auth =new AuthApi(new AsyncResponse() {

            @Override
            public void processFinish(Result output) {
                Log.d("!!=====test=====!!", output.result);
            }
        });
        auth.execute("1234");

    }
}
