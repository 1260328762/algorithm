package com.cl.question;

/**
 * @author chenliang
 * @since 2021/12/6 15:47
 * <p>
 * 共有x瓶啤酒，
 * 3个空瓶换一瓶啤酒，7个瓶盖换一瓶啤酒，一共能喝多少瓶
 */
public class DrinkBeer {

    public int drinkBeer(int x) {
        int bottle = x;
        int cover = x;
        int count = x;

        while (bottle >= 3 || cover >= 7) {
            if (bottle >= 3) {
                // 三个空瓶换一瓶酒
                bottle -= 3;

                // 喝一瓶，瓶盖加1，空瓶加1
                count++;
                cover++;
                bottle++;
            }

            if (cover >= 7) {
                // 七个瓶盖换瓶酒
                cover -= 7;
                // 喝一瓶
                count++;
                // 空瓶加1
                bottle++;
                //瓶盖加1
                cover++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int i = new DrinkBeer().drinkBeer(10);
        System.out.println(i);
    }

}
