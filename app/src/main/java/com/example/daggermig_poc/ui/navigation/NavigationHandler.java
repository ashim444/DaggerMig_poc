package com.example.daggermig_poc.ui.navigation;

import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.example.daggermig_poc.ui.first.FirstController;
import com.example.daggermig_poc.ui.second.SecondController;

import javax.inject.Inject;

public class NavigationHandler implements Navigator {

    private Router router;

    @Inject
    public NavigationHandler() {
    }

    @Override
    public boolean pop() {
        return router != null && router.handleBack();
    }

    @Override
    public void intiFirstScreen(Router router) {
        this.router = router;
        if (!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(FirstController.newInstance()));
        }
    }

    @Override
    public void navigateToSecondScreen() {
        router.pushController(RouterTransaction.with(SecondController.newInstance()));
    }
}
