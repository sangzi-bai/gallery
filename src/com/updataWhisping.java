package com;

/**
 * Created by Big_Boss on 2017/7/19.
 */

import com.opensymphony.xwork2.Action;
import Dao.whisperingDao;
import bases.WhisperingEntity;

public class updataWhisping {
    private int serialNumber;
    private String content;
    private String author;

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String execute(){
        whisperingDao dao=new whisperingDao();
        WhisperingEntity whisper=new WhisperingEntity();
        whisper.setSerialNumber(serialNumber);
        whisper.setAuthor(author);
        whisper.setContent(content);
        dao.insert(whisper);
        return Action.SUCCESS;
    }

}
