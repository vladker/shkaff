package org.apache.logging.log4j.message;

import A3.AbstractC0157z;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import kotlinx.serialization.json.internal.AbstractC1127c;
import org.apache.logging.log4j.util.IndexedStringMap;
import org.apache.logging.log4j.util.PropertiesUtil;
import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.apache.logging.log4j.util.StringBuilders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
enum MapMessageJsonFormatter {
    ;

    private static final char COLON = ':';
    private static final char COMMA = ',';
    private static final char DQUOTE = '\"';
    private static final char LBRACE = '[';
    private static final char LCURLY = '{';
    public static final int MAX_DEPTH = readMaxDepth();
    private static final char RBRACE = ']';
    private static final char RCURLY = '}';

    public static void format(StringBuilder sb, Object obj) {
        format(sb, obj, 0);
    }

    private static void formatBoolean(StringBuilder sb, boolean z6) {
        sb.append(z6);
    }

    private static void formatBooleanArray(StringBuilder sb, boolean[] zArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < zArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append(zArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatByteArray(StringBuilder sb, byte[] bArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < bArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append((int) bArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatCharArray(StringBuilder sb, char[] cArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < cArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            char c = cArr[i5];
            sb.append('\"');
            int length = sb.length();
            sb.append(c);
            StringBuilders.escapeJson(sb, length);
            sb.append('\"');
        }
        sb.append(RBRACE);
    }

    private static void formatCollection(final StringBuilder sb, Collection<Object> collection, int i5) {
        sb.append(LBRACE);
        final int i6 = i5 + 1;
        final boolean[] zArr = {true};
        collection.forEach(new Consumer() { // from class: org.apache.logging.log4j.message.a
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                MapMessageJsonFormatter.lambda$formatCollection$1(zArr, sb, i6, obj);
            }
        });
        sb.append(RBRACE);
    }

    private static void formatDoubleArray(StringBuilder sb, double[] dArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < dArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append(dArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatFloatArray(StringBuilder sb, float[] fArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < fArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append(fArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatFormattable(StringBuilder sb, StringBuilderFormattable stringBuilderFormattable) {
        sb.append('\"');
        int length = sb.length();
        stringBuilderFormattable.formatTo(sb);
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
    }

    private static void formatIndexedStringMap(StringBuilder sb, IndexedStringMap indexedStringMap, int i5) {
        sb.append(LCURLY);
        int i6 = i5 + 1;
        for (int i7 = 0; i7 < indexedStringMap.size(); i7++) {
            String keyAt = indexedStringMap.getKeyAt(i7);
            Object valueAt = indexedStringMap.getValueAt(i7);
            if (i7 > 0) {
                sb.append(COMMA);
            }
            sb.append('\"');
            int length = sb.length();
            sb.append(keyAt);
            StringBuilders.escapeJson(sb, length);
            sb.append('\"');
            sb.append(':');
            format(sb, valueAt, i6);
        }
        sb.append(RCURLY);
    }

    private static void formatIntArray(StringBuilder sb, int[] iArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append(iArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatList(StringBuilder sb, List<Object> list, int i5) {
        sb.append(LBRACE);
        int i6 = i5 + 1;
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (i7 > 0) {
                sb.append(COMMA);
            }
            format(sb, list.get(i7), i6);
        }
        sb.append(RBRACE);
    }

    private static void formatLongArray(StringBuilder sb, long[] jArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < jArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append(jArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatMap(final StringBuilder sb, Map<Object, Object> map, int i5) {
        sb.append(LCURLY);
        final int i6 = i5 + 1;
        final boolean[] zArr = {true};
        map.forEach(new BiConsumer() { // from class: org.apache.logging.log4j.message.b
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MapMessageJsonFormatter.lambda$formatMap$0(zArr, sb, i6, obj, obj2);
            }
        });
        sb.append(RCURLY);
    }

    private static void formatNumber(StringBuilder sb, Number number) {
        if (number instanceof BigDecimal) {
            sb.append(((BigDecimal) number).toString());
            return;
        }
        if (number instanceof Double) {
            sb.append(((Double) number).doubleValue());
            return;
        }
        if (number instanceof Float) {
            sb.append(((Float) number).floatValue());
            return;
        }
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            sb.append(number.longValue());
            return;
        }
        long jLongValue = number.longValue();
        double dDoubleValue = number.doubleValue();
        if (Double.compare(jLongValue, dDoubleValue) == 0) {
            sb.append(jLongValue);
        } else {
            sb.append(dDoubleValue);
        }
    }

    private static void formatObjectArray(StringBuilder sb, Object[] objArr, int i5) {
        sb.append(LBRACE);
        int i6 = i5 + 1;
        for (int i7 = 0; i7 < objArr.length; i7++) {
            if (i7 > 0) {
                sb.append(COMMA);
            }
            format(sb, objArr[i7], i6);
        }
        sb.append(RBRACE);
    }

    private static void formatShortArray(StringBuilder sb, short[] sArr) {
        sb.append(LBRACE);
        for (int i5 = 0; i5 < sArr.length; i5++) {
            if (i5 > 0) {
                sb.append(COMMA);
            }
            sb.append((int) sArr[i5]);
        }
        sb.append(RBRACE);
    }

    private static void formatString(StringBuilder sb, Object obj) {
        sb.append('\"');
        int length = sb.length();
        sb.append(String.valueOf(obj));
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$formatCollection$1(boolean[] zArr, StringBuilder sb, int i5, Object obj) {
        if (zArr[0]) {
            zArr[0] = false;
        } else {
            sb.append(COMMA);
        }
        format(sb, obj, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$formatMap$0(boolean[] zArr, StringBuilder sb, int i5, Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException("null keys are not allowed");
        }
        if (zArr[0]) {
            zArr[0] = false;
        } else {
            sb.append(COMMA);
        }
        sb.append('\"');
        String strValueOf = String.valueOf(obj);
        int length = sb.length();
        sb.append(strValueOf);
        StringBuilders.escapeJson(sb, length);
        sb.append('\"');
        sb.append(':');
        format(sb, obj2, i5);
    }

    private static int readMaxDepth() {
        int integerProperty = PropertiesUtil.getProperties().getIntegerProperty("log4j2.mapMessage.jsonFormatter.maxDepth", 8);
        if (integerProperty >= 0) {
            return integerProperty;
        }
        throw new IllegalArgumentException(AbstractC0157z.k(integerProperty, "was expecting a positive maxDepth, found: "));
    }

    private static void format(StringBuilder sb, Object obj, int i5) {
        if (i5 >= MAX_DEPTH) {
            throw new IllegalArgumentException("maxDepth has been exceeded");
        }
        if (obj == null) {
            sb.append(AbstractC1127c.NULL);
            return;
        }
        if (obj instanceof IndexedStringMap) {
            formatIndexedStringMap(sb, (IndexedStringMap) obj, i5);
            return;
        }
        if (obj instanceof Map) {
            formatMap(sb, (Map) obj, i5);
            return;
        }
        if (obj instanceof List) {
            formatList(sb, (List) obj, i5);
            return;
        }
        if (obj instanceof Collection) {
            formatCollection(sb, (Collection) obj, i5);
            return;
        }
        if (obj instanceof Number) {
            formatNumber(sb, (Number) obj);
            return;
        }
        if (obj instanceof Boolean) {
            formatBoolean(sb, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof StringBuilderFormattable) {
            formatFormattable(sb, (StringBuilderFormattable) obj);
            return;
        }
        if (obj instanceof char[]) {
            formatCharArray(sb, (char[]) obj);
            return;
        }
        if (obj instanceof boolean[]) {
            formatBooleanArray(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            formatByteArray(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            formatShortArray(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            formatIntArray(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            formatLongArray(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            formatFloatArray(sb, (float[]) obj);
            return;
        }
        if (obj instanceof double[]) {
            formatDoubleArray(sb, (double[]) obj);
        } else if (obj instanceof Object[]) {
            formatObjectArray(sb, (Object[]) obj, i5);
        } else {
            formatString(sb, obj);
        }
    }
}
