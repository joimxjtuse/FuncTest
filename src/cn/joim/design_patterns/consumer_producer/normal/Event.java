package cn.joim.design_patterns.consumer_producer.normal;

import java.util.Date;

public class Event {

    private String message;
    private String name;

    private Date createDate;

    public Event(String message, String name, Date createDate) {
        this.message = message;
        this.name = name;
        this.createDate = createDate;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
