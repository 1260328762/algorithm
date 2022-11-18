package com.cl.ipc;

/**
 * @author chenliang
 * @since 2022/9/19 22:29
 */
public class FxPriceImpl implements FxPrice {

    private double bid;

    private double offer;

    private boolean isStale;

    private PriceSource priceSource;

    private PriceProvider priceProvider;

    public FxPriceImpl(double bid, double offer, boolean isStale, PriceSource priceSource, PriceProvider priceProvider) {
        this.bid = bid;
        this.offer = offer;
        this.isStale = isStale;
        this.priceSource = priceSource;
        this.priceProvider = priceProvider;
    }

    @Override
    public double getBid() {
        return bid;
    }

    @Override
    public double getOffer() {
        return offer;
    }

    @Override
    public boolean isStale() {
        return isStale;
    }

    @Override
    public PriceSource getSource() {
        return priceSource;
    }

    @Override
    public PriceProvider getProvider() {
        return priceProvider;
    }
}
