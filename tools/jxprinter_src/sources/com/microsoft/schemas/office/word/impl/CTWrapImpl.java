package com.microsoft.schemas.office.word.impl;

import com.microsoft.schemas.office.word.CTWrap;
import com.microsoft.schemas.office.word.STHorizontalAnchor;
import com.microsoft.schemas.office.word.STHorizontalAnchor$Enum;
import com.microsoft.schemas.office.word.STVerticalAnchor;
import com.microsoft.schemas.office.word.STVerticalAnchor$Enum;
import com.microsoft.schemas.office.word.STWrapSide;
import com.microsoft.schemas.office.word.STWrapSide$Enum;
import com.microsoft.schemas.office.word.STWrapType;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTWrapImpl extends XmlComplexContentImpl implements CTWrap {
    private static final QName[] PROPERTY_QNAME = {new QName("", "type"), new QName("", "side"), new QName("", "anchorx"), new QName("", "anchory")};
    private static final long serialVersionUID = 1;

    public CTWrapImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STHorizontalAnchor$Enum getAnchorx() {
        STHorizontalAnchor$Enum sTHorizontalAnchor$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            sTHorizontalAnchor$Enum = simpleValue == null ? null : (STHorizontalAnchor$Enum) simpleValue.getEnumValue();
        }
        return sTHorizontalAnchor$Enum;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STVerticalAnchor$Enum getAnchory() {
        STVerticalAnchor$Enum sTVerticalAnchor$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            sTVerticalAnchor$Enum = simpleValue == null ? null : (STVerticalAnchor$Enum) simpleValue.getEnumValue();
        }
        return sTVerticalAnchor$Enum;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STWrapSide$Enum getSide() {
        STWrapSide$Enum sTWrapSide$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            sTWrapSide$Enum = simpleValue == null ? null : (STWrapSide$Enum) simpleValue.getEnumValue();
        }
        return sTWrapSide$Enum;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STWrapType.Enum getType() {
        STWrapType.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            r6 = simpleValue == null ? null : (STWrapType.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public boolean isSetAnchorx() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[2]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public boolean isSetAnchory() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[3]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public boolean isSetSide() {
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

    @Override // com.microsoft.schemas.office.word.CTWrap
    public boolean isSetType() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().find_attribute_user(PROPERTY_QNAME[0]) != null;
        }
        return z6;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void setAnchorx(STHorizontalAnchor$Enum sTHorizontalAnchor$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setEnumValue(sTHorizontalAnchor$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void setAnchory(STVerticalAnchor$Enum sTVerticalAnchor$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setEnumValue(sTVerticalAnchor$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void setSide(STWrapSide$Enum sTWrapSide$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setEnumValue(sTWrapSide$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void setType(STWrapType.Enum r6) {
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

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void unsetAnchorx() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[2]);
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void unsetAnchory() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[3]);
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void unsetSide() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[1]);
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void unsetType() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_attribute(PROPERTY_QNAME[0]);
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STHorizontalAnchor xgetAnchorx() {
        STHorizontalAnchor sTHorizontalAnchorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTHorizontalAnchorFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return sTHorizontalAnchorFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STVerticalAnchor xgetAnchory() {
        STVerticalAnchor sTVerticalAnchorFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTVerticalAnchorFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTVerticalAnchorFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STWrapSide xgetSide() {
        STWrapSide sTWrapSideFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapSideFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTWrapSideFind_attribute_user;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public STWrapType xgetType() {
        STWrapType sTWrapType;
        synchronized (monitor()) {
            check_orphaned();
            sTWrapType = (STWrapType) get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTWrapType;
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void xsetAnchorx(STHorizontalAnchor sTHorizontalAnchor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STHorizontalAnchor sTHorizontalAnchorFind_attribute_user = typeStore.find_attribute_user(qNameArr[2]);
                if (sTHorizontalAnchorFind_attribute_user == null) {
                    sTHorizontalAnchorFind_attribute_user = (STHorizontalAnchor) get_store().add_attribute_user(qNameArr[2]);
                }
                sTHorizontalAnchorFind_attribute_user.set(sTHorizontalAnchor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void xsetAnchory(STVerticalAnchor sTVerticalAnchor) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STVerticalAnchor sTVerticalAnchorFind_attribute_user = typeStore.find_attribute_user(qNameArr[3]);
                if (sTVerticalAnchorFind_attribute_user == null) {
                    sTVerticalAnchorFind_attribute_user = (STVerticalAnchor) get_store().add_attribute_user(qNameArr[3]);
                }
                sTVerticalAnchorFind_attribute_user.set(sTVerticalAnchor);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void xsetSide(STWrapSide sTWrapSide) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STWrapSide sTWrapSideFind_attribute_user = typeStore.find_attribute_user(qNameArr[1]);
                if (sTWrapSideFind_attribute_user == null) {
                    sTWrapSideFind_attribute_user = (STWrapSide) get_store().add_attribute_user(qNameArr[1]);
                }
                sTWrapSideFind_attribute_user.set(sTWrapSide);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.microsoft.schemas.office.word.CTWrap
    public void xsetType(STWrapType sTWrapType) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STWrapType sTWrapType2 = (STWrapType) typeStore.find_attribute_user(qNameArr[0]);
                if (sTWrapType2 == null) {
                    sTWrapType2 = (STWrapType) get_store().add_attribute_user(qNameArr[0]);
                }
                sTWrapType2.set(sTWrapType);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
