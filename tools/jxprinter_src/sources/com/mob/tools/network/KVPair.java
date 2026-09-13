package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;

/* JADX INFO: loaded from: classes3.dex */
public class KVPair<T> implements PublicMemberKeeper {
    public final String name;
    public final T value;

    public KVPair(String str, T t6) {
        this.name = str;
        this.value = t6;
    }

    public String toString() {
        return this.name + " = " + this.value;
    }
}
