package com.licl.conn.fragmentcommunication.struct;

/**
 * Created by licl on 2017/11/30.
 */

public abstract class FunctionWithResultOnly<Result> extends Function {

    public FunctionWithResultOnly(String methodName) {
        super(methodName);
    }

    public abstract Result function();
}
