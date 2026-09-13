package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class SidePropagation extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;
    private int mSide = 80;

    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    /* JADX WARN: Code duplicated, block: B:7:0x0012  */
    private int distance(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int i13 = this.mSide;
        if (i13 == 8388611) {
            if (view.getLayoutDirection() == 1) {
                i13 = 5;
            } else {
                i13 = 3;
            }
        } else if (i13 == 8388613) {
            if (view.getLayoutDirection() == 1) {
                i13 = 3;
            } else {
                i13 = 5;
            }
        }
        if (i13 == 3) {
            return Math.abs(i8 - i6) + (i11 - i5);
        }
        if (i13 == 5) {
            return Math.abs(i8 - i6) + (i5 - i9);
        }
        if (i13 == 48) {
            return Math.abs(i7 - i5) + (i12 - i6);
        }
        if (i13 != 80) {
            return 0;
        }
        return Math.abs(i7 - i5) + (i6 - i10);
    }

    private int getMaxDistance(ViewGroup viewGroup) {
        int i5 = this.mSide;
        return (i5 == 3 || i5 == 5 || i5 == 8388611 || i5 == 8388613) ? viewGroup.getWidth() : viewGroup.getHeight();
    }

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(@NonNull ViewGroup viewGroup, @NonNull Transition transition, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        int i5;
        int i6;
        int iCenterY;
        int i7;
        TransitionValues transitionValues3 = transitionValues;
        if (transitionValues3 == null && transitionValues2 == null) {
            return 0L;
        }
        Rect epicenter = transition.getEpicenter();
        if (transitionValues2 == null || getViewVisibility(transitionValues3) == 0) {
            i5 = -1;
        } else {
            transitionValues3 = transitionValues2;
            i5 = 1;
        }
        int viewX = getViewX(transitionValues3);
        int viewY = getViewY(transitionValues3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = Math.round(viewGroup.getTranslationX()) + iArr[0];
        int iRound2 = Math.round(viewGroup.getTranslationY()) + iArr[1];
        int width = viewGroup.getWidth() + iRound;
        int height = viewGroup.getHeight() + iRound2;
        if (epicenter != null) {
            int iCenterX = epicenter.centerX();
            i7 = height;
            iCenterY = epicenter.centerY();
            i6 = iCenterX;
        } else {
            i6 = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
            i7 = height;
        }
        float fDistance = distance(viewGroup, viewX, viewY, i6, iCenterY, iRound, iRound2, width, i7) / getMaxDistance(viewGroup);
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return Math.round(((duration * ((long) i5)) / this.mPropagationSpeed) * fDistance);
    }

    public void setPropagationSpeed(float f6) {
        if (f6 == 0.0f) {
            throw new IllegalArgumentException("propagationSpeed may not be 0");
        }
        this.mPropagationSpeed = f6;
    }

    public void setSide(int i5) {
        this.mSide = i5;
    }
}
