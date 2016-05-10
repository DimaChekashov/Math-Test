package com.foxsay.mathtest;

import android.content.ContentResolver;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import com.foxsay.mathtest.provider.MathTestProvider;

import org.junit.runner.RunWith;

/**
 * @author roman
 * @since 07.05.2016
 */
@RunWith(AndroidJUnit4.class)
public class MathTestProviderTestCase extends ProviderTestCase2<MathTestProvider> {

    private static final String PROVIDER_NAME = "com.foxsay.mathtest.provider.MathTestProvider";

    private ContentResolver contentResolver;

    public MathTestProviderTestCase() {
        super(MathTestProvider.class, PROVIDER_NAME);
    }

    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        contentResolver = getMockContentResolver();
    }
}
