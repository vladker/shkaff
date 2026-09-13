package org.apache.poi.openxml4j.opc.internal;

import A3.AbstractC0157z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.util.Chars;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class ContentType {
    private final Map<String, String> parameters;
    private final String subType;
    private final String type;
    private static final Pattern patternTypeSubType = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)$");
    private static final Pattern patternTypeSubTypeParams = Pattern.compile("^([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)/([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)(;([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+\"?))*$");
    private static final Pattern patternParams = Pattern.compile(";([\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+)=(\"?[\\x21-\\x7E&&[^()<>@,;:\\\\/\"\\[\\]?={}\\x20\\x09]]+\"?)");

    public ContentType(String str) throws InvalidFormatException {
        Matcher matcher = patternTypeSubType.matcher(str);
        matcher = matcher.matches() ? matcher : patternTypeSubTypeParams.matcher(str);
        if (!matcher.matches()) {
            throw new InvalidFormatException(AbstractC0157z.o("The specified content type '", str, "' is not compliant with RFC 2616: malformed content type."));
        }
        if (matcher.groupCount() < 2) {
            this.type = "";
            this.subType = "";
            this.parameters = Collections.EMPTY_MAP;
            return;
        }
        this.type = matcher.group(1);
        this.subType = matcher.group(2);
        this.parameters = new HashMap();
        if (matcher.groupCount() >= 5) {
            Matcher matcher2 = patternParams.matcher(str.substring(matcher.end(2)));
            while (matcher2.find()) {
                this.parameters.put(matcher2.group(1), matcher2.group(2));
            }
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof ContentType) || toString().equalsIgnoreCase(obj.toString());
    }

    public String getParameter(String str) {
        return this.parameters.get(str);
    }

    public String[] getParameterKeys() {
        Map<String, String> map = this.parameters;
        return map == null ? new String[0] : (String[]) map.keySet().toArray(new String[0]);
    }

    public String getSubType() {
        return this.subType;
    }

    public String getType() {
        return this.type;
    }

    public boolean hasParameters() {
        Map<String, String> map = this.parameters;
        return (map == null || map.isEmpty()) ? false : true;
    }

    public int hashCode() {
        return Objects.hash(this.type, this.subType, this.parameters);
    }

    public final String toString() {
        return toString(true);
    }

    public final String toString(boolean z6) {
        StringBuilder sb = new StringBuilder(64);
        sb.append(getType());
        sb.append('/');
        sb.append(getSubType());
        if (z6) {
            for (Map.Entry<String, String> entry : this.parameters.entrySet()) {
                sb.append(';');
                sb.append(entry.getKey());
                sb.append(Chars.EQ);
                sb.append(entry.getValue());
            }
        }
        return sb.toString();
    }
}
