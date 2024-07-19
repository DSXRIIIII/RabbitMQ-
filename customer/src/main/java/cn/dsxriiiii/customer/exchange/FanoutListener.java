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
 * @CreateDate: 2024/7/19 14:12
 * @Email: lihh53453@hundsun.com
 */
@Component
public class FanoutListener {

    private static final Logger log = LoggerFactory.getLogger(FanoutListener.class);

    /**
     *  topic交换机匹配
     *  #匹配多个 例如 mq.#  -> mq.dome.award 和 mq.dome.rebate 都会收到消息
     *  .匹配单个 例如 mq.#  -> mq.dome 只有单个的队列才会收到消息
     * @param msg 传递的消息
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.fanout.award}"),
            exchange = @Exchange(name = "dome.fanout",type = ExchangeTypes.FANOUT)
    ))
    public void direct_award(String msg){
        log.info("FANOUT 广播 mq.fanout.award队列接收到消息{}",msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "${mq.listener.fanout.rebate}"),
            exchange = @Exchange(name = "dome.fanout",type = ExchangeTypes.FANOUT)
    ))
    public void direct_rebate(String msg){
        log.info("FANOUT 广播 mq.fanout.rebate队列接收到消息{}",msg);
    }
}
