package p081o1;

import kotlinx.serialization.json.internal.AbstractC1125a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements p098r1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p098r1.a f6436a;
    public final int b;

    public a(p098r1.a aVar, int i5) {
        this.f6436a = aVar;
        this.b = i5;
    }

    public static void a(int i5, String str, byte[] bArr) {
        if (bArr.length == i5) {
            return;
        }
        throw new IllegalStateException(str + " should be " + i5 + " bytes long but is " + bArr.length);
    }

    @Override // p098r1.a
    public byte[] getCipherKey() {
        byte[] cipherKey = this.f6436a.getCipherKey();
        a(AbstractC1125a.b(this.b), "Key", cipherKey);
        return cipherKey;
    }

    @Override // p098r1.a
    public byte[] getMacKey() {
        byte[] macKey = this.f6436a.getMacKey();
        a(64, "Mac", macKey);
        return macKey;
    }

    @Override // p098r1.a
    public byte[] getNewIV() {
        byte[] newIV = this.f6436a.getNewIV();
        int i5 = this.b;
        if (i5 != 1 && i5 != 2) {
            throw null;
        }
        a(12, "IV", newIV);
        return newIV;
    }
}
