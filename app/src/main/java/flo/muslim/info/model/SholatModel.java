package flo.muslim.info.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class SholatModel {


    @StringRes
    private int stringTitleId;

    @DrawableRes
    private int drawableResId;

    public SholatModel() {
    }

    public SholatModel(@StringRes int stringTitleId, @DrawableRes int drawableResId) {
        this.stringTitleId = stringTitleId;
        this.drawableResId = drawableResId;
    }

    public int getStringTitleId() { return stringTitleId; }

    public void setStringTitleId(int stringTitleId) {
        this.stringTitleId = stringTitleId;
    }

    public int getDrawableResId() {
        return drawableResId;
    }

    public void setDrawableResId(@DrawableRes int drawableResId) { this.drawableResId = drawableResId; }

}
