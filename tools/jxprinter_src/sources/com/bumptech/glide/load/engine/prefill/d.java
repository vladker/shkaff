package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f3067a;
    public final ArrayList b;
    public int c;
    public int d;

    public d(HashMap map) {
        this.f3067a = map;
        this.b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.c = num.intValue() + this.c;
        }
    }
}
