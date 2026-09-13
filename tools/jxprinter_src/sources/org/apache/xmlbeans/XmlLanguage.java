package org.apache.xmlbeans;

import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlLanguage extends XmlToken {
    public static final XmlObjectFactory<XmlLanguage> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlLanguage> xmlObjectFactory = new XmlObjectFactory<>("_BI_language");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }
}
