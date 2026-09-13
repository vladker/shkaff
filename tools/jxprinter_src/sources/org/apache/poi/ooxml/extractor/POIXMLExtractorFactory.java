package org.apache.poi.ooxml.extractor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.extractor.ExtractorFactory;
import org.apache.poi.extractor.ExtractorProvider;
import org.apache.poi.extractor.POITextExtractor;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xdgf.extractor.XDGFVisioExtractor;
import org.apache.poi.xslf.extractor.XSLFExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFRelation;
import org.apache.poi.xssf.extractor.XSSFBEventBasedExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.apache.xmlbeans.XmlException;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class POIXMLExtractorFactory implements ExtractorProvider {
    private static final String CORE_DOCUMENT_REL = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
    private static final String STRICT_DOCUMENT_REL = "http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument";
    private static final List<XSLFRelation> SUPPORTED_XSLF_TYPES = Collections.unmodifiableList(Arrays.asList(XSLFRelation.MAIN, XSLFRelation.MACRO, XSLFRelation.MACRO_TEMPLATE, XSLFRelation.PRESENTATIONML, XSLFRelation.PRESENTATIONML_TEMPLATE, XSLFRelation.PRESENTATION_MACRO));
    private static final String VISIO_DOCUMENT_REL = "http://schemas.microsoft.com/visio/2010/relationships/document";

    public static Boolean getAllThreadsPreferEventExtractors() {
        return ExtractorFactory.getAllThreadsPreferEventExtractors();
    }

    public static boolean getPreferEventExtractor() {
        return ExtractorFactory.getPreferEventExtractor();
    }

    public static boolean getThreadPrefersEventExtractors() {
        return ExtractorFactory.getThreadPrefersEventExtractors();
    }

    public static void setAllThreadsPreferEventExtractors(Boolean bool) {
        ExtractorFactory.setAllThreadsPreferEventExtractors(bool);
    }

    public static void setThreadPrefersEventExtractors(boolean z6) {
        ExtractorFactory.setThreadPrefersEventExtractors(z6);
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public boolean accepts(FileMagic fileMagic) {
        return fileMagic == FileMagic.OOXML;
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(File file, String str) throws IOException {
        if (FileMagic.valueOf(file) != FileMagic.OOXML) {
            return ExtractorFactory.createExtractor(file, str);
        }
        OPCPackage oPCPackageOpen = null;
        try {
            oPCPackageOpen = OPCPackage.open(file.toString(), PackageAccess.READ);
            POIXMLTextExtractor pOIXMLTextExtractorCreate = create(oPCPackageOpen);
            if (pOIXMLTextExtractorCreate != null) {
                return pOIXMLTextExtractorCreate;
            }
            oPCPackageOpen.revert();
            return pOIXMLTextExtractorCreate;
        } catch (IOException e) {
            if (oPCPackageOpen != null) {
                oPCPackageOpen.revert();
            }
            throw e;
        } catch (InvalidFormatException e6) {
            throw new IOException(e6);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0029  */
    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(InputStream inputStream, String str) throws Throwable {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        if (FileMagic.valueOf(inputStreamPrepareToCheckMagic) != FileMagic.OOXML) {
            return ExtractorFactory.createExtractor(inputStreamPrepareToCheckMagic, str);
        }
        OPCPackage oPCPackageOpen = null;
        try {
            oPCPackageOpen = OPCPackage.open(inputStreamPrepareToCheckMagic);
            POIXMLTextExtractor pOIXMLTextExtractorCreate = create(oPCPackageOpen);
            if (pOIXMLTextExtractorCreate != null) {
                return pOIXMLTextExtractorCreate;
            }
            oPCPackageOpen.revert();
            return pOIXMLTextExtractorCreate;
        } catch (IOException e) {
            e = e;
            if (oPCPackageOpen != null) {
                oPCPackageOpen.revert();
            }
            throw e;
        } catch (RuntimeException e6) {
            e = e6;
            if (oPCPackageOpen != null) {
                oPCPackageOpen.revert();
            }
            throw e;
        } catch (InvalidFormatException e7) {
            throw new IOException(e7);
        }
    }

    public POIXMLTextExtractor create(OPCPackage oPCPackage) throws IOException {
        try {
            PackageRelationshipCollection relationshipsByType = oPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
            if (relationshipsByType.isEmpty()) {
                relationshipsByType = oPCPackage.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument");
            }
            if (relationshipsByType.isEmpty()) {
                relationshipsByType = oPCPackage.getRelationshipsByType("http://schemas.microsoft.com/visio/2010/relationships/document");
                if (relationshipsByType.size() == 1) {
                    return new XDGFVisioExtractor(oPCPackage);
                }
            }
            if (relationshipsByType.size() != 1) {
                throw new IllegalArgumentException("Invalid OOXML Package received - expected 1 core document, found " + relationshipsByType.size());
            }
            String contentType = oPCPackage.getPart(relationshipsByType.getRelationship(0)).getContentType();
            Iterator<XSSFRelation> it = XSSFExcelExtractor.SUPPORTED_TYPES.iterator();
            while (it.hasNext()) {
                if (it.next().getContentType().equals(contentType)) {
                    if (getPreferEventExtractor()) {
                        return new XSSFEventBasedExcelExtractor(oPCPackage);
                    }
                    return new XSSFExcelExtractor(oPCPackage);
                }
            }
            Iterator<XWPFRelation> it2 = XWPFWordExtractor.SUPPORTED_TYPES.iterator();
            while (it2.hasNext()) {
                if (it2.next().getContentType().equals(contentType)) {
                    return new XWPFWordExtractor(oPCPackage);
                }
            }
            Iterator<XSLFRelation> it3 = SUPPORTED_XSLF_TYPES.iterator();
            while (it3.hasNext()) {
                if (it3.next().getContentType().equals(contentType)) {
                    return new XSLFExtractor(new XMLSlideShow(oPCPackage));
                }
            }
            if (XSLFRelation.THEME_MANAGER.getContentType().equals(contentType)) {
                return new XSLFExtractor(new XMLSlideShow(oPCPackage));
            }
            Iterator<XSSFRelation> it4 = XSSFBEventBasedExcelExtractor.SUPPORTED_TYPES.iterator();
            while (it4.hasNext()) {
                if (it4.next().getContentType().equals(contentType)) {
                    return new XSSFBEventBasedExcelExtractor(oPCPackage);
                }
            }
            return null;
        } catch (Error e) {
            e = e;
            throw new IOException(e);
        } catch (RuntimeException e6) {
            e = e6;
            throw new IOException(e);
        } catch (OpenXML4JException e7) {
            e = e7;
            throw new IOException(e);
        } catch (XmlException e8) {
            e = e8;
            throw new IOException(e);
        }
    }

    public POITextExtractor create(POIFSFileSystem pOIFSFileSystem) {
        return create(pOIFSFileSystem.getRoot(), Biff8EncryptionKey.getCurrentUserPassword());
    }

    @Override // org.apache.poi.extractor.ExtractorProvider
    public POITextExtractor create(DirectoryNode directoryNode, String str) throws IOException {
        if (directoryNode.hasEntry(ExtractorFactory.OOXML_PACKAGE)) {
            DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(ExtractorFactory.OOXML_PACKAGE);
            try {
                POITextExtractor pOITextExtractorCreate = create(documentInputStreamCreateDocumentInputStream, str);
                if (documentInputStreamCreateDocumentInputStream != null) {
                    documentInputStreamCreateDocumentInputStream.close();
                }
                return pOITextExtractorCreate;
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
        if (directoryNode.hasEntry(Decryptor.DEFAULT_POIFS_ENTRY)) {
            Decryptor decryptor = new EncryptionInfo(directoryNode).getDecryptor();
            try {
                if (decryptor.verifyPassword(str)) {
                    try {
                        InputStream dataStream = decryptor.getDataStream(directoryNode);
                        try {
                            POITextExtractor pOITextExtractorCreate2 = create(dataStream, str);
                            if (dataStream != null) {
                                dataStream.close();
                            }
                            POIFSFileSystem fileSystem = directoryNode.getFileSystem();
                            if (fileSystem == null) {
                                return pOITextExtractorCreate2;
                            }
                            fileSystem.close();
                            return pOITextExtractorCreate2;
                        } catch (Throwable th4) {
                            try {
                                throw th4;
                            } catch (Throwable th5) {
                                if (dataStream != null) {
                                    try {
                                        dataStream.close();
                                    } catch (Throwable th6) {
                                        th4.addSuppressed(th6);
                                    }
                                }
                                throw th5;
                            }
                        }
                    } catch (Throwable th7) {
                        POIFSFileSystem fileSystem2 = directoryNode.getFileSystem();
                        if (fileSystem2 != null) {
                            fileSystem2.close();
                        }
                        throw th7;
                    }
                }
                throw new IOException("Invalid password specified");
            } catch (IOException e) {
                throw e;
            } catch (RuntimeException e6) {
                throw e6;
            } catch (Exception e7) {
                throw new IOException(e7);
            }
        }
        throw new IOException("The OLE2 file neither contained a plain OOXML package node (\"Package\") nor an encrypted one (\"EncryptedPackage\").");
    }
}
