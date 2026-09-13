package com.google.android.gms.internal.mlkit_vision_text_bundled_common;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class zbvg extends LinkedHashMap {
    private static final zbvg zba;
    private boolean zbb;

    static {
        zbvg zbvgVar = new zbvg();
        zba = zbvgVar;
        zbvgVar.zbb = false;
    }

    private zbvg() {
        this.zbb = true;
    }

    public static zbvg zba() {
        return zba;
    }

    private static int zbf(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof zbuh) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        int iZbb = zbuo.zbb(length, bArr, 0, length);
        if (iZbb == 0) {
            return 1;
        }
        return iZbb;
    }

    private final void zbg() {
        if (!this.zbb) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zbg();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        Iterator it = entrySet().iterator();
        int iZbf = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iZbf += zbf(entry.getValue()) ^ zbf(entry.getKey());
        }
        return iZbf;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        zbg();
        byte[] bArr = zbuo.zbb;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zbg();
        for (Object obj : map.keySet()) {
            byte[] bArr = zbuo.zbb;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zbg();
        return super.remove(obj);
    }

    public final zbvg zbb() {
        return isEmpty() ? new zbvg() : new zbvg(this);
    }

    public final void zbc() {
        this.zbb = false;
    }

    public final void zbd(zbvg zbvgVar) {
        zbg();
        if (zbvgVar.isEmpty()) {
            return;
        }
        putAll(zbvgVar);
    }

    public final boolean zbe() {
        return this.zbb;
    }

    private zbvg(Map map) {
        super(map);
        this.zbb = true;
    }
}
