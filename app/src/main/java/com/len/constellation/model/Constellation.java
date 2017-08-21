package com.len.constellation.model;

import java.io.Serializable;

/**
 * Created by Shaolei on 2016/10/17.
 */
public class Constellation implements Serializable{

    private static final long serialVersionUID = 8167443411069763207L;
    private int id;
    private String name;
    private String date;
    private String luckynum;
    private String shortcoming;
    private String merit;
    private String performance;
    private String character;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLuckynum() {
        return luckynum;
    }

    public void setLuckynum(String luckynum) {
        this.luckynum = luckynum;
    }

    public String getShortcoming() {
        return shortcoming;
    }

    public void setShortcoming(String shortcoming) {
        this.shortcoming = shortcoming;
    }

    public String getMerit() {
        return merit;
    }

    public void setMerit(String merit) {
        this.merit = merit;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
