package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.sl.usermodel.MetroShapeProvider;
import org.apache.poi.util.Internal;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class XSLFMetroShape implements MetroShapeProvider {
    @Override // org.apache.poi.sl.usermodel.MetroShapeProvider
    public XSLFShape parseShape(byte[] bArr) throws IOException {
        try {
            OPCPackage oPCPackageOpen = OPCPackage.open(new UnsynchronizedByteArrayInputStream(bArr));
            try {
                PackagePart part = oPCPackageOpen.getPart(PackagingURIHelper.createPartName("/drs/shapexml.xml"));
                XSLFShape xSLFShape = null;
                if (part != null) {
                    InputStream inputStream = part.getInputStream();
                    try {
                        xSLFShape = new XSLFGroupShape(CTGroupShape.Factory.parse(inputStream, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), null).getShapes().get(0);
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
                oPCPackageOpen.close();
                return xSLFShape;
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (oPCPackageOpen != null) {
                        try {
                            oPCPackageOpen.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (InvalidFormatException | XmlException e) {
            throw new IOException("can't parse metro shape", e);
        }
    }
}
