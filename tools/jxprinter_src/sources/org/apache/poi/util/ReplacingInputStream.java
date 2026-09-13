package org.apache.poi.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
@Internal
public class ReplacingInputStream extends FilterInputStream {
    final int[] buf;
    private int matchedIndex;
    private final byte[] pattern;
    private int replacedIndex;
    private final byte[] replacement;
    private State state;
    private int unbufferIndex;

    /* JADX INFO: renamed from: org.apache.poi.util.ReplacingInputStream$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$util$ReplacingInputStream$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$org$apache$poi$util$ReplacingInputStream$State = iArr;
            try {
                iArr[State.NOT_MATCHED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.MATCHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.REPLACING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$poi$util$ReplacingInputStream$State[State.UNBUFFER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
    public enum State {
        NOT_MATCHED,
        MATCHING,
        REPLACING,
        UNBUFFER
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReplacingInputStream(InputStream inputStream, String str, String str2) {
        Charset charset = StandardCharsets.UTF_8;
        this(inputStream, str.getBytes(charset), str2 == null ? null : str2.getBytes(charset));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) throws IOException {
        bArr.getClass();
        if (i5 < 0 || i6 < 0 || i6 > bArr.length - i5) {
            throw new IndexOutOfBoundsException();
        }
        if (i6 == 0) {
            return 0;
        }
        int i7 = read();
        if (i7 == -1) {
            return -1;
        }
        bArr[i5] = (byte) i7;
        int i8 = 1;
        while (i8 < i6) {
            int i9 = read();
            if (i9 == -1) {
                break;
            }
            bArr[i5 + i8] = (byte) i9;
            i8++;
        }
        return i8;
    }

    public String toString() {
        return this.state.name() + " " + this.matchedIndex + " " + this.replacedIndex + " " + this.unbufferIndex;
    }

    public ReplacingInputStream(InputStream inputStream, byte[] bArr, byte[] bArr2) {
        super(inputStream);
        this.state = State.NOT_MATCHED;
        if (bArr == null || bArr.length == 0) {
            throw new IllegalArgumentException("pattern length should be > 0");
        }
        this.pattern = bArr;
        this.replacement = bArr2;
        this.buf = new int[bArr.length];
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i5 = AnonymousClass1.$SwitchMap$org$apache$poi$util$ReplacingInputStream$State[this.state.ordinal()];
        if (i5 == 2) {
            int i6 = super.read();
            byte[] bArr = this.pattern;
            int i7 = this.matchedIndex;
            if (bArr[i7] == i6) {
                int[] iArr = this.buf;
                int i8 = i7 + 1;
                this.matchedIndex = i8;
                iArr[i7] = i6;
                if (i8 == bArr.length) {
                    byte[] bArr2 = this.replacement;
                    if (bArr2 != null && bArr2.length != 0) {
                        this.state = State.REPLACING;
                        this.replacedIndex = 0;
                    } else {
                        this.state = State.NOT_MATCHED;
                        this.matchedIndex = 0;
                    }
                }
            } else {
                int[] iArr2 = this.buf;
                this.matchedIndex = i7 + 1;
                iArr2[i7] = i6;
                this.state = State.UNBUFFER;
                this.unbufferIndex = 0;
            }
            return read();
        }
        if (i5 == 3) {
            byte[] bArr3 = this.replacement;
            int i9 = this.replacedIndex;
            int i10 = i9 + 1;
            this.replacedIndex = i10;
            byte b = bArr3[i9];
            if (i10 == bArr3.length) {
                this.state = State.NOT_MATCHED;
                this.replacedIndex = 0;
            }
            return b;
        }
        if (i5 != 4) {
            int i11 = super.read();
            if (this.pattern[0] != i11) {
                return i11;
            }
            Arrays.fill(this.buf, 0);
            int[] iArr3 = this.buf;
            this.matchedIndex = 1;
            iArr3[0] = i11;
            if (this.pattern.length == 1) {
                this.state = State.REPLACING;
                this.replacedIndex = 0;
            } else {
                this.state = State.MATCHING;
            }
            return read();
        }
        int[] iArr4 = this.buf;
        int i12 = this.unbufferIndex;
        int i13 = i12 + 1;
        this.unbufferIndex = i13;
        int i14 = iArr4[i12];
        if (i13 == this.matchedIndex) {
            this.state = State.NOT_MATCHED;
            this.matchedIndex = 0;
        }
        return i14;
    }
}
