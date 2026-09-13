package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.ext.LexicalHandler;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class FilterXmlObject implements XmlObject, SimpleValue, DelegateXmlObject {
    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject changeType(SchemaType schemaType) {
        return underlyingXmlObject().changeType(schemaType);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int compareTo(Object obj) {
        return underlyingXmlObject().compareTo(obj);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int compareValue(XmlObject xmlObject) {
        return underlyingXmlObject().compareValue(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject copy() {
        return underlyingXmlObject().copy();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlDocumentProperties documentProperties() {
        return underlyingXmlObject().documentProperties();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str) {
        return underlyingXmlObject().execQuery(str);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigDecimal getBigDecimalValue() {
        return ((SimpleValue) underlyingXmlObject()).getBigDecimalValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public BigInteger getBigIntegerValue() {
        return ((SimpleValue) underlyingXmlObject()).getBigIntegerValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public boolean getBooleanValue() {
        return ((SimpleValue) underlyingXmlObject()).getBooleanValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte[] getByteArrayValue() {
        return ((SimpleValue) underlyingXmlObject()).getByteArrayValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public byte getByteValue() {
        return ((SimpleValue) underlyingXmlObject()).getByteValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Calendar getCalendarValue() {
        return ((SimpleValue) underlyingXmlObject()).getCalendarValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Date getDateValue() {
        return ((SimpleValue) underlyingXmlObject()).getDateValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node getDomNode() {
        return underlyingXmlObject().getDomNode();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public double getDoubleValue() {
        return ((SimpleValue) underlyingXmlObject()).getDoubleValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public StringEnumAbstractBase getEnumValue() {
        return ((SimpleValue) underlyingXmlObject()).getEnumValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public float getFloatValue() {
        return ((SimpleValue) underlyingXmlObject()).getFloatValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDate getGDateValue() {
        return ((SimpleValue) underlyingXmlObject()).getGDateValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public GDuration getGDurationValue() {
        return ((SimpleValue) underlyingXmlObject()).getGDurationValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public int getIntValue() {
        return ((SimpleValue) underlyingXmlObject()).getIntValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List<?> getListValue() {
        return ((SimpleValue) underlyingXmlObject()).getListValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public long getLongValue() {
        return ((SimpleValue) underlyingXmlObject()).getLongValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public Object getObjectValue() {
        return ((SimpleValue) underlyingXmlObject()).getObjectValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public QName getQNameValue() {
        return ((SimpleValue) underlyingXmlObject()).getQNameValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public short getShortValue() {
        return ((SimpleValue) underlyingXmlObject()).getShortValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public String getStringValue() {
        return ((SimpleValue) underlyingXmlObject()).getStringValue();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public SchemaType instanceType() {
        return ((SimpleValue) underlyingXmlObject()).instanceType();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isImmutable() {
        return underlyingXmlObject().isImmutable();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean isNil() {
        return underlyingXmlObject().isNil();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Object monitor() {
        return underlyingXmlObject().monitor();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XmlCursor newCursor() {
        return underlyingXmlObject().newCursor();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode() {
        return underlyingXmlObject().newDomNode();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream() {
        return underlyingXmlObject().newInputStream();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader() {
        return underlyingXmlObject().newReader();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader() {
        return underlyingXmlObject().newXMLStreamReader();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler) {
        underlyingXmlObject().save(contentHandler, lexicalHandler);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return underlyingXmlObject().schemaType();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(QName qName) {
        return underlyingXmlObject().selectAttribute(qName);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectAttributes(QNameSet qNameSet) {
        return underlyingXmlObject().selectAttributes(qNameSet);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QName qName) {
        return underlyingXmlObject().selectChildren(qName);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str) {
        return underlyingXmlObject().selectPath(str);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject set(XmlObject xmlObject) {
        return underlyingXmlObject().set(xmlObject);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBigDecimalValue(BigDecimal bigDecimal) {
        ((SimpleValue) underlyingXmlObject()).setBigDecimalValue(bigDecimal);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBigIntegerValue(BigInteger bigInteger) {
        ((SimpleValue) underlyingXmlObject()).setBigIntegerValue(bigInteger);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setBooleanValue(boolean z6) {
        ((SimpleValue) underlyingXmlObject()).setBooleanValue(z6);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setByteArrayValue(byte[] bArr) {
        ((SimpleValue) underlyingXmlObject()).setByteArrayValue(bArr);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setByteValue(byte b) {
        ((SimpleValue) underlyingXmlObject()).setByteValue(b);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setCalendarValue(Calendar calendar) {
        ((SimpleValue) underlyingXmlObject()).setCalendarValue(calendar);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setDateValue(Date date) {
        ((SimpleValue) underlyingXmlObject()).setDateValue(date);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setDoubleValue(double d) {
        ((SimpleValue) underlyingXmlObject()).setDoubleValue(d);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setEnumValue(StringEnumAbstractBase stringEnumAbstractBase) {
        ((SimpleValue) underlyingXmlObject()).setEnumValue(stringEnumAbstractBase);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setFloatValue(float f6) {
        ((SimpleValue) underlyingXmlObject()).setFloatValue(f6);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setGDateValue(GDate gDate) {
        ((SimpleValue) underlyingXmlObject()).setGDateValue(gDate);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setGDurationValue(GDuration gDuration) {
        ((SimpleValue) underlyingXmlObject()).setGDurationValue(gDuration);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setIntValue(int i5) {
        ((SimpleValue) underlyingXmlObject()).setIntValue(i5);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setListValue(List<?> list) {
        ((SimpleValue) underlyingXmlObject()).setListValue(list);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setLongValue(long j6) {
        ((SimpleValue) underlyingXmlObject()).setLongValue(j6);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public void setNil() {
        underlyingXmlObject().setNil();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setObjectValue(Object obj) {
        ((SimpleValue) underlyingXmlObject()).setObjectValue(obj);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setQNameValue(QName qName) {
        ((SimpleValue) underlyingXmlObject()).setQNameValue(qName);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setShortValue(short s6) {
        ((SimpleValue) underlyingXmlObject()).setShortValue(s6);
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public void setStringValue(String str) {
        ((SimpleValue) underlyingXmlObject()).setStringValue(str);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate() {
        return underlyingXmlObject().validate();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean valueEquals(XmlObject xmlObject) {
        return underlyingXmlObject().valueEquals(xmlObject);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public int valueHashCode() {
        return underlyingXmlObject().valueHashCode();
    }

    @Override // org.apache.xmlbeans.SimpleValue
    public List<? extends XmlAnySimpleType> xgetListValue() {
        return ((SimpleValue) underlyingXmlObject()).xgetListValue();
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText() {
        return underlyingXmlObject().xmlText();
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject copy(XmlOptions xmlOptions) {
        return underlyingXmlObject().copy(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] execQuery(String str, XmlOptions xmlOptions) {
        return underlyingXmlObject().execQuery(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Node newDomNode(XmlOptions xmlOptions) {
        return underlyingXmlObject().newDomNode(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public InputStream newInputStream(XmlOptions xmlOptions) {
        return underlyingXmlObject().newInputStream(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public Reader newReader(XmlOptions xmlOptions) {
        return underlyingXmlObject().newReader(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public XMLStreamReader newXMLStreamReader(XmlOptions xmlOptions) {
        return underlyingXmlObject().newXMLStreamReader(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file) {
        underlyingXmlObject().save(file);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject selectAttribute(String str, String str2) {
        return underlyingXmlObject().selectAttribute(str, str2);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(String str, String str2) {
        return underlyingXmlObject().selectChildren(str, str2);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectPath(String str, XmlOptions xmlOptions) {
        return underlyingXmlObject().selectPath(str, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public boolean validate(XmlOptions xmlOptions) {
        return underlyingXmlObject().validate(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public String xmlText(XmlOptions xmlOptions) {
        return underlyingXmlObject().xmlText(xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream) {
        underlyingXmlObject().save(outputStream);
    }

    @Override // org.apache.xmlbeans.XmlObject
    public XmlObject[] selectChildren(QNameSet qNameSet) {
        return underlyingXmlObject().selectChildren(qNameSet);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer) {
        underlyingXmlObject().save(writer);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(ContentHandler contentHandler, LexicalHandler lexicalHandler, XmlOptions xmlOptions) {
        underlyingXmlObject().save(contentHandler, lexicalHandler, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(File file, XmlOptions xmlOptions) {
        underlyingXmlObject().save(file, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(OutputStream outputStream, XmlOptions xmlOptions) {
        underlyingXmlObject().save(outputStream, xmlOptions);
    }

    @Override // org.apache.xmlbeans.XmlTokenSource
    public void save(Writer writer, XmlOptions xmlOptions) {
        underlyingXmlObject().save(writer, xmlOptions);
    }
}
