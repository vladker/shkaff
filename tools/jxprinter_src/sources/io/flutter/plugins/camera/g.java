package io.flutter.plugins.camera;

import java.util.function.IntPredicate;
import org.apache.commons.io.input.AbstractCharacterFilterReader;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements IntPredicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4106a;

    public /* synthetic */ g(int i5) {
        this.f4106a = i5;
    }

    @Override // java.util.function.IntPredicate
    public final boolean test(int i5) {
        switch (this.f4106a) {
            case 0:
                return CameraRegionUtils.lambda$supportsDistortionCorrection$0(i5);
            default:
                return AbstractCharacterFilterReader.lambda$static$0(i5);
        }
    }
}
