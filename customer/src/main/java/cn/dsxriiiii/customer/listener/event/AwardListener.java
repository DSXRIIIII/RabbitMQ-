package cn.dsxriiiii.customer.listener.event;

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
 * @CreateDate: 2024/7/19 9:54
 * @Email: lihh53453@hundsun.com
 */
@Component
public class AwardListener {

    private final Logger logger = LoggerFactory.getLogger(AwardListener.class);

    //@Value("${mq.listener.award}")
    private String topic;

    /**
     * 这里对应Haper项目接受消息 只做展示 使用DemoDirect测试 所以给注解做了注释
     * @param message 消息
     */
    //@RabbitListener(queuesToDeclare = @Queue(value = "${mq.listener.award}"))
    public void listener(String message){
        logger.info("监听到mq.dome.award消息 topic: {} message: {}", topic, message);
        // ... 执行其他业务逻辑
    }



}
