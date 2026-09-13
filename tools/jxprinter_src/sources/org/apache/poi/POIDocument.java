package org.apache.poi;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.PropertySet;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIDecryptor;
import org.apache.poi.poifs.crypt.cryptoapi.CryptoAPIEncryptor;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class POIDocument implements Closeable {
    private static final Logger LOG = LogManager.getLogger((Class<?>) POIDocument.class);
    private DirectoryNode directory;
    private DocumentSummaryInformation dsInf;
    private boolean initialized;
    private SummaryInformation sInf;

    public POIDocument(DirectoryNode directoryNode) {
        this.directory = directoryNode;
    }

    private <T> T readPropertySet(Class<T> cls, String str) {
        String strSubstring = cls.getName().substring(cls.getName().lastIndexOf(46) + 1);
        try {
            T t6 = (T) getPropertySet(str);
            if (cls.isInstance(t6)) {
                return t6;
            }
            if (t6 != null) {
                LOG.atWarn().log("{} property set came back with wrong class - {}", strSubstring, t6.getClass().getName());
            } else {
                LOG.atWarn().log("{} property set came back as null", strSubstring);
            }
            return null;
        } catch (IOException e) {
            LOG.atError().withThrowable(e).log("can't retrieve property set");
            return null;
        }
    }

    private void writePropertySet(String str, PropertySet propertySet, POIFSFileSystem pOIFSFileSystem, List<String> list) {
        if (propertySet == null) {
            return;
        }
        writePropertySet(str, propertySet, pOIFSFileSystem);
        if (list != null) {
            list.add(str);
        }
    }

    @Internal
    public void clearDirectory() {
        this.directory = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DirectoryNode directoryNode = this.directory;
        if (directoryNode == null || directoryNode.getFileSystem() == null) {
            return;
        }
        this.directory.getFileSystem().close();
        clearDirectory();
    }

    public void createInformationProperties() {
        if (!this.initialized) {
            readProperties();
        }
        if (this.sInf == null) {
            this.sInf = PropertySetFactory.newSummaryInformation();
        }
        if (this.dsInf == null) {
            this.dsInf = PropertySetFactory.newDocumentSummaryInformation();
        }
    }

    @Internal
    public DirectoryNode getDirectory() {
        return this.directory;
    }

    public DocumentSummaryInformation getDocumentSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.dsInf;
    }

    public String getEncryptedPropertyStreamName() {
        return "encryption";
    }

    public EncryptionInfo getEncryptionInfo() {
        return null;
    }

    public PropertySet getPropertySet(String str) {
        return getPropertySet(str, getEncryptionInfo());
    }

    public SummaryInformation getSummaryInformation() {
        if (!this.initialized) {
            readProperties();
        }
        return this.sInf;
    }

    @Internal
    public boolean initDirectory() {
        if (this.directory != null) {
            return false;
        }
        this.directory = new POIFSFileSystem().getRoot();
        return true;
    }

    @Internal
    public void readProperties() {
        if (this.initialized) {
            return;
        }
        DocumentSummaryInformation documentSummaryInformation = (DocumentSummaryInformation) readPropertySet(DocumentSummaryInformation.class, DocumentSummaryInformation.DEFAULT_STREAM_NAME);
        if (documentSummaryInformation != null) {
            this.dsInf = documentSummaryInformation;
        }
        SummaryInformation summaryInformation = (SummaryInformation) readPropertySet(SummaryInformation.class, SummaryInformation.DEFAULT_STREAM_NAME);
        if (summaryInformation != null) {
            this.sInf = summaryInformation;
        }
        this.initialized = true;
    }

    @Internal
    public void replaceDirectory(DirectoryNode directoryNode) {
        DirectoryNode directoryNode2 = this.directory;
        if (directoryNode != directoryNode2) {
            if (directoryNode == null || directoryNode2 == null || directoryNode.getFileSystem() != this.directory.getFileSystem()) {
                DirectoryNode directoryNode3 = this.directory;
                if (directoryNode3 != null && directoryNode3.getFileSystem() != null) {
                    this.directory.getFileSystem().close();
                }
                this.directory = directoryNode;
            }
        }
    }

    public void validateInPlaceWritePossible() {
        DirectoryNode directoryNode = this.directory;
        if (directoryNode == null) {
            throw new IllegalStateException("Newly created Document, cannot save in-place");
        }
        if (directoryNode.getParent() != null) {
            throw new IllegalStateException("This is not the root Document, cannot save embedded resource in-place");
        }
        if (this.directory.getFileSystem() == null || !this.directory.getFileSystem().isInPlaceWriteable()) {
            throw new IllegalStateException("Opened read-only or via an InputStream, a Writeable File is required");
        }
    }

    public abstract void write();

    public abstract void write(File file);

    public abstract void write(OutputStream outputStream);

    public void writeProperties() {
        validateInPlaceWritePossible();
        writeProperties(this.directory.getFileSystem(), null);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    public PropertySet getPropertySet(String str, EncryptionInfo encryptionInfo) throws Throwable {
        String str2;
        POIFSFileSystem summaryEntries;
        DirectoryNode root = this.directory;
        POIFSFileSystem pOIFSFileSystem = null;
        String str3 = "getting";
        try {
            if (encryptionInfo == null) {
                summaryEntries = null;
                str2 = "getting";
                if (root != null) {
                }
                IOUtils.closeQuietly(summaryEntries);
                return null;
            }
            try {
                try {
                    if (encryptionInfo.isDocPropsEncrypted()) {
                        str2 = "getting encrypted";
                        try {
                            String encryptedPropertyStreamName = getEncryptedPropertyStreamName();
                            if (!root.hasEntry(encryptedPropertyStreamName)) {
                                throw new EncryptedDocumentException("can't find encrypted property stream '" + encryptedPropertyStreamName + "'");
                            }
                            summaryEntries = ((CryptoAPIDecryptor) encryptionInfo.getDecryptor()).getSummaryEntries(root, encryptedPropertyStreamName);
                            try {
                                try {
                                    root = summaryEntries.getRoot();
                                } catch (Exception e) {
                                    e = e;
                                    str3 = str2;
                                }
                            } catch (IOException e6) {
                                throw e6;
                            } catch (Throwable th) {
                                th = th;
                                pOIFSFileSystem = summaryEntries;
                                IOUtils.closeQuietly(pOIFSFileSystem);
                                throw th;
                            }
                        } catch (Exception e7) {
                            e = e7;
                            str3 = str2;
                        }
                    } else {
                        summaryEntries = null;
                        str2 = "getting";
                    }
                    if (root != null || !root.hasEntry(str)) {
                        IOUtils.closeQuietly(summaryEntries);
                        return null;
                    }
                    try {
                        DocumentInputStream documentInputStreamCreateDocumentInputStream = root.createDocumentInputStream(root.getEntry(str));
                        try {
                            PropertySet propertySetCreate = PropertySetFactory.create(documentInputStreamCreateDocumentInputStream);
                            if (documentInputStreamCreateDocumentInputStream != null) {
                                documentInputStreamCreateDocumentInputStream.close();
                            }
                            IOUtils.closeQuietly(summaryEntries);
                            return propertySetCreate;
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                if (documentInputStreamCreateDocumentInputStream != null) {
                                    try {
                                        documentInputStreamCreateDocumentInputStream.close();
                                    } catch (Throwable th4) {
                                        th2.addSuppressed(th4);
                                    }
                                }
                                throw th3;
                            }
                        }
                    } catch (Exception e8) {
                        e = e8;
                    }
                } catch (Exception e9) {
                    e = e9;
                }
            } catch (IOException e10) {
                throw e10;
            }
            throw new IOException("Error " + str3 + " property set with name " + str, e);
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public POIDocument(POIFSFileSystem pOIFSFileSystem) {
        this(pOIFSFileSystem.getRoot());
    }

    private void writePropertySet(String str, PropertySet propertySet, POIFSFileSystem pOIFSFileSystem) {
        try {
            UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
            try {
                new PropertySet(propertySet).write(unsynchronizedByteArrayOutputStream);
                InputStream inputStream = unsynchronizedByteArrayOutputStream.toInputStream();
                try {
                    pOIFSFileSystem.createOrUpdateDocument(inputStream, str);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    LOG.atInfo().log("Wrote property set {} of size {}", str, Unbox.box(unsynchronizedByteArrayOutputStream.size()));
                    unsynchronizedByteArrayOutputStream.close();
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
            } catch (Throwable th4) {
                try {
                    throw th4;
                } catch (Throwable th5) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th6) {
                        th4.addSuppressed(th6);
                    }
                    throw th5;
                }
            }
        } catch (WritingNotSupportedException unused) {
            LOG.atError().log("Couldn't write property set with name {} as not supported by HPSF yet", str);
        }
    }

    @Internal
    public void writeProperties(POIFSFileSystem pOIFSFileSystem) {
        writeProperties(pOIFSFileSystem, null);
    }

    public void writeProperties(POIFSFileSystem pOIFSFileSystem, List<String> list) {
        EncryptionInfo encryptionInfo = getEncryptionInfo();
        Encryptor encryptor = encryptionInfo == null ? null : encryptionInfo.getEncryptor();
        boolean z6 = encryptionInfo != null && encryptionInfo.isDocPropsEncrypted() && (encryptor instanceof CryptoAPIEncryptor);
        POIFSFileSystem pOIFSFileSystem2 = new POIFSFileSystem();
        POIFSFileSystem pOIFSFileSystem3 = z6 ? pOIFSFileSystem2 : pOIFSFileSystem;
        try {
            writePropertySet(SummaryInformation.DEFAULT_STREAM_NAME, getSummaryInformation(), pOIFSFileSystem3, list);
            writePropertySet(DocumentSummaryInformation.DEFAULT_STREAM_NAME, getDocumentSummaryInformation(), pOIFSFileSystem3, list);
            if (z6) {
                writePropertySet(DocumentSummaryInformation.DEFAULT_STREAM_NAME, PropertySetFactory.newDocumentSummaryInformation(), pOIFSFileSystem);
                if (pOIFSFileSystem.getRoot().hasEntry(SummaryInformation.DEFAULT_STREAM_NAME)) {
                    pOIFSFileSystem.getRoot().getEntry(SummaryInformation.DEFAULT_STREAM_NAME).delete();
                }
                try {
                    ((CryptoAPIEncryptor) encryptor).setSummaryEntries(pOIFSFileSystem.getRoot(), getEncryptedPropertyStreamName(), pOIFSFileSystem3);
                    pOIFSFileSystem2.close();
                    return;
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
            pOIFSFileSystem2.close();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    pOIFSFileSystem2.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }
}
