package br.edu.uniritter.mobile.segundprojeto_2021_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import br.edu.uniritter.mobile.segundprojeto_2021_2.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Thread timer = new Thread() {
            public void run()
            {
                try {
                    //Display for 3 seconds
                    sleep(3000);
                    System.out.println("acordei");
                }
                catch (InterruptedException e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
        timer.start();
    }
}