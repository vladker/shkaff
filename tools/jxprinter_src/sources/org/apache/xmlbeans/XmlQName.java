package org.apache.xmlbeans;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlQName extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlQName> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlQName> xmlObjectFactory = new XmlObjectFactory<>("_BI_QName");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    QName getQNameValue();

    void setQNameValue(QName qName);
}
