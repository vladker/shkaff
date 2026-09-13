package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlFloat extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlFloat> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlFloat> xmlObjectFactory = new XmlObjectFactory<>("_BI_float");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    float getFloatValue();

    void setFloatValue(float f6);
}
