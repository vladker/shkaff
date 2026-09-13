package com.orhanobut.hawk;

import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
final class HawkConverter implements Converter {
    private final Parser parser;

    public HawkConverter(Parser parser) {
        if (parser == null) {
            throw new NullPointerException("Parser should not be null");
        }
        this.parser = parser;
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.List] */
    private <T> T toList(String str, Class<?> cls) {
        if (cls == null) {
            return (T) new ArrayList();
        }
        ?? r6 = (T) ((List) this.parser.fromJson(str, new TypeToken<List<T>>() { // from class: com.orhanobut.hawk.HawkConverter.1
        }.getType()));
        int size = r6.size();
        for (int i5 = 0; i5 < size; i5++) {
            Parser parser = this.parser;
            r6.set(i5, parser.fromJson(parser.toJson(r6.get(i5)), cls));
        }
        return r6;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.HashMap] */
    private <K, V, T> T toMap(String str, Class<?> cls, Class<?> cls2) {
        ?? r6 = (T) new HashMap();
        if (cls != null && cls2 != null) {
            for (Map.Entry<K, V> entry : ((Map) this.parser.fromJson(str, new TypeToken<Map<K, V>>() { // from class: com.orhanobut.hawk.HawkConverter.3
            }.getType())).entrySet()) {
                r6.put(this.parser.fromJson(this.parser.toJson(entry.getKey()), cls), this.parser.fromJson(this.parser.toJson(entry.getValue()), cls2));
            }
        }
        return r6;
    }

    private <T> T toObject(String str, Class<?> cls) {
        return (T) this.parser.fromJson(str, cls);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T, java.util.HashSet] */
    private <T> T toSet(String str, Class<?> cls) {
        ?? r6 = (T) new HashSet();
        if (cls != null) {
            Iterator it = ((Set) this.parser.fromJson(str, new TypeToken<Set<T>>() { // from class: com.orhanobut.hawk.HawkConverter.2
            }.getType())).iterator();
            while (it.hasNext()) {
                r6.add(this.parser.fromJson(this.parser.toJson(it.next()), cls));
            }
        }
        return r6;
    }

    @Override // com.orhanobut.hawk.Converter
    public <T> T fromString(String str, DataInfo dataInfo) {
        if (str == null) {
            return null;
        }
        HawkUtils.checkNull("data info", dataInfo);
        Class<?> cls = dataInfo.keyClazz;
        Class<?> cls2 = dataInfo.valueClazz;
        switch (dataInfo.dataType) {
            case '0':
                return (T) toObject(str, cls);
            case '1':
                return (T) toList(str, cls);
            case '2':
                return (T) toMap(str, cls, cls2);
            case '3':
                return (T) toSet(str, cls);
            default:
                return null;
        }
    }

    @Override // com.orhanobut.hawk.Converter
    public <T> String toString(T t6) {
        if (t6 == null) {
            return null;
        }
        return this.parser.toJson(t6);
    }
}
