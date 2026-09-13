package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.PackagePart;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class XSLFFontData extends POIXMLDocumentPart {
    public XSLFFontData() {
    }

    public InputStream getInputStream() {
        return getPackagePart().getInputStream();
    }

    public OutputStream getOutputStream() {
        PackagePart packagePart = getPackagePart();
        packagePart.clear();
        return packagePart.getOutputStream();
    }

    public void setData(byte[] bArr) throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            outputStream.write(bArr);
            outputStream.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    public XSLFFontData(PackagePart packagePart) {
        super(packagePart);
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void prepareForCommit() {
    }
}
