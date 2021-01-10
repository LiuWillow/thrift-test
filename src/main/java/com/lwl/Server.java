package com.lwl;

import com.lwl.thrift.JazzClient;
import com.lwl.thrift.JazzClientImpl;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.*;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException, TTransportException {
        // 定义服务器使用的socket类型
        TNonblockingServerSocket tNonblockingServerSocket = new TNonblockingServerSocket(8899);

        // 创建服务器参数
        TNonblockingServer.Args arg = new TNonblockingServer.Args(tNonblockingServerSocket);

        // 配置传输数据的格式
        arg.protocolFactory(new TCompactProtocol.Factory());
        // 配置数据传输的方式
        arg.transportFactory(new TFramedTransport.Factory());

        // 配置处理器用来处理rpc请求
        JazzClient.Processor<JazzClientImpl> processor = new JazzClient.Processor<>(new JazzClientImpl());
        arg.processorFactory(new TProcessorFactory(processor));

        // 本示例中使用半同步半异步方式的服务器模型
        TServer server = new TNonblockingServer(arg);
        System.out.println("Thrift Server Started!");
        // 启动服务
        server.serve();
    }
}
