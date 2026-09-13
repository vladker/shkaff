package org.apache.xmlbeans.impl.schema;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaAttributeModel;
import org.apache.xmlbeans.SchemaLocalAttribute;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class SchemaAttributeModelImpl implements SchemaAttributeModel {
    private static final SchemaLocalAttribute[] EMPTY_SLA_ARRAY = new SchemaLocalAttribute[0];
    private Map<QName, SchemaLocalAttribute> attrMap;
    private int wcProcess;
    private QNameSet wcSet;

    public SchemaAttributeModelImpl() {
        this.attrMap = new LinkedHashMap();
        this.wcSet = null;
        this.wcProcess = 0;
    }

    public void addAttribute(SchemaLocalAttribute schemaLocalAttribute) {
        this.attrMap.put(schemaLocalAttribute.getName(), schemaLocalAttribute);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute getAttribute(QName qName) {
        return this.attrMap.get(qName);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public SchemaLocalAttribute[] getAttributes() {
        return (SchemaLocalAttribute[]) this.attrMap.values().toArray(EMPTY_SLA_ARRAY);
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public int getWildcardProcess() {
        return this.wcProcess;
    }

    @Override // org.apache.xmlbeans.SchemaAttributeModel
    public QNameSet getWildcardSet() {
        QNameSet qNameSet = this.wcSet;
        return qNameSet == null ? QNameSet.EMPTY : qNameSet;
    }

    public void removeProhibitedAttribute(QName qName) {
        this.attrMap.remove(qName);
    }

    public void setWildcardProcess(int i5) {
        this.wcProcess = i5;
    }

    public void setWildcardSet(QNameSet qNameSet) {
        this.wcSet = qNameSet;
    }

    public SchemaAttributeModelImpl(SchemaAttributeModel schemaAttributeModel) {
        this.attrMap = new LinkedHashMap();
        if (schemaAttributeModel == null) {
            this.wcSet = null;
            this.wcProcess = 0;
            return;
        }
        SchemaLocalAttribute[] attributes = schemaAttributeModel.getAttributes();
        for (int i5 = 0; i5 < attributes.length; i5++) {
            this.attrMap.put(attributes[i5].getName(), attributes[i5]);
        }
        if (schemaAttributeModel.getWildcardProcess() != 0) {
            this.wcSet = schemaAttributeModel.getWildcardSet();
            this.wcProcess = schemaAttributeModel.getWildcardProcess();
        }
    }
}
