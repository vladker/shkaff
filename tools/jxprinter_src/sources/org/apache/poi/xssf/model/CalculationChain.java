package org.apache.poi.xssf.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcCell;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCalcChain;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CalculationChain extends POIXMLDocumentPart {
    private CTCalcChain chain;

    public CalculationChain() {
        this.chain = CTCalcChain.Factory.newInstance();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() throws IOException {
        OutputStream outputStream = getPackagePart().getOutputStream();
        try {
            writeTo(outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
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

    public CTCalcChain getCTCalcChain() {
        return this.chain;
    }

    public void readFrom(InputStream inputStream) throws IOException {
        try {
            this.chain = CalcChainDocument.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS).getCalcChain();
        } catch (XmlException e) {
            throw new IOException(e.getLocalizedMessage());
        }
    }

    public void removeItem(int i5, String str) {
        CTCalcCell[] cArray = this.chain.getCArray();
        int i6 = -1;
        for (int i7 = 0; i7 < cArray.length; i7++) {
            if (cArray[i7].isSetI()) {
                i6 = cArray[i7].getI();
            }
            if (i6 == i5 && cArray[i7].getR().equals(str)) {
                if (cArray[i7].isSetI() && i7 < cArray.length - 1) {
                    int i8 = i7 + 1;
                    if (!cArray[i8].isSetI()) {
                        cArray[i8].setI(i6);
                    }
                }
                this.chain.removeC(i7);
                return;
            }
        }
    }

    public void writeTo(OutputStream outputStream) {
        CalcChainDocument calcChainDocumentNewInstance = CalcChainDocument.Factory.newInstance();
        calcChainDocumentNewInstance.setCalcChain(this.chain);
        calcChainDocumentNewInstance.save(outputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
    }

    public CalculationChain(PackagePart packagePart) throws IOException {
        super(packagePart);
        InputStream inputStream = packagePart.getInputStream();
        try {
            readFrom(inputStream);
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }
}
