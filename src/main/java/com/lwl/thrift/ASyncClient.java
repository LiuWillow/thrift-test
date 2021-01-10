package com.lwl.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.transport.*;

import java.io.IOException;

public class ASyncClient {
    public static void main(String[] args) throws TException, IOException, InterruptedException {
        TAsyncClientManager clientManager = new TAsyncClientManager();
        TNonblockingTransport transport = new TNonblockingSocket("localhost", 8899);
        TCompactProtocol.Factory factory = new TCompactProtocol.Factory();
        JazzClient.AsyncClient asyncClient = new JazzClient.AsyncClient(factory, clientManager, transport);

        AsyncMethodCallback<Boolean> resultHandler = new AsyncMethodCallback<Boolean>() {
            @Override
            public void onComplete(Boolean response) {
                System.out.println("完成:" + response);
            }

            @Override
            public void onError(Exception exception) {
                System.out.println("异常:" + exception);
            }
        };
        asyncClient.exists("李四", resultHandler);
        Thread.sleep(3000);
    }
}
