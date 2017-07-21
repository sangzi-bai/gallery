package com;

/**
 * Created by Big_Boss on 2017/7/21.
 */

import java.text.SimpleDateFormat;
import java.util.Date;
public class rename {
    public synchronized String createtFileName() {
        java.util.Date dt = new java.util.Date(System.currentTimeMillis());
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String fileName= fmt.format(dt);
        return fileName;
    }
}
