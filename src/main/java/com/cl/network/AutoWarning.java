package com.cl.network;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author chenliang
 * @since 2023/12/6 17:31
 */
public class AutoWarning {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String condition = "[]";

        String w = "keyword\n";
        String domain = "领域";

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("condition", condition);
        body.add("w", w);
        body.add("domain", domain);

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("User-Agent", "PostmanRuntime/7.35.0");
        headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);

        JSONObject result = restTemplate.postForObject("https://search.10jqka.com.cn/unified-wap/get-parser-data", new HttpEntity<>(body, headers), JSONObject.class);

        JSONArray jsonArray = result.getJSONObject("data")
                .getJSONArray("data");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            body.clear();

            body.add("userId", "用户id");
            body.add("limit", true);
            body.add("channel", "THS_MOBILE");
            body.add("stkcode", jsonObject.getString("hqCode"));
            body.add("stkname", jsonObject.getString("股票简称"));
            body.add("marketcode", "33");
            body.add("warnType", "0");
            body.add("pushInfo", "推送信息");
            body.add("frequency", "2");
            body.add("warnIndexs", "[{\"condId\":59,\"indexValue\":\"\"}]");

            // TODO 添加Cookie
            String resultString = restTemplate.postForObject("预警链接",
                    new HttpEntity<>(body, headers), String.class);
            System.out.println(resultString);
        }

    }
}
