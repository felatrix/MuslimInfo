package flo.muslim.info.model;

import android.support.annotation.StringRes;

public class ZakatModel {


    @StringRes
    private int stringTitleId;


    public ZakatModel() {
    }

    public ZakatModel(@StringRes int stringTitleId) {
        this.stringTitleId = stringTitleId;
    }

    public int getStringTitleId() { return stringTitleId; }

    public void setStringTitleId(int stringTitleId) {
        this.stringTitleId = stringTitleId;
    }

}
