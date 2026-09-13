package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlErrorCodes;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.impl.common.ValidationContext;
import org.apache.xmlbeans.impl.common.XMLChar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlNmTokenImpl extends JavaStringHolderEx implements XmlNMTOKEN {
    public XmlNmTokenImpl() {
        super(XmlNMTOKEN.type, false);
    }

    public static void validateLexical(String str, ValidationContext validationContext) {
        if (XMLChar.isValidNmtoken(str)) {
            return;
        }
        validationContext.invalid(XmlErrorCodes.NMTOKEN, new Object[]{str});
    }

    public XmlNmTokenImpl(SchemaType schemaType, boolean z6) {
        super(schemaType, z6);
    }
}
