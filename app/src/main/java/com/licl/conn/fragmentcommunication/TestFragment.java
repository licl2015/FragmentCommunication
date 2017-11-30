package com.licl.conn.fragmentcommunication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.licl.conn.fragmentcommunication.struct.FunctionException;

/**
 * Created by licl on 2017/11/30.
 */

public class TestFragment extends BaseFragment {

    public static final String TAG = TestFragment.class.getSimpleName();
    public static final String method_1 = TAG + "method_1";

    @Override
    public int getResId() {
        return R.layout.act_test_layout;
    }

    @Override
    public void initView(Bundle bundle) {
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        tv_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mFunctionManager.invokeNoParamNoResultFunc(method_1);
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
