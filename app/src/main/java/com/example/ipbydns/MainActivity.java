package com.example.ipbydns;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Search(View view) {
        TextInputEditText textInputEditText = findViewById(R.id.text);
        String domainName = textInputEditText.getText().toString();
        domainName = domainName.replaceFirst("\\s+", "");
        domainName = domainName.toLowerCase();
        TextInputLayout layout = findViewById(R.id.textInputLayout);

        layout.setErrorEnabled(false);
        if (domainName.equals("")) {
            layout.setError("empty");
            layout.setErrorEnabled(true);
        } else {
            String finalDomainName = domainName;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InetAddress giriAddress = InetAddress.getByName(finalDomainName);
                        String addresess = giriAddress.getHostAddress();

                        TextView textView = findViewById(R.id.textView);
                        String text = "ip: " + addresess;
                        textView.setText(text);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}