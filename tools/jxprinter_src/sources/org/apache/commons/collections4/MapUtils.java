package org.apache.commons.collections4;

import A3.AbstractC0157z;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;
import org.apache.commons.math3.geometry.VectorFormat;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class MapUtils {
    public static final SortedMap EMPTY_SORTED_MAP = UnmodifiableSortedMap.unmodifiableSortedMap(new TreeMap());
    private static final String INDENT_STRING = "    ";

    private MapUtils() {
    }

    public static void debugPrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), true);
    }

    public static <K, V> Map<K, V> emptyIfNull(Map<K, V> map) {
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        return FixedSizeMap.fixedSizeMap(map);
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> sortedMap) {
        return FixedSizeSortedMap.fixedSizeSortedMap(sortedMap);
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k6) {
        Object obj;
        if (map == null || (obj = map.get(k6)) == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            return Boolean.valueOf((String) obj);
        }
        if (obj instanceof Number) {
            return ((Number) obj).intValue() != 0 ? Boolean.TRUE : Boolean.FALSE;
        }
        return null;
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k6) {
        return Boolean.TRUE.equals(getBoolean(map, k6));
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Byte ? (Byte) number : Byte.valueOf(number.byteValue());
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k6) {
        Byte b = getByte(map, k6);
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Double ? (Double) number : Double.valueOf(number.doubleValue());
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k6) {
        Double d = getDouble(map, k6);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Float ? (Float) number : Float.valueOf(number.floatValue());
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k6) {
        Float f6 = getFloat(map, k6);
        if (f6 == null) {
            return 0.0f;
        }
        return f6.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k6) {
        Integer integer = getInteger(map, k6);
        if (integer == null) {
            return 0;
        }
        return integer.intValue();
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Integer ? (Integer) number : Integer.valueOf(number.intValue());
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Long ? (Long) number : Long.valueOf(number.longValue());
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k6) {
        Long l6 = getLong(map, k6);
        if (l6 == null) {
            return 0L;
        }
        return l6.longValue();
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k6) {
        Object obj;
        if (map == null || (obj = map.get(k6)) == null || !(obj instanceof Map)) {
            return null;
        }
        return (Map) obj;
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k6) {
        Object obj;
        if (map == null || (obj = map.get(k6)) == null) {
            return null;
        }
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        try {
            return NumberFormat.getInstance().parse((String) obj);
        } catch (ParseException unused) {
            return null;
        }
    }

    public static <K, V> V getObject(Map<? super K, V> map, K k6) {
        if (map != null) {
            return map.get(k6);
        }
        return null;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k6) {
        Number number = getNumber(map, k6);
        if (number == null) {
            return null;
        }
        return number instanceof Short ? (Short) number : Short.valueOf(number.shortValue());
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k6) {
        Short sh = getShort(map, k6);
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k6) {
        Object obj;
        if (map == null || (obj = map.get(k6)) == null) {
            return null;
        }
        return obj.toString();
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            map2.put(entry.getValue(), entry.getKey());
        }
        return map2;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        if (map != null) {
            return map instanceof IterableMap ? (IterableMap) map : new AbstractMapDecorator<K, V>(map) { // from class: org.apache.commons.collections4.MapUtils.1
            };
        }
        throw new NullPointerException("Map must not be null");
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        if (sortedMap != null) {
            return sortedMap instanceof IterableSortedMap ? (IterableSortedMap) sortedMap : new AbstractSortedMapDecorator<K, V>(sortedMap) { // from class: org.apache.commons.collections4.MapUtils.2
            };
        }
        throw new NullPointerException("Map must not be null");
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        return LazyMap.lazyMap(map, factory);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Factory<? extends V> factory) {
        return LazySortedMap.lazySortedMap(sortedMap, factory);
    }

    @Deprecated
    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        return MultiValueMap.multiValueMap(map);
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        return ListOrderedMap.listOrderedMap(map);
    }

    public static <K, V> void populateMap(Map<K, V> map, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap(map, iterable, transformer, TransformerUtils.nopTransformer());
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedMap.predicatedMap(map, predicate, predicate2);
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> sortedMap, Predicate<? super K> predicate, Predicate<? super V> predicate2) {
        return PredicatedSortedMap.predicatedSortedMap(sortedMap, predicate, predicate2);
    }

    private static void printIndent(PrintStream printStream, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            printStream.print(INDENT_STRING);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] objArr) {
        if (map == 0) {
            throw new NullPointerException("The map must not be null");
        }
        if (objArr != null && objArr.length != 0) {
            int i5 = 0;
            Object obj = objArr[0];
            if (obj instanceof Map.Entry) {
                int length = objArr.length;
                while (i5 < length) {
                    Map.Entry entry = (Map.Entry) objArr[i5];
                    map.put(entry.getKey(), entry.getValue());
                    i5++;
                }
            } else if (obj instanceof KeyValue) {
                int length2 = objArr.length;
                while (i5 < length2) {
                    KeyValue keyValue = (KeyValue) objArr[i5];
                    map.put(keyValue.getKey(), keyValue.getValue());
                    i5++;
                }
            } else if (obj instanceof Object[]) {
                for (int i6 = 0; i6 < objArr.length; i6++) {
                    Object[] objArr2 = (Object[]) objArr[i6];
                    if (objArr2 == null || objArr2.length < 2) {
                        throw new IllegalArgumentException(AbstractC0157z.k(i6, "Invalid array element: "));
                    }
                    map.put(objArr2[0], objArr2[1]);
                }
            } else {
                while (i5 < objArr.length - 1) {
                    int i7 = i5 + 1;
                    Object obj2 = objArr[i5];
                    i5 += 2;
                    map.put(obj2, objArr[i7]);
                }
            }
        }
        return map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K> void safeAddToMap(Map<? super K, Object> map, K k6, Object obj) {
        if (obj == null) {
            obj = "";
        }
        map.put(k6, obj);
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        return Collections.synchronizedMap(map);
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> sortedMap) {
        return Collections.synchronizedSortedMap(sortedMap);
    }

    public static Map<String, Object> toMap(ResourceBundle resourceBundle) {
        Enumeration<String> keys = resourceBundle.getKeys();
        HashMap map = new HashMap();
        while (keys.hasMoreElements()) {
            String strNextElement = keys.nextElement();
            map.put(strNextElement, resourceBundle.getObject(strNextElement));
        }
        return map;
    }

    public static <K, V> Properties toProperties(Map<K, V> map) {
        Properties properties = new Properties();
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                properties.put(entry.getKey(), entry.getValue());
            }
        }
        return properties;
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedMap.transformingMap(map, transformer, transformer2);
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends K> transformer, Transformer<? super V, ? extends V> transformer2) {
        return TransformedSortedMap.transformingSortedMap(sortedMap, transformer, transformer2);
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<? extends K, ? extends V> map) {
        return UnmodifiableMap.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, ? extends V> sortedMap) {
        return UnmodifiableSortedMap.unmodifiableSortedMap(sortedMap);
    }

    public static void verbosePrint(PrintStream printStream, Object obj, Map<?, ?> map) {
        verbosePrintInternal(printStream, obj, map, new ArrayDeque(), false);
    }

    private static void verbosePrintInternal(PrintStream printStream, Object obj, Map<?, ?> map, Deque<Map<?, ?>> deque, boolean z6) {
        printIndent(printStream, deque.size());
        if (map == null) {
            if (obj != null) {
                printStream.print(obj);
                printStream.print(" = ");
            }
            printStream.println(AbstractC1127c.NULL);
            return;
        }
        if (obj != null) {
            printStream.print(obj);
            printStream.println(" = ");
        }
        printIndent(printStream, deque.size());
        printStream.println(VectorFormat.DEFAULT_PREFIX);
        deque.addLast(map);
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!(value instanceof Map) || deque.contains(value)) {
                printIndent(printStream, deque.size());
                printStream.print(key);
                printStream.print(" = ");
                int iIndexOf = IterableUtils.indexOf(deque, PredicateUtils.equalPredicate(value));
                if (iIndexOf == -1) {
                    printStream.print(value);
                } else if (deque.size() - 1 == iIndexOf) {
                    printStream.print("(this Map)");
                } else {
                    StringBuilder sb = new StringBuilder("(ancestor[");
                    sb.append(((deque.size() - 1) - iIndexOf) - 1);
                    sb.append("] Map)");
                    printStream.print(sb.toString());
                }
                if (!z6 || value == null) {
                    printStream.println();
                } else {
                    printStream.print(Chars.SPACE);
                    printStream.println(value.getClass().getName());
                }
            } else {
                if (key == null) {
                    key = AbstractC1127c.NULL;
                }
                verbosePrintInternal(printStream, key, (Map) value, deque, z6);
            }
        }
        deque.removeLast();
        printIndent(printStream, deque.size());
        printStream.println(z6 ? "} ".concat(map.getClass().getName()) : VectorFormat.DEFAULT_SUFFIX);
    }

    public static <K> boolean getBooleanValue(Map<? super K, ?> map, K k6, boolean z6) {
        Boolean bool = getBoolean(map, k6);
        return bool == null ? z6 : bool.booleanValue();
    }

    public static <K, V> V getObject(Map<K, V> map, K k6, V v6) {
        V v7;
        return (map == null || (v7 = map.get(k6)) == null) ? v6 : v7;
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformer) {
        return LazyMap.lazyMap(map, transformer);
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> sortedMap, Transformer<? super K, ? extends V> transformer) {
        return LazySortedMap.lazySortedMap(sortedMap, transformer);
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> cls) {
        return MultiValueMap.multiValueMap(map, cls);
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e : iterable) {
            map.put(transformer.transform(e), transformer2.transform(e));
        }
    }

    public static <K> byte getByteValue(Map<? super K, ?> map, K k6, byte b) {
        Byte b6 = getByte(map, k6);
        return b6 == null ? b : b6.byteValue();
    }

    public static <K> double getDoubleValue(Map<? super K, ?> map, K k6, double d) {
        Double d6 = getDouble(map, k6);
        return d6 == null ? d : d6.doubleValue();
    }

    public static <K> float getFloatValue(Map<? super K, ?> map, K k6, float f6) {
        Float f7 = getFloat(map, k6);
        return f7 == null ? f6 : f7.floatValue();
    }

    public static <K> int getIntValue(Map<? super K, ?> map, K k6, int i5) {
        Integer integer = getInteger(map, k6);
        return integer == null ? i5 : integer.intValue();
    }

    public static <K> long getLongValue(Map<? super K, ?> map, K k6, long j6) {
        Long l6 = getLong(map, k6);
        return l6 == null ? j6 : l6.longValue();
    }

    public static <K> short getShortValue(Map<? super K, ?> map, K k6, short s6) {
        Short sh = getShort(map, k6);
        return sh == null ? s6 : sh.shortValue();
    }

    public static <K> String getString(Map<? super K, ?> map, K k6, String str) {
        String string = getString(map, k6);
        return string == null ? str : string;
    }

    @Deprecated
    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> factory) {
        return MultiValueMap.multiValueMap(map, factory);
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K k6, Map<?, ?> map2) {
        Map<?, ?> map3 = getMap(map, k6);
        return map3 == null ? map2 : map3;
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K k6, Byte b) {
        Byte b6 = getByte(map, k6);
        return b6 == null ? b : b6;
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K k6, Double d) {
        Double d6 = getDouble(map, k6);
        return d6 == null ? d : d6;
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K k6, Float f6) {
        Float f7 = getFloat(map, k6);
        return f7 == null ? f6 : f7;
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K k6, Integer num) {
        Integer integer = getInteger(map, k6);
        return integer == null ? num : integer;
    }

    public static <K> Long getLong(Map<? super K, ?> map, K k6, Long l6) {
        Long l7 = getLong(map, k6);
        return l7 == null ? l6 : l7;
    }

    public static <K> Short getShort(Map<? super K, ?> map, K k6, Short sh) {
        Short sh2 = getShort(map, k6);
        return sh2 == null ? sh : sh2;
    }

    public static <K, V> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends V> iterable, Transformer<V, K> transformer) {
        populateMap((MultiMap) multiMap, (Iterable) iterable, (Transformer) transformer, TransformerUtils.nopTransformer());
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K k6, Number number) {
        Number number2 = getNumber(map, k6);
        return number2 == null ? number : number2;
    }

    public static <K, V, E> void populateMap(MultiMap<K, V> multiMap, Iterable<? extends E> iterable, Transformer<E, K> transformer, Transformer<E, V> transformer2) {
        for (E e : iterable) {
            multiMap.put(transformer.transform(e), transformer2.transform(e));
        }
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K k6, Boolean bool) {
        Boolean bool2 = getBoolean(map, k6);
        return bool2 == null ? bool : bool2;
    }
}
