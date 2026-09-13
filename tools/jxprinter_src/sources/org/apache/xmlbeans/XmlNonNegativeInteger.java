package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlNonNegativeInteger extends XmlInteger {
    public static final XmlObjectFactory<XmlNonNegativeInteger> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlNonNegativeInteger> xmlObjectFactory = new XmlObjectFactory<>("_BI_nonNegativeInteger");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }
}
