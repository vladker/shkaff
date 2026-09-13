package org.apache.poi.hpsf;

import androidx.collection.a;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.util.LittleEndianInputStream;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class PropertySetFactory {
    public static PropertySet create(DirectoryEntry directoryEntry, String str) {
        DocumentInputStream documentInputStreamCreateDocumentInputStream = ((DirectoryNode) directoryEntry).createDocumentInputStream(str);
        try {
            PropertySet propertySetCreate = create(documentInputStreamCreateDocumentInputStream);
            if (documentInputStreamCreateDocumentInputStream != null) {
                documentInputStreamCreateDocumentInputStream.close();
            }
            return propertySetCreate;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (documentInputStreamCreateDocumentInputStream != null) {
                    try {
                        documentInputStreamCreateDocumentInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public static DocumentSummaryInformation newDocumentSummaryInformation() {
        return new DocumentSummaryInformation();
    }

    public static SummaryInformation newSummaryInformation() {
        return new SummaryInformation();
    }

    public static PropertySet create(InputStream inputStream) throws NoPropertySetStreamException, IOException {
        inputStream.mark(45);
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(inputStream);
        int uShort = littleEndianInputStream.readUShort();
        int uShort2 = littleEndianInputStream.readUShort();
        littleEndianInputStream.readUInt();
        byte[] bArr = new byte[16];
        littleEndianInputStream.readFully(bArr);
        int uInt = (int) littleEndianInputStream.readUInt();
        if (uShort == 65534 && uShort2 == 0 && uInt >= 0) {
            if (uInt > 0) {
                littleEndianInputStream.readFully(bArr);
            }
            inputStream.reset();
            ClassID classID = new ClassID(bArr, 0);
            if (uInt > 0 && PropertySet.matchesSummary(classID, SummaryInformation.FORMAT_ID)) {
                return new SummaryInformation(inputStream);
            }
            if (uInt > 0 && PropertySet.matchesSummary(classID, DocumentSummaryInformation.FORMAT_ID)) {
                return new DocumentSummaryInformation(inputStream);
            }
            return new PropertySet(inputStream);
        }
        StringBuilder sbS = a.s("ByteOrder: ", uShort, uShort2, ", format: ", ", sectionCount: ");
        sbS.append(uInt);
        throw new NoPropertySetStreamException(sbS.toString());
    }
}
