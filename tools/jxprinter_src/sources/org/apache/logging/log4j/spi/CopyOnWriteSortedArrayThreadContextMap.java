package org.apache.logging.log4j.spi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.ReadOnlyStringMap;
import org.apache.logging.log4j.util.SortedArrayStringMap;
import org.apache.logging.log4j.util.StringMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
class CopyOnWriteSortedArrayThreadContextMap implements ReadOnlyThreadContextMap, ObjectThreadContextMap, CopyOnWrite {
    protected static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final StringMap EMPTY_CONTEXT_DATA;
    public static final String INHERITABLE_MAP = "isThreadContextMapInheritable";
    protected static final String PROPERTY_NAME_INITIAL_CAPACITY = "log4j2.ThreadContext.initial.capacity";
    private static volatile boolean inheritableMap;
    private static volatile int initialCapacity;
    private final ThreadLocal<StringMap> localMap = createThreadLocalMap();

    static {
        SortedArrayStringMap sortedArrayStringMap = new SortedArrayStringMap(1);
        EMPTY_CONTEXT_DATA = sortedArrayStringMap;
        sortedArrayStringMap.freeze();
        init();
    }

    private ThreadLocal<StringMap> createThreadLocalMap() {
        return inheritableMap ? new InheritableThreadLocal<StringMap>() { // from class: org.apache.logging.log4j.spi.CopyOnWriteSortedArrayThreadContextMap.1
            @Override // java.lang.InheritableThreadLocal
            public StringMap childValue(StringMap stringMap) {
                if (stringMap == null) {
                    return null;
                }
                StringMap stringMapCreateStringMap = CopyOnWriteSortedArrayThreadContextMap.this.createStringMap(stringMap);
                stringMapCreateStringMap.freeze();
                return stringMapCreateStringMap;
            }
        } : new ThreadLocal<>();
    }

    public static void init() {
        PropertiesUtil properties = PropertiesUtil.getProperties();
        initialCapacity = properties.getIntegerProperty(PROPERTY_NAME_INITIAL_CAPACITY, 16);
        inheritableMap = properties.getBooleanProperty("isThreadContextMapInheritable");
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public void clear() {
        this.localMap.remove();
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public boolean containsKey(String str) {
        StringMap stringMap = this.localMap.get();
        return stringMap != null && stringMap.containsKey(str);
    }

    public StringMap createStringMap() {
        return new SortedArrayStringMap(initialCapacity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ThreadContextMap)) {
            return Objects.equals(getImmutableMapOrNull(), ((ThreadContextMap) obj).getImmutableMapOrNull());
        }
        return false;
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public String get(String str) {
        return (String) getValue(str);
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public Map<String, String> getCopy() {
        StringMap stringMap = this.localMap.get();
        return stringMap == null ? new HashMap() : stringMap.toMap();
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public Map<String, String> getImmutableMapOrNull() {
        StringMap stringMap = this.localMap.get();
        if (stringMap == null) {
            return null;
        }
        return Collections.unmodifiableMap(stringMap.toMap());
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap2
    public StringMap getReadOnlyContextData() {
        StringMap stringMap = this.localMap.get();
        return stringMap == null ? EMPTY_CONTEXT_DATA : stringMap;
    }

    @Override // org.apache.logging.log4j.spi.ObjectThreadContextMap
    public <V> V getValue(String str) {
        StringMap stringMap = this.localMap.get();
        if (stringMap == null) {
            return null;
        }
        return (V) stringMap.getValue(str);
    }

    public int hashCode() {
        StringMap stringMap = this.localMap.get();
        return 31 + (stringMap == null ? 0 : stringMap.hashCode());
    }

    @Override // org.apache.logging.log4j.spi.ReadOnlyThreadContextMap, org.apache.logging.log4j.spi.ThreadContextMap
    public boolean isEmpty() {
        StringMap stringMap = this.localMap.get();
        return stringMap == null || stringMap.isEmpty();
    }

    @Override // org.apache.logging.log4j.spi.ThreadContextMap
    public void put(String str, String str2) {
        putValue(str, str2);
    }

    @Override // org.apache.logging.log4j.spi.ThreadContextMap2
    public void putAll(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        StringMap stringMap = this.localMap.get();
        StringMap stringMapCreateStringMap = stringMap == null ? createStringMap() : createStringMap(stringMap);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringMapCreateStringMap.putValue(entry.getKey(), entry.getValue());
        }
        stringMapCreateStringMap.freeze();
        this.localMap.set(stringMapCreateStringMap);
    }

    @Override // org.apache.logging.log4j.spi.ObjectThreadContextMap
    public <V> void putAllValues(Map<String, V> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        StringMap stringMap = this.localMap.get();
        StringMap stringMapCreateStringMap = stringMap == null ? createStringMap() : createStringMap(stringMap);
        for (Map.Entry<String, V> entry : map.entrySet()) {
            stringMapCreateStringMap.putValue(entry.getKey(), entry.getValue());
        }
        stringMapCreateStringMap.freeze();
        this.localMap.set(stringMapCreateStringMap);
    }

    @Override // org.apache.logging.log4j.spi.ObjectThreadContextMap
    public void putValue(String str, Object obj) {
        StringMap stringMap = this.localMap.get();
        StringMap stringMapCreateStringMap = stringMap == null ? createStringMap() : createStringMap(stringMap);
        stringMapCreateStringMap.putValue(str, obj);
        stringMapCreateStringMap.freeze();
        this.localMap.set(stringMapCreateStringMap);
    }

    @Override // org.apache.logging.log4j.spi.ThreadContextMap
    public void remove(String str) {
        StringMap stringMap = this.localMap.get();
        if (stringMap != null) {
            StringMap stringMapCreateStringMap = createStringMap(stringMap);
            stringMapCreateStringMap.remove(str);
            stringMapCreateStringMap.freeze();
            this.localMap.set(stringMapCreateStringMap);
        }
    }

    @Override // org.apache.logging.log4j.spi.CleanableThreadContextMap
    public void removeAll(Iterable<String> iterable) {
        StringMap stringMap = this.localMap.get();
        if (stringMap != null) {
            StringMap stringMapCreateStringMap = createStringMap(stringMap);
            Iterator<String> it = iterable.iterator();
            while (it.hasNext()) {
                stringMapCreateStringMap.remove(it.next());
            }
            stringMapCreateStringMap.freeze();
            this.localMap.set(stringMapCreateStringMap);
        }
    }

    public String toString() {
        StringMap stringMap = this.localMap.get();
        return stringMap == null ? "{}" : stringMap.toString();
    }

    public StringMap createStringMap(ReadOnlyStringMap readOnlyStringMap) {
        return new SortedArrayStringMap(readOnlyStringMap);
    }
}
