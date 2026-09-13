package org.apache.poi.sl.usermodel;

import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.hpsf.ClassIDPredefined;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public interface ObjectMetaData {

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum Application {
        EXCEL_V8("Worksheet", "Excel.Sheet.8", ExtractorFactory.OOXML_PACKAGE, ClassIDPredefined.EXCEL_V8),
        EXCEL_V12("Worksheet", "Excel.Sheet.12", ExtractorFactory.OOXML_PACKAGE, ClassIDPredefined.EXCEL_V12),
        WORD_V8("Document", "Word.Document.8", ExtractorFactory.OOXML_PACKAGE, ClassIDPredefined.WORD_V8),
        WORD_V12("Document", "Word.Document.12", ExtractorFactory.OOXML_PACKAGE, ClassIDPredefined.WORD_V12),
        PDF("PDF", "AcroExch.Document", "Contents", ClassIDPredefined.PDF),
        CUSTOM(null, null, null, null);

        ClassID classId;
        String objectName;
        String oleEntry;
        String progId;

        Application(String str, String str2, String str3, ClassIDPredefined classIDPredefined) {
            this.objectName = str;
            this.progId = str2;
            this.classId = classIDPredefined == null ? null : classIDPredefined.getClassID();
            this.oleEntry = str3;
        }

        public static Application lookup(String str) {
            for (Application application : values()) {
                String str2 = application.progId;
                if (str2 != null && str2.equals(str)) {
                    return application;
                }
            }
            return null;
        }

        public ObjectMetaData getMetaData() {
            return new ObjectMetaData() { // from class: org.apache.poi.sl.usermodel.ObjectMetaData.Application.1
                @Override // org.apache.poi.sl.usermodel.ObjectMetaData
                public ClassID getClassID() {
                    return Application.this.classId;
                }

                @Override // org.apache.poi.sl.usermodel.ObjectMetaData
                public String getObjectName() {
                    return Application.this.objectName;
                }

                @Override // org.apache.poi.sl.usermodel.ObjectMetaData
                public String getOleEntry() {
                    return Application.this.oleEntry;
                }

                @Override // org.apache.poi.sl.usermodel.ObjectMetaData
                public String getProgId() {
                    return Application.this.progId;
                }
            };
        }
    }

    ClassID getClassID();

    String getObjectName();

    String getOleEntry();

    String getProgId();
}
