package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetName;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTExternalSheetNamesImpl;
import r5.B;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTExternalSheetNamesImpl extends XmlComplexContentImpl implements CTExternalSheetNames {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "sheetName")};
    private static final long serialVersionUID = 1;

    public CTExternalSheetNamesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName addNewSheetName() {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName[] getSheetNameArray() {
        return (CTExternalSheetName[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTExternalSheetName[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public List<CTExternalSheetName> getSheetNameList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.P
                public final /* synthetic */ CTExternalSheetNamesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSheetNameArray(iIntValue);
                        default:
                            return this.b.insertNewSheetName(iIntValue);
                    }
                }
            }, new B(this, 14), new Function(this) { // from class: r5.P
                public final /* synthetic */ CTExternalSheetNamesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getSheetNameArray(iIntValue);
                        default:
                            return this.b.insertNewSheetName(iIntValue);
                    }
                }
            }, new C1566i(this, 26), new C1568j(this, 26));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName insertNewSheetName(int i5) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            check_orphaned();
            cTExternalSheetName = (CTExternalSheetName) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void removeSheetName(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(CTExternalSheetName[] cTExternalSheetNameArr) {
        check_orphaned();
        arraySetterHelper(cTExternalSheetNameArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public int sizeOfSheetNameArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public CTExternalSheetName getSheetNameArray(int i5) {
        CTExternalSheetName cTExternalSheetName;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTExternalSheetName = (CTExternalSheetName) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTExternalSheetName == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTExternalSheetName;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTExternalSheetNames
    public void setSheetNameArray(int i5, CTExternalSheetName cTExternalSheetName) {
        generatedSetterHelperImpl(cTExternalSheetName, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
