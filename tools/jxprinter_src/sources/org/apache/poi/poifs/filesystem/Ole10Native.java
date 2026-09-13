package org.apache.poi.poifs.filesystem;

import A3.AbstractC0157z;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.input.UnsynchronizedByteArrayInputStream;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndianByteArrayInputStream;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutputStream;
import org.apache.poi.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Ole10Native {
    private static final int DEFAULT_MAX_STRING_LENGTH = 1024;
    public static final String OLE10_NATIVE = "\u0001Ole10Native";
    private static final String OLE_MARKER_NAME = "\u0001Ole";
    private String command;
    private String command2;
    private byte[] dataBuffer;
    private String fileName;
    private String fileName2;
    private short flags1;
    private short flags2;
    private String label;
    private String label2;
    private EncodingMode mode;
    private int totalSize;
    private short unknown1;
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final int DEFAULT_MAX_RECORD_LENGTH = 100000000;
    private static int MAX_RECORD_LENGTH = DEFAULT_MAX_RECORD_LENGTH;
    private static int MAX_STRING_LENGTH = 1024;
    private static final byte[] OLE_MARKER_BYTES = {1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: org.apache.poi.poifs.filesystem.Ole10Native$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode;

        static {
            int[] iArr = new int[EncodingMode.values().length];
            $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode = iArr;
            try {
                iArr[EncodingMode.parsed.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[EncodingMode.compact.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[EncodingMode.unparsed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum EncodingMode {
        parsed,
        unparsed,
        compact
    }

    public Ole10Native(String str, String str2, String str3, byte[] bArr) {
        this.flags1 = (short) 2;
        this.unknown1 = (short) 3;
        setLabel(str);
        setFileName(str2);
        setCommand(str3);
        this.command2 = str3;
        setDataBuffer(bArr);
        this.mode = EncodingMode.parsed;
    }

    public static Ole10Native createFromEmbeddedOleObject(POIFSFileSystem pOIFSFileSystem) {
        return createFromEmbeddedOleObject(pOIFSFileSystem.getRoot());
    }

    public static void createOleMarkerEntry(DirectoryEntry directoryEntry) {
        if (directoryEntry.hasEntry(OLE_MARKER_NAME)) {
            return;
        }
        directoryEntry.createDocument(OLE_MARKER_NAME, new UnsynchronizedByteArrayInputStream(OLE_MARKER_BYTES));
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static int getMaxStringLength() {
        return MAX_STRING_LENGTH;
    }

    private static String readAsciiLen(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int i5 = littleEndianByteArrayInputStream.readInt();
        byte[] byteArray = IOUtils.toByteArray(littleEndianByteArrayInputStream, i5, MAX_STRING_LENGTH);
        return byteArray.length == 0 ? "" : StringUtil.getFromCompressedUnicode(byteArray, 0, i5 - 1);
    }

    private static String readAsciiZ(LittleEndianInput littleEndianInput) throws Ole10NativeException {
        int i5 = MAX_STRING_LENGTH;
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            byte b = littleEndianInput.readByte();
            bArr[i6] = b;
            if (b == 0) {
                return StringUtil.getFromCompressedUTF8(bArr, 0, i6);
            }
        }
        throw new Ole10NativeException(AbstractC0157z.l(" bytes - Exiting.", MAX_STRING_LENGTH, new StringBuilder("AsciiZ string was not null terminated after ")));
    }

    private void readCompact(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this.mode = EncodingMode.compact;
        this.dataBuffer = IOUtils.toByteArray(littleEndianByteArrayInputStream, this.totalSize - 2, MAX_RECORD_LENGTH);
    }

    private void readParsed(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) throws IOException {
        this.mode = EncodingMode.parsed;
        this.label = readAsciiZ(littleEndianByteArrayInputStream);
        this.fileName = readAsciiZ(littleEndianByteArrayInputStream);
        this.flags2 = littleEndianByteArrayInputStream.readShort();
        this.unknown1 = littleEndianByteArrayInputStream.readShort();
        this.command = readAsciiLen(littleEndianByteArrayInputStream);
        this.dataBuffer = IOUtils.toByteArray(littleEndianByteArrayInputStream, littleEndianByteArrayInputStream.readInt(), MAX_RECORD_LENGTH);
        littleEndianByteArrayInputStream.mark(0);
        if (littleEndianByteArrayInputStream.readShort() != 0) {
            littleEndianByteArrayInputStream.reset();
            this.command2 = readUtf16(littleEndianByteArrayInputStream);
            this.label2 = readUtf16(littleEndianByteArrayInputStream);
            this.fileName2 = readUtf16(littleEndianByteArrayInputStream);
        }
    }

    private void readUnparsed(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        this.mode = EncodingMode.unparsed;
        this.dataBuffer = IOUtils.toByteArray(littleEndianByteArrayInputStream, this.totalSize, MAX_RECORD_LENGTH);
    }

    private static String readUtf16(LittleEndianByteArrayInputStream littleEndianByteArrayInputStream) {
        int i5 = littleEndianByteArrayInputStream.readInt();
        return StringUtil.getFromUnicodeLE(IOUtils.toByteArray(littleEndianByteArrayInputStream, i5 * 2, MAX_STRING_LENGTH), 0, i5);
    }

    public static void setMaxRecordLength(int i5) {
        MAX_RECORD_LENGTH = i5;
    }

    public static void setMaxStringLength(int i5) {
        MAX_STRING_LENGTH = i5;
    }

    public String getCommand() {
        return this.command;
    }

    public String getCommand2() {
        return this.command2;
    }

    public byte[] getDataBuffer() {
        return this.dataBuffer;
    }

    public int getDataSize() {
        return this.dataBuffer.length;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFileName2() {
        return this.fileName2;
    }

    public short getFlags1() {
        return this.flags1;
    }

    public short getFlags2() {
        return this.flags2;
    }

    public String getLabel() {
        return this.label;
    }

    public String getLabel2() {
        return this.label2;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public short getUnknown1() {
        return this.unknown1;
    }

    public void setCommand(String str) {
        this.command = str;
    }

    public void setCommand2(String str) {
        this.command2 = str;
    }

    public void setDataBuffer(byte[] bArr) {
        this.dataBuffer = (byte[]) bArr.clone();
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileName2(String str) {
        this.fileName2 = str;
    }

    public void setFlags1(short s6) {
        this.flags1 = s6;
    }

    public void setFlags2(short s6) {
        this.flags2 = s6;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLabel2(String str) {
        this.label2 = str;
    }

    public void setUnknown1(short s6) {
        this.unknown1 = s6;
    }

    public void writeOut(OutputStream outputStream) throws IOException {
        LittleEndianOutputStream littleEndianOutputStream = new LittleEndianOutputStream(outputStream);
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$poifs$filesystem$Ole10Native$EncodingMode[this.mode.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                littleEndianOutputStream.writeInt(getDataSize());
                outputStream.write(getDataBuffer());
                return;
            } else {
                littleEndianOutputStream.writeInt(getDataSize() + 2);
                littleEndianOutputStream.writeShort(getFlags1());
                outputStream.write(getDataBuffer());
                return;
            }
        }
        UnsynchronizedByteArrayOutputStream unsynchronizedByteArrayOutputStream = new UnsynchronizedByteArrayOutputStream();
        LittleEndianOutputStream littleEndianOutputStream2 = new LittleEndianOutputStream(unsynchronizedByteArrayOutputStream);
        try {
            littleEndianOutputStream2.writeShort(getFlags1());
            String label = getLabel();
            Charset charset = UTF8;
            littleEndianOutputStream2.write(label.getBytes(charset));
            littleEndianOutputStream2.write(0);
            littleEndianOutputStream2.write(getFileName().getBytes(charset));
            littleEndianOutputStream2.write(0);
            littleEndianOutputStream2.writeShort(getFlags2());
            littleEndianOutputStream2.writeShort(getUnknown1());
            littleEndianOutputStream2.writeInt(getCommand().length() + 1);
            littleEndianOutputStream2.write(getCommand().getBytes(charset));
            littleEndianOutputStream2.write(0);
            littleEndianOutputStream2.writeInt(getDataSize());
            littleEndianOutputStream2.write(getDataBuffer());
            String str = this.command2;
            if (str == null || this.label2 == null || this.fileName2 == null) {
                littleEndianOutputStream2.writeShort(0);
            } else {
                littleEndianOutputStream2.writeUInt(str.length());
                littleEndianOutputStream2.write(StringUtil.getToUnicodeLE(this.command2));
                littleEndianOutputStream2.writeUInt(this.label2.length());
                littleEndianOutputStream2.write(StringUtil.getToUnicodeLE(this.label2));
                littleEndianOutputStream2.writeUInt(this.fileName2.length());
                littleEndianOutputStream2.write(StringUtil.getToUnicodeLE(this.fileName2));
            }
            littleEndianOutputStream2.close();
            littleEndianOutputStream.writeInt(unsynchronizedByteArrayOutputStream.size());
            unsynchronizedByteArrayOutputStream.writeTo(outputStream);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    littleEndianOutputStream2.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static Ole10Native createFromEmbeddedOleObject(DirectoryNode directoryNode) throws IOException {
        DocumentEntry documentEntry = (DocumentEntry) directoryNode.getEntry(OLE10_NATIVE);
        DocumentInputStream documentInputStreamCreateDocumentInputStream = directoryNode.createDocumentInputStream(documentEntry);
        try {
            Ole10Native ole10Native = new Ole10Native(IOUtils.toByteArray(documentInputStreamCreateDocumentInputStream, documentEntry.getSize(), MAX_RECORD_LENGTH), 0);
            if (documentInputStreamCreateDocumentInputStream != null) {
                documentInputStreamCreateDocumentInputStream.close();
            }
            return ole10Native;
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

    public static void createOleMarkerEntry(POIFSFileSystem pOIFSFileSystem) {
        createOleMarkerEntry(pOIFSFileSystem.getRoot());
    }

    public Ole10Native(byte[] bArr, int i5) throws Ole10NativeException {
        this.flags1 = (short) 2;
        this.unknown1 = (short) 3;
        LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(bArr, i5);
        int i6 = littleEndianByteArrayInputStream.readInt();
        this.totalSize = i6;
        littleEndianByteArrayInputStream.limit(i6 + 4);
        littleEndianByteArrayInputStream.mark(0);
        try {
            short s6 = littleEndianByteArrayInputStream.readShort();
            this.flags1 = s6;
            if (s6 == 2) {
                littleEndianByteArrayInputStream.mark(0);
                boolean zIsISOControl = Character.isISOControl(littleEndianByteArrayInputStream.readByte());
                littleEndianByteArrayInputStream.reset();
                if (!zIsISOControl) {
                    readParsed(littleEndianByteArrayInputStream);
                    return;
                } else {
                    readCompact(littleEndianByteArrayInputStream);
                    return;
                }
            }
            littleEndianByteArrayInputStream.reset();
            readUnparsed(littleEndianByteArrayInputStream);
        } catch (IOException e) {
            throw new Ole10NativeException("Invalid Ole10Native", e);
        }
    }
}
