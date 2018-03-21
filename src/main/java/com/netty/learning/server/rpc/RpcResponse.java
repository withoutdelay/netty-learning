package com.netty.learning.server.rpc;

import lombok.Data;

/**
 * Created by yaohaoqiang on 2018/3/21.
 */
@Data
public class RpcResponse {
    private String requestId;
    private Throwable error;
    private Object result;
}
