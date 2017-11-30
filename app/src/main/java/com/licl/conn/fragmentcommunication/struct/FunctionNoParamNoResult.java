package com.licl.conn.fragmentcommunication.struct;

/**
 * Created by licl on 2017/11/30.
 */

public abstract class FunctionNoParamNoResult extends Function {

    public FunctionNoParamNoResult(String methodName) {
        super(methodName);
    }

    public abstract void function();
}
