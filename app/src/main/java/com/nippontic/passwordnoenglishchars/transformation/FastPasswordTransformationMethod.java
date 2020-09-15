package com.nippontic.passwordnoenglishchars.transformation;

import android.text.method.PasswordTransformationMethod;
import android.view.View;

public class FastPasswordTransformationMethod extends PasswordTransformationMethod {

    private static char DOT = '\u2022';

    @Override
    public CharSequence getTransformation(CharSequence source, View view) {
        return new PasswordCharSequence(source);
    }

    private class PasswordCharSequence implements CharSequence {
        private CharSequence mSource;

        public PasswordCharSequence(CharSequence source) {
            mSource = source;
        }

        public char charAt(int index) {
            return DOT;
        }

        public int length() {
            return mSource.length();
        }

        public CharSequence subSequence(int start, int end) {
            return mSource.subSequence(start, end);
        }
    }
}
