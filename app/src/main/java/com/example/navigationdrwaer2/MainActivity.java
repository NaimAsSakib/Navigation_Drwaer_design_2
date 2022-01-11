package com.example.navigationdrwaer2;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private LinearLayout linearLayoutMessage, linearLayoutArchMessage, linearLayoutNotification, linearLayoutProfile,linearLayoutChangePass,linearLayoutLogout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        linearLayoutMessage=findViewById(R.id.linearForMessage);
        linearLayoutArchMessage=findViewById(R.id.linearForArchivedMessage);
        linearLayoutNotification=findViewById(R.id.linearForNotification);
        linearLayoutProfile=findViewById(R.id.linearForProfile);
        linearLayoutChangePass=findViewById(R.id.linearForChangePass);
        linearLayoutLogout=findViewById(R.id.linearForLogout);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerLayout);

        //Creating hamburger icon in the toolbar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);

        drawerLayout.addDrawerListener(toggle);  //adding listener to toggle or hamburger icon
        toggle.syncState();


        linearLayoutMessage.setOnClickListener(new View.OnClickListener() {  //set listener on whole particular layout
            @Override
            public void onClick(View v) {
                openFragment(new MessageFragment(),"Message fragment is open");  //openFragment method is written below
            }
        });

        linearLayoutArchMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ArchivedMessageFragment(),"Archived Message fragment is open");
            }
        });

        linearLayoutNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new NotificationFragment(),"Notification fragment is open");
            }
        });

        linearLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ProfileFragment(),"Profile fragment is open");
            }
        });

        linearLayoutChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFragment(new ChangePassFragment(),"Change Password fragment is open");
            }
        });

        linearLayoutLogout.setOnClickListener(new View.OnClickListener() {
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
    private void openFragment(Fragment fragment,String msg){  //method for opening fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,fragment).commit();
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
        drawerLayout.closeDrawer(GravityCompat.START);
    }
}