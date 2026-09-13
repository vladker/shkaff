package org.apache.xmlbeans;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface SimpleValue extends XmlObject {
    BigDecimal getBigDecimalValue();

    BigInteger getBigIntegerValue();

    boolean getBooleanValue();

    byte[] getByteArrayValue();

    byte getByteValue();

    Calendar getCalendarValue();

    Date getDateValue();

    double getDoubleValue();

    StringEnumAbstractBase getEnumValue();

    float getFloatValue();

    GDate getGDateValue();

    GDuration getGDurationValue();

    int getIntValue();

    List<?> getListValue();

    long getLongValue();

    Object getObjectValue();

    QName getQNameValue();

    short getShortValue();

    String getStringValue();

    SchemaType instanceType();

    void setBigDecimalValue(BigDecimal bigDecimal);

    void setBigIntegerValue(BigInteger bigInteger);

    void setBooleanValue(boolean z6);

    void setByteArrayValue(byte[] bArr);

    void setByteValue(byte b);

    void setCalendarValue(Calendar calendar);

    void setDateValue(Date date);

    void setDoubleValue(double d);

    void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase);

    void setFloatValue(float f6);

    void setGDateValue(GDate gDate);

    void setGDurationValue(GDuration gDuration);

    void setIntValue(int i5);

    void setListValue(List<?> list);

    void setLongValue(long j6);

    void setObjectValue(Object obj);

    void setQNameValue(QName qName);

    void setShortValue(short s6);

    void setStringValue(String str);

    List<? extends XmlAnySimpleType> xgetListValue();
}
