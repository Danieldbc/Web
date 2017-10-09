package edu.eseiaat.upc.pma.borreguero.daniel.web;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_URL;
    private TextView tv_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_URL=(EditText)findViewById(R.id.et_URL);
        tv_URL=(TextView)findViewById(R.id.tv_URL);
    }

    public void connect(View view) {
        String url =et_URL.getText().toString();
        WebReaderTask wrTask=new WebReaderTask();
        wrTask.execute(url);

    }
    private class WebReaderTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... url) {
            return WebReader.getURL(url[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            tv_URL.setText(s);
        }
    }
}
