package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTH;
import com.microsoft.schemas.vml.CTHandles;
import com.microsoft.schemas.vml.impl.CTHandlesImpl;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import p105s2.i;
import p105s2.j;
import s5.C1758x3;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public class CTHandlesImpl extends XmlComplexContentImpl implements CTHandles {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:vml", "h")};
    private static final long serialVersionUID = 1;

    public CTHandlesImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public CTH addNewH() {
        CTH cth;
        synchronized (monitor()) {
            check_orphaned();
            cth = (CTH) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return cth;
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public CTH[] getHArray() {
        return (CTH[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTH[0]);
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public List<CTH> getHList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: t2.x
                public final /* synthetic */ CTHandlesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getHArray(iIntValue);
                        default:
                            return this.b.insertNewH(iIntValue);
                    }
                }
            }, new C1758x3(this, 5), new Function(this) { // from class: t2.x
                public final /* synthetic */ CTHandlesImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getHArray(iIntValue);
                        default:
                            return this.b.insertNewH(iIntValue);
                    }
                }
            }, new i(this, 20), new j(this, 20));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public CTH insertNewH(int i5) {
        CTH cth;
        synchronized (monitor()) {
            check_orphaned();
            cth = (CTH) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return cth;
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public void removeH(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public void setHArray(CTH[] cthArr) {
        check_orphaned();
        arraySetterHelper(cthArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public int sizeOfHArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public CTH getHArray(int i5) {
        CTH cth;
        synchronized (monitor()) {
            try {
                check_orphaned();
                cth = (CTH) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (cth == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cth;
    }

    @Override // com.microsoft.schemas.vml.CTHandles
    public void setHArray(int i5, CTH cth) {
        generatedSetterHelperImpl(cth, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
