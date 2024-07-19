package cn.dsxriiiii.customer.exchange;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 13:58
 * @Email: lihh53453@hundsun.com
 */
@Component
public class TopicListener {

    private static final Logger log = LoggerFactory.getLogger(TopicListener.class);


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.topic.award}"),
            exchange = @Exchange(name = "dome.topic", type = ExchangeTypes.TOPIC),
            key = "dome.#"
    ))
    public void topic_award(String msg){
        log.info("TOPIC 广播 mq.topic.award队列接收到消息{}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.topic.rebate}"),
            exchange = @Exchange(name = "dome.topic",type = ExchangeTypes.TOPIC),
            key = "#.rebate"
    ))
    public void topic_rebate(String msg){
        log.info("TOPIC 广播 mq.topic.rebate队列 ·队列接收到消息{}",msg);
    }
}
