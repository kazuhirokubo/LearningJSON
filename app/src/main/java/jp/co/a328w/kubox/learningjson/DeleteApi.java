package jp.co.a328w.kubox.learningjson;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * DB内全データを削除する
 * Created by kubox on 2016/10/17.
 */

public class DeleteApi extends AsyncTask<URL, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 一番最初に実行される
    }

    @Override
    protected String doInBackground(URL... urls) {

        HttpURLConnection con = null;
        String result = "";
        try {
            final URL url = new URL("http://dev.domus.jp/kubox/practice/public/items");
            con = (HttpURLConnection) url.openConnection();
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

        JSONObject json;

        try {
            json = new JSONObject(result);
        }catch(JSONException ex){

        }

        Log.d("TEST===", result);
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
