package org.apache.xmlbeans.impl.richParser;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.XMLChar;
import org.apache.xmlbeans.impl.common.XmlWhitespace;
import org.apache.xmlbeans.impl.util.HexBin;
import org.apache.xmlbeans.impl.util.XsTypeConverter;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XMLStreamReaderExtImpl implements XMLStreamReaderExt {
    private final CharSeqTrimWS _charSeq;
    private String _defaultValue;
    private final XMLStreamReader _xmlStream;

    public XMLStreamReaderExtImpl(XMLStreamReader xMLStreamReader) {
        if (xMLStreamReader == null) {
            throw new IllegalArgumentException();
        }
        this._xmlStream = xMLStreamReader;
        this._charSeq = new CharSeqTrimWS(this);
    }

    public void close() {
        this._xmlStream.close();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeBase64Value(int i5) {
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.reloadAtt(i5, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getAttributeBigDecimalValue(int i5) {
        try {
            return XsTypeConverter.lexDecimal(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getAttributeBigIntegerValue(int i5) {
        try {
            return XsTypeConverter.lexInteger(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getAttributeBooleanValue(int i5) {
        try {
            return XsTypeConverter.lexBoolean(this._charSeq.reloadAtt(i5, 2));
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getAttributeByteValue(int i5) {
        try {
            return XsTypeConverter.lexByte(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getAttributeCalendarValue(int i5) {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(i5, 2)).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public int getAttributeCount() {
        return this._xmlStream.getAttributeCount();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getAttributeDateValue(int i5) {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(i5, 2)).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getAttributeDoubleValue(int i5) {
        try {
            return XsTypeConverter.lexDouble(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getAttributeFloatValue(int i5) {
        try {
            return XsTypeConverter.lexFloat(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getAttributeGDateValue(int i5) {
        try {
            return new GDate(this._charSeq.reloadAtt(i5, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getAttributeGDurationValue(int i5) {
        try {
            return new GDuration(this._charSeq.reloadAtt(i5, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeHexBinaryValue(int i5) {
        byte[] bArrDecode = HexBin.decode(this._charSeq.reloadAtt(i5, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getAttributeIntValue(int i5) {
        try {
            return XsTypeConverter.lexInt(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public String getAttributeLocalName(int i5) {
        return this._xmlStream.getAttributeLocalName(i5);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getAttributeLongValue(int i5) {
        try {
            return XsTypeConverter.lexLong(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public QName getAttributeName(int i5) {
        return this._xmlStream.getAttributeName(i5);
    }

    public String getAttributeNamespace(int i5) {
        return this._xmlStream.getAttributeNamespace(i5);
    }

    public String getAttributePrefix(int i5) {
        return this._xmlStream.getAttributePrefix(i5);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getAttributeQNameValue(int i5) {
        try {
            return XsTypeConverter.lexQName(this._charSeq.reloadAtt(i5, 2), this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getAttributeShortValue(int i5) {
        try {
            return XsTypeConverter.lexShort(this._charSeq.reloadAtt(i5, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(int i5) {
        return this._xmlStream.getAttributeValue(i5);
    }

    public String getAttributeType(int i5) {
        return this._xmlStream.getAttributeType(i5);
    }

    public String getAttributeValue(String str, String str2) {
        return this._xmlStream.getAttributeValue(str, str2);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getBase64Value() throws XMLStreamException {
        this._charSeq.reload(2);
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getBigDecimalValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexDecimal(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getBigIntegerValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexInteger(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getBooleanValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexBoolean(this._charSeq);
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getByteValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexByte(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getCalendarValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDateBuilder(this._charSeq).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public String getCharacterEncodingScheme() {
        return this._xmlStream.getCharacterEncodingScheme();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getDateValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDateBuilder(this._charSeq).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getDoubleValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexDouble(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public String getElementText() {
        return this._xmlStream.getElementText();
    }

    public String getEncoding() {
        return this._xmlStream.getEncoding();
    }

    public int getEventType() {
        return this._xmlStream.getEventType();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getFloatValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexFloat(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getGDateValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexGDate(this._charSeq);
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getGDurationValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return new GDuration(this._charSeq);
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getHexBinaryValue() throws XMLStreamException {
        this._charSeq.reload(2);
        byte[] bArrDecode = HexBin.decode(this._charSeq.toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getIntValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexInt(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public String getLocalName() {
        return this._xmlStream.getLocalName();
    }

    public Location getLocation() {
        return this._xmlStream.getLocation();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getLongValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexLong(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    public QName getName() {
        return this._xmlStream.getName();
    }

    public NamespaceContext getNamespaceContext() {
        return this._xmlStream.getNamespaceContext();
    }

    public int getNamespaceCount() {
        return this._xmlStream.getNamespaceCount();
    }

    public String getNamespacePrefix(int i5) {
        return this._xmlStream.getNamespacePrefix(i5);
    }

    public String getNamespaceURI(String str) {
        return this._xmlStream.getNamespaceURI(str);
    }

    public String getPIData() {
        return this._xmlStream.getPIData();
    }

    public String getPITarget() {
        return this._xmlStream.getPITarget();
    }

    public String getPrefix() {
        return this._xmlStream.getPrefix();
    }

    public Object getProperty(String str) {
        return this._xmlStream.getProperty(str);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getQNameValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexQName(this._charSeq, this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getShortValue() throws XMLStreamException {
        this._charSeq.reload(2);
        try {
            return XsTypeConverter.lexShort(this._charSeq);
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getStringValue() throws XMLStreamException {
        this._charSeq.reload(1);
        return this._charSeq.toString();
    }

    public String getText() {
        return this._xmlStream.getText();
    }

    public char[] getTextCharacters() {
        return this._xmlStream.getTextCharacters();
    }

    public int getTextLength() {
        return this._xmlStream.getTextLength();
    }

    public int getTextStart() {
        return this._xmlStream.getTextStart();
    }

    public XMLStreamReader getUnderlyingXmlStream() {
        return this._xmlStream;
    }

    public String getVersion() {
        return this._xmlStream.getVersion();
    }

    public boolean hasName() {
        return this._xmlStream.hasName();
    }

    public boolean hasNext() {
        return this._xmlStream.hasNext();
    }

    public boolean hasText() {
        return this._xmlStream.hasText();
    }

    public boolean isAttributeSpecified(int i5) {
        return this._xmlStream.isAttributeSpecified(i5);
    }

    public boolean isCharacters() {
        return this._xmlStream.isCharacters();
    }

    public boolean isEndElement() {
        return this._xmlStream.isEndElement();
    }

    public boolean isStandalone() {
        return this._xmlStream.isStandalone();
    }

    public boolean isStartElement() {
        return this._xmlStream.isStartElement();
    }

    public boolean isWhiteSpace() {
        return this._xmlStream.isWhiteSpace();
    }

    public int next() {
        return this._xmlStream.next();
    }

    public int nextTag() {
        return this._xmlStream.nextTag();
    }

    public void require(int i5, String str, String str2) {
        this._xmlStream.require(i5, str, str2);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public void setDefaultValue(String str) {
        this._defaultValue = str;
    }

    public boolean standaloneSet() {
        return this._xmlStream.standaloneSet();
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(int i5, int i6) {
        return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(i5), i6);
    }

    public String getAttributeValue(int i5) {
        return this._xmlStream.getAttributeValue(i5);
    }

    public String getNamespaceURI(int i5) {
        return this._xmlStream.getNamespaceURI(i5);
    }

    public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
        return this._xmlStream.getTextCharacters(i5, cArr, i6, i7);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigDecimal getAttributeBigDecimalValue(String str, String str2) {
        try {
            return XsTypeConverter.lexDecimal(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public BigInteger getAttributeBigIntegerValue(String str, String str2) {
        try {
            return XsTypeConverter.lexInteger(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public boolean getAttributeBooleanValue(String str, String str2) {
        try {
            return XsTypeConverter.lexBoolean(this._charSeq.reloadAtt(str, str2, 2));
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public byte getAttributeByteValue(String str, String str2) {
        try {
            return XsTypeConverter.lexByte(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public double getAttributeDoubleValue(String str, String str2) {
        try {
            return XsTypeConverter.lexDouble(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public float getAttributeFloatValue(String str, String str2) {
        try {
            return XsTypeConverter.lexFloat(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDate getAttributeGDateValue(String str, String str2) {
        try {
            return new GDate(this._charSeq.reloadAtt(str, str2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public GDuration getAttributeGDurationValue(String str, String str2) {
        try {
            return new GDuration(this._charSeq.reloadAtt(str, str2, 2));
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public int getAttributeIntValue(String str, String str2) {
        try {
            return XsTypeConverter.lexInt(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public long getAttributeLongValue(String str, String str2) {
        try {
            return XsTypeConverter.lexLong(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public short getAttributeShortValue(String str, String str2) {
        try {
            return XsTypeConverter.lexShort(this._charSeq.reloadAtt(str, str2, 2));
        } catch (NumberFormatException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(String str, String str2) {
        return this._charSeq.reloadAtt(str, str2, 1).toString();
    }

    public String getNamespaceURI() {
        return this._xmlStream.getNamespaceURI();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getStringValue(int i5) throws XMLStreamException {
        this._charSeq.reload(1);
        return XmlWhitespace.collapse(this._charSeq.toString(), i5);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public XmlCalendar getAttributeCalendarValue(String str, String str2) {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(str, str2, 2)).getCalendar();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public Date getAttributeDateValue(String str, String str2) {
        try {
            return new GDateBuilder(this._charSeq.reloadAtt(str, str2, 2)).getDate();
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(e, this._charSeq.getLocation());
        }
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public String getAttributeStringValue(String str, String str2, int i5) {
        return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(str, str2), i5);
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeBase64Value(String str, String str2) {
        byte[] bArrDecode = Base64.getMimeDecoder().decode(this._charSeq.reloadAtt(str, str2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid base64Binary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public InputStream getAttributeHexBinaryValue(String str, String str2) {
        byte[] bArrDecode = HexBin.decode(this._charSeq.reloadAtt(str, str2, 2).toString().getBytes(StandardCharsets.ISO_8859_1));
        if (bArrDecode != null) {
            return new ByteArrayInputStream(bArrDecode);
        }
        throw new InvalidLexicalValueException("invalid hexBinary value", this._charSeq.getLocation());
    }

    @Override // org.apache.xmlbeans.impl.richParser.XMLStreamReaderExt
    public QName getAttributeQNameValue(String str, String str2) {
        try {
            return XsTypeConverter.lexQName(this._charSeq.reloadAtt(str, str2, 2), this._xmlStream.getNamespaceContext());
        } catch (InvalidLexicalValueException e) {
            throw new InvalidLexicalValueException(e.getMessage(), this._charSeq.getLocation());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class CharSeqTrimWS implements CharSequence {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static int INITIAL_SIZE = 100;
        static final int XMLWHITESPACE_PRESERVE = 1;
        static final int XMLWHITESPACE_TRIM = 2;
        private boolean _hasText;
        private int _start;
        private String _toStringValue;
        private XMLStreamReaderExtImpl _xmlSteam;
        private char[] _buf = new char[INITIAL_SIZE];
        private int _length = 0;
        private int _nonWSStart = 0;
        private int _nonWSEnd = 0;
        private final ExtLocation _location = new ExtLocation();

        /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
        public static class ExtLocation implements Location {
            private int _col;
            private boolean _isSet = false;
            private int _line;
            private int _off;
            private String _pid;
            private String _sid;

            public int getCharacterOffset() {
                if (this._isSet) {
                    return this._off;
                }
                throw new IllegalStateException();
            }

            public int getColumnNumber() {
                if (this._isSet) {
                    return this._col;
                }
                throw new IllegalStateException();
            }

            public int getLineNumber() {
                if (this._isSet) {
                    return this._line;
                }
                throw new IllegalStateException();
            }

            public String getPublicId() {
                if (this._isSet) {
                    return this._pid;
                }
                throw new IllegalStateException();
            }

            public String getSystemId() {
                if (this._isSet) {
                    return this._sid;
                }
                throw new IllegalStateException();
            }

            public void reset() {
                this._isSet = false;
            }

            public void set(Location location) {
                if (this._isSet) {
                    return;
                }
                this._isSet = true;
                this._line = location.getLineNumber();
                this._col = location.getColumnNumber();
                this._off = location.getCharacterOffset();
                this._pid = location.getPublicId();
                this._sid = location.getSystemId();
            }
        }

        public CharSeqTrimWS(XMLStreamReaderExtImpl xMLStreamReaderExtImpl) {
            this._xmlSteam = xMLStreamReaderExtImpl;
        }

        private void addEntityToBuffer() {
            String text = this._xmlSteam.getText();
            ensureBufferLength(text.length());
            text.getChars(0, text.length(), this._buf, this._length);
            this._length = text.length() + this._length;
        }

        private void addTextToBuffer() {
            this._hasText = true;
            int textLength = this._xmlSteam.getTextLength();
            ensureBufferLength(textLength);
            System.arraycopy(this._xmlSteam.getTextCharacters(), this._xmlSteam.getTextStart(), this._buf, this._length, textLength);
            this._length += textLength;
        }

        private void ensureBufferLength(int i5) {
            int i6 = this._length;
            int i7 = i6 + i5;
            char[] cArr = this._buf;
            if (i7 > cArr.length) {
                char[] cArr2 = new char[i5 + i6];
                if (i6 > 0) {
                    System.arraycopy(cArr, 0, cArr2, 0, i6);
                }
                this._buf = cArr2;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
        private void fillBuffer() throws XMLStreamException {
            int i5 = 0;
            this._length = 0;
            if (this._xmlSteam.getEventType() == 7) {
                this._xmlSteam.next();
            }
            if (this._xmlSteam.isStartElement()) {
                this._xmlSteam.next();
            }
            int eventType = this._xmlSteam.getEventType();
            String str = null;
            while (true) {
                if (eventType == 1) {
                    i5++;
                    String str2 = "Unexpected element '" + this._xmlSteam.getName() + "' in text content.";
                    this._location.set(this._xmlSteam.getLocation());
                    str = str2;
                } else if (eventType == 2) {
                    this._location.set(this._xmlSteam.getLocation());
                    i5--;
                    if (i5 < 0) {
                        break;
                    }
                } else if (eventType != 4 && eventType != 6 && eventType != 12) {
                    if (eventType == 8) {
                        this._location.set(this._xmlSteam.getLocation());
                        break;
                    } else if (eventType == 9) {
                        this._location.set(this._xmlSteam.getLocation());
                        addEntityToBuffer();
                    }
                } else {
                    this._location.set(this._xmlSteam.getLocation());
                    if (i5 == 0) {
                        addTextToBuffer();
                    }
                }
                eventType = this._xmlSteam.next();
            }
            if (str != null) {
                throw new XMLStreamException(str);
            }
        }

        private void fillBufferFromString(CharSequence charSequence) {
            int length = charSequence.length();
            ensureBufferLength(length);
            for (int i5 = 0; i5 < length; i5++) {
                this._buf[i5] = charSequence.charAt(i5);
            }
            this._length = length;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i5) {
            return this._buf[this._nonWSStart + i5];
        }

        public Location getLocation() {
            ExtLocation extLocation = new ExtLocation();
            extLocation.set(this._location);
            return extLocation;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this._nonWSEnd - this._nonWSStart;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.xml.stream.XMLStreamException */
        public void reload(int i5) throws XMLStreamException {
            this._toStringValue = null;
            this._location.reset();
            this._hasText = false;
            fillBuffer();
            if (i5 == 1) {
                this._nonWSStart = 0;
                this._nonWSEnd = this._length;
                if (!this._hasText && this._xmlSteam._defaultValue != null) {
                    this._length = 0;
                    fillBufferFromString(this._xmlSteam._defaultValue);
                }
            } else if (i5 == 2) {
                this._nonWSStart = 0;
                while (true) {
                    int i6 = this._nonWSStart;
                    if (i6 >= this._length || !XMLChar.isSpace(this._buf[i6])) {
                        break;
                    } else {
                        this._nonWSStart++;
                    }
                }
                int i7 = this._length;
                while (true) {
                    this._nonWSEnd = i7;
                    int i8 = this._nonWSEnd;
                    if (i8 <= this._nonWSStart || !XMLChar.isSpace(this._buf[i8 - 1])) {
                        break;
                    } else {
                        i7 = this._nonWSEnd - 1;
                    }
                }
                if (length() == 0 && this._xmlSteam._defaultValue != null) {
                    this._length = 0;
                    fillBufferFromString(this._xmlSteam._defaultValue);
                    this._nonWSStart = 0;
                    while (true) {
                        int i9 = this._nonWSStart;
                        if (i9 >= this._length || !XMLChar.isSpace(this._buf[i9])) {
                            break;
                        } else {
                            this._nonWSStart++;
                        }
                    }
                    int i10 = this._length;
                    while (true) {
                        this._nonWSEnd = i10;
                        int i11 = this._nonWSEnd;
                        if (i11 <= this._nonWSStart || !XMLChar.isSpace(this._buf[i11 - 1])) {
                            break;
                        } else {
                            i10 = this._nonWSEnd - 1;
                        }
                    }
                }
            }
            this._xmlSteam._defaultValue = null;
        }

        public CharSequence reloadAtt(int i5, int i6) {
            this._location.reset();
            this._location.set(this._xmlSteam.getLocation());
            String attributeValue = this._xmlSteam.getAttributeValue(i5);
            if (attributeValue == null && this._xmlSteam._defaultValue != null) {
                attributeValue = this._xmlSteam._defaultValue;
            }
            this._xmlSteam._defaultValue = null;
            int length = attributeValue.length();
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("unknown style");
                }
                int i7 = 0;
                while (i7 < length && XMLChar.isSpace(attributeValue.charAt(i7))) {
                    i7++;
                }
                int i8 = length;
                while (i8 > i7 && XMLChar.isSpace(attributeValue.charAt(i8 - 1))) {
                    i8--;
                }
                if (i7 != 0 || i8 != length) {
                    return attributeValue.subSequence(i7, i8);
                }
            }
            return attributeValue;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i5, int i6) {
            return new String(this._buf, this._nonWSStart + i5, i6 - i5);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            String str = this._toStringValue;
            if (str != null) {
                return str;
            }
            char[] cArr = this._buf;
            int i5 = this._nonWSStart;
            String str2 = new String(cArr, i5, this._nonWSEnd - i5);
            this._toStringValue = str2;
            return str2;
        }

        public CharSequence reloadAtt(String str, String str2, int i5) {
            this._location.reset();
            this._location.set(this._xmlSteam.getLocation());
            String attributeValue = this._xmlSteam.getAttributeValue(str, str2);
            if (attributeValue == null && this._xmlSteam._defaultValue != null) {
                attributeValue = this._xmlSteam._defaultValue;
            }
            this._xmlSteam._defaultValue = null;
            int length = attributeValue.length();
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = 0;
                    while (true) {
                        this._nonWSStart = i6;
                        int i7 = this._nonWSStart;
                        if (i7 >= length || !XMLChar.isSpace(attributeValue.charAt(i7))) {
                            break;
                        }
                        i6 = this._nonWSStart + 1;
                    }
                    this._nonWSEnd = length;
                    while (true) {
                        int i8 = this._nonWSEnd;
                        if (i8 <= this._nonWSStart || !XMLChar.isSpace(attributeValue.charAt(i8 - 1))) {
                            break;
                        }
                        this._nonWSEnd--;
                    }
                    int i9 = this._nonWSStart;
                    if (i9 != 0 || this._nonWSEnd != length) {
                        return attributeValue.subSequence(i9, this._nonWSEnd);
                    }
                } else {
                    throw new IllegalStateException("unknown style");
                }
            }
            return attributeValue;
        }
    }
}
