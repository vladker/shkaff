package org.openxmlformats.schemas.officeDocument.x2006.math.impl;

import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import l5.b2;
import l5.d2;
import l5.g2;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMC;
import org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS;
import org.openxmlformats.schemas.officeDocument.x2006.math.impl.CTMCSImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class CTMCSImpl extends XmlComplexContentImpl implements CTMCS {
    private static final QName[] PROPERTY_QNAME = {new QName("http://schemas.openxmlformats.org/officeDocument/2006/math", "mc")};
    private static final long serialVersionUID = 1;

    public CTMCSImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC addNewMc() {
        CTMC ctmc;
        synchronized (monitor()) {
            check_orphaned();
            ctmc = (CTMC) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC[] getMcArray() {
        return (CTMC[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTMC[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public List<CTMC> getMcList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: p5.b
                public final /* synthetic */ CTMCSImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getMcArray(iIntValue);
                        default:
                            return this.b.insertNewMc(iIntValue);
                    }
                }
            }, new g2(this, 7), new Function(this) { // from class: p5.b
                public final /* synthetic */ CTMCSImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getMcArray(iIntValue);
                        default:
                            return this.b.insertNewMc(iIntValue);
                    }
                }
            }, new d2(this, 14), new b2(this, 14));
        }
        return javaListXmlObject;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC insertNewMc(int i5) {
        CTMC ctmc;
        synchronized (monitor()) {
            check_orphaned();
            ctmc = (CTMC) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void removeMc(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void setMcArray(CTMC[] ctmcArr) {
        check_orphaned();
        arraySetterHelper(ctmcArr, PROPERTY_QNAME[0]);
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public int sizeOfMcArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public CTMC getMcArray(int i5) {
        CTMC ctmc;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctmc = (CTMC) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (ctmc == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctmc;
    }

    @Override // org.openxmlformats.schemas.officeDocument.x2006.math.CTMCS
    public void setMcArray(int i5, CTMC ctmc) {
        generatedSetterHelperImpl(ctmc, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
