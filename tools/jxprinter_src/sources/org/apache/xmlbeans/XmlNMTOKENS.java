package org.apache.xmlbeans;

import java.util.List;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlNMTOKENS extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlNMTOKENS> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlNMTOKENS> xmlObjectFactory = new XmlObjectFactory<>("_BI_NMTOKENS");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    List<?> getListValue();

    void setListValue(List<?> list);

    List<? extends XmlAnySimpleType> xgetListValue();
}
