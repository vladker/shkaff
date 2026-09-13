package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjAngle;
import org.openxmlformats.schemas.drawingml.x2006.main.STAdjCoordinate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTPath2DArcToImpl extends XmlComplexContentImpl implements CTPath2DArcTo {
    private static final QName[] PROPERTY_QNAME = {new QName("", "wR"), new QName("", "hR"), new QName("", "stAng"), new QName("", "swAng")};
    private static final long serialVersionUID = 1;

    public CTPath2DArcToImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getHR() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getStAng() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getSwAng() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public Object getWR() {
        Object objectValue;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setHR(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setStAng(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setSwAng(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void setWR(Object obj) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setObjectValue(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjCoordinate xgetHR() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjAngle xgetStAng() {
        STAdjAngle sTAdjAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjAngle = (STAdjAngle) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return sTAdjAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjAngle xgetSwAng() {
        STAdjAngle sTAdjAngle;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjAngle = (STAdjAngle) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTAdjAngle;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public STAdjCoordinate xgetWR() {
        STAdjCoordinate sTAdjCoordinate;
        synchronized (monitor()) {
            check_orphaned();
            sTAdjCoordinate = (STAdjCoordinate) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTAdjCoordinate;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetHR(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qNameArr[1]);
                if (sTAdjCoordinate2 == null) {
                    sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qNameArr[1]);
                }
                sTAdjCoordinate2.set(sTAdjCoordinate);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetStAng(STAdjAngle sTAdjAngle) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STAdjAngle sTAdjAngle2 = (STAdjAngle) typeStore.find_attribute_user(qNameArr[2]);
                if (sTAdjAngle2 == null) {
                    sTAdjAngle2 = (STAdjAngle) get_store().add_attribute_user(qNameArr[2]);
                }
                sTAdjAngle2.set(sTAdjAngle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetSwAng(STAdjAngle sTAdjAngle) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STAdjAngle sTAdjAngle2 = (STAdjAngle) typeStore.find_attribute_user(qNameArr[3]);
                if (sTAdjAngle2 == null) {
                    sTAdjAngle2 = (STAdjAngle) get_store().add_attribute_user(qNameArr[3]);
                }
                sTAdjAngle2.set(sTAdjAngle);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DArcTo
    public void xsetWR(STAdjCoordinate sTAdjCoordinate) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STAdjCoordinate sTAdjCoordinate2 = (STAdjCoordinate) typeStore.find_attribute_user(qNameArr[0]);
                if (sTAdjCoordinate2 == null) {
                    sTAdjCoordinate2 = (STAdjCoordinate) get_store().add_attribute_user(qNameArr[0]);
                }
                sTAdjCoordinate2.set(sTAdjCoordinate);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
