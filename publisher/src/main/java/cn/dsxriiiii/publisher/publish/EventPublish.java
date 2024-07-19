package cn.dsxriiiii.publisher.publish;

import cn.dsxriiiii.publisher.BaseEvent;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 10:25
 * @Email: lihh53453@hundsun.com
 */
@Component
public class EventPublish {

    private final Logger logger = LoggerFactory.getLogger(EventPublish.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void publish(String topic, BaseEvent.BaseEventMessage<?> eventMessage){
        try{
            String messageJson = JSON.toJSONString(eventMessage);
            rabbitTemplate.convertAndSend(topic,messageJson);
            logger.info("发送MQ消息 topic:{} message:{}", topic, messageJson);
        }catch (Exception e){
            logger.error("发送MQ消息 topic:{} message:{}", topic, JSON.toJSONString(eventMessage),e);
            throw e;
        }
    }

    public void publish(String topic, String eventMessageJSON){
        try {
            rabbitTemplate.convertAndSend(topic, eventMessageJSON);
            logger.info("发送MQ JSON数据 topic:{} message:{}", topic, eventMessageJSON);
        } catch (Exception e) {
            logger.error("发送MQ JSON数据失败 topic:{} message:{}", topic, eventMessageJSON, e);
            throw e;
        }
    }

}
