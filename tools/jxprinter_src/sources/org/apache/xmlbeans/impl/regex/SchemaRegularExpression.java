package org.apache.xmlbeans.impl.regex;

import java.util.HashMap;
import java.util.Map;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaRegularExpression extends RegularExpression {
    static final Map<String, SchemaRegularExpression> knownPatterns = buildKnownPatternMap();

    private static Map<String, SchemaRegularExpression> buildKnownPatternMap() {
        HashMap map = new HashMap();
        map.put("\\c+", new SchemaRegularExpression("\\c+") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.1
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNmtoken(str);
            }
        });
        map.put("\\i\\c*", new SchemaRegularExpression("\\i\\c*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.2
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidName(str);
            }
        });
        map.put("[\\i-[:]][\\c-[:]]*", new SchemaRegularExpression("[\\i-[:]][\\c-[:]]*") { // from class: org.apache.xmlbeans.impl.regex.SchemaRegularExpression.3
            @Override // org.apache.xmlbeans.impl.regex.RegularExpression
            public boolean matches(String str) {
                return XMLChar.isValidNCName(str);
            }
        });
        return map;
    }

    public static RegularExpression forPattern(String str) {
        SchemaRegularExpression schemaRegularExpression = knownPatterns.get(str);
        return schemaRegularExpression != null ? schemaRegularExpression : new RegularExpression(str, "X");
    }

    private SchemaRegularExpression(String str) {
        super(str, "X");
    }
}
