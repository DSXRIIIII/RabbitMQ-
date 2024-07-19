package cn.dsxriiiii.customer.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: rabbit-demo
 * @Description: 非注解形式绑定队列
 * @Author: DSXRIIIII
 * @CreateDate: 2024/5/23 10:01
 * @Email: lihh53453@hundsun.com
 **/
@Configuration
public class FanoutConfig {
    //@Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("dome.fanout");
    }
    //@Bean
    public Queue fanoutQueueAward(){
        return new Queue("dome.fanout.award");
    }
    //@Bean
    public Binding FanoutBindingQueueAward(Queue fanoutQueueAward,FanoutExchange fanoutExchange1){
        return BindingBuilder.bind(fanoutQueueAward).to(fanoutExchange1);
    }
    //@Bean
    public Queue fanoutQueueRebate(){
        return new Queue("dome.fanout.rebate");
    }
    //@Bean
    public Binding FanoutBindingQueueRebate(Queue fanoutQueueRebate,FanoutExchange fanoutExchange1){
        return BindingBuilder.bind(fanoutQueueRebate).to(fanoutExchange1);
    }
}
