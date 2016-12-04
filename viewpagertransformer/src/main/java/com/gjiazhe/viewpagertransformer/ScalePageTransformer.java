package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 04/12/2016.
 */

public class ScalePageTransformer implements ViewPager.PageTransformer {
    private float finalScale;

    public ScalePageTransformer() {
        finalScale = 0.5f;
    }

    public ScalePageTransformer(float finalScale) {
        setFinalScale(finalScale);
    }

    @Override
    public void transformPage(View page, float position) {
        float scale;
        if (position <= -1 || position >= 1) {
            scale = finalScale;
        } else {
            scale = 1 - (1 - finalScale) * Math.abs(position);
        }

        page.setPivotX(position < 0 ? page.getWidth() : 0);
        page.setPivotY(page.getHeight() / 2f);

        page.setScaleX(scale);
        page.setScaleY(scale);
    }

    public float getFinalScale() {
        return finalScale;
    }

    public void setFinalScale(float finalScale) {
        this.finalScale = finalScale;
    }
}
