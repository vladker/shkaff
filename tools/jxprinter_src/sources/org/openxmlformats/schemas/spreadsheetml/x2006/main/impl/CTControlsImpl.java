package org.openxmlformats.schemas.spreadsheetml.x2006.main.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.g2;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTControlsImpl;
import r5.C1566i;
import r5.C1568j;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes6.dex */
public class CTControlsImpl extends XmlComplexContentImpl implements CTControls {
    private static final QName[] PROPERTY_QNAME = {new QName(XSSFRelation.NS_SPREADSHEETML, "control")};
    private static final long serialVersionUID = 1;

    public CTControlsImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl addNewControl() {
        CTControl cTControl;
        synchronized (monitor()) {
            check_orphaned();
            cTControl = (CTControl) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl[] getControlArray() {
        return (CTControl[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTControl[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public List<CTControl> getControlList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: r5.z
                public final /* synthetic */ CTControlsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getControlArray(iIntValue);
                        default:
                            return this.b.insertNewControl(iIntValue);
                    }
                }
            }, new g2(this, 29), new Function(this) { // from class: r5.z
                public final /* synthetic */ CTControlsImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getControlArray(iIntValue);
                        default:
                            return this.b.insertNewControl(iIntValue);
                    }
                }
            }, new C1566i(this, 11), new C1568j(this, 11));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl insertNewControl(int i5) {
        CTControl cTControl;
        synchronized (monitor()) {
            check_orphaned();
            cTControl = (CTControl) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void removeControl(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void setControlArray(CTControl[] cTControlArr) {
        check_orphaned();
        arraySetterHelper(cTControlArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public int sizeOfControlArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public CTControl getControlArray(int i5) {
        CTControl cTControl;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cTControl = (CTControl) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cTControl == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cTControl;
    }

    @Override // org.openxmlformats.schemas.spreadsheetml.x2006.main.CTControls
    public void setControlArray(int i5, CTControl cTControl) {
        generatedSetterHelperImpl(cTControl, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
