package com.test.ich;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Toast;

import com.test.ich.User.User;
import com.test.ich.ui.main.SectionsPagerAdapter;
import com.test.ich.ui.main.Tools;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        initComponent();
        initToolbar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.textbar_layout);

    }
    private void initComponent() {
        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.instagram:
                        Toast toast = Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT);
                        toast.show();
                        break;
                    case R.id.facebook:
                        Intent intentd = new Intent(MainActivity.this, com.test.ich.home.MainActivity.class);
                        startActivity(intentd);
                        break;
                    case R.id.phone:
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel:0377778888"));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this,
                                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return false ;
                        }
                        startActivity(callIntent);
                        break;
                    case R.id.user:
                        Intent intent = new Intent(MainActivity.this, User.class);
                        startActivity(intent);
                        break;
                    case R.id.home:
                        initNavigationMenu();
                 /*       Intent intent = new Intent(MainActivity.this, User.class);
                        startActivity(intent);*/
                        break;
                }
                return true;
            }
        });



    }

    private void initToolbar() {
         toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("I & CH");
        Tools.setSystemBarColor(this);
    }

    boolean isNavigationHide = false;

    public void animateNavigation(final boolean hide) {
        if (isNavigationHide && hide || !isNavigationHide && !hide) return;
        isNavigationHide = hide;
        int moveY = hide ? (2 * bottomNavigationView.getHeight()) : 0;
        bottomNavigationView.animate().translationY(moveY).setStartDelay(100).setDuration(300).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }
    private void initNavigationMenu() {
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getTitle() + " Selected", Toast.LENGTH_SHORT).show();
                getSupportActionBar().setTitle(item.getTitle());
                drawer.closeDrawers();
                return true;
            }
        });

        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
    }
}


