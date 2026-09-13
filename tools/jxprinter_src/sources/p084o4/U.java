package p084o4;

import java.util.Arrays;
import kotlin.jvm.internal.E;
import p072m4.r;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final class U extends G0 {
    public final boolean c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public U(String name, O generatedSerializer) {
        super(name, generatedSerializer, 1);
        E.f(name, "name");
        E.f(generatedSerializer, "generatedSerializer");
        this.c = true;
    }

    @Override // p084o4.G0
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof U) {
            r rVar = (r) obj;
            if (E.a(getSerialName(), rVar.getSerialName())) {
                U u6 = (U) obj;
                if (u6.c && Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), u6.getTypeParameterDescriptors$kotlinx_serialization_core())) {
                    int iB = rVar.b();
                    int i5 = this.f6453a;
                    if (i5 == iB) {
                        for (int i6 = 0; i6 < i5; i6++) {
                            if (E.a(getElementDescriptor(i6).getSerialName(), rVar.getElementDescriptor(i6).getSerialName()) && E.a(getElementDescriptor(i6).getKind(), rVar.getElementDescriptor(i6).getKind())) {
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // p084o4.G0
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // p084o4.G0, p072m4.r
    public final boolean isInline() {
        return this.c;
    }
}
