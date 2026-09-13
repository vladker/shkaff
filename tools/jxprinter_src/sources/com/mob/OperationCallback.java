package com.mob;

import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class OperationCallback<T> implements PublicMemberKeeper {
    public abstract void onComplete(T t6);

    public abstract void onFailure(Throwable th);
}
