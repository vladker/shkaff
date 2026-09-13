package org.apache.commons.math3.geometry.euclidean.threed;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes4.dex */
public final class RotationOrder {
    public static final RotationOrder XYX;
    public static final RotationOrder XYZ;
    public static final RotationOrder XZX;
    public static final RotationOrder XZY;
    public static final RotationOrder YXY;
    public static final RotationOrder YXZ;
    public static final RotationOrder YZX;
    public static final RotationOrder YZY;
    public static final RotationOrder ZXY;
    public static final RotationOrder ZXZ;
    public static final RotationOrder ZYX;
    public static final RotationOrder ZYZ;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    private final Vector3D f6791a1;

    /* JADX INFO: renamed from: a2, reason: collision with root package name */
    private final Vector3D f6792a2;

    /* JADX INFO: renamed from: a3, reason: collision with root package name */
    private final Vector3D f6793a3;
    private final String name;

    static {
        Vector3D vector3D = Vector3D.PLUS_I;
        Vector3D vector3D2 = Vector3D.PLUS_J;
        Vector3D vector3D3 = Vector3D.PLUS_K;
        XYZ = new RotationOrder("XYZ", vector3D, vector3D2, vector3D3);
        XZY = new RotationOrder("XZY", vector3D, vector3D3, vector3D2);
        YXZ = new RotationOrder("YXZ", vector3D2, vector3D, vector3D3);
        YZX = new RotationOrder("YZX", vector3D2, vector3D3, vector3D);
        ZXY = new RotationOrder("ZXY", vector3D3, vector3D, vector3D2);
        ZYX = new RotationOrder("ZYX", vector3D3, vector3D2, vector3D);
        XYX = new RotationOrder("XYX", vector3D, vector3D2, vector3D);
        XZX = new RotationOrder("XZX", vector3D, vector3D3, vector3D);
        YXY = new RotationOrder("YXY", vector3D2, vector3D, vector3D2);
        YZY = new RotationOrder("YZY", vector3D2, vector3D3, vector3D2);
        ZXZ = new RotationOrder("ZXZ", vector3D3, vector3D, vector3D3);
        ZYZ = new RotationOrder("ZYZ", vector3D3, vector3D2, vector3D3);
    }

    private RotationOrder(String str, Vector3D vector3D, Vector3D vector3D2, Vector3D vector3D3) {
        this.name = str;
        this.f6791a1 = vector3D;
        this.f6792a2 = vector3D2;
        this.f6793a3 = vector3D3;
    }

    public Vector3D getA1() {
        return this.f6791a1;
    }

    public Vector3D getA2() {
        return this.f6792a2;
    }

    public Vector3D getA3() {
        return this.f6793a3;
    }

    public String toString() {
        return this.name;
    }
}
