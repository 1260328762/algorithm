package com.cl.algorithm.probability;

/**
 * @author chenliang
 * @date 2020-07-01
 */
public class News {

    private String title;

    private boolean isPositive;

    public News(String title, boolean isPositive) {
        this.title = title;
        this.isPositive = isPositive;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPositive() {
        return isPositive;
    }

    public void setPositive(boolean positive) {
        isPositive = positive;
    }
}
