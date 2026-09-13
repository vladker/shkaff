package org.apache.xmlbeans.impl.values;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDuration;
import org.apache.xmlbeans.QNameSet;
import org.apache.xmlbeans.SchemaProperty;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SimpleValue;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class XmlComplexContentImpl extends XmlObjectBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final SchemaTypeImpl _schemaType;

    public XmlComplexContentImpl(SchemaType schemaType) {
        this._schemaType = (SchemaTypeImpl) schemaType;
        initComplexType(true, true);
    }

    private <T> void commonSetterHelper(QName qName, QNameSet qNameSet, T[] tArr, BiConsumer<XmlObjectBase, Integer> biConsumer) {
        commonSetterHelper(qName, qNameSet, tArr == null ? 0 : tArr.length, biConsumer);
    }

    private <T> void commonSetterHelper2(QName qName, QNameSet qNameSet, T[] tArr, BiConsumer<XmlObjectBase, T> biConsumer) {
        int length = tArr == null ? 0 : tArr.length;
        TypeStore typeStore = get_store();
        int iCount_elements = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
        while (iCount_elements > length) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, iCount_elements - 1);
            } else {
                typeStore.remove_element(qNameSet, iCount_elements - 1);
            }
            iCount_elements--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            biConsumer.accept((XmlObjectBase) (i5 >= iCount_elements ? typeStore.add_element_user(qName) : qNameSet == null ? typeStore.find_element_user(qName, i5) : typeStore.find_element_user(qNameSet, i5)), tArr[i5]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$0(SimpleValue[] simpleValueArr, XmlObjectBase xmlObjectBase, Integer num) {
        simpleValueArr[num.intValue()] = xmlObjectBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$1(SimpleValue[] simpleValueArr, XmlObjectBase xmlObjectBase, Integer num) {
        simpleValueArr[num.intValue()] = xmlObjectBase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$10(float[] fArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setFloatValue(fArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$11(double[] dArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setDoubleValue(dArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$12(byte[] bArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setByteValue(bArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$13(short[] sArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setShortValue(sArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$14(int[] iArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setIntValue(iArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$15(long[] jArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setLongValue(jArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$2(boolean[] zArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setBooleanValue(zArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$3(float[] fArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setFloatValue(fArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$4(double[] dArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setDoubleValue(dArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$5(byte[] bArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setByteValue(bArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$6(short[] sArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setShortValue(sArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$7(int[] iArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setIntValue(iArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$8(long[] jArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setLongValue(jArr[num.intValue()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arraySetterHelper$9(boolean[] zArr, XmlObjectBase xmlObjectBase, Integer num) {
        xmlObjectBase.setBooleanValue(zArr[num.intValue()]);
    }

    public SimpleValue[] arraySetterHelper(int i5, QName qName) {
        SimpleValue[] simpleValueArr = new SimpleValue[i5];
        commonSetterHelper(qName, (QNameSet) null, simpleValueArr, new d(simpleValueArr, 1));
        return simpleValueArr;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public String compute_text(NamespaceManager namespaceManager) {
        return null;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public boolean equal_to(XmlObject xmlObject) {
        return this._schemaType.equals(xmlObject.schemaType());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_attribute_text(QName qName) {
        return super.get_default_attribute_text(qName);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public String get_default_element_text(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        return elementProperty == null ? "" : elementProperty.getDefaultText();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public int get_elementflags(QName qName) {
        SchemaProperty elementProperty = schemaType().getElementProperty(qName);
        if (elementProperty == null) {
            return 0;
        }
        if (elementProperty.hasDefault() == 1 || elementProperty.hasFixed() == 1 || elementProperty.hasNillable() == 1) {
            return -1;
        }
        return (elementProperty.hasDefault() == 0 ? 0 : 2) | (elementProperty.hasFixed() == 0 ? 0 : 4) | (elementProperty.hasNillable() != 0 ? 1 : 0);
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public boolean is_child_element_order_sensitive() {
        return schemaType().isOrderSensitive();
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.impl.values.TypeStoreUser
    public TypeStoreVisitor new_visitor() {
        return new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase, org.apache.xmlbeans.XmlObject
    public SchemaType schemaType() {
        return this._schemaType;
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public final void set_String(String str) {
        if (this._schemaType.getContentType() == 4 || this._schemaType.isNoType()) {
            super.set_String(str);
        } else {
            throw new IllegalArgumentException("Type does not allow for textual content: " + this._schemaType);
        }
    }

    public void unionArraySetterHelper(Object[] objArr, QName qName) {
        commonSetterHelper2(qName, null, objArr, new org.apache.poi.poifs.nio.b(1));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public int value_hash_code() {
        throw new IllegalStateException("Complex types cannot be used as hash keys");
    }

    private void commonSetterHelper(QName qName, QNameSet qNameSet, int i5, BiConsumer<XmlObjectBase, Integer> biConsumer) {
        TypeStore typeStore = get_store();
        int iCount_elements = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
        while (iCount_elements > i5) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, iCount_elements - 1);
            } else {
                typeStore.remove_element(qNameSet, iCount_elements - 1);
            }
            iCount_elements--;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            biConsumer.accept((XmlObjectBase) (i6 >= iCount_elements ? typeStore.add_element_user(qName) : qNameSet == null ? typeStore.find_element_user(qName, i6) : typeStore.find_element_user(qNameSet, i6)), Integer.valueOf(i6));
        }
    }

    public void unionArraySetterHelper(Object[] objArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, objArr, new org.apache.poi.poifs.nio.b(1));
    }

    public SimpleValue[] arraySetterHelper(int i5, QName qName, QNameSet qNameSet) {
        SimpleValue[] simpleValueArr = new SimpleValue[i5];
        commonSetterHelper(qName, qNameSet, simpleValueArr, new d(simpleValueArr, 0));
        return simpleValueArr;
    }

    public void arraySetterHelper(boolean[] zArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, zArr == null ? 0 : zArr.length, new h(zArr, 0));
    }

    public void arraySetterHelper(float[] fArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, fArr == null ? 0 : fArr.length, new b(fArr, 1));
    }

    public void arraySetterHelper(double[] dArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, dArr == null ? 0 : dArr.length, new e(dArr, 1));
    }

    public void arraySetterHelper(byte[] bArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, bArr == null ? 0 : bArr.length, new a(bArr, 1));
    }

    public void arraySetterHelper(short[] sArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, sArr == null ? 0 : sArr.length, new f(sArr, 1));
    }

    public void arraySetterHelper(int[] iArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, iArr == null ? 0 : iArr.length, new c(iArr, 1));
    }

    public void arraySetterHelper(long[] jArr, QName qName) {
        commonSetterHelper(qName, (QNameSet) null, jArr == null ? 0 : jArr.length, new g(jArr, 1));
    }

    public void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName) {
        commonSetterHelper2(qName, null, bigDecimalArr, new org.apache.poi.poifs.nio.b(2));
    }

    public void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName) {
        commonSetterHelper2(qName, null, bigIntegerArr, new org.apache.poi.poifs.nio.b(3));
    }

    public void arraySetterHelper(String[] strArr, QName qName) {
        commonSetterHelper2(qName, null, strArr, new org.apache.poi.poifs.nio.b(10));
    }

    public void arraySetterHelper(byte[][] bArr, QName qName) {
        commonSetterHelper2(qName, null, bArr, new org.apache.poi.poifs.nio.b(8));
    }

    public void arraySetterHelper(GDate[] gDateArr, QName qName) {
        commonSetterHelper2(qName, null, gDateArr, new org.apache.poi.poifs.nio.b(6));
    }

    public void arraySetterHelper(GDuration[] gDurationArr, QName qName) {
        commonSetterHelper2(qName, null, gDurationArr, new org.apache.poi.poifs.nio.b(4));
    }

    public void arraySetterHelper(Calendar[] calendarArr, QName qName) {
        commonSetterHelper2(qName, null, calendarArr, new org.apache.poi.poifs.nio.b(11));
    }

    public void arraySetterHelper(Date[] dateArr, QName qName) {
        commonSetterHelper2(qName, null, dateArr, new org.apache.poi.poifs.nio.b(5));
    }

    public void arraySetterHelper(QName[] qNameArr, QName qName) {
        commonSetterHelper2(qName, null, qNameArr, new org.apache.poi.poifs.nio.b(12));
    }

    public void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName) {
        commonSetterHelper2(qName, null, stringEnumAbstractBaseArr, new org.apache.poi.poifs.nio.b(9));
    }

    public void arraySetterHelper(List<?>[] listArr, QName qName) {
        commonSetterHelper2(qName, null, listArr, new org.apache.poi.poifs.nio.b(7));
    }

    public void arraySetterHelper(boolean[] zArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, zArr == null ? 0 : zArr.length, new h(zArr, 1));
    }

    public void arraySetterHelper(float[] fArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, fArr == null ? 0 : fArr.length, new b(fArr, 0));
    }

    public void arraySetterHelper(double[] dArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, dArr == null ? 0 : dArr.length, new e(dArr, 0));
    }

    public void arraySetterHelper(byte[] bArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, bArr == null ? 0 : bArr.length, new a(bArr, 0));
    }

    public void arraySetterHelper(short[] sArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, sArr == null ? 0 : sArr.length, new f(sArr, 0));
    }

    public void arraySetterHelper(int[] iArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, iArr == null ? 0 : iArr.length, new c(iArr, 0));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_nil() {
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void update_from_complex_content() {
    }

    public void arraySetterHelper(long[] jArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper(qName, qNameSet, jArr == null ? 0 : jArr.length, new g(jArr, 0));
    }

    public void arraySetterHelper(BigDecimal[] bigDecimalArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bigDecimalArr, new org.apache.poi.poifs.nio.b(2));
    }

    public void arraySetterHelper(BigInteger[] bigIntegerArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bigIntegerArr, new org.apache.poi.poifs.nio.b(3));
    }

    public void arraySetterHelper(String[] strArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, strArr, new org.apache.poi.poifs.nio.b(10));
    }

    public void arraySetterHelper(byte[][] bArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, bArr, new org.apache.poi.poifs.nio.b(8));
    }

    public void arraySetterHelper(GDate[] gDateArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, gDateArr, new org.apache.poi.poifs.nio.b(6));
    }

    public void arraySetterHelper(GDuration[] gDurationArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, gDurationArr, new org.apache.poi.poifs.nio.b(4));
    }

    public void arraySetterHelper(Calendar[] calendarArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, calendarArr, new org.apache.poi.poifs.nio.b(11));
    }

    public void arraySetterHelper(Date[] dateArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, dateArr, new org.apache.poi.poifs.nio.b(5));
    }

    public void arraySetterHelper(QName[] qNameArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, qNameArr, new org.apache.poi.poifs.nio.b(12));
    }

    @Override // org.apache.xmlbeans.impl.values.XmlObjectBase
    public void set_text(String str) {
    }

    public void arraySetterHelper(StringEnumAbstractBase[] stringEnumAbstractBaseArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, stringEnumAbstractBaseArr, new org.apache.poi.poifs.nio.b(9));
    }

    public void arraySetterHelper(List<?>[] listArr, QName qName, QNameSet qNameSet) {
        commonSetterHelper2(qName, qNameSet, listArr, new org.apache.poi.poifs.nio.b(7));
    }

    public void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName) {
        arraySetterHelper(xmlObjectArr, qName, (QNameSet) null);
    }

    /* JADX WARN: Code duplicated, block: B:73:0x00d4  */
    public void arraySetterHelper(XmlObject[] xmlObjectArr, QName qName, QNameSet qNameSet) throws Throwable {
        int i5;
        int iCount_elements;
        int i6;
        TypeStoreUser typeStoreUserFind_element_user;
        TypeStore typeStore = get_store();
        int i7 = 0;
        if (xmlObjectArr != null && xmlObjectArr.length != 0) {
            int iCount_elements2 = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet);
            int i8 = 0;
            while (i8 < xmlObjectArr.length) {
                if (!xmlObjectArr[i8].isImmutable()) {
                    XmlCursor xmlCursorNewCursor = xmlObjectArr[i8].newCursor();
                    try {
                        if (xmlCursorNewCursor.toParent() && xmlCursorNewCursor.getObject() == this) {
                            xmlCursorNewCursor.close();
                            break;
                        }
                        xmlCursorNewCursor.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (xmlCursorNewCursor != null) {
                                try {
                                    xmlCursorNewCursor.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                }
                i8++;
            }
            if (i8 >= xmlObjectArr.length) {
                i5 = i8;
                iCount_elements = iCount_elements2;
                i6 = 0;
            } else if ((qNameSet == null ? typeStore.find_element_user(qName, 0) : typeStore.find_element_user(qNameSet, 0)) == xmlObjectArr[i8]) {
                while (i7 < i8) {
                    ((XmlObjectBase) (qNameSet == null ? typeStore.insert_element_user(qName, i7) : typeStore.insert_element_user(qNameSet, qName, i7))).set(xmlObjectArr[i7]);
                    i7++;
                }
                i6 = i7 + 1;
                i7 = i8 + 1;
                while (i7 < xmlObjectArr.length) {
                    XmlCursor xmlCursorNewCursor2 = xmlObjectArr[i7].isImmutable() ? null : xmlObjectArr[i7].newCursor();
                    if (xmlCursorNewCursor2 != null && xmlCursorNewCursor2.toParent() && xmlCursorNewCursor2.getObject() == this) {
                        xmlCursorNewCursor2.close();
                        if ((qNameSet == null ? typeStore.find_element_user(qName, i6) : typeStore.find_element_user(qNameSet, i6)) != xmlObjectArr[i7]) {
                            break;
                        }
                    } else {
                        if (xmlCursorNewCursor2 != null) {
                            xmlCursorNewCursor2.close();
                        }
                        ((XmlObjectBase) (qNameSet == null ? typeStore.insert_element_user(qName, i6) : typeStore.insert_element_user(qNameSet, qName, i6))).set(xmlObjectArr[i7]);
                    }
                    i7++;
                    i6++;
                }
                iCount_elements = typeStore.count_elements(qName);
                i5 = i7;
            } else {
                i5 = i8;
                iCount_elements = iCount_elements2;
                i6 = 0;
            }
            for (int i9 = i5; i9 < xmlObjectArr.length; i9++) {
                ((XmlObjectBase) typeStore.add_element_user(qName)).set(xmlObjectArr[i9]);
            }
            while (iCount_elements > (i5 - i7) + i6) {
                if (qNameSet == null) {
                    typeStore.remove_element(qName, iCount_elements - 1);
                } else {
                    typeStore.remove_element(qNameSet, iCount_elements - 1);
                }
                iCount_elements--;
            }
            while (i7 < i5) {
                if (i6 >= iCount_elements) {
                    typeStoreUserFind_element_user = typeStore.add_element_user(qName);
                } else if (qNameSet == null) {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qName, i6);
                } else {
                    typeStoreUserFind_element_user = typeStore.find_element_user(qNameSet, i6);
                }
                ((XmlObjectBase) typeStoreUserFind_element_user).set(xmlObjectArr[i7]);
                i7++;
                i6++;
            }
            return;
        }
        for (int iCount_elements3 = qNameSet == null ? typeStore.count_elements(qName) : typeStore.count_elements(qNameSet); iCount_elements3 > 0; iCount_elements3--) {
            if (qNameSet == null) {
                typeStore.remove_element(qName, 0);
            } else {
                typeStore.remove_element(qNameSet, 0);
            }
        }
    }
}
