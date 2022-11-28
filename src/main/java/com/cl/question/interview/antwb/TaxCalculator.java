package com.cl.question.interview.antwb;

/**
 * @author chenliang
 * @since 2022/11/24 20:19
 * 给定工资实现汇率计算
 * 要求
 * ⅰ. 逻辑正确，代码优雅
 * ⅱ. 可扩展性，考虑区间的变化，比如说起征点从5000变成10000等等，或者说85000以上的征税50%。
 * ⅲ. 推荐使用合适的设计模式
 * 这里举个例子，比如说税前10000元，5000部分是不扣税，后面5000，3000扣税3%，2000扣税10%。
 * TODO 待实现
 */
public class TaxCalculator {

    private String[][] taxRates = new String[][]{
            {"1", "5000", "0"},
            {"5001", "8000", "0.03"},
            {"8001", "17000", "0.1"},
            {"17001", "30000", "0.2"},
            {"30001", "40000", "0.25"},
            {"40001", "60000", "0.3"},
            {"60001", "85000", "0.35"},
            {"85001", "-", "0.35"}};

    public double calculateTax(int amount) {
        for (int i = 0; i < taxRates.length; i++) {
            int start = Integer.parseInt(taxRates[i][0]);
            int end = Integer.parseInt(taxRates[i][1]);
            if (start <= amount && amount <= end) {
                double tax = ((amount - start - 1) * Double.parseDouble(taxRates[i][2]));
                for (int j = i; j >= 0; j--) {
                    tax = tax + (amount - Integer.parseInt(taxRates[j][0]) - 1) * Double.parseDouble(taxRates[j][2]);
                }

                return tax;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.calculateTax(6000));
    }

}
