package org.apache.poi.openxml4j.opc;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class StreamHelper {
    private StreamHelper() {
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream) {
        try {
            IOUtils.copy(inputStream, outputStream);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean saveXmlInStream(Document document, OutputStream outputStream) {
        try {
            Transformer transformerNewTransformer = XMLHelper.newTransformer();
            DOMSource dOMSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new FilterOutputStream(outputStream) { // from class: org.apache.poi.openxml4j.opc.StreamHelper.1
                @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    ((FilterOutputStream) this).out.flush();
                }

                @Override // java.io.FilterOutputStream, java.io.OutputStream
                public void write(byte[] bArr, int i5, int i6) throws IOException {
                    ((FilterOutputStream) this).out.write(bArr, i5, i6);
                }
            });
            transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
            transformerNewTransformer.setOutputProperty("indent", "no");
            transformerNewTransformer.setOutputProperty("standalone", "yes");
            transformerNewTransformer.transform(dOMSource, streamResult);
            return true;
        } catch (TransformerException unused) {
            return false;
        }
    }
}
