package com.len.constellation.utils;

import android.util.Xml;

import com.len.constellation.model.Constellation;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author wsl
 */
public class XmlPullParserUtil {
    public static ArrayList<Constellation> readDataXml(InputStream is) throws Exception {
        ArrayList<Constellation> list = null;
        Constellation constellation = null;
        XmlPullParser xmlPullParser = Xml.newPullParser();
        xmlPullParser.setInput(is, "UTF-8");
        int type = xmlPullParser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            switch (type) {
                case XmlPullParser.START_TAG:
                    switch (xmlPullParser.getName()) {
                        case "constellation":
                            list = new ArrayList<>();
                            break;
                        case "star":
                            constellation = new Constellation();
                            break;
                        case "id":
                            constellation.setId(Integer.valueOf(xmlPullParser.nextText()));
                            break;
                        case "name":
                            constellation.setName(xmlPullParser.nextText());
                            break;
                        case "date":
                            constellation.setDate(xmlPullParser.nextText());
                            break;
                        case "luckynum":
                            constellation.setLuckynum(xmlPullParser.nextText());
                            break;
                        case "shortcoming":
                            constellation.setShortcoming(xmlPullParser.nextText());
                            break;
                        case "merit":
                            constellation.setMerit(xmlPullParser.nextText());
                            break;
                        case "performance":
                            constellation.setPerformance(xmlPullParser.nextText());
                            break;
                        case "character":
                            constellation.setCharacter(xmlPullParser.nextText());
                            break;
                    }

                    break;
                case XmlPullParser.END_TAG:
                    if ("star".equals(xmlPullParser.getName())) {
                        list.add(constellation);
                    }
                    break;
            }
            type = xmlPullParser.next();
        }
        return list;
    }
}
