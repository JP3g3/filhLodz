package com.example.admin.f.Listeners;

import android.support.v4.app.Fragment;

import com.example.admin.f.Fragments.EventsPlusFragment;

/**
 * Created on 21.03.2017.
 */

public interface NavigationListener {
    void onNavigate(Fragment fragment);
    void onNavigateFalse(Fragment fragment);
}
