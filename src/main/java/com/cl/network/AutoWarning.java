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
        String condition = "[{\"opName\":\"and\",\"opProperty\":\"\",\"sonSize\":5,\"chunkedResult\":\"市值从小到大前100个,_&_非st,_&_主板\",\"relatedSize\":0},{\"opName\":\"sort\",\"opProperty\":\"从小到大排名前100\",\"sonSize\":1,\"uiText\":\"2023年12月06日总市值从小到大排名前100\",\"queryText\":\"2023年12月06日总市值从小到大排名前100\",\"relatedSize\":1},{\"indexName\":\"总市值\",\"indexProperties\":[\"nodate 1\",\"交易日期 20231206\"],\"indexPropertiesMap\":{\"交易日期\":\"20231206\",\"nodate\":\"1\"},\"type\":\"index\",\"sonSize\":0,\"reportType\":\"TRADE_DAILY\",\"valueType\":\"_浮点型数值(元|港元|美元|英镑)\",\"domain\":\"abs_股票领域\",\"source\":\"new_parser\",\"dateType\":\"交易日期\",\"tag\":\"总市值\",\"relatedSize\":0},{\"opName\":\"and\",\"opProperty\":\"\",\"sonSize\":2,\"relatedSize\":0},{\"indexName\":\"股票简称\",\"indexProperties\":[\"不包含st\"],\"indexPropertiesMap\":{\"不包含\":\"st\"},\"type\":\"index\",\"sonSize\":0,\"reportType\":\"null\",\"valueType\":\"_股票简称\",\"domain\":\"abs_股票领域\",\"source\":\"new_parser\",\"tag\":\"股票简称\",\"uiText\":\"股票简称不包含st\",\"queryText\":\"股票简称不包含st\",\"relatedSize\":0},{\"indexName\":\"上市板块\",\"indexProperties\":[\"包含主板\"],\"indexPropertiesMap\":{\"包含\":\"主板\"},\"type\":\"index\",\"sonSize\":0,\"reportType\":\"null\",\"valueType\":\"_上市板块\",\"domain\":\"abs_股票领域\",\"source\":\"new_parser\",\"tag\":\"上市板块\",\"uiText\":\"上市板块是主板\",\"queryText\":\"上市板块是主板\",\"relatedSize\":0}]\n";
        String w = "市值从小到大前100个，非st，主板\n";
        String domain = "abs_股票领域";

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
        JSONObject jsonObject = jsonArray.getJSONObject(0);

        body.clear();

        body.add("userId", "659352650");
        body.add("limit", true);
        body.add("channel", "THS_MOBILE");
        body.add("stkcode", jsonObject.getString("hqCode"));
        body.add("stkname", jsonObject.getString("股票简称"));
        body.add("marketcode", "33");
        body.add("warnType", "0");
        body.add("pushInfo", "[{\"pushClient\":\"PUSH\",\"pushStatus\":1,\"pushParams\":null},{\"pushClient\":\"WX\",\"pushStatus\":1,\"pushParams\":null},{\"pushClient\":\"SMS\",\"pushStatus\":0,\"pushParams\":null}]");
        body.add("frequency", "2");
        body.add("warnIndexs", "[{\"condId\":59,\"indexValue\":\"\"}]");

        // todo 添加Cookie
        String resultString = restTemplate.postForObject("https://vaserviece.10jqka.com.cn/iwcalarm/nlp/v1/add_warn_info",
                new HttpEntity<>(body, headers), String.class);
        System.out.println(resultString);
    }
}
