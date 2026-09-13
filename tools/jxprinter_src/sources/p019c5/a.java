package p019c5;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1191a;
    public String b;
    public String c;
    public Field d;
    public Field e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1192f;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.f1192f != this.f1192f || !aVar.c.equals(this.c)) {
            return false;
        }
        if (aVar.f1191a.equals(this.f1191a) && aVar.b.equals(this.b)) {
            return true;
        }
        return aVar.f1191a.equals(this.b) && aVar.b.equals(this.f1191a);
    }
}
