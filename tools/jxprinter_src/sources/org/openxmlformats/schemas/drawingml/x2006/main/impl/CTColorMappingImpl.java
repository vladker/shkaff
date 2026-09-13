package org.openxmlformats.schemas.drawingml.x2006.main.impl;

import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.impl.values.TypeStore;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.main.STColorSchemeIndex;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTColorMappingImpl extends XmlComplexContentImpl implements CTColorMapping {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_DRAWINGML, "extLst"), new QName("", "bg1"), new QName("", "tx1"), new QName("", "bg2"), new QName("", "tx2"), new QName("", "accent1"), new QName("", "accent2"), new QName("", "accent3"), new QName("", "accent4"), new QName("", "accent5"), new QName("", "accent6"), new QName("", "hlink"), new QName("", "folHlink")};
    private static final long serialVersionUID = 1;

    public CTColorMappingImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public CTOfficeArtExtensionList addNewExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent1() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[5]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent2() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[6]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent3() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[7]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent4() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[8]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent5() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[9]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getAccent6() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[10]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getBg1() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[1]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getBg2() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[3]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public CTOfficeArtExtensionList getExtLst() {
        CTOfficeArtExtensionList cTOfficeArtExtensionList;
        synchronized (monitor()) {
            check_orphaned();
            cTOfficeArtExtensionList = (CTOfficeArtExtensionList) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (cTOfficeArtExtensionList == null) {
                cTOfficeArtExtensionList = null;
            }
        }
        return cTOfficeArtExtensionList;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getFolHlink() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[12]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getHlink() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[11]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getTx1() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[2]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex.Enum getTx2() {
        STColorSchemeIndex.Enum r6;
        synchronized (monitor()) {
            check_orphaned();
            SimpleValue simpleValue = (SimpleValue) get_store().find_attribute_user(PROPERTY_QNAME[4]);
            r6 = simpleValue == null ? null : (STColorSchemeIndex.Enum) simpleValue.getEnumValue();
        }
        return r6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public boolean isSetExtLst() {
        boolean z6;
        synchronized (monitor()) {
            check_orphaned();
            z6 = get_store().count_elements(PROPERTY_QNAME[0]) != 0;
        }
        return z6;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent1(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[5]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[5]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent2(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[6]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[6]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent3(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[7]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[7]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent4(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[8]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[8]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent5(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[9]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[9]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setAccent6(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[10]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[10]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setBg1(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[1]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[1]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setBg2(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[3]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[3]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList) {
        generatedSetterHelperImpl(cTOfficeArtExtensionList, PROPERTY_QNAME[0], 0, (short) 1);
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setFolHlink(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[12]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[12]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setHlink(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[11]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[11]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setTx1(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[2]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[2]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void setTx2(STColorSchemeIndex.Enum r6) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                SimpleValue simpleValue = (SimpleValue) typeStore.find_attribute_user(qNameArr[4]);
                if (simpleValue == null) {
                    simpleValue = (SimpleValue) get_store().add_attribute_user(qNameArr[4]);
                }
                simpleValue.setEnumValue(r6);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void unsetExtLst() {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], 0);
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[5]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[6]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent3() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[7]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent4() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[8]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent5() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[9]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetAccent6() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[10]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetBg1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[1]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetBg2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[3]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetFolHlink() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[12]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetHlink() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[11]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetTx1() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[2]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public STColorSchemeIndex xgetTx2() {
        STColorSchemeIndex sTColorSchemeIndex;
        synchronized (monitor()) {
            check_orphaned();
            sTColorSchemeIndex = (STColorSchemeIndex) get_store().find_attribute_user(PROPERTY_QNAME[4]);
        }
        return sTColorSchemeIndex;
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[5]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[5]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[6]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[6]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent3(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[7]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[7]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent4(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[8]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[8]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent5(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[9]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[9]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetAccent6(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[10]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[10]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetBg1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[1]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[1]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetBg2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[3]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[3]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetFolHlink(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[12]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[12]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetHlink(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[11]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[11]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetTx1(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[2]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[2]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.openxmlformats.schemas.drawingml.x2006.main.CTColorMapping
    public void xsetTx2(STColorSchemeIndex sTColorSchemeIndex) {
        synchronized (monitor()) {
            try {
                check_orphaned();
                TypeStore typeStore = get_store();
                QName[] qNameArr = PROPERTY_QNAME;
                STColorSchemeIndex sTColorSchemeIndex2 = (STColorSchemeIndex) typeStore.find_attribute_user(qNameArr[4]);
                if (sTColorSchemeIndex2 == null) {
                    sTColorSchemeIndex2 = (STColorSchemeIndex) get_store().add_attribute_user(qNameArr[4]);
                }
                sTColorSchemeIndex2.set(sTColorSchemeIndex);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
