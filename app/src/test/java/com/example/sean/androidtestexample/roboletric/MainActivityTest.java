package com.example.sean.androidtestexample.roboletric;

import android.widget.TextView;

import com.example.sean.androidtestexample.BuildConfig;
import com.example.sean.androidtestexample.MainActivity;
import com.example.sean.androidtestexample.R;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Sean on 2017/9/19.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityTest {

    @Test
    public void test_textView() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);

        TextView results = (TextView) activity.findViewById(R.id.text);

        Assert.assertEquals("Hello World!", results.getText().toString());
    }
}