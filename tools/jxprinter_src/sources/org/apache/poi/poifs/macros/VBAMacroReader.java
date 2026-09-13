package org.apache.poi.poifs.macros;

import A3.AbstractC0157z;
import androidx.collection.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Unbox;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentInputStream;
import org.apache.poi.poifs.filesystem.DocumentNode;
import org.apache.poi.poifs.filesystem.Entry;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RLEDecompressingInputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class VBAMacroReader implements Closeable {
    private static final int DOC_STRING_RESERVED = 64;
    private static final int HELP_FILE_PATH_RESERVED = 61;
    private static final Logger LOGGER = LogManager.getLogger((Class<?>) VBAMacroReader.class);
    private static final int MAX_STRING_LENGTH = 20000;
    private static final int MODULE_DOCSTRING_RESERVED = 72;
    private static final int PROJECT_CONSTANTS_RESERVED = 60;
    private static final int REFERENCE_NAME_RESERVED = 62;
    private static final int STREAMNAME_RESERVED = 50;
    protected static final String VBA_PROJECT_OOXML = "vbaProject.bin";
    protected static final String VBA_PROJECT_POIFS = "VBA";
    private POIFSFileSystem fs;

    /* JADX INFO: renamed from: org.apache.poi.poifs.macros.VBAMacroReader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType;

        static {
            int[] iArr = new int[RecordType.values().length];
            $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType = iArr;
            try {
                iArr[RecordType.PROJECT_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.PROJECT_CODEPAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.MODULE_STREAM_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.PROJECT_DOC_STRING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.PROJECT_HELP_FILE_PATH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.PROJECT_CONSTANTS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.REFERENCE_NAME.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.REFERENCE_REGISTERED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.MODULE_DOC_STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.MODULE_OFFSET.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.PROJECT_MODULES.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.REFERENCE_CONTROL_A.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[RecordType.MODULE_TERMINATOR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum DIR_STATE {
        INFORMATION_RECORD,
        REFERENCES_RECORD,
        MODULES_RECORD
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ModuleImpl implements Module {
        byte[] buf;
        Charset charset;
        Module.ModuleType moduleType;
        Integer offset;

        @Override // org.apache.poi.poifs.macros.Module
        public Module.ModuleType geModuleType() {
            return this.moduleType;
        }

        @Override // org.apache.poi.poifs.macros.Module
        public String getContent() {
            return new String(this.buf, this.charset);
        }

        public void read(InputStream inputStream) {
            this.buf = IOUtils.toByteArray(inputStream);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ModuleMap extends HashMap<String, ModuleImpl> {
        Charset charset = StringUtil.WIN_1252;
    }

    public VBAMacroReader(InputStream inputStream) throws IOException {
        InputStream inputStreamPrepareToCheckMagic = FileMagic.prepareToCheckMagic(inputStream);
        if (FileMagic.valueOf(inputStreamPrepareToCheckMagic) == FileMagic.OLE2) {
            this.fs = new POIFSFileSystem(inputStreamPrepareToCheckMagic);
        } else {
            openOOXML(inputStreamPrepareToCheckMagic);
        }
    }

    private static byte[] findCompressedStreamWBruteForce(InputStream inputStream) {
        int uShort;
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        byte[] bArrTryToDecompress = null;
        for (int i5 = 0; i5 < byteArray.length; i5++) {
            if (byteArray[i5] == 1 && i5 < byteArray.length - 1 && (uShort = LittleEndian.getUShort(byteArray, i5 + 1)) > 0 && (uShort & 28672) == 12288 && (bArrTryToDecompress = tryToDecompress(new UnsynchronizedByteArrayInputStream(byteArray, i5, byteArray.length - i5))) != null && bArrTryToDecompress.length > 9 && new String(bArrTryToDecompress, 0, Math.min(20, bArrTryToDecompress.length), StringUtil.WIN_1252).contains("Attribute")) {
                return bArrTryToDecompress;
            }
        }
        return bArrTryToDecompress;
    }

    private ModuleImpl getModule(String str, Map<String, String> map, ModuleMap moduleMap) {
        return map.containsKey(str) ? moduleMap.get(map.get(str)) : moduleMap.get(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        throw r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void openOOXML(java.io.InputStream r3) throws java.io.IOException {
        /*
            r2 = this;
            java.util.zip.ZipInputStream r0 = new java.util.zip.ZipInputStream
            r0.<init>(r3)
        L5:
            java.util.zip.ZipEntry r3 = r0.getNextEntry()     // Catch: java.lang.Throwable -> L22
            if (r3 == 0) goto L29
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L22
            java.lang.String r1 = "vbaProject.bin"
            boolean r3 = org.apache.poi.util.StringUtil.endsWithIgnoreCase(r3, r1)     // Catch: java.lang.Throwable -> L22
            if (r3 == 0) goto L5
            org.apache.poi.poifs.filesystem.POIFSFileSystem r3 = new org.apache.poi.poifs.filesystem.POIFSFileSystem     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            r2.fs = r3     // Catch: java.lang.Throwable -> L22 java.io.IOException -> L24
            r0.close()
            return
        L22:
            r3 = move-exception
            goto L34
        L24:
            r3 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L22
            throw r3     // Catch: java.lang.Throwable -> L22
        L29:
            r0.close()
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "No VBA project found"
            r3.<init>(r0)
            throw r3
        L34:
            throw r3     // Catch: java.lang.Throwable -> L35
        L35:
            r1 = move-exception
            r0.close()     // Catch: java.lang.Throwable -> L3a
            goto L3e
        L3a:
            r0 = move-exception
            r3.addSuppressed(r0)
        L3e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.poifs.macros.VBAMacroReader.openOOXML(java.io.InputStream):void");
    }

    private void processDirStream(Entry entry, ModuleMap moduleMap) {
        int i5;
        IOException e;
        DIR_STATE dir_state = DIR_STATE.INFORMATION_RECORD;
        DocumentInputStream documentInputStream = new DocumentInputStream((DocumentNode) entry);
        try {
            try {
                RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(documentInputStream);
                String ascii = null;
                i5 = 0;
                while (true) {
                    try {
                        try {
                            i5 = rLEDecompressingInputStream.readShort();
                            if (i5 != -1) {
                                RecordType recordTypeLookup = RecordType.lookup(i5);
                                if (!recordTypeLookup.equals(RecordType.EOF) && !recordTypeLookup.equals(RecordType.DIR_STREAM_TERMINATOR)) {
                                    switch (AnonymousClass1.$SwitchMap$org$apache$poi$poifs$macros$VBAMacroReader$RecordType[recordTypeLookup.ordinal()]) {
                                        case 1:
                                            trySkip(rLEDecompressingInputStream, RecordType.PROJECT_VERSION.getConstantLength());
                                            continue;
                                        case 2:
                                            rLEDecompressingInputStream.readInt();
                                            moduleMap.charset = Charset.forName(CodePageUtil.codepageToEncoding(rLEDecompressingInputStream.readShort(), true));
                                            continue;
                                        case 3:
                                            ascii = readStringPair(rLEDecompressingInputStream, moduleMap.charset, 50).getAscii();
                                            continue;
                                        case 4:
                                            readStringPair(rLEDecompressingInputStream, moduleMap.charset, 64);
                                            continue;
                                        case 5:
                                            readStringPair(rLEDecompressingInputStream, moduleMap.charset, 61);
                                            continue;
                                        case 6:
                                            readStringPair(rLEDecompressingInputStream, moduleMap.charset, 60);
                                            continue;
                                        case 7:
                                            if (dir_state.equals(DIR_STATE.INFORMATION_RECORD)) {
                                                dir_state = DIR_STATE.REFERENCES_RECORD;
                                            }
                                            ASCIIUnicodeStringPair stringPair = readStringPair(rLEDecompressingInputStream, moduleMap.charset, 62, false);
                                            if (stringPair.getPushbackRecordId() != -1) {
                                                int pushbackRecordId = stringPair.getPushbackRecordId();
                                                RecordType recordType = RecordType.REFERENCE_REGISTERED;
                                                if (pushbackRecordId != recordType.id) {
                                                    throw new IllegalArgumentException("Unexpected reserved character. Expected " + Integer.toHexString(62) + " or " + Integer.toHexString(recordType.id) + " not: " + Integer.toHexString(stringPair.getPushbackRecordId()));
                                                }
                                            }
                                            break;
                                        case 8:
                                            break;
                                        case 9:
                                            readString(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt(), moduleMap.charset);
                                            int i6 = rLEDecompressingInputStream.readShort();
                                            if (i6 != 72) {
                                                throw new IOException("Expected x003C after stream name before Unicode stream name, but found: " + Integer.toHexString(i6));
                                            }
                                            readUnicodeString(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                            continue;
                                            break;
                                        case 10:
                                            rLEDecompressingInputStream.readInt();
                                            readModuleMetadataFromDirStream(rLEDecompressingInputStream, ascii, moduleMap);
                                            continue;
                                        case 11:
                                            dir_state = DIR_STATE.MODULES_RECORD;
                                            rLEDecompressingInputStream.readInt();
                                            rLEDecompressingInputStream.readShort();
                                            continue;
                                        case 12:
                                            trySkip(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                            int i7 = rLEDecompressingInputStream.readShort();
                                            if (i7 == RecordType.REFERENCE_NAME.id) {
                                                readStringPair(rLEDecompressingInputStream, moduleMap.charset, 62);
                                                i7 = rLEDecompressingInputStream.readShort();
                                            }
                                            if (i7 != 48) {
                                                throw new IOException("Expected 0x30 as Reserved3 in a ReferenceControl record");
                                            }
                                            trySkip(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                            continue;
                                            break;
                                        case 13:
                                            rLEDecompressingInputStream.readInt();
                                            continue;
                                        default:
                                            if (recordTypeLookup.getConstantLength() > -1) {
                                                trySkip(rLEDecompressingInputStream, recordTypeLookup.getConstantLength());
                                            } else {
                                                trySkip(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                                continue;
                                            }
                                            break;
                                    }
                                    trySkip(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt());
                                }
                            }
                        } catch (IOException e6) {
                            e = e6;
                            throw new IOException("Error occurred while reading macros at section id " + i5 + " (" + HexDump.shortToHex(i5) + ")", e);
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                rLEDecompressingInputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                }
                rLEDecompressingInputStream.close();
                documentInputStream.close();
            } catch (IOException e7) {
                i5 = 0;
                e = e7;
            }
        } catch (Throwable th4) {
            try {
                throw th4;
            } catch (Throwable th5) {
                try {
                    documentInputStream.close();
                } catch (Throwable th6) {
                    th4.addSuppressed(th6);
                }
                throw th5;
            }
        }
    }

    private static String readMBCS(int i5, InputStream inputStream, Charset charset) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        int i6 = 0;
        while (i5 > 0 && i6 < 20000) {
            i6++;
            try {
                unsynchronizedByteArrayOutputStream.write(i5);
                i5 = IOUtils.readByte(inputStream);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        unsynchronizedByteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = unsynchronizedByteArrayOutputStream.toString(charset);
        unsynchronizedByteArrayOutputStream.close();
        return string;
    }

    private static void readModuleFromDocumentStream(DocumentNode documentNode, String str, ModuleMap moduleMap) throws IOException {
        ModuleImpl moduleImpl = moduleMap.get(str);
        if (moduleImpl == null) {
            ModuleImpl moduleImpl2 = new ModuleImpl();
            moduleMap.put(str, moduleImpl2);
            DocumentInputStream documentInputStream = new DocumentInputStream(documentNode);
            try {
                moduleImpl2.read(documentInputStream);
                documentInputStream.close();
                return;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        documentInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        if (moduleImpl.buf == null) {
            if (moduleImpl.offset == null) {
                throw new IOException(AbstractC0157z.o("Module offset for '", str, "' was never read."));
            }
            try {
                DocumentInputStream documentInputStream2 = new DocumentInputStream(documentNode);
                try {
                    trySkip(documentInputStream2, moduleImpl.offset.intValue());
                    RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(documentInputStream2);
                    try {
                        moduleImpl.read(rLEDecompressingInputStream);
                        rLEDecompressingInputStream.close();
                        documentInputStream2.close();
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            try {
                                rLEDecompressingInputStream.close();
                            } catch (Throwable th6) {
                                th4.addSuppressed(th6);
                            }
                            throw th5;
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        throw th7;
                    } catch (Throwable th8) {
                        try {
                            documentInputStream2.close();
                        } catch (Throwable th9) {
                            th7.addSuppressed(th9);
                        }
                        throw th8;
                    }
                }
            } catch (IllegalArgumentException | IllegalStateException unused) {
                DocumentInputStream documentInputStream3 = new DocumentInputStream(documentNode);
                try {
                    byte[] bArrFindCompressedStreamWBruteForce = findCompressedStreamWBruteForce(documentInputStream3);
                    documentInputStream3.close();
                    if (bArrFindCompressedStreamWBruteForce != null) {
                        moduleImpl.read(new UnsynchronizedByteArrayInputStream(bArrFindCompressedStreamWBruteForce));
                    }
                } catch (Throwable th10) {
                    try {
                        throw th10;
                    } catch (Throwable th11) {
                        try {
                            documentInputStream3.close();
                        } catch (Throwable th12) {
                            th10.addSuppressed(th12);
                        }
                        throw th11;
                    }
                }
            }
        }
    }

    private static void readModuleMetadataFromDirStream(RLEDecompressingInputStream rLEDecompressingInputStream, String str, ModuleMap moduleMap) throws IOException {
        int i5 = rLEDecompressingInputStream.readInt();
        ModuleImpl moduleImpl = moduleMap.get(str);
        if (moduleImpl == null) {
            ModuleImpl moduleImpl2 = new ModuleImpl();
            moduleImpl2.offset = Integer.valueOf(i5);
            moduleMap.put(str, moduleImpl2);
        } else {
            byte[] bArr = moduleImpl.buf;
            RLEDecompressingInputStream rLEDecompressingInputStream2 = new RLEDecompressingInputStream(new UnsynchronizedByteArrayInputStream(bArr, i5, bArr.length - i5));
            moduleImpl.read(rLEDecompressingInputStream2);
            rLEDecompressingInputStream2.close();
        }
    }

    private static String readString(InputStream inputStream, int i5, Charset charset) throws IOException {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, 20000);
        int fully = IOUtils.readFully(inputStream, bArrSafelyAllocate);
        if (fully == i5) {
            return new String(bArrSafelyAllocate, 0, i5, charset);
        }
        throw new IOException(a.h(i5, fully, "Tried to read: ", ", but could only read: "));
    }

    private ASCIIUnicodeStringPair readStringPair(RLEDecompressingInputStream rLEDecompressingInputStream, Charset charset, int i5) {
        return readStringPair(rLEDecompressingInputStream, charset, i5, true);
    }

    private static String readUnicode(InputStream inputStream) {
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        try {
            int i5 = IOUtils.readByte(inputStream);
            int i6 = IOUtils.readByte(inputStream);
            int i7 = 2;
            while (i5 + i6 != 0 && i7 < 20000) {
                unsynchronizedByteArrayOutputStream.write(i5);
                unsynchronizedByteArrayOutputStream.write(i6);
                i5 = IOUtils.readByte(inputStream);
                i6 = IOUtils.readByte(inputStream);
                i7 += 2;
            }
            if (i7 >= 20000) {
                LOGGER.atWarn().log("stopped reading unicode name after {} bytes", Unbox.box(i7));
            }
            String string = unsynchronizedByteArrayOutputStream.toString(StandardCharsets.UTF_16LE);
            unsynchronizedByteArrayOutputStream.close();
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    unsynchronizedByteArrayOutputStream.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    private String readUnicodeString(RLEDecompressingInputStream rLEDecompressingInputStream, int i5) throws EOFException {
        byte[] bArrSafelyAllocate = IOUtils.safelyAllocate(i5, 20000);
        if (IOUtils.readFully(rLEDecompressingInputStream, bArrSafelyAllocate) == i5) {
            return new String(bArrSafelyAllocate, StringUtil.UTF16LE);
        }
        throw new EOFException();
    }

    private static void trySkip(InputStream inputStream, long j6) throws IOException {
        long jSkipFully = IOUtils.skipFully(inputStream, j6);
        if (jSkipFully != j6) {
            if (jSkipFully >= 0) {
                throw new IOException(AbstractC0157z.r(a.t("Tried skipping ", j6, " bytes, but only "), jSkipFully, " bytes were skipped. This should never happen with a non-corrupt file."));
            }
            throw new IOException(androidx.exifinterface.media.a.k("Tried skipping ", j6, " bytes, but no bytes were skipped. The end of the stream has been reached or the stream is closed."));
        }
    }

    private static byte[] tryToDecompress(InputStream inputStream) {
        try {
            RLEDecompressingInputStream rLEDecompressingInputStream = new RLEDecompressingInputStream(inputStream);
            try {
                byte[] byteArray = IOUtils.toByteArray(rLEDecompressingInputStream);
                rLEDecompressingInputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        rLEDecompressingInputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        } catch (IOException | IllegalArgumentException | IllegalStateException unused) {
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fs.close();
        this.fs = null;
    }

    public void findMacros(DirectoryNode directoryNode, ModuleMap moduleMap) throws IOException {
        if (VBA_PROJECT_POIFS.equalsIgnoreCase(directoryNode.getName())) {
            readMacros(directoryNode, moduleMap);
            return;
        }
        for (Entry entry : directoryNode) {
            if (entry instanceof DirectoryNode) {
                findMacros((DirectoryNode) entry, moduleMap);
            }
        }
    }

    public void findModuleNameMap(DirectoryNode directoryNode, Map<String, String> map, ModuleMap moduleMap) {
        for (Entry entry : directoryNode) {
            if ("projectwm".equalsIgnoreCase(entry.getName())) {
                DocumentInputStream documentInputStream = new DocumentInputStream((DocumentNode) entry);
                try {
                    readNameMapRecords(documentInputStream, map, moduleMap.charset);
                    documentInputStream.close();
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            documentInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
            if (entry.isDirectoryEntry()) {
                findModuleNameMap((DirectoryNode) entry, map, moduleMap);
            }
        }
    }

    public void findProjectProperties(DirectoryNode directoryNode, Map<String, String> map, ModuleMap moduleMap) {
        for (Entry entry : directoryNode) {
            if ("project".equalsIgnoreCase(entry.getName())) {
                DocumentInputStream documentInputStream = new DocumentInputStream((DocumentNode) entry);
                try {
                    readProjectProperties(documentInputStream, map, moduleMap);
                    documentInputStream.close();
                    return;
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            documentInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            }
            if (entry instanceof DirectoryNode) {
                findProjectProperties((DirectoryNode) entry, map, moduleMap);
            }
        }
    }

    public Map<String, Module> readMacroModules() throws IOException {
        ModuleMap moduleMap = new ModuleMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        findMacros(this.fs.getRoot(), moduleMap);
        findModuleNameMap(this.fs.getRoot(), linkedHashMap, moduleMap);
        findProjectProperties(this.fs.getRoot(), linkedHashMap, moduleMap);
        HashMap map = new HashMap();
        for (Map.Entry<String, ModuleImpl> entry : moduleMap.entrySet()) {
            ModuleImpl value = entry.getValue();
            value.charset = moduleMap.charset;
            map.put(entry.getKey(), value);
        }
        return map;
    }

    public Map<String, String> readMacros() throws IOException {
        Map<String, Module> macroModules = readMacroModules();
        HashMap map = new HashMap();
        for (Map.Entry<String, Module> entry : macroModules.entrySet()) {
            map.put(entry.getKey(), entry.getValue().getContent());
        }
        return map;
    }

    public void readNameMapRecords(InputStream inputStream, Map<String, String> map, Charset charset) throws IOException {
        int i5 = 0;
        while (true) {
            i5++;
            if (i5 >= 10000) {
                LOGGER.atWarn().log("Hit max name records to read (10000). Stopped early.");
                return;
            }
            try {
                int i6 = IOUtils.readByte(inputStream);
                if (i6 == 0 && (i6 = IOUtils.readByte(inputStream)) == 0) {
                    return;
                }
                String mbcs = readMBCS(i6, inputStream, charset);
                String unicode = readUnicode(inputStream);
                if (StringUtil.isNotBlank(mbcs) && StringUtil.isNotBlank(unicode)) {
                    map.put(mbcs, unicode);
                }
            } catch (EOFException unused) {
                return;
            }
        }
    }

    public void readProjectProperties(DocumentInputStream documentInputStream, Map<String, String> map, ModuleMap moduleMap) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(documentInputStream, moduleMap.charset);
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[512];
        while (true) {
            int i5 = inputStreamReader.read(cArr);
            if (i5 < 0) {
                break;
            } else {
                sb.append(cArr, 0, i5);
            }
        }
        for (String str : sb.toString().split("\r\n|\n\r")) {
            if (!str.startsWith("[")) {
                String[] strArrSplit = str.split("=");
                if (strArrSplit.length > 1 && strArrSplit[1].length() > 1 && strArrSplit[1].startsWith("\"") && strArrSplit[1].endsWith("\"")) {
                    strArrSplit[1] = a.g(1, 1, strArrSplit[1]);
                }
                if ("Document".equals(strArrSplit[0]) && strArrSplit.length > 1) {
                    String str2 = strArrSplit[1];
                    String strSubstring = str2.substring(0, str2.indexOf("/&H"));
                    ModuleImpl module = getModule(strSubstring, map, moduleMap);
                    if (module != null) {
                        module.moduleType = Module.ModuleType.Document;
                    } else {
                        LOGGER.atWarn().log("couldn't find module with name: {}", strSubstring);
                    }
                } else if ("Module".equals(strArrSplit[0]) && strArrSplit.length > 1) {
                    ModuleImpl module2 = getModule(strArrSplit[1], map, moduleMap);
                    if (module2 != null) {
                        module2.moduleType = Module.ModuleType.Module;
                    } else {
                        LOGGER.atWarn().log("couldn't find module with name: {}", strArrSplit[1]);
                    }
                } else if ("Class".equals(strArrSplit[0]) && strArrSplit.length > 1) {
                    ModuleImpl module3 = getModule(strArrSplit[1], map, moduleMap);
                    if (module3 != null) {
                        module3.moduleType = Module.ModuleType.Class;
                    } else {
                        LOGGER.atWarn().log("couldn't find module with name: {}", strArrSplit[1]);
                    }
                }
            }
        }
    }

    private ASCIIUnicodeStringPair readStringPair(RLEDecompressingInputStream rLEDecompressingInputStream, Charset charset, int i5, boolean z6) throws IOException {
        String string = readString(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt(), charset);
        int i6 = rLEDecompressingInputStream.readShort();
        if (i6 == i5) {
            return new ASCIIUnicodeStringPair(string, readUnicodeString(rLEDecompressingInputStream, rLEDecompressingInputStream.readInt()));
        }
        if (!z6) {
            return new ASCIIUnicodeStringPair(string, i6);
        }
        throw new IOException("Expected " + Integer.toHexString(i5) + "after name before Unicode name, but found: " + Integer.toHexString(i6));
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum RecordType {
        MODULE_OFFSET(49),
        PROJECT_SYS_KIND(1),
        PROJECT_LCID(2),
        PROJECT_LCID_INVOKE(20),
        PROJECT_CODEPAGE(3),
        PROJECT_NAME(4),
        PROJECT_DOC_STRING(5),
        PROJECT_HELP_FILE_PATH(6),
        PROJECT_HELP_CONTEXT(7, 8),
        PROJECT_LIB_FLAGS(8),
        PROJECT_VERSION(9, 10),
        PROJECT_CONSTANTS(12),
        PROJECT_MODULES(15),
        DIR_STREAM_TERMINATOR(16),
        PROJECT_COOKIE(19),
        MODULE_NAME(25),
        MODULE_NAME_UNICODE(71),
        MODULE_STREAM_NAME(26),
        MODULE_DOC_STRING(28),
        MODULE_HELP_CONTEXT(30),
        MODULE_COOKIE(44),
        MODULE_TYPE_PROCEDURAL(33, 4),
        MODULE_TYPE_OTHER(34, 4),
        MODULE_PRIVATE(40, 4),
        REFERENCE_NAME(22),
        REFERENCE_REGISTERED(13),
        REFERENCE_PROJECT(14),
        REFERENCE_CONTROL_A(47),
        REFERENCE_CONTROL_B(51),
        MODULE_TERMINATOR(43),
        EOF(-1),
        UNKNOWN(-2);

        private final int constantLength;
        private final int id;

        RecordType(int i5) {
            this.id = i5;
            this.constantLength = -1;
        }

        public static RecordType lookup(int i5) {
            for (RecordType recordType : values()) {
                if (recordType.id == i5) {
                    return recordType;
                }
            }
            return UNKNOWN;
        }

        public int getConstantLength() {
            return this.constantLength;
        }

        RecordType(int i5, int i6) {
            this.id = i5;
            this.constantLength = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static class ASCIIUnicodeStringPair {
        private final String ascii;
        private final int pushbackRecordId;
        private final String unicode;

        public ASCIIUnicodeStringPair(String str, int i5) {
            this.ascii = str;
            this.unicode = "";
            this.pushbackRecordId = i5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getAscii() {
            return this.ascii;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getPushbackRecordId() {
            return this.pushbackRecordId;
        }

        private String getUnicode() {
            return this.unicode;
        }

        public ASCIIUnicodeStringPair(String str, String str2) {
            this.ascii = str;
            this.unicode = str2;
            this.pushbackRecordId = -1;
        }
    }

    public void readMacros(DirectoryNode directoryNode, ModuleMap moduleMap) throws IOException {
        for (String str : directoryNode.getEntryNames()) {
            if ("dir".equalsIgnoreCase(str)) {
                processDirStream(directoryNode.getEntry(str), moduleMap);
                break;
            }
        }
        for (Entry entry : directoryNode) {
            if (entry instanceof DocumentNode) {
                String name = entry.getName();
                DocumentNode documentNode = (DocumentNode) entry;
                if (!"dir".equalsIgnoreCase(name) && !StringUtil.startsWithIgnoreCase(name, "__SRP") && !StringUtil.startsWithIgnoreCase(name, "_VBA_PROJECT")) {
                    readModuleFromDocumentStream(documentNode, name, moduleMap);
                }
            }
        }
    }

    public VBAMacroReader(File file) throws IOException {
        try {
            this.fs = new POIFSFileSystem(file);
        } catch (OfficeXmlFileException unused) {
            openOOXML(new FileInputStream(file));
        }
    }

    public VBAMacroReader(POIFSFileSystem pOIFSFileSystem) {
        this.fs = pOIFSFileSystem;
    }
}
