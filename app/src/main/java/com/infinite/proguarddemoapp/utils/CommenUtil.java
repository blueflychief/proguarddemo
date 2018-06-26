package com.infinite.proguarddemoapp.utils;

import java.util.List;

public class CommenUtil {

    public static String printList(List list) {
        StringBuilder sb = new StringBuilder(20);
        if (list != null && list.size() > 0) {
            for (Object o : list) {
                sb.append(o.toString()).append("\n");
            }
        } else {
            sb.append("null");
        }
        return sb.toString();
    }
}
