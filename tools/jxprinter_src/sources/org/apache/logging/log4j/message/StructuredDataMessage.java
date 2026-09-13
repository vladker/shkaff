package org.apache.logging.log4j.message;

import java.util.Map;
import org.apache.logging.log4j.util.Chars;
import org.apache.logging.log4j.util.EnglishEnums;
import org.apache.logging.log4j.util.StringBuilders;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@AsynchronouslyFormattable
public class StructuredDataMessage extends MapMessage<StructuredDataMessage, String> {
    private static final int HASHVAL = 31;
    private static final int MAX_LENGTH = 32;
    private static final long serialVersionUID = 1703221292892071920L;
    private StructuredDataId id;
    private final int maxLength;
    private String message;
    private String type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Format {
        XML,
        FULL
    }

    public StructuredDataMessage(String str, String str2, String str3) {
        this(str, str2, str3, 32);
    }

    private void asXml(StructuredDataId structuredDataId, StringBuilder sb) {
        sb.append("<StructuredData>\n");
        sb.append("<type>");
        sb.append(this.type);
        sb.append("</type>\n");
        sb.append("<id>");
        sb.append(structuredDataId);
        sb.append("</id>\n");
        super.asXml(sb);
        sb.append("\n</StructuredData>\n");
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String asString() {
        return asString(Format.FULL, null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        StructuredDataMessage structuredDataMessage = (StructuredDataMessage) obj;
        if (!super.equals(obj)) {
            return false;
        }
        String str = this.type;
        if (str == null ? structuredDataMessage.type != null : !str.equals(structuredDataMessage.type)) {
            return false;
        }
        StructuredDataId structuredDataId = this.id;
        if (structuredDataId == null ? structuredDataMessage.id != null : !structuredDataId.equals(structuredDataMessage.id)) {
            return false;
        }
        String str2 = this.message;
        return str2 == null ? structuredDataMessage.message == null : str2.equals(structuredDataMessage.message);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.util.StringBuilderFormattable
    public void formatTo(StringBuilder sb) {
        asString(Format.FULL, null, sb);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.Message
    public String getFormat() {
        return this.message;
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.MultiformatMessage
    public String[] getFormats() {
        String[] strArr = new String[Format.values().length];
        Format[] formatArrValues = Format.values();
        int length = formatArrValues.length;
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            strArr[i6] = formatArrValues[i5].name();
            i5++;
            i6++;
        }
        return strArr;
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.Message
    public String getFormattedMessage() {
        return asString(Format.FULL, null);
    }

    public StructuredDataId getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.type;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        StructuredDataId structuredDataId = this.id;
        int iHashCode3 = (iHashCode2 + (structuredDataId != null ? structuredDataId.hashCode() : 0)) * 31;
        String str2 = this.message;
        return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    public void setId(String str) {
        this.id = new StructuredDataId(str, null, null);
    }

    public void setMessageFormat(String str) {
        this.message = str;
    }

    public void setType(String str) {
        if (str.length() > 32) {
            throw new IllegalArgumentException("structured data type exceeds maximum length of 32 characters: ".concat(str));
        }
        this.type = str;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String toString() {
        return asString(null, null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, boolean z6) {
        validateKey(str);
    }

    public void validateKey(String str) {
        if (this.maxLength > 0 && str.length() > this.maxLength) {
            throw new IllegalArgumentException("Structured data keys are limited to " + this.maxLength + " characters. key: " + str);
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < '!' || cCharAt > '~' || cCharAt == '=' || cCharAt == ']' || cCharAt == '\"') {
                throw new IllegalArgumentException("Structured data keys must contain printable US ASCII charactersand may not contain a space, =, ], or \"");
            }
        }
    }

    public StructuredDataMessage(String str, String str2, String str3, int i5) {
        this.id = new StructuredDataId(str, (String[]) null, (String[]) null, i5);
        this.message = str2;
        this.type = str3;
        this.maxLength = i5;
    }

    private Format getFormat(String[] strArr) {
        if (strArr == null || strArr.length <= 0) {
            return Format.FULL;
        }
        for (String str : strArr) {
            Format format = Format.XML;
            if (format.name().equalsIgnoreCase(str)) {
                return format;
            }
            Format format2 = Format.FULL;
            if (format2.name().equalsIgnoreCase(str)) {
                return format2;
            }
        }
        return null;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public String asString(String str) {
        try {
            return asString((Format) EnglishEnums.valueOf(Format.class, str), null);
        } catch (IllegalArgumentException unused) {
            return asString();
        }
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.util.MultiFormatStringBuilderFormattable
    public void formatTo(String[] strArr, StringBuilder sb) {
        asString(getFormat(strArr), null, sb);
    }

    @Override // org.apache.logging.log4j.message.MapMessage, org.apache.logging.log4j.message.MultiformatMessage
    public String getFormattedMessage(String[] strArr) {
        return asString(getFormat(strArr), null);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public StructuredDataMessage newInstance(Map<String, String> map) {
        return new StructuredDataMessage(this, map);
    }

    public void setId(StructuredDataId structuredDataId) {
        this.id = structuredDataId;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, byte b) {
        validateKey(str);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, char c) {
        validateKey(str);
    }

    public final String asString(Format format, StructuredDataId structuredDataId) {
        StringBuilder sb = new StringBuilder();
        asString(format, structuredDataId, sb);
        return sb.toString();
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, double d) {
        validateKey(str);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, float f6) {
        validateKey(str);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, int i5) {
        validateKey(str);
    }

    public StructuredDataMessage(String str, String str2, String str3, Map<String, String> map) {
        this(str, str2, str3, map, 32);
    }

    public final void asString(Format format, StructuredDataId structuredDataId, StringBuilder sb) {
        String format2;
        boolean zEquals = Format.FULL.equals(format);
        if (zEquals) {
            if (getType() == null) {
                return;
            }
            sb.append(getType());
            sb.append(Chars.SPACE);
        }
        StructuredDataId id = getId();
        if (id != null) {
            structuredDataId = id.makeId(structuredDataId);
        }
        if (structuredDataId == null || structuredDataId.getName() == null) {
            return;
        }
        if (Format.XML.equals(format)) {
            asXml(structuredDataId, sb);
            return;
        }
        sb.append('[');
        StringBuilders.appendValue(sb, structuredDataId);
        sb.append(Chars.SPACE);
        appendMap(sb);
        sb.append(']');
        if (!zEquals || (format2 = getFormat()) == null) {
            return;
        }
        sb.append(Chars.SPACE);
        sb.append(format2);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, long j6) {
        validateKey(str);
    }

    public StructuredDataMessage(String str, String str2, String str3, Map<String, String> map, int i5) {
        super(map);
        this.id = new StructuredDataId(str, (String[]) null, (String[]) null, i5);
        this.message = str2;
        this.type = str3;
        this.maxLength = i5;
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, Object obj) {
        validateKey(str);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, short s6) {
        validateKey(str);
    }

    @Override // org.apache.logging.log4j.message.MapMessage
    public void validate(String str, String str2) {
        validateKey(str);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2) {
        this(structuredDataId, str, str2, 32);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, int i5) {
        this.id = structuredDataId;
        this.message = str;
        this.type = str2;
        this.maxLength = i5;
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, Map<String, String> map) {
        this(structuredDataId, str, str2, map, 32);
    }

    public StructuredDataMessage(StructuredDataId structuredDataId, String str, String str2, Map<String, String> map, int i5) {
        super(map);
        this.id = structuredDataId;
        this.message = str;
        this.type = str2;
        this.maxLength = i5;
    }

    private StructuredDataMessage(StructuredDataMessage structuredDataMessage, Map<String, String> map) {
        super(map);
        this.id = structuredDataMessage.id;
        this.message = structuredDataMessage.message;
        this.type = structuredDataMessage.type;
        this.maxLength = 32;
    }

    public StructuredDataMessage() {
        this.maxLength = 32;
    }
}
