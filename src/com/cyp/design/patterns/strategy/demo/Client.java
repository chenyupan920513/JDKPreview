package com.cyp.design.patterns.strategy.demo;

/**
 * Created by Administrator on 2017/4/14.
 */
public class Client {
    public static void main(String[] args) {
        /**
         * 根据玩家消费金额不同，划分不同等级的会员，享受不同等级的折扣
         */
        Player2 player = new Player2();
        player.buy(8000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(8000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(8000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(8000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }
}
