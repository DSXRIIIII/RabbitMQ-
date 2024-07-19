package cn.dsxriiiii.customer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: rabbit-demo
 * @Description: 非注解形式绑定队列
 * @Author: DSXRIIIII
 * @CreateDate: 2024/5/23 10:08
 * @Email: lihh53453@hundsun.com
 **/
@Configuration
public class DirectConfig {

    @Value("${mq.listener.direct.award}")
    private String queue_award;

    @Value("${mq.listener.direct.rebate}")
    private String queue_rebate;

    @Bean
    public DirectExchange directExchange(){
        return ExchangeBuilder.directExchange("dome.direct").build();
    }

//    @Bean
//    public TopicExchange topicExchange(){
//        return ExchangeBuilder.topicExchange("dome.topic").build();
//    }

    //@Bean
    public Queue queue_award(){
        return new Queue(queue_award);
    }

    //@Bean
    public Queue queue_rebate(){
        return new Queue(queue_rebate);
    }

    //@Bean
    public Binding QueueAwardBindingDirect(Queue queue_award, DirectExchange directExchange){
        return BindingBuilder.bind(queue_award).to(directExchange).with("award");
    }

    //@Bean
    public Binding QueueRebateBindingDirect(Queue queue_rebate, DirectExchange directExchange){
        return BindingBuilder.bind(queue_rebate).to(directExchange).with("rebate");
    }

}

