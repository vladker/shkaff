package androidx.constraintlayout.core.state;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public interface CoreMotionScene {
    String getConstraintSet(int i5);

    String getConstraintSet(String str);

    String getTransition(String str);

    void setConstraintSetContent(String str, String str2);

    void setDebugName(String str);

    void setTransitionContent(String str, String str2);
}
