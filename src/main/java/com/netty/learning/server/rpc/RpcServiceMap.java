package com.netty.learning.server.rpc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yaohaoqiang on 2018/3/21.
 */
public class RpcServiceMap {

    public static Map<String, Object> map = new ConcurrentHashMap<>();

}
