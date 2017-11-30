package com.licl.conn.fragmentcommunication.struct;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 方法管理类
 * Created by licl on 2017/11/30.
 */

public class FunctionManager {

    private Map<String, FunctionNoParamNoResult> mNoParamNoResult;
    private Map<String, FunctionWithParamOnly> mParamOnly;
    private Map<String, FunctionWithResultOnly> mResultOnly;
    private Map<String, FunctionParamAndResult> mParamAndResult;
    private static volatile FunctionManager mInstance;

    public static FunctionManager getInstance() {
        if (mInstance == null) {
            synchronized (FunctionManager.class) {
                if (mInstance == null) {
                    mInstance = new FunctionManager();
                }
            }
        }
        return mInstance;
    }

    private FunctionManager() {
        mNoParamNoResult = new HashMap<>();
        mParamOnly = new HashMap<>();
        mResultOnly = new HashMap<>();
        mParamAndResult = new HashMap<>();
    }

    public FunctionManager addNoParamNoResultFunc(FunctionNoParamNoResult funcNoParamNoResult) {
        if (!TextUtils.isEmpty(funcNoParamNoResult.methodName)) {
            mNoParamNoResult.put(funcNoParamNoResult.methodName, funcNoParamNoResult);
        }
        return this;
    }

    public void invokeNoParamNoResultFunc(String methodName) throws FunctionException {
        if (TextUtils.isEmpty(methodName)) {
            return;
        }
        FunctionNoParamNoResult funcNoParamNoResult = mNoParamNoResult.get(methodName);
        if (funcNoParamNoResult != null) {
            funcNoParamNoResult.function();
        } else {
            throw new FunctionException("no has method " + methodName);
        }
    }

    public FunctionManager addParamOnlyFunc(FunctionWithParamOnly funcParamOnly) {
        if (!TextUtils.isEmpty(funcParamOnly.methodName)) {
            mParamOnly.put(funcParamOnly.methodName, funcParamOnly);
        }
        return this;
    }

    public <Param> void invokeParamOnlyFunc(String methodName, Param param) throws FunctionException {
        if (TextUtils.isEmpty(methodName)) {
            return;
        }
        FunctionWithParamOnly funcParamOnly = mParamOnly.get(methodName);
        if (funcParamOnly != null) {
            funcParamOnly.function(param);
        } else {
            throw new FunctionException("no has method " + methodName);
        }
    }

    public FunctionManager addResultOnlyFunc(FunctionWithResultOnly funcResultOnly) {
        if (!TextUtils.isEmpty(funcResultOnly.methodName)) {
            mResultOnly.put(funcResultOnly.methodName, funcResultOnly);
        }
        return this;
    }

    public <Result> Result invokeResultOnlyFunc(String methodName, Class<Result> resultClass) throws FunctionException {
        if (TextUtils.isEmpty(methodName)) {
            return null;
        }
        FunctionWithResultOnly funcReultOnly = mResultOnly.get(methodName);
        if (funcReultOnly != null) {
            if (resultClass != null) {
                return resultClass.cast(funcReultOnly.function());
            } else {
                return (Result) funcReultOnly.function();
            }
        } else {
            throw new FunctionException("no has method " + methodName);
        }
    }

    public FunctionManager addParamAndResult(FunctionParamAndResult funcParamAndResult) {
        if (!TextUtils.isEmpty(funcParamAndResult.methodName)) {
            mParamAndResult.put(funcParamAndResult.methodName, funcParamAndResult);
        }
        return this;
    }

    public <Result, Param> Result invokeParamAndResult(String methodName, Param param, Class<Result> resultClass) throws FunctionException {
        if (TextUtils.isEmpty(methodName)) {
            return null;
        }
        FunctionParamAndResult funcParamAndResult = mParamAndResult.get(methodName);
        if (funcParamAndResult != null) {
            if (resultClass != null) {
                return resultClass.cast(funcParamAndResult.function(param));
            } else {
                return (Result) funcParamAndResult.function(param);
            }
        } else {
            throw new FunctionException("no has method " + methodName);
        }
    }


}
