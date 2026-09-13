package org.apache.xmlbeans.impl.xb.ltgfmt;

import java.util.List;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.impl.schema.DocumentFactory;
import org.apache.xmlbeans.impl.schema.ElementFactory;
import org.apache.xmlbeans.metadata.system.sXMLTOOLS.TypeSystemHolder;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public interface TestsDocument extends XmlObject {
    public static final DocumentFactory<TestsDocument> Factory;
    public static final SchemaType type;

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public interface Tests extends XmlObject {
        public static final ElementFactory<Tests> Factory;
        public static final SchemaType type;

        static {
            ElementFactory<Tests> elementFactory = new ElementFactory<>(TypeSystemHolder.typeSystem, "tests9d6eelemtype");
            Factory = elementFactory;
            type = elementFactory.getType();
        }

        TestCase addNewTest();

        TestCase getTestArray(int i5);

        TestCase[] getTestArray();

        List<TestCase> getTestList();

        TestCase insertNewTest(int i5);

        void removeTest(int i5);

        void setTestArray(int i5, TestCase testCase);

        void setTestArray(TestCase[] testCaseArr);

        int sizeOfTestArray();
    }

    static {
        DocumentFactory<TestsDocument> documentFactory = new DocumentFactory<>(TypeSystemHolder.typeSystem, "tests5621doctype");
        Factory = documentFactory;
        type = documentFactory.getType();
    }

    Tests addNewTests();

    Tests getTests();

    void setTests(Tests tests);
}
