package org.openxmlformats.schemas.drawingml.x2006.chart.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir;
import org.openxmlformats.schemas.drawingml.x2006.chart.STErrDir;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTErrDirImpl extends XmlComplexContentImpl implements CTErrDir {
    private static final QName[] PROPERTY_QNAME = {new QName("", "val")};
    private static final long serialVersionUID = 1;

    public CTErrDirImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
    public STErrDir.Enum getVal() {
        STErrDir.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STErrDir.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
    public void setVal(STErrDir.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
    public STErrDir xgetVal() {
        STErrDir sTErrDir;
        synchronized (monitor()) {
            check_orphaned();
            sTErrDir = (STErrDir) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTErrDir;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.chart.CTErrDir
    public void xsetVal(STErrDir sTErrDir) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STErrDir sTErrDir2 = (STErrDir) typeStore.find_attribute_user(qNameArr[0]);
                if (sTErrDir2 == null) {
                    sTErrDir2 = (STErrDir) get_store().add_attribute_user(qNameArr[0]);
                }
                sTErrDir2.set(sTErrDir);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
