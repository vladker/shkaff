package org.apache.xmlbeans;

import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.util.Chars;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlOptionCharEscapeMap {
    public static final int DECIMAL = 1;
    public static final int HEXADECIMAL = 2;
    public static final int PREDEF_ENTITY = 0;
    private static final Map<Character, String> _predefEntities;
    private final Map<Character, String> _charMap = new HashMap();

    static {
        HashMap map = new HashMap();
        _predefEntities = map;
        map.put('<', "&lt;");
        map.put('>', "&gt;");
        map.put('&', "&amp;");
        map.put(Character.valueOf(Chars.QUOTE), "&apos;");
        map.put(Character.valueOf(Chars.DQUOTE), "&quot;");
    }

    public void addMapping(char c, int i5) throws XmlException {
        Character chValueOf = Character.valueOf(c);
        if (i5 == 0) {
            String str = _predefEntities.get(chValueOf);
            if (str == null) {
                throw new XmlException("XmlOptionCharEscapeMap.addMapping(): the PREDEF_ENTITY mode can only be used for the following characters: <, >, &, \" and '");
            }
            this._charMap.put(chValueOf, str);
            return;
        }
        if (i5 == 1) {
            this._charMap.put(chValueOf, "&#" + ((int) c) + ";");
            return;
        }
        if (i5 != 2) {
            throw new XmlException("XmlOptionCharEscapeMap.addMapping(): mode must be PREDEF_ENTITY, DECIMAL or HEXADECIMAL");
        }
        String hexString = Integer.toHexString(c);
        this._charMap.put(chValueOf, "&#x" + hexString + ";");
    }

    public void addMappings(char c, char c6, int i5) throws XmlException {
        if (c > c6) {
            throw new XmlException("XmlOptionCharEscapeMap.addMappings(): ch1 must be <= ch2");
        }
        while (c <= c6) {
            addMapping(c, i5);
            c = (char) (c + 1);
        }
    }

    public boolean containsChar(char c) {
        return this._charMap.containsKey(Character.valueOf(c));
    }

    public String getEscapedString(char c) {
        return this._charMap.get(Character.valueOf(c));
    }
}
