package com.cl.ipc;

/**
 * @author chenliang
 * @since 2022/9/19 22:15
 */
public interface ReferenceRateCalculator {

    void onConfiguration(Configuration configuration);

    void onFxPrice(FxPrice fxPrice);

    FxPrice calculate();

    interface Configuration {
        int getSize();

        PriceSource getSource(int index);

        PriceProvider getProvider(int index);
    }
}
