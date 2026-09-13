package com.microsoft.schemas.vml.impl;

import com.microsoft.schemas.vml.CTF;
import com.microsoft.schemas.vml.CTFormulas;
import com.microsoft.schemas.vml.impl.CTFormulasImpl;
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
public class CTFormulasImpl extends XmlComplexContentImpl implements CTFormulas {
    private static final QName[] PROPERTY_QNAME = {new QName("urn:schemas-microsoft-com:vml", "f")};
    private static final long serialVersionUID = 1;

    public CTFormulasImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF addNewF() {
        CTF ctf;
        synchronized (monitor()) {
            check_orphaned();
            ctf = (CTF) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return ctf;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF[] getFArray() {
        return (CTF[]) getXmlObjectArray(PROPERTY_QNAME[0], new CTF[0]);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public List<CTF> getFList() {
        JavaListXmlObject javaListXmlObject;
        synchronized (monitor()) {
            check_orphaned();
            final int i5 = 0;
            final int i6 = 1;
            javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: t2.a
                public final /* synthetic */ CTFormulasImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i5;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getFArray(iIntValue);
                        default:
                            return this.b.insertNewF(iIntValue);
                    }
                }
            }, new C1758x3(this, 4), new Function(this) { // from class: t2.a
                public final /* synthetic */ CTFormulasImpl b;

                {
                    this.b = this;
                }

                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i7 = i6;
                    int iIntValue = ((Integer) obj).intValue();
                    switch (i7) {
                        case 0:
                            return this.b.getFArray(iIntValue);
                        default:
                            return this.b.insertNewF(iIntValue);
                    }
                }
            }, new i(this, 19), new j(this, 19));
        }
        return javaListXmlObject;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF insertNewF(int i5) {
        CTF ctf;
        synchronized (monitor()) {
            check_orphaned();
            ctf = (CTF) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
        }
        return ctf;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void removeF(int i5) {
        synchronized (monitor()) {
            check_orphaned();
            get_store().remove_element(PROPERTY_QNAME[0], i5);
        }
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void setFArray(CTF[] ctfArr) {
        check_orphaned();
        arraySetterHelper(ctfArr, PROPERTY_QNAME[0]);
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public int sizeOfFArray() {
        int iCount_elements;
        synchronized (monitor()) {
            check_orphaned();
            iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
        }
        return iCount_elements;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public CTF getFArray(int i5) {
        CTF ctf;
        synchronized (monitor()) {
            try {
                check_orphaned();
                ctf = (CTF) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                if (ctf == null) {
                    throw new IndexOutOfBoundsException();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return ctf;
    }

    @Override // com.microsoft.schemas.vml.CTFormulas
    public void setFArray(int i5, CTF ctf) {
        generatedSetterHelperImpl(ctf, PROPERTY_QNAME[0], i5, (short) 2);
    }
}
