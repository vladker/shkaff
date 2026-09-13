package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTDefinedNamesImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTDefinedNamesImpl extends XmlComplexContentImpl implements CTDefinedNames {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "definedName")};
    private static final long serialVersionUID = 1;

    public CTDefinedNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName addNewDefinedName() {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName[] getDefinedNameArray() {
        return (CTDefinedName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTDefinedName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public List<CTDefinedName> getDefinedNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.H
                public final /* synthetic */ CTDefinedNamesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getDefinedNameArray(iIntValue);
                        default:
                            return this.b.insertNewDefinedName(iIntValue);
                    }
                }
            }, new B(this, 6), new Function(this) { // from class: r5.H
                public final /* synthetic */ CTDefinedNamesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getDefinedNameArray(iIntValue);
                        default:
                            return this.b.insertNewDefinedName(iIntValue);
                    }
                }
            }, new C1566i(this, 18), new C1568j(this, 18));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName insertNewDefinedName(int i5) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            check_orphaned();
            cTDefinedName = (CTDefinedName) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void removeDefinedName(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(CTDefinedName[] cTDefinedNameArr) {
        check_orphaned();
        arraySetterHelper(cTDefinedNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public int sizeOfDefinedNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public CTDefinedName getDefinedNameArray(int i5) {
        CTDefinedName cTDefinedName;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTDefinedName = (CTDefinedName) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTDefinedName == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTDefinedName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTDefinedNames
    public void setDefinedNameArray(int i5, CTDefinedName cTDefinedName) {
        generatedSetterHelperImpl(cTDefinedName, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
