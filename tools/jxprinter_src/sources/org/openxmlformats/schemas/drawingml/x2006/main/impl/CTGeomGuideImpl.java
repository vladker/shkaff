package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideFormula;
import org.openxmlformats.schemas.drawingml.x2006.main.STGeomGuideName;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTGeomGuideImpl extends XmlComplexContentImpl implements CTGeomGuide {
    private static final QName[] PROPERTY_QNAME = {new QName("", "name"), new QName("", "fmla")};
    private static final long serialVersionUID = 1;

    public CTGeomGuideImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public String getFmla() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public String getName() {
        String stringValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            stringValue = simpleValue == null ? null : simpleValue.getStringValue();
        }
        return stringValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void setFmla(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void setName(String str) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setStringValue(str);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public STGeomGuideFormula xgetFmla() {
        STGeomGuideFormula sTGeomGuideFormula;
        synchronized (monitor()) {
            check_orphaned();
            sTGeomGuideFormula = (STGeomGuideFormula) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTGeomGuideFormula;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public STGeomGuideName xgetName() {
        STGeomGuideName sTGeomGuideName;
        synchronized (monitor()) {
            check_orphaned();
            sTGeomGuideName = (STGeomGuideName) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTGeomGuideName;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void xsetFmla(STGeomGuideFormula sTGeomGuideFormula) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STGeomGuideFormula sTGeomGuideFormula2 = (STGeomGuideFormula) typeStore.find_attribute_user(qNameArr[1]);
                if (sTGeomGuideFormula2 == null) {
                    sTGeomGuideFormula2 = (STGeomGuideFormula) get_store().add_attribute_user(qNameArr[1]);
                }
                sTGeomGuideFormula2.set(sTGeomGuideFormula);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide
    public void xsetName(STGeomGuideName sTGeomGuideName) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STGeomGuideName sTGeomGuideName2 = (STGeomGuideName) typeStore.find_attribute_user(qNameArr[0]);
                if (sTGeomGuideName2 == null) {
                    sTGeomGuideName2 = (STGeomGuideName) get_store().add_attribute_user(qNameArr[0]);
                }
                sTGeomGuideName2.set(sTGeomGuideName);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
