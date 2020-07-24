package com.lqh.order;

import com.google.gson.JsonParser;
import com.lqh.order.service.IOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author liqihua
 * @date 2020/6/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
public class OrderTest {

    @Resource
    private IOrderService orderService;

    private static final String URL = "https://net.jdcloud.com/search/getDomainPriceAndRegisterState";

    @Resource
    private RestTemplate restTemplate;

    @Test
    public void searchDomain() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("domainName", "addasd");
        body.add("productName", ".com");
        body.add("searchIndex",null);
        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, request, String.class);
        if (responseEntity.getStatusCode().equals(HttpStatus.OK)) {
            /*Map map = JsonUtils.readValue(responseEntity.getBody(), Map.class);*/
            System.out.println(new JsonParser().parse(responseEntity.getBody()));
        } else {
            throw new RuntimeException("查询失败");
        }
    }

    @Test
    public void test() {
        System.out.println(orderService.selectAll());
    }
}
