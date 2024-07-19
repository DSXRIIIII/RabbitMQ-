package cn.dsxriiiii.publisher.event;

import cn.dsxriiiii.publisher.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 9:44
 * @Email: lihh53453@hundsun.com
 */
@Component
public class RebateEvent extends BaseEvent<RebateEvent.RebateMessage> {

    @Value("${mq.server.rebate}")
    private String topic;

    @Override
    public BaseEventMessage<RebateMessage> buildBaseEventMessage(RebateMessage data) {
        return BaseEventMessage.<RebateMessage>builder()
                .id(RandomStringUtils.random(11))
                .time(new Date())
                .data(data)
                .build();
    }

    @Override
    public String topic() {
        return topic;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class RebateMessage{
        private String id;
        private String info;
    }
}
