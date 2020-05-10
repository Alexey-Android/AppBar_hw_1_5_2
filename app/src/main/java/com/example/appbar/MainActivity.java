package com.example.appbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_open_notes) {
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }

        if (id == R.id.action_open_calendarView) {
            Intent intentCalendar = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intentCalendar);
            return true;
        }
        if (id == R.id.action_open_first) {
            Intent intentFirst = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intentFirst);
            return true;
        }

        if (id == R.id.action_open_helloworld) {
            Intent intentSplash = new Intent(MainActivity.this, SplashScreenActivity.class);
            startActivity(intentSplash);
            return true;
        }

        if (id == R.id.action_open_subscription) {
            Intent intentSubscription = new Intent(MainActivity.this, SubscriptionActivity.class);
            startActivity(intentSubscription);
            return true;
        }

        if (id == R.id.action_open_photoview) {
            Intent intentPhotoView = new Intent(MainActivity.this, PhotoViewActivity.class);
            startActivity(intentPhotoView);
            return true;
        }

        if (id == R.id.action_open_checkbox) {
            Intent intentCheckbox = new Intent(MainActivity.this, CheckBoxActivity.class);
            startActivity(intentCheckbox);
            return true;
        }

        if (id == R.id.action_open_spinner) {
            Intent intentSpinner = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intentSpinner);
            return true;
        }

        if (id == R.id.action_open_healthsystem) {
            Intent intentHealthSystem = new Intent(MainActivity.this, HealthSystemActivity.class);
            startActivity(intentHealthSystem);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
