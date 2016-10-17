package jp.co.a328w.kubox.learningjson;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kubox on 2016/10/12.
 */

public class AuthApi extends AsyncTask<String, Void, String> {


    public AsyncResponse delegate = null;

    public AuthApi(AsyncResponse asyncResponse) {
        delegate = asyncResponse;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 一番最初に実行される
    }

    @Override
    protected String doInBackground(String... pass) {

//        Log.d("==========", "http://dev.domus.jp/kubox/practice/public/auth/" + pass[0]);

        HttpURLConnection con = null;
        String result = "";
        try {
            con = (HttpURLConnection) new URL("http://dev.domus.jp/kubox/practice/public/auth/" + pass[0]).openConnection();
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
        Result res = gson.fromJson(result, Result.class);
        delegate.processFinish(res);
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
