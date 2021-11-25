package com.example.ipbydns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Search(View view) {
        /*try {
            TextInputEditText textInputEditText = findViewById(R.id.text);
            String domain = textInputEditText.getText().toString();
            InetAddress giriAddress = InetAddress.getByName("ipv4.local.com");
            String addresess = giriAddress.getHostAddress();
            Toast toast = Toast.makeText(this, addresess, Toast.LENGTH_LONG);
            toast.show();
        } catch (Exception e) {
            e.getMessage();
        }*/

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {TextInputEditText textInputEditText = findViewById(R.id.text);
                    String host = textInputEditText.getText().toString();
                    InetAddress giriAddress = InetAddress.getByName(host);
                    String addresess = giriAddress.getHostAddress();
                    textInputEditText.setText(addresess);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

}