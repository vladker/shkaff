package com.mob.commons.dialog;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class PolicyThrowable extends Throwable {
    private int code;

    public PolicyThrowable() {
        super("Privacy policy is not accepted");
    }

    public int getCode() {
        return this.code;
    }

    public PolicyThrowable(String str) {
        super(str);
    }

    public PolicyThrowable(String str, Throwable th) {
        super(str, th);
    }

    public PolicyThrowable(int i5, String str) {
        this(str);
        this.code = i5;
    }

    public PolicyThrowable(int i5, String str, Throwable th) {
        this(str, th);
        this.code = i5;
    }

    public PolicyThrowable(Throwable th) {
        super(th);
    }
}
