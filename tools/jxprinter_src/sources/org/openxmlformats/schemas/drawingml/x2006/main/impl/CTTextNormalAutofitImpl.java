package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextFontScalePercentOrPercentString;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextSpacingPercentOrPercentString;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTextNormalAutofitImpl extends XmlComplexContentImpl implements CTTextNormalAutofit {
    private static final QName[] PROPERTY_QNAME = {new QName("", "fontScale"), new QName("", "lnSpcReduction")};
    private static final long serialVersionUID = 1;

    public CTTextNormalAutofitImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public Object getFontScale() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[0]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public Object getLnSpcReduction() {
        Object objectValue;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_default_attribute_value(qNameArr[1]);
                }
                objectValue = simpleValue == null ? null : simpleValue.getObjectValue();
            } catch (Throwable th) {
                throw th;
            }
        }
        return objectValue;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public boolean isSetFontScale() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public boolean isSetLnSpcReduction() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = true;
            if (get_store().find_attribute_user(PROPERTY_QNAME[1]) == null) {
                z6 = false;
            }
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void setFontScale(Object obj) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void setLnSpcReduction(Object obj) {
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

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void unsetFontScale() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void unsetLnSpcReduction() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public STTextFontScalePercentOrPercentString xgetFontScale() {
        STTextFontScalePercentOrPercentString sTTextFontScalePercentOrPercentString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTTextFontScalePercentOrPercentString = (STTextFontScalePercentOrPercentString) typeStore.find_attribute_user(qNameArr[0]);
                if (sTTextFontScalePercentOrPercentString == null) {
                    sTTextFontScalePercentOrPercentString = (STTextFontScalePercentOrPercentString) get_default_attribute_value(qNameArr[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTextFontScalePercentOrPercentString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public STTextSpacingPercentOrPercentString xgetLnSpcReduction() {
        STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString;
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                sTTextSpacingPercentOrPercentString = (STTextSpacingPercentOrPercentString) typeStore.find_attribute_user(qNameArr[1]);
                if (sTTextSpacingPercentOrPercentString == null) {
                    sTTextSpacingPercentOrPercentString = (STTextSpacingPercentOrPercentString) get_default_attribute_value(qNameArr[1]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sTTextSpacingPercentOrPercentString;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void xsetFontScale(STTextFontScalePercentOrPercentString sTTextFontScalePercentOrPercentString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextFontScalePercentOrPercentString sTTextFontScalePercentOrPercentString2 = (STTextFontScalePercentOrPercentString) typeStore.find_attribute_user(qNameArr[0]);
                if (sTTextFontScalePercentOrPercentString2 == null) {
                    sTTextFontScalePercentOrPercentString2 = (STTextFontScalePercentOrPercentString) get_store().add_attribute_user(qNameArr[0]);
                }
                sTTextFontScalePercentOrPercentString2.set(sTTextFontScalePercentOrPercentString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTTextNormalAutofit
    public void xsetLnSpcReduction(STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STTextSpacingPercentOrPercentString sTTextSpacingPercentOrPercentString2 = (STTextSpacingPercentOrPercentString) typeStore.find_attribute_user(qNameArr[1]);
                if (sTTextSpacingPercentOrPercentString2 == null) {
                    sTTextSpacingPercentOrPercentString2 = (STTextSpacingPercentOrPercentString) get_store().add_attribute_user(qNameArr[1]);
                }
                sTTextSpacingPercentOrPercentString2.set(sTTextSpacingPercentOrPercentString);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
