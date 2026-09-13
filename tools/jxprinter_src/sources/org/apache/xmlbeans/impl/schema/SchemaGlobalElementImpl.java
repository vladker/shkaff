package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaComponent;
import org.apache.xmlbeans.SchemaGlobalElement;
import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlObject;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaGlobalElementImpl extends SchemaLocalElementImpl implements SchemaGlobalElement {
    private static final QName[] _namearray = new QName[0];
    private boolean _chameleon;
    private SchemaContainer _container;
    private String _filename;
    private boolean _finalExt;
    private boolean _finalRest;
    private String _parseTNS;
    private SchemaGlobalElement.Ref _sg;
    private Set _sgMembers = new LinkedHashSet();
    private SchemaGlobalElement.Ref _selfref = new SchemaGlobalElement.Ref(this);

    public SchemaGlobalElementImpl(SchemaContainer schemaContainer) {
        this._container = schemaContainer;
    }

    public void addSubstitutionGroupMember(QName qName) {
        mutate();
        this._sgMembers.add(qName);
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public boolean finalExtension() {
        return this._finalExt;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public boolean finalRestriction() {
        return this._finalRest;
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
        return 1;
    }

    public SchemaContainer getContainer() {
        return this._container;
    }

    public XmlObject getParseObject() {
        return this._parseObject;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public SchemaGlobalElement.Ref getRef() {
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

    public void setFilename(String str) {
        this._filename = str;
    }

    public void setFinal(boolean z6, boolean z7) {
        mutate();
        this._finalExt = z6;
        this._finalRest = z7;
    }

    public void setParseContext(XmlObject xmlObject, String str, boolean z6) {
        this._parseObject = xmlObject;
        this._parseTNS = str;
        this._chameleon = z6;
    }

    public void setSubstitutionGroup(SchemaGlobalElement.Ref ref) {
        this._sg = ref;
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public SchemaGlobalElement substitutionGroup() {
        SchemaGlobalElement.Ref ref = this._sg;
        if (ref == null) {
            return null;
        }
        return ref.get();
    }

    @Override // org.apache.xmlbeans.SchemaGlobalElement
    public QName[] substitutionGroupMembers() {
        return (QName[]) this._sgMembers.toArray(_namearray);
    }
}
