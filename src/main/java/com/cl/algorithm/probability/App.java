package com.cl.algorithm.probability;

import com.cl.algorithm.util.IOUtils;
import com.hankcs.hanlp.classification.classifiers.IClassifier;
import com.hankcs.hanlp.classification.classifiers.NaiveBayesClassifier;
import com.hankcs.hanlp.classification.models.NaiveBayesModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenliang
 * @date 2020-07-01
 */
public class App {
    public static void main(String[] args) throws Exception{

        testHanLp();
    }




    public static void testHanLp() throws Exception{
        IClassifier classifier = new NaiveBayesClassifier();
        classifier.train("C:\\Users\\Administrator\\Desktop\\新闻分类", "UTF-8");

        System.out.println(classifier.predict("jia"));
    }







    public static void my(){
        List<News> list = new ArrayList<>();
        list.add(new News("同学，你好！您有免费特权尚未领取，点击领取", false));
        list.add(new News("周二钜惠，全程大促，快进来抢", false));
        list.add(new News("原价99元的课程，限时抢购", false));
        list.add(new News("恭喜您你获得拉钩教育超级vip，限时免费激活", false));
        list.add(new News("尊敬尾号8506用户，您有7580积分将过期，避免失效请点击领取商品", false));
        list.add(new News("尊敬的客户，您的专属会员回馈礼来了，抽奖有机会赢好礼", false));
        list.add(new News("一张8折快车券已到账，最高减20元，更有五折优惠限量领", false));
        list.add(new News("端午放心花，送您一笔满意贷备用金，快点击领取把", false));
        list.add(new News("Java进阶面试突击训练营，教你大厂面试offer怎么拿，限时免费", false));
        list.add(new News("由于套餐月租等固定费用即将收取，您的余额可能不足", true));
        list.add(new News("【滴滴优享】乘客您好，专属30元杭州优享券礼包到账，使用规则请打开APP-我的钱包查看。滴滴四项防疫措施，守护您的出行安全。 退订TD", false));
        list.add(new News("【拉勾网】验证码5839，用于注册/登录，10分钟内有效。验证码提供给他人可能导致账号被盗，请勿泄漏，谨防被骗。", true));
        list.add(new News("【甲骨文】【浙江甲骨文超级码科技人事通知】行政部的行政前台-杨桐、技术研发中心-后端研发部的Java开发工程师-蔡虹，" +
                "两位新同事自入职后在各自的工作岗位上表现良好，或者部门主管的一致好评，并通过试用期考核经主管讨论沟通予以转正，恭喜两位小甲，" +
                "也祝愿两位小甲在转正后继续保持良好的工作态度，积极发挥自己的主动意识，更高效完成工作",
                true));
        list.add(new News("你好，外卖放到了5号桌", true));
        list.add(new News("【美团点评】在吗？帮您整理一份美食地图，大牌美食5折起，吃点好的犒劳一下自己~戳 dpurl.cn/vxPnh9A 回TD退订", false));
        list.add(new News("【超级码】陈亮,C区的卫生靠大家来维护，今天轮到你值日倒水。如果不方便倒水，" +
                "通知另一个倒水人员。如果当日未倒水，第二天自觉发红包50元到技术部总群，继续是你倒水。感谢配合！", true));
        list.add(new News("您好，我是美团骑手徐晓锋，您点的华莱士（九堡金海城店）已经帮您放在外卖架上了，有问题请联系13185059065", true));
        list.add(new News("你好你的外卖给你放架子上了！", true));


        String MODEL_PATH = "classification-model.ser";

        Map<String, String[]> trainModel = new HashMap<>();
        trainModel.put("junk", list.stream().filter(news -> !news.isPositive()).map(News::getTitle)
                .toArray(String[]::new));
        trainModel.put("normal", list.stream().filter(News::isPositive).map(News::getTitle)
                .toArray(String[]::new));


        IClassifier classifier = new NaiveBayesClassifier((NaiveBayesModel) IOUtils.readObject(MODEL_PATH));
        // classifier.train(trainModel);

        // System.out.println(JsonUtils.toJson(classifier.getModel()));


        // IOUtils.saveObject(classifier.getModel(), "src/main/resources/mode.ser");

        System.out.println(classifier.predict("你好你的外卖给你放架子上了！"));
    }

}
