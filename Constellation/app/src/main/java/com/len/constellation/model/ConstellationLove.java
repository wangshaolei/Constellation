package com.len.constellation.model;

import com.len.constellation.R;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 星座配对
 *
 * @author wsl
 */
public class ConstellationLove implements Serializable {

    private static final long serialVersionUID = -6090373530902200742L;
    private int imgid;
    private int id;

    private ArrayList<ConstellationLove> list;

    public ConstellationLove(){}

    public ConstellationLove(int imgid, int id) {
        this.imgid = imgid;
        this.id = id;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<ConstellationLove> getData() {
        list = new ArrayList<>();
        list.add(new ConstellationLove(R.drawable.aries1, 0));
        list.add(new ConstellationLove(R.drawable.taurus1, 1));
        list.add(new ConstellationLove(R.drawable.gemini1, 2));
        list.add(new ConstellationLove(R.drawable.cancer1, 3));
        list.add(new ConstellationLove(R.drawable.leo1, 4));
        list.add(new ConstellationLove(R.drawable.virgo1, 5));
        list.add(new ConstellationLove(R.drawable.libra1, 6));
        list.add(new ConstellationLove(R.drawable.scorpio1, 7));
        list.add(new ConstellationLove(R.drawable.sagittarius1, 8));
        list.add(new ConstellationLove(R.drawable.capricorn1, 9));
        list.add(new ConstellationLove(R.drawable.aquarius1, 10));
        list.add(new ConstellationLove(R.drawable.pisces1, 11));
        return list;
    }
}
