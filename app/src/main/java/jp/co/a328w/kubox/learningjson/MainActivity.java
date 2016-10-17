package jp.co.a328w.kubox.learningjson;

import android.os.Bundle;
import android.app.Activity;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new DeleteApi().execute();

//        new AlertDialog.Builder(this).setTitle("エラー")
//            .setMessage("認証エラー")
//            .setPositiveButton("OK", null)
//            .show();
    }
}
