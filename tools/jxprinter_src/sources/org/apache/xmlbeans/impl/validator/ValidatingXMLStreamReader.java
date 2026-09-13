package org.apache.xmlbeans.impl.validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.Location;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.impl.common.QNameHelper;
import org.apache.xmlbeans.impl.common.ValidatorListener;
import org.apache.xmlbeans.impl.common.XmlWhitespace;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class ValidatingXMLStreamReader extends StreamReaderDelegate implements XMLStreamReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final AttributeEventImpl _attEvent;
    private List<QName> _attNamesList;
    private List<String> _attValuesList;
    private SchemaType _contentType;
    private int _depth;
    private final ElementEventImpl _elemEvent;
    private Collection<XmlError> _errorListener;
    private XmlOptions _options;
    private PackTextXmlStreamReader _packTextXmlStreamReader;
    private final SimpleEventImpl _simpleEvent;
    private int _state;
    private SchemaTypeLoader _stl;
    protected Validator _validator;
    private SchemaType _xsiType;
    private static final String URI_XSI = "http://www.w3.org/2001/XMLSchema-instance";
    private static final QName XSI_TYPE = new QName(URI_XSI, "type");
    private static final QName XSI_NIL = new QName(URI_XSI, "nil");
    private static final QName XSI_SL = new QName(URI_XSI, "schemaLocation");
    private static final QName XSI_NSL = new QName(URI_XSI, "noNamespaceSchemaLocation");
    private final int STATE_FIRSTEVENT = 0;
    private final int STATE_VALIDATING = 1;
    private final int STATE_ATTBUFFERING = 2;
    private final int STATE_ERROR = 3;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class AttributeEventImpl implements ValidatorListener.Event {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private int _attIndex;
        private XMLStreamReader _xmlStream;

        private AttributeEventImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAttributeIndex(int i5) {
            this._attIndex = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            String attributeNamespace = this._xmlStream.getAttributeNamespace(this._attIndex);
            if (attributeNamespace == null) {
                attributeNamespace = "";
            }
            return new QName(attributeNamespace, this._xmlStream.getAttributeLocalName(this._attIndex));
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._xmlStream.getNamespaceURI(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            return this._xmlStream.getAttributeValue(this._attIndex);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            throw new IllegalStateException();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i5) {
            return XmlWhitespace.collapse(this._xmlStream.getAttributeValue(this._attIndex), i5);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class PackTextXmlStreamReader extends StreamReaderDelegate implements XMLStreamReader {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private StringBuilder _buffer;
        private boolean _hasBufferedText;
        private int _textEventType;

        private PackTextXmlStreamReader() {
            this._buffer = new StringBuilder();
        }

        private void bufferText() {
            if (super.hasText()) {
                this._buffer.append(super.getText());
            }
            this._hasBufferedText = true;
            while (hasNext()) {
                int next = super.next();
                if (next != 4) {
                    if (next == 5) {
                        continue;
                    } else if (next != 6 && next != 12) {
                        return;
                    }
                }
                if (super.hasText()) {
                    this._buffer.append(super.getText());
                }
            }
        }

        private void clearBuffer() {
            StringBuilder sb = this._buffer;
            sb.delete(0, sb.length());
            this._hasBufferedText = false;
        }

        public int getEventType() {
            return this._hasBufferedText ? this._textEventType : super.getEventType();
        }

        public String getText() {
            return this._buffer.toString();
        }

        public char[] getTextCharacters() {
            return this._buffer.toString().toCharArray();
        }

        public int getTextLength() {
            return this._buffer.length();
        }

        public int getTextStart() {
            return 0;
        }

        public boolean hasText() {
            if (this._hasBufferedText) {
                return true;
            }
            return super.hasText();
        }

        public void init(XMLStreamReader xMLStreamReader) {
            setParent(xMLStreamReader);
            this._hasBufferedText = false;
            StringBuilder sb = this._buffer;
            sb.delete(0, sb.length());
        }

        public boolean isWhiteSpace() {
            return XmlWhitespace.isAllSpace(this._buffer);
        }

        public int next() {
            if (this._hasBufferedText) {
                clearBuffer();
                return super.getEventType();
            }
            int next = super.next();
            if (next != 4 && next != 12 && next != 6) {
                return next;
            }
            this._textEventType = next;
            bufferText();
            return next;
        }

        public int getTextCharacters(int i5, char[] cArr, int i6, int i7) {
            this._buffer.getChars(i5, i5 + i7, cArr, i6);
            return i7;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static final class SimpleEventImpl implements ValidatorListener.Event {
        private QName _qname;
        private String _text;
        private XMLStreamReader _xmlStream;

        private SimpleEventImpl() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            return this._qname;
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._xmlStream.getNamespaceURI(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            return this._text;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return false;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i5) {
            return XmlWhitespace.collapse(this._text, i5);
        }
    }

    public ValidatingXMLStreamReader() {
        this._elemEvent = new ElementEventImpl();
        this._attEvent = new AttributeEventImpl();
        this._simpleEvent = new SimpleEventImpl();
        this._packTextXmlStreamReader = new PackTextXmlStreamReader();
    }

    private void addError(String str) {
        Location location = getLocation();
        if (location == null) {
            this._errorListener.add(XmlError.forMessage(str));
            return;
        }
        String publicId = location.getPublicId();
        if (publicId == null) {
            publicId = location.getSystemId();
        }
        this._errorListener.add(XmlError.forLocation(str, publicId, location));
    }

    private void initValidator(SchemaType schemaType) {
        this._validator = new Validator(schemaType, null, this._stl, this._options, this._errorListener);
    }

    private boolean isSpecialAttribute(QName qName) {
        if (qName.getNamespaceURI().equals(URI_XSI)) {
            return qName.getLocalPart().equals(XSI_TYPE.getLocalPart()) || qName.getLocalPart().equals(XSI_NIL.getLocalPart()) || qName.getLocalPart().equals(XSI_SL.getLocalPart()) || qName.getLocalPart().equals(XSI_NSL.getLocalPart());
        }
        return false;
    }

    private void pushBufferedAttributes() {
        SchemaType schemaTypeFindAttributeType = this._xsiType;
        if (schemaTypeFindAttributeType != null) {
            SchemaType schemaType = this._contentType;
            if (schemaType != null) {
                if (!schemaType.isAssignableFrom(schemaTypeFindAttributeType)) {
                    addError("Specified type '" + this._contentType + "' not compatible with found xsi:type '" + this._xsiType + "'.");
                    this._state = 3;
                    return;
                }
                schemaTypeFindAttributeType = this._xsiType;
            }
        } else {
            schemaTypeFindAttributeType = this._contentType;
            if (schemaTypeFindAttributeType == null) {
                List<QName> list = this._attNamesList;
                if (list == null) {
                    addError("No content type provided for validation of a content model.");
                    this._state = 3;
                    return;
                }
                schemaTypeFindAttributeType = this._stl.findAttributeType(list.get(0));
                if (schemaTypeFindAttributeType == null) {
                    addError("A schema global attribute with name '" + this._attNamesList.get(0) + "' could not be found in the current schema type loader.");
                    this._state = 3;
                    return;
                }
            }
        }
        initValidator(schemaTypeFindAttributeType);
        this._validator.nextEvent(1, this._simpleEvent);
        validate_attributes(this._attNamesList.size());
        this._attNamesList = null;
        this._attValuesList = null;
        this._state = 1;
    }

    private SchemaType typeForGlobalElement(QName qName) {
        SchemaType schemaTypeFindDocumentType = this._stl.findDocumentType(qName);
        if (schemaTypeFindDocumentType == null) {
            addError("Schema document type not found for element '" + qName + "'.");
            this._state = 3;
        }
        return schemaTypeFindDocumentType;
    }

    private void validate_event(int i5) {
        int i6 = this._state;
        if (i6 == 3) {
            return;
        }
        int i7 = this._depth;
        if (i7 < 0) {
            throw new IllegalArgumentException("ValidatingXMLStreamReader cannot go further than the subtree is was initialized on.");
        }
        switch (i5) {
            case 1:
                this._depth = i7 + 1;
                if (i6 == 2) {
                    pushBufferedAttributes();
                }
                if (this._validator == null) {
                    QName qName = new QName(getNamespaceURI(), getLocalName());
                    if (this._contentType == null) {
                        this._contentType = typeForGlobalElement(qName);
                    }
                    if (this._state == 3) {
                        return;
                    }
                    initValidator(this._contentType);
                    this._validator.nextEvent(1, this._elemEvent);
                }
                this._validator.nextEvent(1, this._elemEvent);
                validate_attributes(getAttributeCount());
                return;
            case 2:
            case 8:
                this._depth = i7 - 1;
                if (i6 == 2) {
                    pushBufferedAttributes();
                }
                this._validator.nextEvent(2, this._elemEvent);
                return;
            case 3:
            case 5:
            case 6:
            case 9:
            case 11:
            case 13:
            case 14:
            case 15:
                return;
            case 4:
            case 12:
                if (i6 == 2) {
                    pushBufferedAttributes();
                }
                if (this._validator == null) {
                    SchemaType schemaType = this._contentType;
                    if (schemaType == null) {
                        if (isWhiteSpace()) {
                            return;
                        }
                        addError("No content type provided for validation of a content model.");
                        this._state = 3;
                        return;
                    }
                    initValidator(schemaType);
                    this._validator.nextEvent(1, this._simpleEvent);
                }
                this._validator.nextEvent(3, this._elemEvent);
                return;
            case 7:
                this._depth = i7 + 1;
                return;
            case 10:
                if (getAttributeCount() == 0) {
                    return;
                }
                int i8 = this._state;
                if (i8 != 0 && i8 != 2) {
                    throw new IllegalStateException("ATT event must be only at the beggining of the stream.");
                }
                for (int i9 = 0; i9 < getAttributeCount(); i9++) {
                    QName qName2 = new QName(getAttributeNamespace(i9), getAttributeLocalName(i9));
                    if (qName2.equals(XSI_TYPE)) {
                        String attributeValue = getAttributeValue(i9);
                        this._xsiType = this._stl.findType(new QName(super.getNamespaceURI(QNameHelper.getPrefixPart(attributeValue)), QNameHelper.getLocalPart(attributeValue)));
                    }
                    if (this._attNamesList == null) {
                        this._attNamesList = new ArrayList();
                        this._attValuesList = new ArrayList();
                    }
                    if (!isSpecialAttribute(qName2)) {
                        this._attNamesList.add(qName2);
                        this._attValuesList.add(getAttributeValue(i9));
                    }
                }
                this._state = 2;
                return;
            default:
                throw new IllegalStateException("Unknown event type.");
        }
    }

    public Object getProperty(String str) {
        return super.getProperty(str);
    }

    public void init(XMLStreamReader xMLStreamReader, boolean z6, SchemaType schemaType, SchemaTypeLoader schemaTypeLoader, XmlOptions xmlOptions, Collection<XmlError> collection) {
        this._packTextXmlStreamReader.init(xMLStreamReader);
        setParent(this._packTextXmlStreamReader);
        this._contentType = schemaType;
        this._stl = schemaTypeLoader;
        this._options = xmlOptions;
        this._errorListener = collection;
        this._elemEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._attEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._simpleEvent.setXMLStreamReader(this._packTextXmlStreamReader);
        this._validator = null;
        this._state = 0;
        List<QName> list = this._attNamesList;
        if (list != null) {
            list.clear();
            this._attValuesList.clear();
        }
        this._xsiType = null;
        this._depth = 0;
        if (z6) {
            validate_event(getEventType());
        }
    }

    public boolean isValid() {
        Validator validator;
        if (this._state == 3 || (validator = this._validator) == null) {
            return false;
        }
        return validator.isValid();
    }

    public int next() {
        int next = super.next();
        validate_event(next);
        return next;
    }

    public void validate_attribute(int i5) {
        ValidatorListener.Event event;
        List<QName> list = this._attNamesList;
        if (list == null) {
            this._attEvent.setAttributeIndex(i5);
            if (isSpecialAttribute(this._attEvent.getName())) {
                return;
            } else {
                event = this._attEvent;
            }
        } else {
            this._simpleEvent._qname = list.get(i5);
            this._simpleEvent._text = this._attValuesList.get(i5);
            event = this._simpleEvent;
        }
        this._validator.nextEvent(4, event);
    }

    public void validate_attributes(int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            validate_attribute(i6);
        }
        XmlOptions xmlOptions = this._options;
        if (xmlOptions == null || !xmlOptions.isAttributeValidationCompatMode()) {
            this._validator.nextEvent(5, this._simpleEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ElementEventImpl implements ValidatorListener.Event {
        private static final int BUF_LENGTH = 1024;
        private char[] _buf;
        private int _length;
        private boolean _supportForGetTextCharacters;
        private XMLStreamReader _xmlStream;

        private ElementEventImpl() {
            this._buf = new char[1024];
            this._supportForGetTextCharacters = true;
        }

        private void addTextToBuffer() {
            int textLength = this._xmlStream.getTextLength();
            ensureBufferLength(textLength);
            if (this._supportForGetTextCharacters) {
                try {
                    this._length = this._xmlStream.getTextCharacters(0, this._buf, this._length, textLength);
                } catch (Exception unused) {
                    this._supportForGetTextCharacters = false;
                }
            }
            if (this._supportForGetTextCharacters) {
                return;
            }
            System.arraycopy(this._xmlStream.getTextCharacters(), this._xmlStream.getTextStart(), this._buf, this._length, textLength);
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

        /* JADX INFO: Access modifiers changed from: private */
        public void setXMLStreamReader(XMLStreamReader xMLStreamReader) {
            this._xmlStream = xMLStreamReader;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public Location getLocation() {
            return this._xmlStream.getLocation();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public XmlCursor getLocationAsCursor() {
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public QName getName() {
            if (this._xmlStream.hasName()) {
                return new QName(this._xmlStream.getNamespaceURI(), this._xmlStream.getLocalName());
            }
            return null;
        }

        @Override // org.apache.xmlbeans.impl.common.PrefixResolver
        public String getNamespaceForPrefix(String str) {
            return this._xmlStream.getNamespaceURI(str);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText() {
            this._length = 0;
            addTextToBuffer();
            return new String(this._buf, 0, this._length);
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiLoc() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "schemaLocation");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNil() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "nil");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiNoLoc() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "noNamespaceSchemaLocation");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getXsiType() {
            return this._xmlStream.getAttributeValue(ValidatingXMLStreamReader.URI_XSI, "type");
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public boolean textIsWhitespace() {
            return this._xmlStream.isWhiteSpace();
        }

        @Override // org.apache.xmlbeans.impl.common.ValidatorListener.Event
        public String getText(int i5) {
            return XmlWhitespace.collapse(this._xmlStream.getText(), i5);
        }
    }
}
