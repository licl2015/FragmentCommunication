package com.licl.conn.fragmentcommunication.struct;

/**
 * Created by licl on 2017/11/30.
 */

public abstract class FunctionWithParamOnly<Param> extends Function {

    public FunctionWithParamOnly(String methodName) {
        super(methodName);
    }

    public abstract <Param> void function(Param param);
}
