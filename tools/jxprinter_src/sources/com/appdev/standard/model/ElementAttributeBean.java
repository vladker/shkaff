package com.appdev.standard.model;

/* JADX INFO: compiled from: r8-map-id-ecf7e14176b8e73200efbc86dd80f717955f363e9b0ac3efdea3eedd88177748 */
/* JADX INFO: loaded from: classes2.dex */
public class ElementAttributeBean {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f2660h;
    private int itemType;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f2661l;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private float f2662t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2663w;
    private int rotate = 0;
    private boolean lockLocation = false;
    private int controlType = 1;
    private boolean takePrint = true;

    public int getControlType() {
        return this.controlType;
    }

    public int getElementType() {
        return this.itemType;
    }

    public float getHeight() {
        return this.f2660h;
    }

    public int getRotationAngle() {
        return this.rotate;
    }

    public float getWidth() {
        return this.f2663w;
    }

    public float getX() {
        return this.f2661l;
    }

    public float getY() {
        return this.f2662t;
    }

    public boolean isLockLocation() {
        return this.lockLocation;
    }

    public boolean isTakePrint() {
        return this.takePrint;
    }

    public void setControlType(int i5) {
        this.controlType = i5;
    }

    public void setElementType(int i5) {
        this.itemType = i5;
    }

    public void setHeight(float f6) {
        this.f2660h = f6;
    }

    public void setLockLocation(boolean z6) {
        this.lockLocation = z6;
    }

    public void setRotationAngle(int i5) {
        this.rotate = i5;
    }

    public void setTakePrint(boolean z6) {
        this.takePrint = z6;
    }

    public void setWidth(float f6) {
        this.f2663w = f6;
    }

    public void setX(float f6) {
        this.f2661l = f6;
    }

    public void setY(float f6) {
        this.f2662t = f6;
    }
}
