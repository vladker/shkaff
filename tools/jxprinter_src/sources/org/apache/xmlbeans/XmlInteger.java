package org.apache.xmlbeans;

import java.math.BigInteger;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlInteger extends XmlDecimal {
    public static final XmlObjectFactory<XmlInteger> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlInteger> xmlObjectFactory = new XmlObjectFactory<>("_BI_integer");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    BigInteger getBigIntegerValue();

    void setBigIntegerValue(BigInteger bigInteger);
}
