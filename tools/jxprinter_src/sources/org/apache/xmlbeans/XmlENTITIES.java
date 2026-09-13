package org.apache.xmlbeans;

import java.util.List;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlENTITIES extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlENTITIES> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlENTITIES> xmlObjectFactory = new XmlObjectFactory<>("_BI_ENTITIES");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    List<?> getListValue();

    void setListValue(List<?> list);

    List<? extends XmlAnySimpleType> xgetListValue();
}
