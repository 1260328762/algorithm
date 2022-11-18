package com.cl.ipc;

/**
 * @author chenliang
 * @since 2022/9/19 22:15
 */
public interface FxPrice {

    double getBid();

    double getOffer();

    boolean isStale();

    PriceSource getSource();

    PriceProvider getProvider();
}
