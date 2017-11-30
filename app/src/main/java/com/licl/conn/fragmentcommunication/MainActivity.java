package com.licl.conn.fragmentcommunication;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.licl.conn.fragmentcommunication.struct.FunctionManager;
import com.licl.conn.fragmentcommunication.struct.FunctionNoParamNoResult;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        initFragment();
        setFragmentTag(TestFragment.TAG);
    }

    private void initFragment() {
        FragmentManager supManager = getSupportFragmentManager();
        TestFragment baseFragment = (TestFragment) supManager.findFragmentByTag("tag");
        FragmentTransaction fragmentTransaction = supManager.beginTransaction();
        if (baseFragment != null) {
            fragmentTransaction.replace(R.id.fl_fragment, baseFragment);
        } else {
            baseFragment = new TestFragment();
            fragmentTransaction.add(baseFragment, "tag");
        }
        fragmentTransaction.commit();

    }

    private void setFragmentTag(String tag) {
        FragmentManager supManager = getSupportFragmentManager();
        BaseFragment baseFragment = (BaseFragment) supManager.findFragmentByTag(tag);
        if (baseFragment != null) {
            FunctionManager instance = FunctionManager.getInstance();
            instance.addNoParamNoResultFunc(new FunctionNoParamNoResult(TestFragment.method_1) {
                @Override
                public void function() {
                    Toast.makeText(MainActivity.this, "无参构造", Toast.LENGTH_LONG).show();
                }
            });
            baseFragment.setFunctionManager(instance);
        }
    }
}
