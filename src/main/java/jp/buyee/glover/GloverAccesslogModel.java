package jp.buyee.glover;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;

/**
 * Created by nico on 2015/11/01.
 */
public class GloverAccesslogModel implements Serializable {

    public String time;
    public String client;
    public String level;
    public String message;
    public String tag;

    public GloverAccesslogModel() {

    }

    public GloverAccesslogModel(String time,
                                String client,
                                String level,
                                String message,
                                String tag) {
        this.time = time;
        this.client = client;
        this.level = level;
        this.message = message;
        this.tag = tag;
    }

    @Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
