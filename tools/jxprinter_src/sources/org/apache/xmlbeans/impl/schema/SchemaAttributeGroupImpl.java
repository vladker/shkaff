package org.apache.xmlbeans.impl.schema;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaAnnotation;
import org.apache.xmlbeans.SchemaAttributeGroup;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaAttributeGroupImpl implements SchemaAttributeGroup {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private SchemaAnnotation _annotation;
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private String _formDefault;
    private QName _name;
    private XmlObject _parseObject;
    private String _parseTNS;
    private boolean _redefinition;
    private SchemaAttributeGroup.Ref _selfref = new SchemaAttributeGroup.Ref(this);
    private Object _userData;

    public SchemaAttributeGroupImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
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

    @Override // org.apache.xmlbeans.SchemaAttributeGroup, org.apache.xmlbeans.SchemaComponent
    public int getComponentType() {
        return 4;
    }

    public SchemaContainer getContainer() {
        return this._container;
    }

    public String getFormDefault() {
        return this._formDefault;
    }

    @Override // org.apache.xmlbeans.SchemaAttributeGroup, org.apache.xmlbeans.SchemaComponent
    public QName getName() {
        return this._name;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    public SchemaAttributeGroup.Ref getRef() {
        return this._selfref;
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

    @Override // org.apache.xmlbeans.SchemaAttributeGroup
    public Object getUserData() {
        return this._userData;
    }

    public void init(QName qName, String str, boolean z6, String str2, boolean z7, XmlObject xmlObject, SchemaAnnotation schemaAnnotation, Object obj) {
        this._name = qName;
        this._parseTNS = str;
        this._chameleon = z6;
        this._formDefault = str2;
        this._redefinition = z7;
        this._parseObject = xmlObject;
        this._annotation = schemaAnnotation;
        this._userData = obj;
    }

    public boolean isRedefinition() {
        return this._redefinition;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public SchemaAttributeGroupImpl(SchemaContainer schemaContainer, QName qName) {
        this._container = schemaContainer;
        this._name = qName;
    }
}
