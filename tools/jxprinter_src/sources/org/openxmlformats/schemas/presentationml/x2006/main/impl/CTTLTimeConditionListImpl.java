package org.openxmlformats.schemas.presentationml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeCondition;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList;
import org.openxmlformats.schemas.presentationml.x2006.main.impl.CTTLTimeConditionListImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTTLTimeConditionListImpl extends XmlComplexContentImpl implements CTTLTimeConditionList {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_PRESENTATIONML, "cond")};
    private static final long serialVersionUID = 1;

    public CTTLTimeConditionListImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition addNewCond() {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition[] getCondArray() {
        return (CTTLTimeCondition[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTTLTimeCondition[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public List<CTTLTimeCondition> getCondList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: q5.m
                public final /* synthetic */ CTTLTimeConditionListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCondArray(iIntValue);
                        default:
                            return this.b.insertNewCond(iIntValue);
                    }
                }
            }, new g2(this, 17), new Function(this) { // from class: q5.m
                public final /* synthetic */ CTTLTimeConditionListImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getCondArray(iIntValue);
                        default:
                            return this.b.insertNewCond(iIntValue);
                    }
                }
            }, new d2(this, 25), new b2(this, 25));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition insertNewCond(int i5) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            check_orphaned();
            cTTLTimeCondition = (CTTLTimeCondition) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void removeCond(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(CTTLTimeCondition[] cTTLTimeConditionArr) {
        check_orphaned();
        arraySetterHelper(cTTLTimeConditionArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public int sizeOfCondArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public CTTLTimeCondition getCondArray(int i5) {
        CTTLTimeCondition cTTLTimeCondition;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTTLTimeCondition = (CTTLTimeCondition) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTTLTimeCondition == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTTLTimeCondition;
    }

    @Override // org.openxmlformats.schemas.presentationml.x2006.main.CTTLTimeConditionList
    public void setCondArray(int i5, CTTLTimeCondition cTTLTimeCondition) {
        generatedSetterHelperImpl(cTTLTimeCondition, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
