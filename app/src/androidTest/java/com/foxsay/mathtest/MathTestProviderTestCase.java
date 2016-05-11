package com.foxsay.mathtest;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ProviderTestCase2;

import com.foxsay.mathtest.provider.MathTestContract.*;
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

    private Uri createTask(long creationTime) {
        ContentValues values = new ContentValues();
        values.put(Notes.CREATED_DATE, creationTime);
        values.put(Tasks.SECTION, "Mathematics");
        values.put(Tasks.SUB_SECTION, "Geometry");
        values.put(Tasks.GROUP, "Cylinder");
        values.put(Tasks.QUESTION_IMG, "https://ege.yandex.ru/media/ege/mathematics/4/14/task_1_ege_2016_4_bas_math_14.png");
        values.put(Tasks.QUESTION, "Пользуясь графиком, поставьте в соответствие каждой точке (обозначено буквами) характеристику функции и ее производной (обозначено цифрами).");
        return contentResolver.insert(Tasks.CONTENT_URI, values);
    }
}
