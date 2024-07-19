package cn.dsxriiiii.publisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ProjectName: rabbit-demo
 * @Description:
 * @Author: DSXRIIIII
 * @CreateDate: 2024/7/19 9:18
 * @Email: lihh53453@hundsun.com
 */
@Data
public abstract class BaseEvent<T> {

    public abstract BaseEventMessage<T> buildBaseEventMessage(T data);

    public abstract String topic();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class BaseEventMessage<T>{
        private String id;
        private Date time;
        private T data;
    }
}
