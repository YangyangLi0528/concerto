package com.lyyco.concerto.transport;

import com.lyyco.concerto.common.Pair;
import com.lyyco.concerto.transport.netty.NettyRequestProcessor;

import java.nio.channels.Channel;
import java.util.concurrent.ExecutorService;

public interface RemotingServer extends EndPoint {
    void registerProcessor(final int requestCode, final NettyRequestProcessor processor, final ExecutorService executor);

    void registerDefaultProcessor(final NettyRequestProcessor processor, final ExecutorService executor);

    int localListenPort();

    Pair<NettyRequestProcessor, ExecutorService> getProcessorPair(final int requestCode);

    RemotingCommand invokeSync(final Channel channel, final RemotingCommand request, final long timeoutMillis) throws InterruptedException;

    void invokeAsync(final Channel channel, final RemotingCommand request, final long timeoutMillis);
}
