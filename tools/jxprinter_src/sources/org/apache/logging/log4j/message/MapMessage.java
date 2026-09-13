package org.apache.logging.log4j.message;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.apache.logging.log4j.message.MapMessage;
import org.apache.logging.log4j.util.BiConsumer;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.EnglishEnums;
import org.apache.logging.log4j.util.IndexedReadOnlyStringMap;
import org.apache.logging.log4j.util.IndexedStringMap;
import org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable;
import org.apache.logging.log4j.util.PerformanceSensitive;
import org.apache.logging.log4j.util.SortedArrayStringMap;
import org.apache.logging.log4j.util.StringBuilders;
import org.apache.logging.log4j.util.TriConsumer;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@AsynchronouslyFormattable
@PerformanceSensitive({"allocation"})
public class MapMessage<M extends MapMessage<M, V>, V> implements MultiFormatStringBuilderFormattable {
    private static final long serialVersionUID = -5031471831131487120L;
    private final IndexedStringMap data;

    /* JADX INFO: renamed from: org.apache.logging.log4j.message.MapMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat;

        static {
            int[] iArr = new int[MapFormat.values().length];
            $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat = iArr;
            try {
                iArr[MapFormat.XML.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JSON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JAVA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[MapFormat.JAVA_UNQUOTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum MapFormat {
        XML,
        JSON,
        JAVA,
        JAVA_UNQUOTED;

        public static MapFormat lookupIgnoreCase(String str) {
            MapFormat mapFormat = XML;
            if (mapFormat.name().equalsIgnoreCase(str)) {
                return mapFormat;
            }
            MapFormat mapFormat2 = JSON;
            if (mapFormat2.name().equalsIgnoreCase(str)) {
                return mapFormat2;
            }
            MapFormat mapFormat3 = JAVA;
            if (mapFormat3.name().equalsIgnoreCase(str)) {
                return mapFormat3;
            }
            MapFormat mapFormat4 = JAVA_UNQUOTED;
            if (mapFormat4.name().equalsIgnoreCase(str)) {
                return mapFormat4;
            }
            return null;
        }

        public static String[] names() {
            return new String[]{XML.name(), JSON.name(), JAVA.name(), JAVA_UNQUOTED.name()};
        }
    }

    public MapMessage() {
        this.data = new SortedArrayStringMap();
    }

    private StringBuilder format(MapFormat mapFormat, StringBuilder sb) {
        if (mapFormat == null) {
            appendMap(sb);
            return sb;
        }
        int i5 = AnonymousClass1.$SwitchMap$org$apache$logging$log4j$message$MapMessage$MapFormat[mapFormat.ordinal()];
        if (i5 == 1) {
            asXml(sb);
            return sb;
        }
        if (i5 == 2) {
            asJson(sb);
            return sb;
        }
        if (i5 == 3) {
            asJava(sb);
            return sb;
        }
        if (i5 != 4) {
            appendMap(sb);
            return sb;
        }
        asJavaUnquoted(sb);
        return sb;
    }

    public void appendMap(StringBuilder sb) {
        for (int i5 = 0; i5 < this.data.size(); i5++) {
            if (i5 > 0) {
                sb.append(Chars.SPACE);
            }
            sb.append(this.data.getKeyAt(i5));
            sb.append(Chars.EQ);
            sb.append(Chars.DQUOTE);
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i5), sb);
            sb.append(Chars.DQUOTE);
        }
    }

    public void asJava(StringBuilder sb) {
        asJava(sb, true);
    }

    public void asJavaUnquoted(StringBuilder sb) {
        asJava(sb, false);
    }

    public void asJson(StringBuilder sb) {
        MapMessageJsonFormatter.format(sb, this.data);
    }

    public String asString() {
        return format(null, new StringBuilder()).toString();
    }

    public void asXml(StringBuilder sb) {
        sb.append("<Map>\n");
        for (int i5 = 0; i5 < this.data.size(); i5++) {
            sb.append("  <Entry key=\"");
            sb.append(this.data.getKeyAt(i5));
            sb.append("\">");
            int length = sb.length();
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i5), sb);
            StringBuilders.escapeXml(sb, length);
            sb.append("</Entry>\n");
        }
        sb.append("</Map>");
    }

    public void clear() {
        this.data.clear();
    }

    public boolean containsKey(String str) {
        return this.data.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.data.equals(((MapMessage) obj).data);
    }

    public <CV> void forEach(BiConsumer<String, ? super CV> biConsumer) {
        this.data.forEach(biConsumer);
    }

    @Override // org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        format(null, sb);
    }

    public String get(String str) {
        return ParameterFormatter.deepToString(this.data.getValue(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Map<String, V> getData() {
        TreeMap treeMap = new TreeMap();
        for (int i5 = 0; i5 < this.data.size(); i5++) {
            treeMap.put(this.data.getKeyAt(i5), this.data.getValueAt(i5));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormat() {
        return "";
    }

    @Override // org.apache.logging.log4j.message.MultiformatMessage
    public String[] getFormats() {
        return MapFormat.names();
    }

    @Override // org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return asString();
    }

    public IndexedReadOnlyStringMap getIndexedReadOnlyStringMap() {
        return this.data;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Object[] getParameters() {
        Object[] objArr = new Object[this.data.size()];
        for (int i5 = 0; i5 < this.data.size(); i5++) {
            objArr[i5] = this.data.getValueAt(i5);
        }
        return objArr;
    }

    @Override // org.apache.logging.log4j.message.Message
    public Throwable getThrowable() {
        return null;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public M newInstance(Map<String, V> map) {
        return (M) new MapMessage(map);
    }

    public void put(String str, String str2) {
        if (str2 == null) {
            throw new IllegalArgumentException(AbstractC0157z.n("No value provided for key ", str));
        }
        String key = toKey(str);
        validate(key, str2);
        this.data.putValue(key, str2);
    }

    public void putAll(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.data.putValue(entry.getKey(), entry.getValue());
        }
    }

    public String remove(String str) {
        String str2 = get(str);
        this.data.remove(str);
        return str2;
    }

    public String toString() {
        return asString();
    }

    public void validate(String str, byte b) {
    }

    public M with(String str, boolean z6) {
        String key = toKey(str);
        validate(key, z6);
        this.data.putValue(key, Boolean.valueOf(z6));
        return this;
    }

    private void asJava(StringBuilder sb, boolean z6) {
        sb.append('{');
        for (int i5 = 0; i5 < this.data.size(); i5++) {
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(this.data.getKeyAt(i5));
            sb.append(Chars.EQ);
            if (z6) {
                sb.append(Chars.DQUOTE);
            }
            ParameterFormatter.recursiveDeepToString(this.data.getValueAt(i5), sb);
            if (z6) {
                sb.append(Chars.DQUOTE);
            }
        }
        sb.append('}');
    }

    private MapFormat getFormat(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            for (String str : strArr) {
                MapFormat mapFormatLookupIgnoreCase = MapFormat.lookupIgnoreCase(str);
                if (mapFormatLookupIgnoreCase != null) {
                    return mapFormatLookupIgnoreCase;
                }
            }
        }
        return null;
    }

    public String asString(String str) {
        try {
            return format((MapFormat) EnglishEnums.valueOf(MapFormat.class, str), new StringBuilder()).toString();
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    public <CV, S> void forEach(TriConsumer<String, ? super CV, S> triConsumer, S s6) {
        this.data.forEach(triConsumer, s6);
    }

    @Override // org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] strArr, StringBuilder sb) {
        format(getFormat(strArr), sb);
    }

    @Override // org.apache.logging.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] strArr) {
        return format(getFormat(strArr), new StringBuilder()).toString();
    }

    public void validate(String str, char c) {
    }

    public MapMessage(int i5) {
        this.data = new SortedArrayStringMap(i5);
    }

    public void validate(String str, double d) {
    }

    public void validate(String str, float f6) {
    }

    public M with(String str, byte b) {
        String key = toKey(str);
        validate(key, b);
        this.data.putValue(key, Byte.valueOf(b));
        return this;
    }

    public MapMessage(Map<String, V> map) {
        this.data = new SortedArrayStringMap((Map<String, ?>) map);
    }

    public void validate(String str, int i5) {
    }

    public void validate(String str, long j6) {
    }

    public void validate(String str, Object obj) {
    }

    public M with(String str, char c) {
        String key = toKey(str);
        validate(key, c);
        this.data.putValue(key, Character.valueOf(c));
        return this;
    }

    public void validate(String str, String str2) {
    }

    public void validate(String str, short s6) {
    }

    public void validate(String str, boolean z6) {
    }

    public M with(String str, double d) {
        String key = toKey(str);
        validate(key, d);
        this.data.putValue(key, Double.valueOf(d));
        return this;
    }

    public M with(String str, float f6) {
        String key = toKey(str);
        validate(key, f6);
        this.data.putValue(key, Float.valueOf(f6));
        return this;
    }

    public M with(String str, int i5) {
        String key = toKey(str);
        validate(key, i5);
        this.data.putValue(key, Integer.valueOf(i5));
        return this;
    }

    public M with(String str, long j6) {
        String key = toKey(str);
        validate(key, j6);
        this.data.putValue(key, Long.valueOf(j6));
        return this;
    }

    public M with(String str, Object obj) {
        String key = toKey(str);
        validate(key, obj);
        this.data.putValue(key, obj);
        return this;
    }

    public M with(String str, short s6) {
        String key = toKey(str);
        validate(key, s6);
        this.data.putValue(key, Short.valueOf(s6));
        return this;
    }

    public String toKey(String str) {
        return str;
    }

    public M with(String str, String str2) {
        put(toKey(str), str2);
        return this;
    }
}
