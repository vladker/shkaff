package org.apache.xmlbeans.impl.schema;

import java.util.Collections;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaIdentityConstraint;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.xpath.XPath;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaIdentityConstraintImpl implements SchemaIdentityConstraint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private final SchemaContainer _container;
    private volatile XPath[] _fieldPaths;
    private String[] _fields;
    private String _filename;
    private SchemaIdentityConstraint.Ref _key;
    private QName _name;
    private XmlObject _parse;
    private String _parseTNS;
    private String _selector;
    private volatile XPath _selectorPath;
    private int _type;
    private Object _userData;
    private Map<String, String> _nsMap = Collections.EMPTY_MAP;
    private final SchemaIdentityConstraint.Ref _selfref = new SchemaIdentityConstraint.Ref(this);

    public SchemaIdentityConstraintImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public void buildPaths() {
        this._selectorPath = XPath.compileXPath(this._selector, this._nsMap);
        int length = this._fields.length;
        XPath[] xPathArr = new XPath[length];
        for (int i5 = 0; i5 < length; i5++) {
            xPathArr[i5] = XPath.compileXPath(this._fields[i5], this._nsMap);
        }
        this._fieldPaths = xPathArr;
    }

    @Override // org.apache.xmlbeans.SchemaAnnotated
    public SchemaAnnotation getAnnotation() {
        return this._annotation;
    }

    public String getChameleonNamespace() {
        if (this._chameleon) {
            return this._parseTNS;
        }
        return null;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaComponent.Ref getComponentRef() {
        return getRef();
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 5;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public int getConstraintCategory() {
        return this._type;
    }

    public SchemaContainer getContainer() {
        return this._container;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getFieldPath(int i5) {
        XPath[] xPathArr = this._fieldPaths;
        if (xPathArr == null) {
            try {
                buildPaths();
                xPathArr = this._fieldPaths;
            } catch (XPath.XPathCompileException unused) {
                return null;
            }
        }
        return xPathArr[i5];
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public String[] getFields() {
        String[] strArr = this._fields;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        return strArr2;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Map<String, String> getNSMap() {
        return Collections.unmodifiableMap(this._nsMap);
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public XmlObject getParseObject() {
        return this._parse;
    }

    public SchemaIdentityConstraint.Ref getRef() {
        return this._selfref;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public SchemaIdentityConstraint getReferencedKey() {
        return this._key.get();
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public String getSelector() {
        return this._selector;
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getSelectorPath() {
        XPath xPath = this._selectorPath;
        if (xPath != null) {
            return xPath;
        }
        try {
            buildPaths();
            return this._selectorPath;
        } catch (XPath.XPathCompileException unused) {
            return null;
        }
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public String getSourceName() {
        return this._filename;
    }

    public String getTargetNamespace() {
        return this._parseTNS;
    }

    @Override // org.apache.xmlbeans.SchemaComponent
    public SchemaTypeSystem getTypeSystem() {
        return this._container.getTypeSystem();
    }

    @Override // org.apache.xmlbeans.SchemaIdentityConstraint
    public Object getUserData() {
        return this._userData;
    }

    public boolean isResolved() {
        return (getConstraintCategory() == 2 && this._key == null) ? false : true;
    }

    public void setAnnotation(SchemaAnnotation schemaAnnotation) {
        this._annotation = schemaAnnotation;
    }

    public void setConstraintCategory(int i5) {
        this._type = i5;
    }

    public void setFields(String[] strArr) {
        this._fields = (String[]) strArr.clone();
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public void setNSMap(Map<String, String> map) {
        this._nsMap = map;
    }

    public void setName(QName qName) {
        this._name = qName;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z6) {
        this._parse = xmlObject;
        this._parseTNS = str;
        this._chameleon = z6;
    }

    public void setReferencedKey(SchemaIdentityConstraint.Ref ref) {
        this._key = ref;
    }

    public void setSelector(String str) {
        this._selector = str;
    }

    public void setUserData(Object obj) {
        this._userData = obj;
    }
}
