package org.apache.xmlbeans.impl.values;

import org.apache.xmlbeans.XmlError;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlValueOutOfRangeException extends IllegalArgumentException {
    public XmlValueOutOfRangeException() {
    }

    public XmlValueOutOfRangeException(String str) {
        super(str);
    }

    public XmlValueOutOfRangeException(String str, Object[] objArr) {
        super(XmlError.formattedMessage(str, objArr));
    }
}
