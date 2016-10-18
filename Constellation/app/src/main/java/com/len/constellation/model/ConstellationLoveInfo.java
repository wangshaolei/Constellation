package com.len.constellation.model;

import java.io.Serializable;

/**
 * 星座配对数据库信息
 *
 * @author wsl
 */
public class ConstellationLoveInfo implements Serializable {

    private static final long serialVersionUID = -1629020405666611353L;
    private int mid;
    private int wid;
    private int indexnum;
    private String proportion;
    private String content;

    public ConstellationLoveInfo() {
    }

    public ConstellationLoveInfo(int mid, int wid, int indexnum, String proportion, String content) {
        this.mid = mid;
        this.wid = wid;
        this.indexnum = indexnum;
        this.proportion = proportion;
        this.content = content;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public int getIndexnum() {
        return indexnum;
    }

    public void setIndexnum(int indexnum) {
        this.indexnum = indexnum;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
