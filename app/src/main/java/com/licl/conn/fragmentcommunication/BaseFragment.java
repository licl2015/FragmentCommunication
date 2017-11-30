package com.licl.conn.fragmentcommunication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.licl.conn.fragmentcommunication.struct.FunctionManager;

/**
 * Created by licl on 2017/11/30.
 */

public abstract class BaseFragment extends Fragment {

    protected FunctionManager mFunctionManager;
    protected View rootView;

    public void setFunctionManager(FunctionManager manager) {
        this.mFunctionManager = manager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle bundle) {
        rootView = inflater.inflate(getResId(), container);
        initView(bundle);
        return rootView;
    }

    public abstract int getResId();

    public abstract void initView(Bundle bundle);

    public View findViewById(int resId) {
        return rootView.findViewById(resId);
    }
}
