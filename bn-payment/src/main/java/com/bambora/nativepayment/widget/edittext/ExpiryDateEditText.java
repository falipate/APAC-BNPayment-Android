/*
 * Copyright (c) 2016 Bambora ( http://bambora.com/ )
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.bambora.nativepayment.widget.edittext;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.text.InputType;
import android.util.AttributeSet;

import com.bambora.nativepayment.widget.textwatcher.ExpiryDateTextWatcher;

/**
 * TODO
 */
public class ExpiryDateEditText extends CardFormEditText {

    private static final int MAX_LENGTH = 5;
    private static final String DEFAULT_HINT = "MM/YY";
    private static final String DELIMITER = "/";

    public ExpiryDateEditText(Context context) {
        super(context);
        setupView();
    }

    public ExpiryDateEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupView();
    }

    public ExpiryDateEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setupView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ExpiryDateEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setupView();
    }

    @Override
    public Integer getDefaultMaxLength() {
        return MAX_LENGTH;
    }

    @Override
    public String getDefaultHint() {
        return DEFAULT_HINT;
    }

    public String getEnteredExpiryMonth() {
        String[] splitted = getSplittedInput();
        return splitted.length > 0 ? splitted[0] : null;
    }

    public String getEnteredExpiryYear() {
        String[] splitted = getSplittedInput();
        return splitted.length > 1 ? splitted[1] : null;
    }

    private void setupView() {
        setInputType(InputType.TYPE_CLASS_PHONE);
        addTextChangedListener(new ExpiryDateTextWatcher(this));
    }

    private String[] getSplittedInput() {
        String input = getText().toString();
        return input.split(DELIMITER);
    }
}
