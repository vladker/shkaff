package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlUnsignedByte extends XmlUnsignedShort {
    public static final XmlObjectFactory<XmlUnsignedByte> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlUnsignedByte> xmlObjectFactory = new XmlObjectFactory<>("_BI_unsignedByte");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    short getShortValue();

    void setShortValue(short s6);
}
