package p100r3;

import java.util.List;
import p027e3.c;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f7963a;
    public static final /* synthetic */ i[] b;

    static {
        i iVar = new i("INSTANCE", 0);
        f7963a = iVar;
        b = new i[]{iVar};
    }

    public static i valueOf(String str) {
        return (i) Enum.valueOf(i.class, str);
    }

    public static i[] values() {
        return (i[]) b.clone();
    }

    @Override // p027e3.c
    public List apply(List list, Object obj) {
        list.add(obj);
        return list;
    }
}
