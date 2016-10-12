package jp.co.a328w.kubox.learningjson;

import android.os.AsyncTask;
import android.util.Log;

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

public class AuthApi extends AsyncTask<URL, Void, Void> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // 一番最初に実行される
    }

    @Override
    protected Void doInBackground(URL... urls) {
        final URL url = urls[0];
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            String str = InputStreamToString(con.getInputStream());
            JSONObject json = new JSONObject(str);
            Log.d("test", json.get("result").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
        return null;
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
