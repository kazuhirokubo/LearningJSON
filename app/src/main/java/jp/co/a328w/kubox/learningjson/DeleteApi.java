package jp.co.a328w.kubox.learningjson;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by kubox on 2016/10/17.
 */

public class DeleteApi extends AsyncTask<Void, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 一番最初に実行される
    }

    @Override
    protected String doInBackground(Void... params) {

        HttpURLConnection con = null;
        String result = "";
        try {
            con = (HttpURLConnection) new URL("http://dev.domus.jp/kubox/practice/public/items").openConnection();
            con.setRequestMethod("DELETE");
            result = InputStreamToString(con.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return result;
    }

    @Override
    protected void onPostExecute(String result) {

        Gson gson = new Gson();
        Result str = gson.fromJson(result, Result.class);

    }



    // InputStream -> String
    static String InputStreamToString(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
