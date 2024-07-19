package cn.dsxriiiii.customer.listener.event;

import cn.dsxriiiii.publisher.BaseEvent;
import cn.dsxriiiii.publisher.event.RebateEvent;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 10:03
 * @Email: lihh53453@hundsun.com
 */
@Component
public class RebateListener {

    private final Logger logger = LoggerFactory.getLogger(RebateListener.class);

    //@Value("${mq.listener.rebate}")
    private String topic;

    /**
     * 这里对应Haper项目接受消息 只做展示 使用DemoDirect测试 所以给注解做了注释
     * @param message 消息
     */
    //@RabbitListener(queuesToDeclare = @Queue("${mq.listener.rebate}"))
    public void Listener(String message){
        try{
            BaseEvent.BaseEventMessage<RebateEvent.RebateMessage> rebateMessageBaseEventMessage  = JSON.parseObject(message, new TypeReference<BaseEvent.BaseEventMessage<RebateEvent.RebateMessage>>() {
            }.getType());
            RebateEvent.RebateMessage data = rebateMessageBaseEventMessage.getData();
            logger.info("监听mq.dome.rebate发送的消息 topic: {} message: {}", topic, data);
        }catch (Exception e){
            logger.info("监听mq.dome.rebate发送的消息失败 topic: {}", topic);
        }
    }

}
