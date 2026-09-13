package org.apache.poi.poifs.crypt;

import V2.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.DocumentOutputStream;
import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.TempFile;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public abstract class ChunkedCipherOutputStream extends FilterOutputStream {
    private static final Logger LOG = LogManager.getLogger((Class<?>) ChunkedCipherOutputStream.class);
    private static final int STREAMING = -1;
    private final byte[] chunk;
    private final int chunkBits;
    private final int chunkSize;
    private Cipher cipher;
    private final DirectoryNode dir;
    private final File fileOut;
    private boolean isClosed;
    private final f plainByteFlags;
    private long pos;
    private long totalPos;
    private long written;

    public ChunkedCipherOutputStream(DirectoryNode directoryNode, int i5) {
        super(null);
        this.chunkSize = i5;
        i5 = i5 == -1 ? 4096 : i5;
        this.chunk = IOUtils.safelyAllocate(i5, CryptoFunctions.MAX_RECORD_LENGTH);
        this.plainByteFlags = new f(i5);
        this.chunkBits = Integer.bitCount(i5 - 1);
        File fileCreateTempFile = TempFile.createTempFile("encrypted_package", "crypt");
        this.fileOut = fileCreateTempFile;
        ((FilterOutputStream) this).out = new FileOutputStream(fileCreateTempFile);
        this.dir = directoryNode;
        this.cipher = initCipherForBlock(null, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processPOIFSWriterEvent(POIFSWriterEvent pOIFSWriterEvent) {
        try {
            DocumentOutputStream stream = pOIFSWriterEvent.getStream();
            try {
                FileInputStream fileInputStream = new FileInputStream(this.fileOut);
                try {
                    byte[] bArr = new byte[8];
                    LittleEndian.putLong(bArr, 0, this.pos);
                    stream.write(bArr);
                    IOUtils.copy(fileInputStream, stream);
                    fileInputStream.close();
                    stream.close();
                    if (this.fileOut.delete()) {
                        return;
                    }
                    LOG.atError().log("Can't delete temporary encryption file: {}", this.fileOut);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
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
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                    }
                    throw th5;
                }
            }
        } catch (IOException e) {
            throw new EncryptedDocumentException(e);
        }
    }

    public abstract void calculateChecksum(File file, int i5);

    /* JADX WARN: Bottom block not found for handler: all -> 0x0043 */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void close() {
        /*
            r5 = this;
            boolean r0 = r5.isClosed
            if (r0 == 0) goto L10
            org.apache.logging.log4j.Logger r0 = org.apache.poi.poifs.crypt.ChunkedCipherOutputStream.LOG
            org.apache.logging.log4j.LogBuilder r0 = r0.atDebug()
            java.lang.String r1 = "ChunkedCipherOutputStream was already closed - ignoring"
            r0.log(r1)
            return
        L10:
            r0 = 1
            r5.isClosed = r0
            r0 = 0
            r5.writeChunk(r0)     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            super.close()     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            java.io.File r0 = r5.fileOut     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            if (r0 == 0) goto L47
            long r0 = r0.length()     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            r2 = 8
            long r0 = r0 + r2
            int r0 = (int) r0     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            java.io.File r1 = r5.fileOut     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            long r2 = r5.pos     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            int r2 = (int) r2     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            r5.calculateChecksum(r1, r2)     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            org.apache.poi.poifs.filesystem.DirectoryNode r1 = r5.dir     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            java.lang.String r2 = "EncryptedPackage"
            org.apache.poi.openxml4j.opc.g r3 = new org.apache.poi.openxml4j.opc.g     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            r4 = 1
            r3.<init>(r5, r4)     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            r1.createDocument(r2, r0, r3)     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            org.apache.poi.poifs.filesystem.DirectoryNode r0 = r5.dir     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            java.io.File r1 = r5.fileOut     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            r5.createEncryptionInfoEntry(r0, r1)     // Catch: java.lang.Throwable -> L43 java.security.GeneralSecurityException -> L45
            goto L47
        L43:
            r0 = move-exception
            goto L55
        L45:
            r0 = move-exception
            goto L4f
        L47:
            java.io.File r0 = r5.fileOut
            if (r0 == 0) goto L4e
            r0.delete()
        L4e:
            return
        L4f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L43
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L43
            throw r1     // Catch: java.lang.Throwable -> L43
        L55:
            java.io.File r1 = r5.fileOut
            if (r1 == 0) goto L5c
            r1.delete()
        L5c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.poifs.crypt.ChunkedCipherOutputStream.close():void");
    }

    public abstract void createEncryptionInfoEntry(DirectoryNode directoryNode, File file);

    public byte[] getChunk() {
        return this.chunk;
    }

    public int getChunkMask() {
        return this.chunk.length - 1;
    }

    public f getPlainByteFlags() {
        return this.plainByteFlags;
    }

    public long getPos() {
        return this.pos;
    }

    public long getTotalPos() {
        return this.totalPos;
    }

    public final Cipher initCipherForBlock(int i5, boolean z6) {
        return initCipherForBlock(this.cipher, i5, z6);
    }

    public abstract Cipher initCipherForBlock(Cipher cipher, int i5, boolean z6);

    @Internal
    public Cipher initCipherForBlockNoFlush(Cipher cipher, int i5, boolean z6) {
        return initCipherForBlock(this.cipher, i5, z6);
    }

    public int invokeCipher(int i5, boolean z6) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int iUpdate;
        boolean z7;
        f fVar = this.plainByteFlags;
        fVar.k();
        byte[] bArr = fVar.d.b == 0 ? null : (byte[]) this.chunk.clone();
        if (z6) {
            Cipher cipher = this.cipher;
            byte[] bArr2 = this.chunk;
            iUpdate = cipher.doFinal(bArr2, 0, i5, bArr2);
        } else {
            Cipher cipher2 = this.cipher;
            byte[] bArr3 = this.chunk;
            iUpdate = cipher2.update(bArr3, 0, i5, bArr3);
        }
        if (z6 && "IBMJCE".equals(this.cipher.getProvider().getName()) && "RC4".equals(this.cipher.getAlgorithm())) {
            int i6 = (int) (this.pos >> this.chunkBits);
            if (i5 == 0) {
                i6--;
                i5 = this.chunk.length;
                z7 = false;
            } else {
                z7 = true;
            }
            this.cipher = initCipherForBlockNoFlush(this.cipher, i6, z7);
        }
        if (bArr != null) {
            int iH = this.plainByteFlags.h(0);
            while (iH >= 0 && iH < i5) {
                this.chunk[iH] = bArr[iH];
                iH = this.plainByteFlags.h(iH + 1);
            }
        }
        return iUpdate;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i5) throws IOException {
        write(new byte[]{(byte) i5});
    }

    public void writeChunk(boolean z6) throws IOException {
        boolean z7;
        long j6 = this.pos;
        if (j6 == 0 || this.totalPos == this.written) {
            return;
        }
        int chunkMask = (int) (j6 & ((long) getChunkMask()));
        long j7 = this.pos;
        int i5 = (int) (j7 >> this.chunkBits);
        boolean z8 = true;
        if (chunkMask == 0) {
            i5--;
            chunkMask = this.chunk.length;
            z7 = false;
        } else {
            z7 = true;
        }
        try {
            this.pos = 0L;
            if (this.chunkSize != -1) {
                this.cipher = initCipherForBlock(this.cipher, i5, z7);
                this.pos = j7;
            } else if (z6) {
                z8 = false;
            }
            int iInvokeCipher = invokeCipher(chunkMask, z8);
            ((FilterOutputStream) this).out.write(this.chunk, 0, iInvokeCipher);
            f fVar = this.plainByteFlags;
            int length = fVar.b.length;
            if (length > 0) {
                for (int i6 = 0; i6 != length; i6++) {
                    fVar.b[i6] = null;
                }
                fVar.d.f742a = 0;
            }
            this.written += (long) iInvokeCipher;
        } catch (GeneralSecurityException e) {
            throw new IOException("can't re-/initialize cipher", e);
        }
    }

    public void writePlain(byte[] bArr, int i5, int i6) throws IOException {
        write(bArr, i5, i6, true);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i5, int i6) throws IOException {
        write(bArr, i5, i6, false);
    }

    public void write(byte[] bArr, int i5, int i6, boolean z6) throws IOException {
        if (i6 == 0) {
            return;
        }
        if (i6 >= 0 && bArr.length >= i5 + i6) {
            int chunkMask = getChunkMask();
            while (i6 > 0) {
                long j6 = chunkMask;
                int i7 = (int) (this.pos & j6);
                int iMin = Math.min(this.chunk.length - i7, i6);
                System.arraycopy(bArr, i5, this.chunk, i7, iMin);
                if (z6) {
                    this.plainByteFlags.set(i7, i7 + iMin);
                }
                long j7 = iMin;
                long j8 = this.pos + j7;
                this.pos = j8;
                this.totalPos += j7;
                i5 += iMin;
                i6 -= iMin;
                if ((j8 & j6) == 0) {
                    writeChunk(i6 > 0);
                }
            }
            return;
        }
        throw new IOException("not enough bytes in your input buffer");
    }

    public ChunkedCipherOutputStream(OutputStream outputStream, int i5) {
        super(outputStream);
        this.chunkSize = i5;
        i5 = i5 == -1 ? 4096 : i5;
        this.chunk = IOUtils.safelyAllocate(i5, CryptoFunctions.MAX_RECORD_LENGTH);
        this.plainByteFlags = new f(i5);
        this.chunkBits = Integer.bitCount(i5 - 1);
        this.fileOut = null;
        this.dir = null;
        this.cipher = initCipherForBlock(null, 0, false);
    }

    public void setNextRecordSize(int i5, boolean z6) {
    }
}
