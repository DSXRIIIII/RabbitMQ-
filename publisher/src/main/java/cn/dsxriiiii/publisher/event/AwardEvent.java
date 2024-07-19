package cn.dsxriiiii.publisher.event;

import cn.dsxriiiii.publisher.BaseEvent;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 9:35
 * @Email: lihh53453@hundsun.com
 */
@Component
public class AwardEvent extends BaseEvent<Long> {

    @Value("${mq.server.award}")
    private String topic;


    @Override
    public BaseEventMessage<Long> buildBaseEventMessage(Long data) {
        return BaseEventMessage.<Long>builder()
                .id(RandomStringUtils.randomNumeric(11))
                .time(new Date())
                .data(data)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

}
