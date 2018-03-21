package com.netty.learning.server.rpc.bussiness.impl;

import com.netty.learning.server.rpc.RpcService;
import com.netty.learning.server.rpc.bussiness.TestRpcService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by yaohaoqiang on 2018/3/21.
 */
@Service
@RpcService(TestRpcService.class)
public class TestRpcServiceImpl implements TestRpcService {

    @Override
    public String helloMessage(String visitor, Date remoteTime) {
        return "hello " + visitor + "time is now : " + remoteTime;
    }
}
