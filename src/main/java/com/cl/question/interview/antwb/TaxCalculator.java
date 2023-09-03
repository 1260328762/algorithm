package com.cl.question.interview.antwb;

/**
 * @author chenliang
 * @since 2022/11/24 20:19
 * 给定工资实现汇率计算
 * 1~5000 税率 0
 * 5001~8000 3%
 * 8001~17000 10%
 * 17001~30000 20%
 * 30001~40000 25%
 * 40001~60000 30%
 * 60001~85000 35%
 * 85001~ 45%
 * 要求
 * ⅰ. 逻辑正确，代码优雅
 * ⅱ. 可扩展性，考虑区间的变化，比如说起征点从5000变成10000等等，或者说85000以上的征税50%。
 * ⅲ. 推荐使用合适的设计模式
 * 这里举个例子，比如说税前10000元，5000部分是不扣税，后面5000，3000扣税3%，2000扣税10%。
 */
public class TaxCalculator {

    private String[][] taxConfig = new String[][]{
            {"1", "5000", "0"},
            {"5001", "8000", "0.03"},
            {"8001", "17000", "0.1"},
            {"17001", "30000", "0.2"},
            {"30001", "40000", "0.25"},
            {"40001", "60000", "0.3"},
            {"60001", "85000", "0.35"},
            {"85001", "+", "0.45"},
    };

    public double calculateTax(double amount) {
        // 获取税率配置信息
        String[][] taxConfig = getTaxConfig();

        for (int i = 0; i < taxConfig.length; i++) {
            String[] taxStr = taxConfig[i];
            if (amount >= Integer.parseInt(taxStr[0])) {
                if (taxStr[1].equals("+") || amount <= Integer.parseInt(taxStr[1])) {
                    // 计算税率
                    double tax = (amount - Integer.parseInt(taxStr[0])) * Double.parseDouble(taxStr[2]);
                    for (int j = i - 1; j > 0; j--) {
                        tax += (Integer.parseInt(taxConfig[j + 1][0]) - Integer.parseInt(taxConfig[j][0])) * Double.parseDouble(taxConfig[j][2]);
                    }
                    return tax;
                }
            }
        }

        return 0;
    }

    public String[][] getTaxConfig() {
        return taxConfig;
    }

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator();
        System.out.println(taxCalculator.calculateTax(15000));
    }

}
