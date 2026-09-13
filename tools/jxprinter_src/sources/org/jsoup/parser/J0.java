package org.jsoup.parser;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final enum J0 extends h1 {
    public J0() {
        super("CharacterReferenceInRcdata", 3);
    }

    @Override // org.jsoup.parser.h1
    public final void d(Q q6, C1465a c1465a) {
        int[] iArrConsumeCharacterReference = q6.consumeCharacterReference(null, false);
        if (iArrConsumeCharacterReference == null) {
            q6.f('&');
        } else {
            q6.g(new String(iArrConsumeCharacterReference, 0, iArrConsumeCharacterReference.length));
        }
        q6.c = h1.c;
    }
}
