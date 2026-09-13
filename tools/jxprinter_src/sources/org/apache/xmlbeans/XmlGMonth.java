package org.apache.xmlbeans;

import java.util.Calendar;
import org.apache.xmlbeans.impl.schema.XmlObjectFactory;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XmlGMonth extends XmlAnySimpleType {
    public static final XmlObjectFactory<XmlGMonth> Factory;
    public static final SchemaType type;

    static {
        XmlObjectFactory<XmlGMonth> xmlObjectFactory = new XmlObjectFactory<>("_BI_gMonth");
        Factory = xmlObjectFactory;
        type = xmlObjectFactory.getType();
    }

    Calendar getCalendarValue();

    GDate getGDateValue();

    int getIntValue();

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    void setIntValue(int i5);
}
