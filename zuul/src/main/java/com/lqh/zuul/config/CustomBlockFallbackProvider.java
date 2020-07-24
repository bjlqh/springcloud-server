package com.lqh.zuul.config;

import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.BlockResponse;
import com.alibaba.csp.sentinel.adapter.gateway.zuul.fallback.ZuulBlockFallbackProvider;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * 发生限流之后的处理流程
 * @author liqihua
 * @date 2020/6/4
 */
@Slf4j
public class CustomBlockFallbackProvider implements ZuulBlockFallbackProvider {

    @Override
    public String getRoute() {
        return null;
    }

    @Override
    public BlockResponse fallbackResponse(String route, Throwable throwable) {
        if (throwable instanceof BlockException) {
            return new BlockResponse(429, "Sentinel block exception", route);
        } else {
            return new BlockResponse(500, "System Error", route);
        }
    }
}
