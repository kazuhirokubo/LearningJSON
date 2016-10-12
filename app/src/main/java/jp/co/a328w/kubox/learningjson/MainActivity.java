package jp.co.a328w.kubox.learningjson;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            new AuthApi().execute(new URL("http://dev.domus.jp/kubox/practice/public/auth/1234"));


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//        new AlertDialog.Builder(this).setTitle("エラー")
//            .setMessage("認証エラー")
//            .setPositiveButton("OK", null)
//            .show();
    }
}
