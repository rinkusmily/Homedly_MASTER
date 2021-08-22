package com.gunaeats.myecommerce;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gunaeats.myecommerce.ActivityUtills.SearchResultActivity;
import com.gunaeats.myecommerce.FragmentUtills.AccountFragment;
import com.gunaeats.myecommerce.FragmentUtills.HelpFragment;
import com.gunaeats.myecommerce.FragmentUtills.Order2Fragment;
import com.gunaeats.myecommerce.FragmentUtills.ProfileFragment;
import com.gunaeats.myecommerce.UAtils.BottomNavigationViewHelper;
import com.gunaeats.myecommerce.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView navView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //  selectedTab(TAB_HOME);
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            HomeFragment.newInstance("Home")).commit();
                    return true;
                case R.id.navigation_dashboard:

                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                Order2Fragment.newInstance("Orders")).commit();
                        // selectedTab(TAB_ORDER);

                    return true;
                case R.id.navigation_call:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            AccountFragment.newInstance("Categories")).commit();
                    // selectedTab(TAB_CATEGORY);
                    return true;
                case R.id.navigation_accounts:
                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                            ProfileFragment.newInstance("Help")).commit();
                    // selectedTab(TAB_HELP);
                    return true;
                case R.id.navigation_cart:

                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,
                                HelpFragment.newInstance("My Order")).commit();
                        // selectedTab(TAB_ACCOUNT);

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationViewHelper.removeShiftMode(navView);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_call,R.id.navigation_accounts,R.id.navigation_cart)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Intent in = new Intent(MainActivity.this, SearchResultActivity.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.action_search).getActionView();
        return true;
    }

}