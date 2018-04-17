package com.example.admin.f;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.admin.f.Fragments.AboutFragment;
import com.example.admin.f.Fragments.ArtistsFragments;
import com.example.admin.f.Fragments.ContactFragment;
import com.example.admin.f.Fragments.MapFragment;
import com.example.admin.f.Fragments.EventsFragment;
import com.example.admin.f.Fragments.TicketFragment;
import com.example.admin.f.Listeners.NavigationListener;

import java.util.Stack;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, NavigationListener {
    public static Stack<String> toolbarTitle = new Stack<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Repertuar FŁ");
        toolbarTitle.push("Repertuar FŁ");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        onNavigateFalse(new EventsFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (toolbarTitle.size() == 1){
                toolbar.setTitle(toolbarTitle.pop());
            }
            else if (toolbarTitle.size() > 1) {
                toolbarTitle.pop();
                String temp = toolbarTitle.pop();
                toolbar.setTitle(temp);
                toolbarTitle.push(temp);
            }
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (id == R.id.nav_artists) {
            toolbar.setTitle("Artyści FŁ");
            toolbarTitle.push("Artyści FŁ");
            onNavigate(new ArtistsFragments());
        }else if (id == R.id.nav_repertoire) {
            toolbar.setTitle("Repertuar FŁ");
            toolbarTitle.push("Repertuar FŁ");
            onNavigate(new EventsFragment());
        }else if (id == R.id.nav_ticket) {
            toolbar.setTitle("Cennik biletów");
            toolbarTitle.push("Cennik biletów");
            onNavigate(new TicketFragment());
        }else if (id == R.id.nav_about) {
            toolbar.setTitle("O FŁ");
            toolbarTitle.push("O FŁ");
            onNavigate(new AboutFragment());
        }else if (id == R.id.nav_map) {
            toolbar.setTitle("Mapa");
            toolbarTitle.push("Mapa");
            onNavigate(new MapFragment());
        }else if (id == R.id.nav_contact) {
            toolbar.setTitle("Kontakt");
            toolbarTitle.push("Kontakt");
            onNavigate(new ContactFragment());
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onNavigate(Fragment fragment) {
        navigateTo(fragment, true);
    }

    @Override
    public void onNavigateFalse(Fragment fragment) {
        navigateTo(fragment, false);
    }

    private void navigateTo(Fragment fragment, boolean backStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, fragment);

        if (backStack) {
            fragmentTransaction.addToBackStack(fragment.toString());
        }

        fragmentTransaction.commit();
    }
}
