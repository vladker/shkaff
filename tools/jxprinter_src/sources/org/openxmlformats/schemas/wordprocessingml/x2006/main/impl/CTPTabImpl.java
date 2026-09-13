package org.openxmlformats.schemas.wordprocessingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabAlignment;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabAlignment$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabLeader;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabLeader$Enum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabRelativeTo;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STPTabRelativeTo$Enum;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTPTabImpl extends XmlComplexContentImpl implements CTPTab {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_WORDPROCESSINGML, CellUtil.ALIGNMENT), new QName(XSSFRelation.NS_WORDPROCESSINGML, "relativeTo"), new QName(XSSFRelation.NS_WORDPROCESSINGML, "leader")};
    private static final long serialVersionUID = 1;

    public CTPTabImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabAlignment$Enum getAlignment() {
        STPTabAlignment$Enum sTPTabAlignment$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[0]);
            sTPTabAlignment$Enum = simpleValue == null ? null : (STPTabAlignment$Enum) simpleValue.getEnumValue();
        }
        return sTPTabAlignment$Enum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabLeader$Enum getLeader() {
        STPTabLeader$Enum sTPTabLeader$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            sTPTabLeader$Enum = simpleValue == null ? null : (STPTabLeader$Enum) simpleValue.getEnumValue();
        }
        return sTPTabLeader$Enum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabRelativeTo$Enum getRelativeTo() {
        STPTabRelativeTo$Enum sTPTabRelativeTo$Enum;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            sTPTabRelativeTo$Enum = simpleValue == null ? null : (STPTabRelativeTo$Enum) simpleValue.getEnumValue();
        }
        return sTPTabRelativeTo$Enum;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setAlignment(STPTabAlignment$Enum sTPTabAlignment$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[0]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[0]);
                }
                simpleValue.setEnumValue(sTPTabAlignment$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setLeader(STPTabLeader$Enum sTPTabLeader$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setEnumValue(sTPTabLeader$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void setRelativeTo(STPTabRelativeTo$Enum sTPTabRelativeTo$Enum) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setEnumValue(sTPTabRelativeTo$Enum);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabAlignment xgetAlignment() {
        STPTabAlignment sTPTabAlignmentFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabAlignmentFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[0]);
        }
        return sTPTabAlignmentFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabLeader xgetLeader() {
        STPTabLeader sTPTabLeaderFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabLeaderFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return sTPTabLeaderFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public STPTabRelativeTo xgetRelativeTo() {
        STPTabRelativeTo sTPTabRelativeToFind_attribute_user;
        synchronized (monitor()) {
            check_orphaned();
            sTPTabRelativeToFind_attribute_user = get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTPTabRelativeToFind_attribute_user;
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetAlignment(STPTabAlignment sTPTabAlignment) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPTabAlignment sTPTabAlignmentFind_attribute_user = typeStore.find_attribute_user(qNameArr[0]);
                if (sTPTabAlignmentFind_attribute_user == null) {
                    sTPTabAlignmentFind_attribute_user = (STPTabAlignment) get_store().add_attribute_user(qNameArr[0]);
                }
                sTPTabAlignmentFind_attribute_user.set(sTPTabAlignment);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetLeader(STPTabLeader sTPTabLeader) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPTabLeader sTPTabLeaderFind_attribute_user = typeStore.find_attribute_user(qNameArr[2]);
                if (sTPTabLeaderFind_attribute_user == null) {
                    sTPTabLeaderFind_attribute_user = (STPTabLeader) get_store().add_attribute_user(qNameArr[2]);
                }
                sTPTabLeaderFind_attribute_user.set(sTPTabLeader);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPTab
    public void xsetRelativeTo(STPTabRelativeTo sTPTabRelativeTo) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STPTabRelativeTo sTPTabRelativeToFind_attribute_user = typeStore.find_attribute_user(qNameArr[1]);
                if (sTPTabRelativeToFind_attribute_user == null) {
                    sTPTabRelativeToFind_attribute_user = (STPTabRelativeTo) get_store().add_attribute_user(qNameArr[1]);
                }
                sTPTabRelativeToFind_attribute_user.set(sTPTabRelativeTo);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
