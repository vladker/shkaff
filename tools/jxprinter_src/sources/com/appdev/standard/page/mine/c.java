package com.appdev.standard.page.mine;

import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements IntFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2704a;

    public /* synthetic */ c(int i5) {
        this.f2704a = i5;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i5) {
        switch (this.f2704a) {
            case 0:
                return FeedbackActivity.AnonymousClass2.lambda$onItemClick$1(i5);
            default:
                return FeedbackListActivity.AnonymousClass3.lambda$onItemClick$0(i5);
        }
    }
}
