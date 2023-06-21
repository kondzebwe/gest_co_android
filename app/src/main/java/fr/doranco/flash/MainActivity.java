package fr.doranco.flash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import fr.doranco.flash.database.SpecialiteDatabaseTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpecialiteDatabaseTest test = new SpecialiteDatabaseTest(this);
        test.start();
    }
}