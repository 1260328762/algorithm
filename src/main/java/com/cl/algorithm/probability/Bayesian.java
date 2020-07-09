package com.cl.algorithm.probability;

import com.cl.algorithm.util.IKSUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chenliang
 * @date 2020-07-01
 * 朴素贝叶斯算法，判断新闻是否是正面新闻
 */
public class Bayesian {


    public void init(List<News> list, String message) {
        // 垃圾短信概率
        List<News> junkMessages = list.stream().filter(news -> !news.isPositive()).collect(Collectors.toList());
        BigDecimal junkMessagePro = new BigDecimal(junkMessages.size())
                .divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("垃圾短信概率: " + junkMessagePro);

        message = message.replaceAll("的", "")
                .replaceAll("是", "")
                .replaceAll("您", "")
                .replaceAll("了", "")
                .replaceAll("请", "");
        List<String> splitWords = IKSUtil.cutString(message);
        System.out.println("对短信进行分词后数据：" + splitWords);

        // w1, w2, wn出现在短信中的概率
        List<BigDecimal> pros = new ArrayList<>();
        for (String splitWord : splitWords) {
            long count = junkMessages.stream()
                    .filter(news -> news.getTitle().toLowerCase().contains(splitWord))
                    .count();
            if (count != 0) {
                pros.add(new BigDecimal(count).divide(new BigDecimal(junkMessages.size()), 10, BigDecimal.ROUND_HALF_UP));
            }
        }
        BigDecimal junkWordPro = new BigDecimal(1);
        if (!pros.isEmpty()) {
            // junkWordPro = pros.remove(0);
            for (BigDecimal pro : pros) {
                junkWordPro = junkWordPro.multiply(pro);
            }
        }
        System.out.println("单词出现在垃圾短信中概率: " + pros);
        System.out.println("此消息是垃圾短信概率: " + junkWordPro.multiply(junkMessagePro));


        // 计算非垃圾短信概率
        List<News> normalMessages = list.stream().filter(News::isPositive).collect(Collectors.toList());
        BigDecimal normalMessagePro = new BigDecimal(normalMessages.size())
                .divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("正常短信概率: " + normalMessagePro);


        List<BigDecimal> normalPro = new ArrayList<>();
        for (String splitWord : splitWords) {
            long count = normalMessages.stream()
                    .filter(news -> news.getTitle().toLowerCase().contains(splitWord))
                    .count();
            if (count != 0) {
                normalPro.add(new BigDecimal(count).divide(new BigDecimal(normalMessages.size()), 10, BigDecimal.ROUND_HALF_UP));
            }
        }

        BigDecimal normalWordPro = new BigDecimal(1);
        if (!normalPro.isEmpty()) {
            // normalWordPro = normalPro.remove(0);
            for (BigDecimal pro : normalPro) {
                junkWordPro = junkWordPro.multiply(pro);
            }
        }
        System.out.println("此消息是正常短信概率：" + normalWordPro.multiply(normalMessagePro));

    }


    private Map<String, BigDecimal> junkWord = new HashMap<>();

    private BigDecimal junkPro = new BigDecimal(1);

    private Map<String, BigDecimal> normalWord = new HashMap<>();

    private BigDecimal normalPro = new BigDecimal(1);

    public void training(List<News> list) {
        // 垃圾短信概率
        List<News> junkMessages = list.stream().filter(news -> !news.isPositive()).collect(Collectors.toList());
        BigDecimal junkMessagePro = new BigDecimal(junkMessages.size())
                .divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP);
        this.junkPro = junkMessagePro;
        System.out.println("垃圾短信概率: " + junkMessagePro);

        for (News junkMessage : junkMessages) {
            String content = stopWord(junkMessage.getTitle());
            List<String> words = IKSUtil.cutString(content);

            for (String word : words) {
                long count = junkMessages.stream()
                        .filter(news -> news.getTitle().toLowerCase().contains(word))
                        .count();
                junkWord.put(word, new BigDecimal(count).divide(new BigDecimal(junkMessages.size()), 10, BigDecimal.ROUND_HALF_UP));
            }

        }
        System.out.println("垃圾短信词汇出现概率：" + junkWord);


        // 计算非垃圾短信概率
        List<News> normalMessages = list.stream().filter(News::isPositive).collect(Collectors.toList());
        BigDecimal normalMessagePro = new BigDecimal(normalMessages.size())
                .divide(new BigDecimal(list.size()), 2, BigDecimal.ROUND_HALF_UP);
        this.normalPro = normalMessagePro;
        System.out.println("正常短信概率: " + normalMessagePro);


        for (News nornalMessage : normalMessages) {
            String content = stopWord(nornalMessage.getTitle());
            List<String> words = IKSUtil.cutString(content);

            for (String word : words) {
                long count = normalMessages.stream()
                        .filter(news -> news.getTitle().toLowerCase().contains(word))
                        .count();
                normalWord.put(word, new BigDecimal(count).divide(new BigDecimal(normalMessages.size()), 10, BigDecimal.ROUND_HALF_UP));
            }

        }
        System.out.println("正常短信词汇出现概率：" + normalWord);
    }

    public void predicate(String content) {
        List<String> words = IKSUtil.cutString(stopWord(content));
        System.out.println("对短信分词：" + words);


        BigDecimal junkPro = new BigDecimal(1);
        System.out.print("单词出现在垃圾短信中概率：");
        for (String word : words) {
            BigDecimal prob = junkWord.get(word);
            if (prob != null) {
                System.out.print(prob + " ");
                junkPro = junkPro.multiply(prob);
            }
        }
        System.out.println();
        junkPro = junkPro.multiply(this.junkPro);
        System.out.println("此短信为垃圾短信概率：" + junkPro);


        BigDecimal normalPro = new BigDecimal(1);
        for (String word : words) {
            BigDecimal prob = normalWord.get(word);
            if (prob != null) {
                System.out.print(prob + " ");
                normalPro = normalPro.multiply(prob);
            }
        }
        System.out.println();
        normalPro = normalPro.multiply(this.normalPro);
        System.out.println("此短信为正常短信概率：" + normalPro);

    }


    private String stopWord(String content) {
        return content.replaceAll("的", "")
                .replaceAll("是", "")
                .replaceAll("您", "")
                .replaceAll("了", "")
                .replaceAll("请", "")
                .replaceAll("你", "")
                .replaceAll("你好", "")
                .replaceAll("您好", "")
                .replaceAll("的", "")
                ;
    }

}
