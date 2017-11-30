package com.licl.conn.fragmentcommunication.struct;

/**
 * Created by licl on 2017/11/30.
 */

public abstract class FunctionParamAndResult<Param, Result> extends Function {

    public FunctionParamAndResult(String methodName) {
        super(methodName);
    }

    public abstract Result function(Param param);
}
