package com.google.android.material.carousel;

import A3.AbstractC0157z;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float endShiftRange;
    private final List<KeylineState> endStateSteps;
    private final float[] endStateStepsInterpolationPoints;
    private final float startShiftRange;
    private final List<KeylineState> startStateSteps;
    private final float[] startStateStepsInterpolationPoints;

    private KeylineStateList(@NonNull KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.startStateSteps = Collections.unmodifiableList(list);
        this.endStateSteps = Collections.unmodifiableList(list2);
        float f6 = ((KeylineState) AbstractC0157z.f(1, list)).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.startShiftRange = f6;
        float f7 = keylineState.getLastKeyline().loc - ((KeylineState) AbstractC0157z.f(1, list2)).getLastKeyline().loc;
        this.endShiftRange = f7;
        this.startStateStepsInterpolationPoints = getStateStepInterpolationPoints(f6, list, true);
        this.endStateStepsInterpolationPoints = getStateStepInterpolationPoints(f7, list2, false);
    }

    private KeylineState closestStateStepFromInterpolation(List<KeylineState> list, float f6, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f6, fArr);
        return stateStepsRange[0] >= 0.5f ? list.get((int) stateStepsRange[2]) : list.get((int) stateStepsRange[1]);
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f6) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f6 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findFirstNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int i5 = 0; i5 < keylineState.getKeylines().size(); i5++) {
            if (!keylineState.getKeylines().get(i5).isAnchor) {
                return i5;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f6) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f6 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    private static int findLastNonAnchorKeylineIndex(KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (!keylineState.getKeylines().get(size).isAnchor) {
                return size;
            }
        }
        return -1;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState, float f6, float f7, float f8) {
        return new KeylineStateList(keylineState, getStateStepsStart(carousel, keylineState, f6, f7), getStateStepsEnd(carousel, keylineState, f6, f8));
    }

    private static float[] getStateStepInterpolationPoints(float f6, List<KeylineState> list, boolean z6) {
        int size = list.size();
        float[] fArr = new float[size];
        int i5 = 1;
        while (i5 < size) {
            int i6 = i5 - 1;
            KeylineState keylineState = list.get(i6);
            KeylineState keylineState2 = list.get(i5);
            fArr[i5] = i5 == size + (-1) ? 1.0f : fArr[i6] + ((z6 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f6);
            i5++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsEnd(Carousel carousel, KeylineState keylineState, float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastNonAnchorKeylineIndex = findLastNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isLastFocalItemVisibleAtRightOfContainer(carousel, keylineState) && iFindLastNonAnchorKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastNonAnchorKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f8 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (lastFocalKeylineIndex <= 0 && keylineState.getLastFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f8 - keylineState.getLastFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i5 = 0;
            float f9 = 0.0f;
            while (i5 < lastFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) androidx.collection.a.e(arrayList, 1);
                int i6 = iFindLastNonAnchorKeylineIndex - i5;
                float f10 = f9 + keylineState.getKeylines().get(i6).cutoff;
                int i7 = i6 + 1;
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindLastNonAnchorKeylineIndex, i7 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i7).mask) + 1 : 0, f8 - f10, keylineState.getFirstFocalKeylineIndex() + i5 + 1, keylineState.getLastFocalKeylineIndex() + i5 + 1, containerWidth);
                if (i5 == lastFocalKeylineIndex - 1 && f7 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f7, containerWidth, false, f6);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i5++;
                f9 = f10;
            }
        } else if (f7 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f7, containerWidth, false, f6));
        }
        return arrayList;
    }

    private static float[] getStateStepsRange(List<KeylineState> list, float f6, float[] fArr) {
        int size = list.size();
        float f7 = fArr[0];
        int i5 = 1;
        while (i5 < size) {
            float f8 = fArr[i5];
            if (f6 <= f8) {
                return new float[]{AnimationUtils.lerp(0.0f, 1.0f, f7, f8, f6), i5 - 1, i5};
            }
            i5++;
            f7 = f8;
        }
        return new float[]{0.0f, 0.0f, 0.0f};
    }

    private static List<KeylineState> getStateStepsStart(Carousel carousel, KeylineState keylineState, float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstNonAnchorKeylineIndex = findFirstNonAnchorKeylineIndex(keylineState);
        float containerWidth = carousel.isHorizontal() ? carousel.getContainerWidth() : carousel.getContainerHeight();
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstNonAnchorKeylineIndex != -1) {
            int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - iFindFirstNonAnchorKeylineIndex;
            float f8 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            if (firstFocalKeylineIndex <= 0 && keylineState.getFirstFocalKeyline().cutoff > 0.0f) {
                arrayList.add(shiftKeylinesAndCreateKeylineState(keylineState, f8 + keylineState.getFirstFocalKeyline().cutoff, containerWidth));
                return arrayList;
            }
            int i5 = 0;
            float f9 = 0.0f;
            while (i5 < firstFocalKeylineIndex) {
                KeylineState keylineState2 = (KeylineState) androidx.collection.a.e(arrayList, 1);
                int i6 = iFindFirstNonAnchorKeylineIndex + i5;
                int size = keylineState.getKeylines().size() - 1;
                float f10 = f9 + keylineState.getKeylines().get(i6).cutoff;
                int i7 = i6 - 1;
                if (i7 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i7).mask) - 1;
                }
                KeylineState keylineStateMoveKeylineAndCreateKeylineState = moveKeylineAndCreateKeylineState(keylineState2, iFindFirstNonAnchorKeylineIndex, size, f8 + f10, (keylineState.getFirstFocalKeylineIndex() - i5) - 1, (keylineState.getLastFocalKeylineIndex() - i5) - 1, containerWidth);
                if (i5 == firstFocalKeylineIndex - 1 && f7 > 0.0f) {
                    keylineStateMoveKeylineAndCreateKeylineState = shiftKeylineStateForPadding(keylineStateMoveKeylineAndCreateKeylineState, f7, containerWidth, true, f6);
                }
                arrayList.add(keylineStateMoveKeylineAndCreateKeylineState);
                i5++;
                f9 = f10;
            }
        } else if (f7 > 0.0f) {
            arrayList.add(shiftKeylineStateForPadding(keylineState, f7, containerWidth, true, f6));
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) >= 0.0f && keylineState.getFirstFocalKeyline() == keylineState.getFirstNonAnchorKeyline();
    }

    private static boolean isLastFocalItemVisibleAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        int containerHeight = carousel.getContainerHeight();
        if (carousel.isHorizontal()) {
            containerHeight = carousel.getContainerWidth();
        }
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset <= ((float) containerHeight) && keylineState.getLastFocalKeyline() == keylineState.getLastNonAnchorKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f6, float[] fArr) {
        float[] stateStepsRange = getStateStepsRange(list, f6, fArr);
        return KeylineState.lerp(list.get((int) stateStepsRange[1]), list.get((int) stateStepsRange[2]), stateStepsRange[0]);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i5, int i6, float f6, int i7, int i8, float f7) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i6, (KeylineState.Keyline) arrayList.remove(i5));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f7);
        int i9 = 0;
        while (i9 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i9);
            float f8 = keyline.maskedItemSize;
            builder.addKeyline((f8 / 2.0f) + f6, keyline.mask, f8, i9 >= i7 && i9 <= i8, keyline.isAnchor, keyline.cutoff);
            f6 += keyline.maskedItemSize;
            i9++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylineStateForPadding(KeylineState keylineState, float f6, float f7, boolean z6, float f8) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize(), f7);
        float numberOfNonAnchorKeylines = f6 / keylineState.getNumberOfNonAnchorKeylines();
        float f9 = z6 ? f6 : 0.0f;
        int i5 = 0;
        while (i5 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i5);
            if (keyline.isAnchor) {
                builder.addKeyline(keyline.locOffset, keyline.mask, keyline.maskedItemSize, false, true, keyline.cutoff);
            } else {
                boolean z7 = i5 >= keylineState.getFirstFocalKeylineIndex() && i5 <= keylineState.getLastFocalKeylineIndex();
                float f10 = keyline.maskedItemSize - numberOfNonAnchorKeylines;
                float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(f10, keylineState.getItemSize(), f8);
                float f11 = (f10 / 2.0f) + f9;
                float f12 = f11 - keyline.locOffset;
                builder.addKeyline(f11, childMaskPercentage, f10, z7, false, keyline.cutoff, z6 ? f12 : 0.0f, z6 ? 0.0f : f12);
                f9 += f10;
            }
            i5++;
        }
        return builder.build();
    }

    private static KeylineState shiftKeylinesAndCreateKeylineState(KeylineState keylineState, float f6, float f7) {
        return moveKeylineAndCreateKeylineState(keylineState, 0, 0, f6, keylineState.getFirstFocalKeylineIndex(), keylineState.getLastFocalKeylineIndex(), f7);
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getEndState() {
        return (KeylineState) AbstractC0157z.f(1, this.endStateSteps);
    }

    public Map<Integer, KeylineState> getKeylineStateForPositionMap(int i5, int i6, int i7, boolean z6) {
        float itemSize = this.defaultState.getItemSize();
        HashMap map = new HashMap();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i8 >= i5) {
                break;
            }
            int i10 = z6 ? (i5 - i8) - 1 : i8;
            if (i10 * itemSize * (z6 ? -1 : 1) > i7 - this.endShiftRange || i8 >= i5 - this.endStateSteps.size()) {
                Integer numValueOf = Integer.valueOf(i10);
                List<KeylineState> list = this.endStateSteps;
                map.put(numValueOf, list.get(MathUtils.clamp(i9, 0, list.size() - 1)));
                i9++;
            }
            i8++;
        }
        int i11 = 0;
        for (int i12 = i5 - 1; i12 >= 0; i12--) {
            int i13 = z6 ? (i5 - i12) - 1 : i12;
            if (i13 * itemSize * (z6 ? -1 : 1) < i6 + this.startShiftRange || i12 < this.startStateSteps.size()) {
                Integer numValueOf2 = Integer.valueOf(i13);
                List<KeylineState> list2 = this.startStateSteps;
                map.put(numValueOf2, list2.get(MathUtils.clamp(i11, 0, list2.size() - 1)));
                i11++;
            }
        }
        return map;
    }

    public KeylineState getShiftedState(float f6, float f7, float f8) {
        return getShiftedState(f6, f7, f8, false);
    }

    public KeylineState getStartState() {
        return (KeylineState) AbstractC0157z.f(1, this.startStateSteps);
    }

    public KeylineState getShiftedState(float f6, float f7, float f8, boolean z6) {
        float fLerp;
        List<KeylineState> list;
        float[] fArr;
        float f9 = this.startShiftRange + f7;
        float f10 = f8 - this.endShiftRange;
        float f11 = getStartState().getFirstFocalKeyline().leftOrTopPaddingShift;
        float f12 = getEndState().getLastFocalKeyline().rightOrBottomPaddingShift;
        if (this.startShiftRange == f11) {
            f9 += f11;
        }
        if (this.endShiftRange == f12) {
            f10 -= f12;
        }
        if (f6 < f9) {
            fLerp = AnimationUtils.lerp(1.0f, 0.0f, f7, f9, f6);
            list = this.startStateSteps;
            fArr = this.startStateStepsInterpolationPoints;
        } else {
            if (f6 <= f10) {
                return this.defaultState;
            }
            fLerp = AnimationUtils.lerp(0.0f, 1.0f, f10, f8, f6);
            list = this.endStateSteps;
            fArr = this.endStateStepsInterpolationPoints;
        }
        return z6 ? closestStateStepFromInterpolation(list, fLerp, fArr) : lerp(list, fLerp, fArr);
    }
}
