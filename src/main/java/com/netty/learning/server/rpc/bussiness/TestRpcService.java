package com.netty.learning.server.rpc.bussiness;

import java.util.Date;

/**
 * Created by yaohaoqiang on 2018/3/21.
 */
public interface TestRpcService {
    String helloMessage(String visitor, Date remoteTime);
}
