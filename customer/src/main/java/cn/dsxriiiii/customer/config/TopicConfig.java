package cn.dsxriiiii.customer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: rabbit-demo
 * @Description: 非注解形式绑定队列
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 13:54
 * @Email: lihh53453@hundsun.com
 */
@Configuration
public class TopicConfig {
    //@Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("dome.topic");
    }

    //@Bean
    public Queue topicQueueAward(){
        return new Queue("dome.topic.award");
    }
    //@Bean
    public Binding TopicBindingQueueRebate(Queue topicQueueAward, TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueAward).to(topicExchange).with("dome.#");
    }
    //@Bean
    public Queue topicQueueRebate(){
        return new Queue("dome.topic.rebate");
    }
    //@Bean
    public Binding TopicBindingQueueAward(Queue topicQueueRebate,TopicExchange topicExchange){
        return BindingBuilder.bind(topicQueueRebate).to(topicExchange).with("dome.#");
    }
}
