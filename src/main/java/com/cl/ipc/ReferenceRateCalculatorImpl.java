package com.cl.ipc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/9/19 22:16
 */
public class ReferenceRateCalculatorImpl implements ReferenceRateCalculator {

    // 方案一，每次获取中位数先排序，然后再计算中位数,实现方便，效率低
    private List<Double> priceList = new ArrayList<>();

    // 方案二，用TreeMap自带排序功能，实现复杂，效率高
    private MedianFinder medianFinder = new MedianFinder();

    @Override
    public void onConfiguration(Configuration configuration) {

    }

    @Override
    public void onFxPrice(FxPrice fxPrice) {
        if (!fxPrice.isStale()) {
            // // 方案1
            // priceList.add((fxPrice.getBid() + fxPrice.getOffer()) / 2);

            // 方案2
            medianFinder.addNum((fxPrice.getBid() + fxPrice.getOffer()) / 2);
        }
    }

    @Override
    public FxPrice calculate() {
        // // 方案1
        // Collections.sort(priceList);
        //
        // double result = 0;
        // int size = priceList.size();
        // if (size % 2 == 1) {
        //     result = priceList.get((size - 1) / 2);
        // } else {
        //     result = (priceList.get(size / 2 - 1) + priceList.get(size / 2) + 0.0) / 2;
        // }
        // return new FxPriceImpl(result, result, true, PriceSource.SOURCE1, PriceProvider.PROVIDER1);

        // 方案2
        double median = medianFinder.findMedian();
        return new FxPriceImpl(median, median, true, PriceSource.SOURCE1, PriceProvider.PROVIDER1);
    }

}
