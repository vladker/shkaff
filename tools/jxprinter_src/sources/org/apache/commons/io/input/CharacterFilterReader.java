package org.apache.commons.io.input;

import java.io.Reader;
import java.util.function.IntPredicate;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public class CharacterFilterReader extends AbstractCharacterFilterReader {
    public CharacterFilterReader(Reader reader, final int i5) {
        super(reader, new IntPredicate() { // from class: org.apache.commons.io.input.a
            @Override // java.util.function.IntPredicate
            public final boolean test(int i6) {
                return CharacterFilterReader.lambda$new$0(i5, i6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$new$0(int i5, int i6) {
        return i6 == i5;
    }

    public CharacterFilterReader(Reader reader, IntPredicate intPredicate) {
        super(reader, intPredicate);
    }
}
