package com.gjiazhe.viewpagertransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gjz on 04/12/2016.
 */

public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
    private float minScale;
    private float minAlpha;

    public ZoomOutPageTransformer() {
        this.minScale = 0.85f;
        this.minAlpha = 0.7f;
    }

    public ZoomOutPageTransformer(float minScale, float minAlpha) {
        setMinScale(minScale);
        setMinAlpha(minAlpha);
    }

    public void transformPage(View page, float position) {
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            page.setAlpha(0);

        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            float scaleFactor = Math.max(minScale, 1 - Math.abs(position));
            float vertMargin = pageHeight * (1 - scaleFactor) / 2;
            float horzMargin = pageWidth * (1 - scaleFactor) / 2;
            if (position < 0) {
                page.setTranslationX(horzMargin - vertMargin / 2);
            } else {
                page.setTranslationX(-horzMargin + vertMargin / 2);
            }

            // Scale the page down (between minScale and 1)
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

            // Fade the page relative to its size.
            if (minScale == 1f || minAlpha == 1f) {
                page.setAlpha(1f);
            } else {
                page.setAlpha(minAlpha + (scaleFactor - minScale) / (1 - minScale) * (1 - minAlpha));
            }

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            page.setAlpha(0);
        }
    }

    public float getMinScale() {
        return minScale;
    }

    public void setMinScale(float minScale) {
        if (minScale < 0 || minScale > 1) {
            throw new IllegalArgumentException("the min scale must be between 0 to 1");
        }
        this.minScale = minScale;
    }

    public float getMinAlpha() {
        return minAlpha;
    }

    public void setMinAlpha(float minAlpha) {
        if (minAlpha < 0 || minAlpha >1) {
            throw new IllegalArgumentException("the min alpha must be between 0 to 1");
        }
        this.minAlpha = minAlpha;
    }
}

