package com.orhanobut.hawk;

import A3.AbstractC0157z;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
class HawkSerializer implements Serializer {
    private static final char DELIMITER = '@';
    private static final String INFO_DELIMITER = "#";
    private static final char NEW_VERSION = 'V';
    private final LogInterceptor logInterceptor;

    public HawkSerializer(LogInterceptor logInterceptor) {
        this.logInterceptor = logInterceptor;
    }

    private String getCipherText(String str) {
        int iIndexOf = str.indexOf(64);
        if (iIndexOf != -1) {
            return str.substring(iIndexOf + 1);
        }
        throw new IllegalArgumentException("Text should contain delimiter");
    }

    @Override // com.orhanobut.hawk.Serializer
    public DataInfo deserialize(String str) {
        Class<?> cls;
        String[] strArrSplit = str.split(INFO_DELIMITER);
        char cCharAt = strArrSplit[2].charAt(0);
        String str2 = strArrSplit[0];
        Class<?> cls2 = null;
        if (str2 == null || str2.length() == 0) {
            cls = null;
        } else {
            try {
                cls = Class.forName(str2);
            } catch (ClassNotFoundException e) {
                this.logInterceptor.onLog("HawkSerializer -> " + e.getMessage());
                cls = null;
            }
        }
        String str3 = strArrSplit[1];
        if (str3 != null && str3.length() != 0) {
            try {
                cls2 = Class.forName(str3);
            } catch (ClassNotFoundException e6) {
                this.logInterceptor.onLog("HawkSerializer -> " + e6.getMessage());
            }
        }
        return new DataInfo(cCharAt, getCipherText(strArrSplit[strArrSplit.length - 1]), cls, cls2);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0074  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a6  */
    @Override // com.orhanobut.hawk.Serializer
    public <T> String serialize(String str, T t6) {
        String name;
        char c;
        String name2;
        HawkUtils.checkNullOrEmpty("Cipher text", str);
        HawkUtils.checkNull("Value", t6);
        String name3 = "";
        if (List.class.isAssignableFrom(t6.getClass())) {
            List list = (List) t6;
            name = !list.isEmpty() ? list.get(0).getClass().getName() : "";
            c = '1';
        } else if (Map.class.isAssignableFrom(t6.getClass())) {
            Map map = (Map) t6;
            if (map.isEmpty()) {
                name2 = "";
            } else {
                Iterator it = map.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    name3 = entry.getKey().getClass().getName();
                    name2 = entry.getValue().getClass().getName();
                } else {
                    name2 = "";
                }
            }
            c = '2';
            String str2 = name3;
            name3 = name2;
            name = str2;
        } else if (Set.class.isAssignableFrom(t6.getClass())) {
            Set set = (Set) t6;
            if (set.isEmpty()) {
                name = "";
            } else {
                Iterator it2 = set.iterator();
                if (it2.hasNext()) {
                    name = it2.next().getClass().getName();
                } else {
                    name = "";
                }
            }
            c = '3';
        } else {
            name = t6.getClass().getName();
            c = '0';
        }
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(INFO_DELIMITER);
        sb.append(name3);
        sb.append(INFO_DELIMITER);
        sb.append(c);
        return AbstractC0157z.s(sb, "V@", str);
    }
}
