package cn.dsxriiiii.publisher.event;

import cn.dsxriiiii.publisher.BaseEvent;
import cn.dsxriiiii.publisher.publish.EventPublish;
import com.alibaba.fastjson2.JSONObject;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 13:40
 * @Email: lihh53453@hundsun.com
 */
@SpringBootTest
public class DirectExchangeTest {

    private final Logger logger = LoggerFactory.getLogger(DirectExchangeTest.class);

    @Resource
    private AwardEvent awardEvent;

    @Resource
    private EventPublish eventPublish;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void send_award_message(){
        for (int i = 0; i < 10; i++) {
            BaseEvent.BaseEventMessage<Long> longBaseEventMessage = awardEvent.buildBaseEventMessage((long) i);
            eventPublish.publish(awardEvent.topic(),longBaseEventMessage);
            logger.info("send_award_message 发送mq消息成功 for循环节点：{},发送消息为：{}",i, JSONObject.toJSONString(longBaseEventMessage));
        }
    }

    @Test
    public void testExchangeDirect_award(){
        String exchangeName = "dome.direct";
        String message = "hello,direct_award,Key为{award}要接受到/(ㄒoㄒ)/~~";
        rabbitTemplate.convertAndSend(exchangeName,"award",message);
    }

    @Test
    public void testExchangeDirect_rebate(){
        String exchangeName = "dome.direct";
        String message = "hello,direct_award,Key为{rebate}要接受到/(ㄒoㄒ)/~~";
        rabbitTemplate.convertAndSend(exchangeName,"rebate",message);
    }

    @Test
    public void testExchangeTopic_all(){
        String exchangeName = "dome.topic";
        String message = "hello,我是topic,dome下的都要接收到 (⊙o⊙)！";
        rabbitTemplate.convertAndSend(exchangeName,"dome.#",message);
    }

    @Test
    public void testExchangeTopic_rebate(){
        String exchangeName = "dome.topic";
        String message = "hello,我是topic,rebate前的都要接收到ヽ(✿ﾟ▽ﾟ)ノ";
        rabbitTemplate.convertAndSend(exchangeName,"#.rebate",message);
    }

    @Test
    public void testExchangeFanout(){
        String exchangeName = "dome.fanout";
        String message = "我是广播 都要接收到 (╯▔皿▔)╯";
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }
}
