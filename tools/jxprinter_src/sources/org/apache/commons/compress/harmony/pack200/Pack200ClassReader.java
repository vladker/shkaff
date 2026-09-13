package org.apache.commons.compress.harmony.pack200;

import org.objectweb.asm.ClassReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class Pack200ClassReader extends ClassReader {
    private boolean anySyntheticAttributes;
    private String fileName;
    private boolean lastConstantHadWideIndex;
    private int lastUnsignedShort;

    public Pack200ClassReader(byte[] bArr) {
        super(bArr);
    }

    public String getFileName() {
        return this.fileName;
    }

    public boolean hasSyntheticAttributes() {
        return this.anySyntheticAttributes;
    }

    public boolean lastConstantHadWideIndex() {
        return this.lastConstantHadWideIndex;
    }

    public Object readConst(int i5, char[] cArr) {
        this.lastConstantHadWideIndex = i5 == this.lastUnsignedShort;
        return super.readConst(i5, cArr);
    }

    public String readUTF8(int i5, char[] cArr) {
        String utf8 = super.readUTF8(i5, cArr);
        if (!this.anySyntheticAttributes && "Synthetic".equals(utf8)) {
            this.anySyntheticAttributes = true;
        }
        return utf8;
    }

    public int readUnsignedShort(int i5) {
        int unsignedShort = super.readUnsignedShort(i5);
        if (this.b[i5 - 1] == 19) {
            this.lastUnsignedShort = unsignedShort;
            return unsignedShort;
        }
        this.lastUnsignedShort = -32768;
        return unsignedShort;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }
}
