package com.example.daggermig_poc.ui.home;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.example.daggermig_poc.R;
import com.example.daggermig_poc.base.MyApplication;
import com.example.daggermig_poc.base.UserStorage;
import com.example.daggermig_poc.ui.navigation.Navigator;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    UserStorage sharedPref;

    @Inject
    Navigator navigator;

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ((MyApplication) getApplication()).getAppComp().getMainActivityComp().getActivityComp().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup viewRoot = findViewById(R.id.root_view);
        router = Conductor.attachRouter(this, viewRoot, savedInstanceState);
        navigator.intiFirstScreen(router);
    }
}
