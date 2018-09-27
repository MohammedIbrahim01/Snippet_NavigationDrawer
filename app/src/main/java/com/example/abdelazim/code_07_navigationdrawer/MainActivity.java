package com.example.abdelazim.code_07_navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //setup actionbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);


        /**
         * handle click on the drawer items
         */
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                switch (menuItem.getItemId()) {
                    case R.id.nav_import:
                        Toast.makeText(MainActivity.this, "import", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_gallery:
                        Toast.makeText(MainActivity.this, "gallery", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_slideshow:
                        Toast.makeText(MainActivity.this, "slideshow", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.nav_tools:
                        Toast.makeText(MainActivity.this, "tools", Toast.LENGTH_SHORT).show();
                        return true;
                }

                return true;
            }
        });
    }


    /**
     * to detect click on the home button to open the drawer
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(Gravity.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
