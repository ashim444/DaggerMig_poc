package com.example.daggermig_poc.ui.navigation;

import com.bluelinelabs.conductor.Router;

public interface Navigator {

    boolean pop();

    void intiFirstScreen(Router router);

    void navigateToSecondScreen();

}
