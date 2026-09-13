package org.apache.commons.io.input;

import io.flutter.plugins.camera.g;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AbstractCharacterFilterReader extends FilterReader {
    protected static final IntPredicate SKIP_NONE = new g(1);
    private final IntPredicate skip;

    public AbstractCharacterFilterReader(Reader reader) {
        this(reader, SKIP_NONE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(int i5) {
        return false;
    }

    public boolean filter(int i5) {
        return this.skip.test(i5);
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int i5;
        do {
            i5 = ((FilterReader) this).in.read();
            if (i5 == -1) {
                break;
            }
        } while (filter(i5));
        return i5;
    }

    public AbstractCharacterFilterReader(Reader reader, IntPredicate intPredicate) {
        super(reader);
        this.skip = intPredicate == null ? SKIP_NONE : intPredicate;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i5, int i6) throws IOException {
        int i7 = super.read(cArr, i5, i6);
        if (i7 == -1) {
            return -1;
        }
        int i8 = i5 - 1;
        for (int i9 = i5; i9 < i5 + i7; i9++) {
            if (!filter(cArr[i9]) && (i8 = i8 + 1) < i9) {
                cArr[i8] = cArr[i9];
            }
        }
        return (i8 - i5) + 1;
    }
}
