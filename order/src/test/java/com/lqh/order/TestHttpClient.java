package com.lqh.order;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

/**
 * @author liqihua
 * @date 2020/6/4
 */
public class TestHttpClient {

    @Test
    public void createOrderTask() {
        String url = "http://localhost:7000/market/order-service/order/create";
        createTask(url, HttpMethod.GET);
        while (true) {

        }
    }

    @Test
    public void findOrderTask() {
        String url = "http://localhost:7000/market/order-service/order/find";
        createTask(url, HttpMethod.GET);
        while (true) {

        }
    }

    /**
     * 每秒10个并发请求
     *
     * @param url
     * @param method
     */
    private void createTask(String url, HttpMethod method) {
        final int[] count = {1000};
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                count[0]++;
                CountDownLatch countDownLatch = new CountDownLatch(1);
                for (int i = 0; i < 10; i++) {
                    String requestUrl = url + "?uid=" + count[0] + i;
                    new Thread(() -> {
                        try {
                            countDownLatch.await();
                            System.out.println(Thread.currentThread().getName() + "响应为：" + sendRequest(requestUrl, method).getBody());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
                countDownLatch.countDown();
            }
        }, 0, 1000);
    }

    private ResponseEntity<String> sendRequest(String url, HttpMethod method) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(url, method, null, String.class);
    }
}
