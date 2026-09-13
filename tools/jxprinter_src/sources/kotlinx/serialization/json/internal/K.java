package kotlinx.serialization.json.internal;

import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5727a;
    private Object[] currentObjectPath = new Object[8];
    private int[] indicies;

    public K() {
        int[] iArr = new int[8];
        for (int i5 = 0; i5 < 8; i5++) {
            iArr[i5] = -1;
        }
        this.indicies = iArr;
        this.f5727a = -1;
    }

    public final void a() {
        int i5 = this.f5727a;
        int[] iArr = this.indicies;
        if (iArr[i5] == -2) {
            iArr[i5] = -1;
            this.f5727a = i5 - 1;
        }
        int i6 = this.f5727a;
        if (i6 != -1) {
            this.f5727a = i6 - 1;
        }
    }

    public final void b() {
        int[] iArr = this.indicies;
        int i5 = this.f5727a;
        if (iArr[i5] == -2) {
            this.currentObjectPath[i5] = J.INSTANCE;
        }
    }

    public final void c(int i5) {
        this.indicies[this.f5727a] = i5;
    }

    public final String getPath() {
        StringBuilder sb = new StringBuilder("$");
        int i5 = this.f5727a + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = this.currentObjectPath[i6];
            if (obj instanceof p072m4.r) {
                p072m4.r rVar = (p072m4.r) obj;
                if (!kotlin.jvm.internal.E.a(rVar.getKind(), p072m4.B.INSTANCE)) {
                    int i7 = this.indicies[i6];
                    if (i7 >= 0) {
                        sb.append(Consts.DOT);
                        sb.append(rVar.getElementName(i7));
                    }
                } else if (this.indicies[i6] != -1) {
                    sb.append("[");
                    sb.append(this.indicies[i6]);
                    sb.append("]");
                }
            } else if (obj != J.INSTANCE) {
                sb.append("['");
                sb.append(obj);
                sb.append("']");
            }
        }
        String string = sb.toString();
        kotlin.jvm.internal.E.e(string, "toString(...)");
        return string;
    }

    public final void pushDescriptor(p072m4.r sd) {
        kotlin.jvm.internal.E.f(sd, "sd");
        int i5 = this.f5727a + 1;
        this.f5727a = i5;
        Object[] objArr = this.currentObjectPath;
        if (i5 == objArr.length) {
            int i6 = i5 * 2;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, i6);
            kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
            this.currentObjectPath = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.indicies, i6);
            kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
            this.indicies = iArrCopyOf;
        }
        this.currentObjectPath[i5] = sd;
    }

    public String toString() {
        return getPath();
    }

    public final void updateCurrentMapKey(Object obj) {
        int[] iArr = this.indicies;
        int i5 = this.f5727a;
        if (iArr[i5] != -2) {
            int i6 = i5 + 1;
            this.f5727a = i6;
            Object[] objArr = this.currentObjectPath;
            if (i6 == objArr.length) {
                int i7 = i6 * 2;
                Object[] objArrCopyOf = Arrays.copyOf(objArr, i7);
                kotlin.jvm.internal.E.e(objArrCopyOf, "copyOf(...)");
                this.currentObjectPath = objArrCopyOf;
                int[] iArrCopyOf = Arrays.copyOf(this.indicies, i7);
                kotlin.jvm.internal.E.e(iArrCopyOf, "copyOf(...)");
                this.indicies = iArrCopyOf;
            }
        }
        Object[] objArr2 = this.currentObjectPath;
        int i8 = this.f5727a;
        objArr2[i8] = obj;
        this.indicies[i8] = -2;
    }
}
