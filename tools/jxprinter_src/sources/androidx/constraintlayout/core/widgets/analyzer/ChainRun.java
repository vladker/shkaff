package androidx.constraintlayout.core.widgets.analyzer;

import androidx.collection.a;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int mChainStyle;
    ArrayList<WidgetRun> mWidgets;

    public ChainRun(ConstraintWidget constraintWidget, int i5) {
        super(constraintWidget);
        this.mWidgets = new ArrayList<>();
        this.orientation = i5;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.mWidget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.mWidget = constraintWidget;
        this.mWidgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.mWidgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            WidgetRun widgetRun2 = widgetRun;
            int i6 = this.orientation;
            if (i6 == 0) {
                widgetRun2.mWidget.horizontalChainRun = this;
            } else if (i6 == 1) {
                widgetRun2.mWidget.verticalChainRun = this;
            }
        }
        if (this.orientation == 0 && ((ConstraintWidgetContainer) this.mWidget.getParent()).isRtl() && this.mWidgets.size() > 1) {
            this.mWidget = ((WidgetRun) a.e(this.mWidgets, 1)).mWidget;
        }
        this.mChainStyle = this.orientation == 0 ? this.mWidget.getHorizontalChainStyle() : this.mWidget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i5 = 0; i5 < this.mWidgets.size(); i5++) {
            WidgetRun widgetRun = this.mWidgets.get(i5);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.mWidgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.mWidgets.get(size);
            if (widgetRun.mWidget.getVisibility() != 8) {
                return widgetRun.mWidget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void apply() {
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            widgetRun.apply();
        }
        int size2 = this.mWidgets.size();
        if (size2 < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.mWidgets.get(0).mWidget;
        ConstraintWidget constraintWidget2 = this.mWidgets.get(size2 - 1).mWidget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i5 = 0; i5 < this.mWidgets.size(); i5++) {
            this.mWidgets.get(i5).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void clear() {
        this.mRunGroup = null;
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            widgetRun.clear();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.mWidgets.size();
        long wrapDimension = 0;
        for (int i5 = 0; i5 < size; i5++) {
            WidgetRun widgetRun = this.mWidgets.get(i5);
            wrapDimension = ((long) widgetRun.end.mMargin) + widgetRun.getWrapDimension() + wrapDimension + ((long) widgetRun.start.mMargin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean supportsWrapComputation() {
        int size = this.mWidgets.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!this.mWidgets.get(i5).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        ArrayList<WidgetRun> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i5 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = arrayList.get(i5);
            i5++;
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:90:0x0160  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency dependency) {
        int i5;
        int i6;
        boolean z6;
        float f6;
        float f7;
        int i7;
        int i8;
        int i9;
        int i10;
        float f8;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z7;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.mWidget.getParent();
            boolean zIsRtl = parent instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer) parent).isRtl() : false;
            int i15 = this.end.value - this.start.value;
            int size = this.mWidgets.size();
            int i16 = 0;
            while (true) {
                i5 = -1;
                i6 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (this.mWidgets.get(i16).mWidget.getVisibility() != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            for (int i18 = i17; i18 >= 0; i18--) {
                if (this.mWidgets.get(i18).mWidget.getVisibility() != 8) {
                    i5 = i18;
                    break;
                }
            }
            int i19 = 0;
            while (true) {
                if (i19 >= 2) {
                    z6 = zIsRtl;
                    f6 = 0.0f;
                    f7 = 0.0f;
                    i7 = 0;
                    i8 = 0;
                    i9 = 0;
                    break;
                }
                int i20 = 0;
                i8 = 0;
                i9 = 0;
                int i21 = 0;
                f7 = 0.0f;
                while (i20 < size) {
                    WidgetRun widgetRun = this.mWidgets.get(i20);
                    if (widgetRun.mWidget.getVisibility() == i6) {
                        z7 = zIsRtl;
                    } else {
                        i21++;
                        if (i20 > 0 && i20 >= i16) {
                            i8 += widgetRun.start.mMargin;
                        }
                        DimensionDependency dimensionDependency = widgetRun.mDimension;
                        int i22 = dimensionDependency.value;
                        boolean z8 = widgetRun.mDimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (z8) {
                            int i23 = this.orientation;
                            if (i23 == 0 && !widgetRun.mWidget.mHorizontalRun.mDimension.resolved) {
                                return;
                            }
                            if (i23 == 1 && !widgetRun.mWidget.mVerticalRun.mDimension.resolved) {
                                return;
                            } else {
                                z7 = zIsRtl;
                            }
                        } else {
                            z7 = zIsRtl;
                            if (widgetRun.matchConstraintsType == 1 && i19 == 0) {
                                i22 = dimensionDependency.wrapValue;
                                i9++;
                            } else if (dimensionDependency.resolved) {
                            }
                            z8 = true;
                        }
                        if (z8) {
                            i8 += i22;
                        } else {
                            i9++;
                            float f9 = widgetRun.mWidget.mWeight[this.orientation];
                            if (f9 >= 0.0f) {
                                f7 += f9;
                            }
                        }
                        if (i20 < i17 && i20 < i5) {
                            i8 += -widgetRun.end.mMargin;
                        }
                    }
                    i20++;
                    zIsRtl = z7;
                    i6 = 8;
                }
                z6 = zIsRtl;
                f6 = 0.0f;
                if (i8 < i15 || i9 == 0) {
                    i7 = i21;
                    break;
                } else {
                    i19++;
                    zIsRtl = z6;
                    i6 = 8;
                }
            }
            int i24 = this.start.value;
            if (z6) {
                i24 = this.end.value;
            }
            float f10 = 0.5f;
            if (i8 > i15) {
                i24 = z6 ? i24 + ((int) (((i8 - i15) / 2.0f) + 0.5f)) : i24 - ((int) (((i8 - i15) / 2.0f) + 0.5f));
            }
            if (i9 > 0) {
                float f11 = i15 - i8;
                int i25 = (int) ((f11 / i9) + 0.5f);
                int i26 = 0;
                int i27 = 0;
                while (i26 < size) {
                    WidgetRun widgetRun2 = this.mWidgets.get(i26);
                    float f12 = f10;
                    int i28 = i24;
                    if (widgetRun2.mWidget.getVisibility() != 8 && widgetRun2.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        DimensionDependency dimensionDependency2 = widgetRun2.mDimension;
                        if (dimensionDependency2.resolved) {
                            i25 = i25;
                            i27 = i27;
                        } else {
                            int i29 = f7 > f6 ? (int) (((widgetRun2.mWidget.mWeight[this.orientation] * f11) / f7) + f12) : i25;
                            if (this.orientation == 0) {
                                ConstraintWidget constraintWidget = widgetRun2.mWidget;
                                i13 = constraintWidget.mMatchConstraintMaxWidth;
                                i14 = constraintWidget.mMatchConstraintMinWidth;
                            } else {
                                ConstraintWidget constraintWidget2 = widgetRun2.mWidget;
                                i13 = constraintWidget2.mMatchConstraintMaxHeight;
                                i14 = constraintWidget2.mMatchConstraintMinHeight;
                            }
                            int i30 = i27;
                            int iMax = Math.max(i14, widgetRun2.matchConstraintsType == 1 ? Math.min(i29, dimensionDependency2.wrapValue) : i29);
                            if (i13 > 0) {
                                iMax = Math.min(i13, iMax);
                            }
                            if (iMax != i29) {
                                i27 = i30 + 1;
                                i29 = iMax;
                            } else {
                                i27 = i30;
                            }
                            widgetRun2.mDimension.resolve(i29);
                        }
                    } else {
                        i25 = i25;
                        i27 = i27;
                    }
                    i26++;
                    f10 = f12;
                    i24 = i28;
                    f11 = f11;
                    i25 = i25;
                }
                i10 = i24;
                f8 = f10;
                int i31 = i27;
                if (i31 > 0) {
                    i9 -= i31;
                    i8 = 0;
                    for (int i32 = 0; i32 < size; i32++) {
                        WidgetRun widgetRun3 = this.mWidgets.get(i32);
                        if (widgetRun3.mWidget.getVisibility() != 8) {
                            if (i32 > 0 && i32 >= i16) {
                                i8 += widgetRun3.start.mMargin;
                            }
                            i8 += widgetRun3.mDimension.value;
                            if (i32 < i17 && i32 < i5) {
                                i8 += -widgetRun3.end.mMargin;
                            }
                        }
                    }
                }
                i12 = 2;
                if (this.mChainStyle == 2 && i31 == 0) {
                    i11 = 0;
                    this.mChainStyle = 0;
                } else {
                    i11 = 0;
                }
            } else {
                i10 = i24;
                f8 = 0.5f;
                i11 = 0;
                i12 = 2;
            }
            if (i8 > i15) {
                this.mChainStyle = i12;
            }
            if (i7 > 0 && i9 == 0 && i16 == i5) {
                this.mChainStyle = i12;
            }
            int i33 = this.mChainStyle;
            if (i33 == 1) {
                int i34 = i7 > 1 ? (i15 - i8) / (i7 - 1) : i7 == 1 ? (i15 - i8) / 2 : i11;
                if (i9 > 0) {
                    i34 = i11;
                }
                int i35 = i10;
                while (i11 < size) {
                    WidgetRun widgetRun4 = this.mWidgets.get(z6 ? size - (i11 + 1) : i11);
                    if (widgetRun4.mWidget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i35);
                        widgetRun4.end.resolve(i35);
                    } else {
                        if (i11 > 0) {
                            i35 = z6 ? i35 - i34 : i35 + i34;
                        }
                        if (i11 > 0 && i11 >= i16) {
                            i35 = z6 ? i35 - widgetRun4.start.mMargin : i35 + widgetRun4.start.mMargin;
                        }
                        if (z6) {
                            widgetRun4.end.resolve(i35);
                        } else {
                            widgetRun4.start.resolve(i35);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun4.mDimension;
                        int i36 = dimensionDependency3.value;
                        if (widgetRun4.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i36 = dimensionDependency3.wrapValue;
                        }
                        i35 = z6 ? i35 - i36 : i35 + i36;
                        if (z6) {
                            widgetRun4.start.resolve(i35);
                        } else {
                            widgetRun4.end.resolve(i35);
                        }
                        widgetRun4.mResolved = true;
                        if (i11 < i17 && i11 < i5) {
                            i35 = z6 ? i35 - (-widgetRun4.end.mMargin) : i35 + (-widgetRun4.end.mMargin);
                        }
                    }
                    i11++;
                }
                return;
            }
            if (i33 == 0) {
                int i37 = (i15 - i8) / (i7 + 1);
                if (i9 > 0) {
                    i37 = i11;
                }
                int i38 = i10;
                while (i11 < size) {
                    WidgetRun widgetRun5 = this.mWidgets.get(z6 ? size - (i11 + 1) : i11);
                    if (widgetRun5.mWidget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i38);
                        widgetRun5.end.resolve(i38);
                    } else {
                        int i39 = z6 ? i38 - i37 : i38 + i37;
                        if (i11 > 0 && i11 >= i16) {
                            i39 = z6 ? i39 - widgetRun5.start.mMargin : i39 + widgetRun5.start.mMargin;
                        }
                        if (z6) {
                            widgetRun5.end.resolve(i39);
                        } else {
                            widgetRun5.start.resolve(i39);
                        }
                        DimensionDependency dimensionDependency4 = widgetRun5.mDimension;
                        int iMin = dimensionDependency4.value;
                        if (widgetRun5.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency4.wrapValue);
                        }
                        i38 = z6 ? i39 - iMin : i39 + iMin;
                        if (z6) {
                            widgetRun5.start.resolve(i38);
                        } else {
                            widgetRun5.end.resolve(i38);
                        }
                        if (i11 < i17 && i11 < i5) {
                            i38 = z6 ? i38 - (-widgetRun5.end.mMargin) : i38 + (-widgetRun5.end.mMargin);
                        }
                    }
                    i11++;
                }
                return;
            }
            if (i33 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.mWidget.getHorizontalBiasPercent() : this.mWidget.getVerticalBiasPercent();
                if (z6) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i40 = (int) (((i15 - i8) * horizontalBiasPercent) + f8);
                if (i40 < 0 || i9 > 0) {
                    i40 = i11;
                }
                int i41 = z6 ? i10 - i40 : i10 + i40;
                while (i11 < size) {
                    WidgetRun widgetRun6 = this.mWidgets.get(z6 ? size - (i11 + 1) : i11);
                    if (widgetRun6.mWidget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i41);
                        widgetRun6.end.resolve(i41);
                    } else {
                        if (i11 > 0 && i11 >= i16) {
                            i41 = z6 ? i41 - widgetRun6.start.mMargin : i41 + widgetRun6.start.mMargin;
                        }
                        if (z6) {
                            widgetRun6.end.resolve(i41);
                        } else {
                            widgetRun6.start.resolve(i41);
                        }
                        DimensionDependency dimensionDependency5 = widgetRun6.mDimension;
                        int i42 = dimensionDependency5.value;
                        if (widgetRun6.mDimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i42 = dimensionDependency5.wrapValue;
                        }
                        i41 = z6 ? i41 - i42 : i41 + i42;
                        if (z6) {
                            widgetRun6.start.resolve(i41);
                        } else {
                            widgetRun6.end.resolve(i41);
                        }
                        if (i11 < i17 && i11 < i5) {
                            i41 = z6 ? i41 - (-widgetRun6.end.mMargin) : i41 + (-widgetRun6.end.mMargin);
                        }
                    }
                    i11++;
                }
            }
        }
    }
}
