package com.lyyco.concerto.transport;

public interface EndPoint {
    void start();

    void shutdown();

    void registerRPCHook(RPCHook rpcHook);
}
