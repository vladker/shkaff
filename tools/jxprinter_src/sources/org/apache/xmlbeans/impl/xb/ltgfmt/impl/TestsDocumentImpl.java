package org.apache.xmlbeans.impl.xb.ltgfmt.impl;

import H4.d;
import J4.b;
import J4.c;
import java.util.List;
import java.util.function.Function;
import javax.xml.namespace.QName;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.impl.values.JavaListXmlObject;
import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestCase;
import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.TestsDocumentImpl;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public class TestsDocumentImpl extends XmlComplexContentImpl implements TestsDocument {
    private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "tests")};
    private static final long serialVersionUID = 1;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class TestsImpl extends XmlComplexContentImpl implements TestsDocument.Tests {
        private static final QName[] PROPERTY_QNAME = {new QName("http://www.bea.com/2003/05/xmlbean/ltgfmt", "test")};
        private static final long serialVersionUID = 1;

        public TestsImpl(SchemaType schemaType) {
            super(schemaType);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase addNewTest() {
            TestCase testCase;
            synchronized (monitor()) {
                check_orphaned();
                testCase = (TestCase) get_store().add_element_user(PROPERTY_QNAME[0]);
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase[] getTestArray() {
            return (TestCase[]) getXmlObjectArray(PROPERTY_QNAME[0], new TestCase[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public List<TestCase> getTestList() {
            JavaListXmlObject javaListXmlObject;
            synchronized (monitor()) {
                check_orphaned();
                final int i5 = 0;
                final int i6 = 1;
                javaListXmlObject = new JavaListXmlObject(new Function(this) { // from class: J4.d
                    public final /* synthetic */ TestsDocumentImpl.TestsImpl b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i7 = i5;
                        int iIntValue = ((Integer) obj).intValue();
                        switch (i7) {
                            case 0:
                                return this.b.getTestArray(iIntValue);
                            default:
                                return this.b.insertNewTest(iIntValue);
                        }
                    }
                }, new b(this, 1), new Function(this) { // from class: J4.d
                    public final /* synthetic */ TestsDocumentImpl.TestsImpl b;

                    {
                        this.b = this;
                    }

                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        int i7 = i6;
                        int iIntValue = ((Integer) obj).intValue();
                        switch (i7) {
                            case 0:
                                return this.b.getTestArray(iIntValue);
                            default:
                                return this.b.insertNewTest(iIntValue);
                        }
                    }
                }, new c(this, 1), new d(this, 2));
            }
            return javaListXmlObject;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase insertNewTest(int i5) {
            TestCase testCase;
            synchronized (monitor()) {
                check_orphaned();
                testCase = (TestCase) get_store().insert_element_user(PROPERTY_QNAME[0], i5);
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void removeTest(int i5) {
            synchronized (monitor()) {
                check_orphaned();
                get_store().remove_element(PROPERTY_QNAME[0], i5);
            }
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void setTestArray(TestCase[] testCaseArr) {
            check_orphaned();
            arraySetterHelper(testCaseArr, PROPERTY_QNAME[0]);
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public int sizeOfTestArray() {
            int iCount_elements;
            synchronized (monitor()) {
                check_orphaned();
                iCount_elements = get_store().count_elements(PROPERTY_QNAME[0]);
            }
            return iCount_elements;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public TestCase getTestArray(int i5) {
            TestCase testCase;
            synchronized (monitor()) {
                try {
                    check_orphaned();
                    testCase = (TestCase) get_store().find_element_user(PROPERTY_QNAME[0], i5);
                    if (testCase == null) {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return testCase;
        }

        @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument.Tests
        public void setTestArray(int i5, TestCase testCase) {
            generatedSetterHelperImpl(testCase, PROPERTY_QNAME[0], i5, (short) 2);
        }
    }

    public TestsDocumentImpl(SchemaType schemaType) {
        super(schemaType);
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public TestsDocument.Tests addNewTests() {
        TestsDocument.Tests tests;
        synchronized (monitor()) {
            check_orphaned();
            tests = (TestsDocument.Tests) get_store().add_element_user(PROPERTY_QNAME[0]);
        }
        return tests;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public TestsDocument.Tests getTests() {
        TestsDocument.Tests tests;
        synchronized (monitor()) {
            check_orphaned();
            tests = (TestsDocument.Tests) get_store().find_element_user(PROPERTY_QNAME[0], 0);
            if (tests == null) {
                tests = null;
            }
        }
        return tests;
    }

    @Override // org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument
    public void setTests(TestsDocument.Tests tests) {
        generatedSetterHelperImpl(tests, PROPERTY_QNAME[0], 0, (short) 1);
    }
}
