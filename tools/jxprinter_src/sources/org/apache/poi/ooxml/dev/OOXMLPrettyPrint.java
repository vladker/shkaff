package org.apache.poi.ooxml.dev;

import com.alibaba.android.arouter.utils.Consts;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.openxml4j.util.ZipArchiveThresholdInputStream;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class OOXMLPrettyPrint {
    private static final String XML_INDENT_AMOUNT = "{http://xml.apache.org/xslt}indent-amount";
    private final DocumentBuilder documentBuilder;

    public OOXMLPrettyPrint() {
        ZipSecureFile.setMinInflateRatio(1.0E-5d);
        this.documentBuilder = DocumentHelper.newDocumentBuilder();
    }

    private void handle(ZipSecureFile zipSecureFile, ZipOutputStream zipOutputStream) throws IOException {
        Enumeration<ZipArchiveEntry> entries = zipSecureFile.getEntries();
        while (entries.hasMoreElements()) {
            ZipArchiveEntry zipArchiveEntryNextElement = entries.nextElement();
            String name = zipArchiveEntryNextElement.getName();
            zipOutputStream.putNextEntry(new ZipEntry(name));
            try {
                try {
                    if (name.endsWith(".xml") || name.endsWith(PackagingURIHelper.RELATIONSHIP_PART_EXTENSION_NAME)) {
                        Document document = this.documentBuilder.parse(new InputSource(zipSecureFile.getInputStream(zipArchiveEntryNextElement)));
                        document.setXmlStandalone(true);
                        pretty(document, zipOutputStream, 2);
                    } else {
                        System.out.println("Not pretty-printing non-XML file " + name);
                        ZipArchiveThresholdInputStream inputStream = zipSecureFile.getInputStream(zipArchiveEntryNextElement);
                        try {
                            IOUtils.copy(inputStream, zipOutputStream);
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
                    zipOutputStream.closeEntry();
                    System.out.print(Consts.DOT);
                } catch (Throwable th4) {
                    zipOutputStream.closeEntry();
                    throw th4;
                }
            } catch (Exception e) {
                throw new IOException("While handling entry " + name, e);
            }
        }
    }

    private static void handleFile(File file, File file2) {
        System.out.println("Reading zip-file " + file + " and writing pretty-printed XML to " + file2);
        try {
            ZipSecureFile zipSecureFileOpenZipFile = ZipHelper.openZipFile(file);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file2)));
                try {
                    new OOXMLPrettyPrint().handle(zipSecureFileOpenZipFile, zipOutputStream);
                    zipOutputStream.close();
                    if (zipSecureFileOpenZipFile != null) {
                        zipSecureFileOpenZipFile.close();
                    }
                    System.out.println();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            zipOutputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    if (zipSecureFileOpenZipFile != null) {
                        try {
                            zipSecureFileOpenZipFile.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (Throwable th7) {
            System.out.println();
            throw th7;
        }
    }

    public static void main(String[] strArr) {
        if (strArr.length <= 1 || strArr.length % 2 != 0) {
            System.err.println("Use:");
            System.err.println("\tjava OOXMLPrettyPrint [<filename> <outfilename>] ...");
            System.exit(1);
        }
        for (int i5 = 0; i5 < strArr.length; i5 += 2) {
            File file = new File(strArr[i5]);
            if (!file.exists()) {
                System.err.println("Error, file not found!");
                System.err.println("\t" + file);
                System.exit(2);
            }
            handleFile(file, new File(strArr[i5 + 1]));
        }
        System.out.println("Done.");
    }

    private static void pretty(Document document, OutputStream outputStream, int i5) throws TransformerException {
        Transformer transformerNewTransformer = XMLHelper.newTransformer();
        if (i5 > 0) {
            transformerNewTransformer.setOutputProperty("indent", "yes");
            transformerNewTransformer.setOutputProperty(XML_INDENT_AMOUNT, Integer.toString(i5));
        }
        transformerNewTransformer.transform(new DOMSource(document), new StreamResult(outputStream));
    }
}
