package org.apache.xmlbeans.impl.schema;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaParticle;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlQName;
import org.apache.xmlbeans.impl.values.NamespaceContext;
import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
import org.apache.xmlbeans.impl.xb.xsdschema.Element;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaParticleImpl implements SchemaParticle {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final BigInteger _maxint = BigInteger.valueOf(2147483647L);
    private String _defaultText;
    private XmlValueRef _defaultValue;
    private String _documentation;
    private QNameSet _excludeNextSet;
    private int _intMaxOccurs;
    private int _intMinOccurs;
    private boolean _isDefault;
    private boolean _isDeterministic;
    private boolean _isFixed;
    private boolean _isImmutable;
    private boolean _isNillable;
    private boolean _isSkippable;
    private BigInteger _maxOccurs;
    private BigInteger _minOccurs;
    protected XmlObject _parseObject;
    private SchemaParticle[] _particleChildren;
    private int _particleType;
    private QName _qName;
    private QNameSet _startSet;
    private SchemaType.Ref _typeref;
    private Object _userData;
    private int _wildcardProcess;
    private QNameSet _wildcardSet;

    private static String parseDocumentation(XmlObject xmlObject) {
        try {
            if (xmlObject instanceof Element) {
                Element element = (Element) xmlObject;
                if (element.getAnnotation() != null) {
                    AnnotationDocument.Annotation annotation = element.getAnnotation();
                    if (annotation.getDocumentationArray() != null) {
                        DocumentationDocument.Documentation[] documentationArray = annotation.getDocumentationArray();
                        StringBuilder sb = new StringBuilder();
                        for (DocumentationDocument.Documentation documentation : documentationArray) {
                            XmlCursor xmlCursorNewCursor = documentation.newCursor();
                            try {
                                sb.append(xmlCursorNewCursor.getTextValue());
                                xmlCursorNewCursor.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    if (xmlCursorNewCursor != null) {
                                        try {
                                            xmlCursorNewCursor.close();
                                        } catch (Throwable th3) {
                                            th.addSuppressed(th3);
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        return sb.toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return "";
    }

    private static int pegBigInteger(BigInteger bigInteger) {
        if (bigInteger == null) {
            return Integer.MAX_VALUE;
        }
        if (bigInteger.signum() <= 0) {
            return 0;
        }
        if (bigInteger.compareTo(_maxint) >= 0) {
            return Integer.MAX_VALUE;
        }
        return bigInteger.intValue();
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet acceptedStartNames() {
        return this._startSet;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean canStartWithElement(QName qName) {
        return qName != null && this._startSet.contains(qName);
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int countOfParticleChild() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            return 0;
        }
        return schemaParticleArr.length;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public String getDefaultText() {
        return this._defaultText;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public XmlAnySimpleType getDefaultValue() {
        XmlValueRef xmlValueRef = this._defaultValue;
        if (xmlValueRef != null) {
            return xmlValueRef.get();
        }
        if (this._defaultText == null || !XmlAnySimpleType.type.isAssignableFrom(getType())) {
            return null;
        }
        if (this._parseObject == null || !XmlQName.type.isAssignableFrom(getType())) {
            return getType().newValue(this._defaultText);
        }
        try {
            NamespaceContext.push(new NamespaceContext(this._parseObject));
            return getType().newValue(this._defaultText);
        } finally {
            NamespaceContext.pop();
        }
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public String getDocumentation() {
        return this._documentation;
    }

    public QNameSet getExcludeNextSet() {
        return this._excludeNextSet;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMaxOccurs() {
        return this._intMaxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getIntMinOccurs() {
        return this._intMinOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public BigInteger getMaxOccurs() {
        return this._maxOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public BigInteger getMinOccurs() {
        return this._minOccurs;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QName getName() {
        return this._qName;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaParticle getParticleChild(int i5) {
        return this._particleChildren[i5];
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaParticle[] getParticleChildren() {
        SchemaParticle[] schemaParticleArr = this._particleChildren;
        if (schemaParticleArr == null) {
            return null;
        }
        SchemaParticle[] schemaParticleArr2 = new SchemaParticle[schemaParticleArr.length];
        System.arraycopy(schemaParticleArr, 0, schemaParticleArr2, 0, schemaParticleArr.length);
        return schemaParticleArr2;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getParticleType() {
        return this._particleType;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public SchemaType getType() {
        SchemaType.Ref ref = this._typeref;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    public Object getUserData() {
        return this._userData;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public int getWildcardProcess() {
        return this._wildcardProcess;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public QNameSet getWildcardSet() {
        return this._wildcardSet;
    }

    public boolean hasTransitionNotes() {
        return this._excludeNextSet != null;
    }

    public boolean hasTransitionRules() {
        return this._startSet != null;
    }

    public boolean isAttribute() {
        return false;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isDefault() {
        return this._isDefault;
    }

    public boolean isDeterministic() {
        return this._isDeterministic;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isFixed() {
        return this._isFixed;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isNillable() {
        return this._isNillable;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isSingleton() {
        BigInteger bigInteger = this._maxOccurs;
        if (bigInteger == null) {
            return false;
        }
        BigInteger bigInteger2 = BigInteger.ONE;
        return bigInteger.compareTo(bigInteger2) == 0 && this._minOccurs.compareTo(bigInteger2) == 0;
    }

    @Override // org.apache.xmlbeans.SchemaParticle
    public boolean isSkippable() {
        return this._isSkippable;
    }

    public boolean isTypeResolved() {
        return this._typeref != null;
    }

    public void mutate() {
        if (this._isImmutable) {
            throw new IllegalStateException();
        }
    }

    public void resolveTypeRef(SchemaType.Ref ref) {
        if (this._typeref != null) {
            throw new IllegalStateException();
        }
        this._typeref = ref;
    }

    public void setDefault(String str, boolean z6, XmlObject xmlObject) {
        mutate();
        this._defaultText = str;
        this._isDefault = str != null;
        this._isFixed = z6;
        this._parseObject = xmlObject;
        this._documentation = parseDocumentation(xmlObject);
    }

    public void setDefaultValue(XmlValueRef xmlValueRef) {
        mutate();
        this._defaultValue = xmlValueRef;
    }

    public void setImmutable() {
        mutate();
        this._isImmutable = true;
    }

    public void setMaxOccurs(BigInteger bigInteger) {
        mutate();
        this._maxOccurs = bigInteger;
        this._intMaxOccurs = pegBigInteger(bigInteger);
    }

    public void setMinOccurs(BigInteger bigInteger) {
        mutate();
        this._minOccurs = bigInteger;
        this._intMinOccurs = pegBigInteger(bigInteger);
    }

    public void setNameAndTypeRef(QName qName, SchemaType.Ref ref) {
        mutate();
        this._qName = qName;
        this._typeref = ref;
    }

    public void setNillable(boolean z6) {
        mutate();
        this._isNillable = z6;
    }

    public void setParticleChildren(SchemaParticle[] schemaParticleArr) {
        mutate();
        this._particleChildren = schemaParticleArr == null ? null : (SchemaParticle[]) schemaParticleArr.clone();
    }

    public void setParticleType(int i5) {
        mutate();
        this._particleType = i5;
    }

    public void setTransitionNotes(QNameSet qNameSet, boolean z6) {
        this._excludeNextSet = qNameSet;
        this._isDeterministic = z6;
    }

    public void setTransitionRules(QNameSet qNameSet, boolean z6) {
        this._startSet = qNameSet;
        this._isSkippable = z6;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }

    public void setWildcardProcess(int i5) {
        mutate();
        this._wildcardProcess = i5;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        mutate();
        this._wildcardSet = qNameSet;
    }
}
