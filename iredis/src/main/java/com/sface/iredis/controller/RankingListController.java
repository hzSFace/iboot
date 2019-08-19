package com.sface.iredis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

/**
 * @className RankingListController
 * @Desc 排行榜
 * 某国有银行举行模拟交易大赛
 * @Author HZ
 * @Date 2019/6/17 22:09
 * @Version 1.0
 */
@RestController
public class RankingListController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    //盈利亏损排行榜
    public static final String PROFIT_LOSS_RANK = "profit_loss_rank";


    @RequestMapping("/batchInit")
    public void batchInit(){
        Set<ZSetOperations.TypedTuple<String>> tuples = new HashSet<>();

        long startTime = System.currentTimeMillis();

        for(int i=0; i<100000; i++){
            DefaultTypedTuple<String> tuple = new DefaultTypedTuple<>("HZ"+i, 1D+i);
            tuples.add(tuple);
        }

        System.out.print("循环耗时："+ (System.currentTimeMillis() - startTime));

        Long num = redisTemplate.opsForZSet().add(PROFIT_LOSS_RANK, tuples);
    }

}
