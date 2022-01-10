package com.example.navigationdrwaer2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private TextView tvMessage, tvArchivedMessage, tvNotification, tvProfile, tvChangePass, tvLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessage = findViewById(R.id.tvMessage);
        tvArchivedMessage = findViewById(R.id.tvArchivedMessage);
        tvNotification = findViewById(R.id.tvNotification);
        tvProfile = findViewById(R.id.tvProfile);
        tvChangePass = findViewById(R.id.tvChangePass);
        tvLogout = findViewById(R.id.tvLogout);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        tvMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new MessageFragment(),"Message fragment is open");
            }
        });

        tvArchivedMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ArchivedMessageFragment(),"Archived Message fragment is open");
            }
        });

        tvNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new NotificationFragment(),"Notification fragment is open");
            }
        });

        tvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ProfileFragment(),"Profile fragment is open");
            }
        });

        tvChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ChangePassFragment(),"Change Password fragment is open");
            }
        });

        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new LogoutFragment(),"Logout fragment is open");
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void openFragment(Fragment fragment,String msg){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}