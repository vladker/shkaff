package org.apache.xmlbeans.impl.richParser;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlCalendar;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface XMLStreamReaderExt extends XMLStreamReader {
    public static final int WS_COLLAPSE = 3;
    public static final int WS_PRESERVE = 1;
    public static final int WS_REPLACE = 2;

    InputStream getAttributeBase64Value(int i5);

    InputStream getAttributeBase64Value(String str, String str2);

    BigDecimal getAttributeBigDecimalValue(int i5);

    BigDecimal getAttributeBigDecimalValue(String str, String str2);

    BigInteger getAttributeBigIntegerValue(int i5);

    BigInteger getAttributeBigIntegerValue(String str, String str2);

    boolean getAttributeBooleanValue(int i5);

    boolean getAttributeBooleanValue(String str, String str2);

    byte getAttributeByteValue(int i5);

    byte getAttributeByteValue(String str, String str2);

    XmlCalendar getAttributeCalendarValue(int i5);

    XmlCalendar getAttributeCalendarValue(String str, String str2);

    Date getAttributeDateValue(int i5);

    Date getAttributeDateValue(String str, String str2);

    double getAttributeDoubleValue(int i5);

    double getAttributeDoubleValue(String str, String str2);

    float getAttributeFloatValue(int i5);

    float getAttributeFloatValue(String str, String str2);

    GDate getAttributeGDateValue(int i5);

    GDate getAttributeGDateValue(String str, String str2);

    GDuration getAttributeGDurationValue(int i5);

    GDuration getAttributeGDurationValue(String str, String str2);

    InputStream getAttributeHexBinaryValue(int i5);

    InputStream getAttributeHexBinaryValue(String str, String str2);

    int getAttributeIntValue(int i5);

    int getAttributeIntValue(String str, String str2);

    long getAttributeLongValue(int i5);

    long getAttributeLongValue(String str, String str2);

    QName getAttributeQNameValue(int i5);

    QName getAttributeQNameValue(String str, String str2);

    short getAttributeShortValue(int i5);

    short getAttributeShortValue(String str, String str2);

    String getAttributeStringValue(int i5);

    String getAttributeStringValue(int i5, int i6);

    String getAttributeStringValue(String str, String str2);

    String getAttributeStringValue(String str, String str2, int i5);

    InputStream getBase64Value();

    BigDecimal getBigDecimalValue();

    BigInteger getBigIntegerValue();

    boolean getBooleanValue();

    byte getByteValue();

    XmlCalendar getCalendarValue();

    Date getDateValue();

    double getDoubleValue();

    float getFloatValue();

    GDate getGDateValue();

    GDuration getGDurationValue();

    InputStream getHexBinaryValue();

    int getIntValue();

    long getLongValue();

    QName getQNameValue();

    short getShortValue();

    String getStringValue();

    String getStringValue(int i5);

    void setDefaultValue(String str);
}
