package p075n1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import kotlinx.serialization.json.internal.AbstractC1125a;
import kotlinx.serialization.json.internal.AbstractC1127c;
import p098r1.a;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6215a;
    public final SharedPreferences b;
    public final b c;
    public byte[] d;
    public boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f6216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f6217g;

    @Deprecated
    public d(Context context) {
        this(context, 1);
    }

    private byte[] generateAndSaveKey(String str, int i5) {
        byte[] bArr = new byte[i5];
        this.c.nextBytes(bArr);
        SharedPreferences.Editor editorEdit = this.b.edit();
        editorEdit.putString(str, Base64.encodeToString(bArr, 0));
        editorEdit.commit();
        return bArr;
    }

    private byte[] maybeGenerateKey(String str, int i5) {
        String string = this.b.getString(str, null);
        return string == null ? generateAndSaveKey(str, i5) : Base64.decode(string, 0);
    }

    @Override // p098r1.a
    public synchronized byte[] getCipherKey() {
        try {
            if (!this.e) {
                this.d = maybeGenerateKey("cipher_key", AbstractC1125a.b(this.f6215a));
            }
            this.e = true;
        } catch (Throwable th) {
            throw th;
        }
        return this.d;
    }

    @Override // p098r1.a
    public byte[] getMacKey() {
        if (!this.f6217g) {
            this.f6216f = maybeGenerateKey("mac_key", 64);
        }
        this.f6217g = true;
        return this.f6216f;
    }

    @Override // p098r1.a
    public byte[] getNewIV() {
        if (this.f6215a == 0) {
            throw null;
        }
        byte[] bArr = new byte[12];
        this.c.nextBytes(bArr);
        return bArr;
    }

    public d(Context context, int i5) {
        String strConcat;
        if (i5 == 1) {
            strConcat = "crypto";
        } else {
            strConcat = "crypto.".concat(i5 != 1 ? i5 != 2 ? AbstractC1127c.NULL : "KEY_256" : "KEY_128");
        }
        this.b = context.getSharedPreferences(strConcat, 0);
        this.c = new b();
        this.f6215a = i5;
    }
}
