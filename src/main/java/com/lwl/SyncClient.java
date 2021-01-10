package com.lwl;

import com.lwl.thrift.JazzClient;
import com.lwl.thrift.ShitPO;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

import java.io.IOException;

public class SyncClient {
    public static void main(String[] args) throws TException, IOException, InterruptedException {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899));
        TProtocol protocol = new TCompactProtocol(transport);
        JazzClient.Client client = new JazzClient.Client(protocol);
        transport.open();
        ShitPO shit = client.getShit((short) 1, new ShitPO());
        System.out.println();
    }
}
