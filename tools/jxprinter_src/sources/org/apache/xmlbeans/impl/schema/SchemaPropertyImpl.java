package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaPropertyImpl implements SchemaProperty {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Set<QName> _acceptedNames;
    private SchemaType.Ref _containerTypeRef;
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private String _documentation;
    private boolean _extendsArray;
    private boolean _extendsOption;
    private boolean _extendsSingleton;
    private int _hasDefault;
    private int _hasFixed;
    private int _hasNillable;
    private boolean _isAttribute;
    private boolean _isImmutable;
    private SchemaType.Ref _javaBasedOnTypeRef;
    private String _javaPropertyName;
    private QNameSet _javaSetterDelimiter;
    private int _javaTypeCode;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    private QName _name;
    private SchemaType.Ref _typeref;

    private void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName[] acceptedNames() {
        Set<QName> set = this._acceptedNames;
        return set == null ? new QName[]{this._name} : (QName[]) set.toArray(new QName[0]);
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaArray() {
        return this._extendsArray;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaOption() {
        return this._extendsOption;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean extendsJavaSingleton() {
        return this._extendsSingleton;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType getContainerType() {
        return this._containerTypeRef.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getDocumentation() {
        return this._documentation;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public String getJavaPropertyName() {
        return this._javaPropertyName;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QNameSet getJavaSetterDelimiter() {
        if (this._isAttribute) {
            return QNameSet.EMPTY;
        }
        if (this._javaSetterDelimiter == null) {
            ((SchemaTypeImpl) getContainerType()).assignJavaElementSetterModel();
        }
        return this._javaSetterDelimiter;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int getJavaTypeCode() {
        return this._javaTypeCode;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public QName getName() {
        return this._name;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType getType() {
        return this._typeref.get();
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasDefault() {
        return this._hasDefault;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasFixed() {
        return this._hasFixed;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public int hasNillable() {
        return this._hasNillable;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean isAttribute() {
        return this._isAttribute;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public SchemaType javaBasedOnType() {
        SchemaType.Ref ref = this._javaBasedOnTypeRef;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public void setAcceptedNames(Set<QName> set) {
        mutate();
        this._acceptedNames = set;
    }

    public void setAttribute(boolean z6) {
        mutate();
        this._isAttribute = z6;
    }

    public void setContainerTypeRef(SchemaType.Ref ref) {
        mutate();
        this._containerTypeRef = ref;
    }

    public void setDefault(int i5) {
        mutate();
        this._hasDefault = i5;
    }

    public void setDefaultText(String str) {
        mutate();
        this._defaultText = str;
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        mutate();
        this._defaultValue = xmlValueRef;
    }

    @Override // org.apache.xmlbeans.SchemaProperty
    public void setDocumentation(String str) {
        this._documentation = str;
    }

    public void setExtendsJava(SchemaType.Ref ref, boolean z6, boolean z7, boolean z8) {
        mutate();
        this._javaBasedOnTypeRef = ref;
        this._extendsSingleton = z6;
        this._extendsOption = z7;
        this._extendsArray = z8;
    }

    public void setFixed(int i5) {
        mutate();
        this._hasFixed = i5;
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public void setJavaPropertyName(String str) {
        mutate();
        this._javaPropertyName = str;
    }

    public void setJavaSetterDelimiter(QNameSet qNameSet) {
        this._javaSetterDelimiter = qNameSet;
    }

    public void setJavaTypeCode(int i5) {
        mutate();
        this._javaTypeCode = i5;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
    }

    public void setName(QName qName) {
        mutate();
        this._name = qName;
    }

    public void setNillable(int i5) {
        mutate();
        this._hasNillable = i5;
    }

    public void setTypeRef(SchemaType.Ref ref) {
        mutate();
        this._typeref = ref;
    }

    public void setAcceptedNames(QNameSet qNameSet) {
        mutate();
        this._acceptedNames = qNameSet.includedQNamesInExcludedURIs();
    }
}
