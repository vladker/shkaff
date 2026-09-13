package com.mob.tools.utils;

import cn.fly.tools.utils.FlyRSA;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class MobRSA implements PublicMemberKeeper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlyRSA f3677a;

    public MobRSA(int i5) {
        this.f3677a = new FlyRSA(i5);
    }

    public byte[] encode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        return this.f3677a.encode(bArr, bigInteger, bigInteger2);
    }
}
