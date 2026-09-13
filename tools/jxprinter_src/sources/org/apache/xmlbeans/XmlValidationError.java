package org.apache.xmlbeans;

import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlValidationError extends XmlError {
    public static final int ATTRIBUTE_TYPE_INVALID = 1001;
    public static final int ELEMENT_NOT_ALLOWED = 2;
    public static final int ELEMENT_TYPE_INVALID = 3;
    public static final int INCORRECT_ATTRIBUTE = 1000;
    public static final int INCORRECT_ELEMENT = 1;
    public static final int LIST_INVALID = 2000;
    public static final int NIL_ELEMENT = 4;
    public static final int UNDEFINED = 10000;
    public static final int UNION_INVALID = 3000;
    private SchemaType _badSchemaType;
    private int _errorType;
    private List<QName> _expectedQNames;
    private SchemaType _expectedSchemaType;
    private QName _fieldQName;
    private QName _offendingQName;

    private XmlValidationError(String str, int i5, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        super(str, (String) null, i5, xmlCursor);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i6);
        setBadSchemaType(schemaType2);
    }

    public static XmlValidationError forCursorWithDetails(String str, String str2, Object[] objArr, int i5, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        return str2 == null ? new XmlValidationError(str, i5, xmlCursor, qName, qName2, schemaType, list, i6, schemaType2) : new XmlValidationError(str2, objArr, i5, xmlCursor, qName, qName2, schemaType, list, i6, schemaType2);
    }

    public static XmlValidationError forLocationWithDetails(String str, String str2, Object[] objArr, int i5, Location location, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        return str2 == null ? new XmlValidationError(str, i5, location, qName, qName2, schemaType, list, i6, schemaType2) : new XmlValidationError(str2, objArr, i5, location, qName, qName2, schemaType, list, i6, schemaType2);
    }

    public SchemaType getBadSchemaType() {
        return this._badSchemaType;
    }

    public int getErrorType() {
        return this._errorType;
    }

    public List<QName> getExpectedQNames() {
        return this._expectedQNames;
    }

    public SchemaType getExpectedSchemaType() {
        return this._expectedSchemaType;
    }

    public QName getFieldQName() {
        return this._fieldQName;
    }

    @Override // org.apache.xmlbeans.XmlError
    public String getMessage() {
        if (this._fieldQName == null) {
            return super.getMessage();
        }
        String message = super.getMessage();
        StringBuilder sb = new StringBuilder(message.length() + 100);
        sb.append(message);
        sb.append(" in element ");
        sb.append(this._fieldQName.getLocalPart());
        if (this._fieldQName.getNamespaceURI() != null && this._fieldQName.getNamespaceURI().length() != 0) {
            sb.append('@');
            sb.append(this._fieldQName.getNamespaceURI());
        }
        return sb.toString();
    }

    public QName getOffendingQName() {
        return this._offendingQName;
    }

    public void setBadSchemaType(SchemaType schemaType) {
        this._badSchemaType = schemaType;
    }

    public void setErrorType(int i5) {
        this._errorType = i5;
    }

    public void setExpectedQNames(List<QName> list) {
        this._expectedQNames = list;
    }

    public void setExpectedSchemaType(SchemaType schemaType) {
        this._expectedSchemaType = schemaType;
    }

    public void setFieldQName(QName qName) {
        this._fieldQName = qName;
    }

    public void setOffendingQName(QName qName) {
        this._offendingQName = qName;
    }

    private XmlValidationError(String str, Object[] objArr, int i5, XmlCursor xmlCursor, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        super(str, objArr, i5, xmlCursor);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i6);
        setBadSchemaType(schemaType2);
    }

    private XmlValidationError(String str, int i5, Location location, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        super(str, (String) null, i5, location);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i6);
        setBadSchemaType(schemaType2);
    }

    private XmlValidationError(String str, Object[] objArr, int i5, Location location, QName qName, QName qName2, SchemaType schemaType, List<QName> list, int i6, SchemaType schemaType2) {
        super(str, objArr, i5, location);
        setFieldQName(qName);
        setOffendingQName(qName2);
        setExpectedSchemaType(schemaType);
        setExpectedQNames(list);
        setErrorType(i6);
        setBadSchemaType(schemaType2);
    }
}
