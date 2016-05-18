package com.foxsay.mathtest;

import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.test.ProviderTestCase2;

import com.foxsay.mathtest.model.Answer;
import com.foxsay.mathtest.model.Section;
import com.foxsay.mathtest.model.Task;
import com.foxsay.mathtest.provider.MathTestContract;
import com.foxsay.mathtest.provider.MathTestContract.Answers;
import com.foxsay.mathtest.provider.MathTestContract.Tasks;
import com.foxsay.mathtest.provider.MathTestProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roman
 * @since 07.05.2016
 */
public class MathTestProviderTestCase extends ProviderTestCase2<MathTestProvider> {

    private ContentResolver contentResolver;

    public MathTestProviderTestCase() {
        super(MathTestProvider.class, MathTestContract.CONTENT_AUTHORITY);
    }

    @Override
    public void setUp() throws Exception {
        setContext(InstrumentationRegistry.getTargetContext());
        super.setUp();
        contentResolver = getMockContentResolver();
    }

    public void testShouldCreateAndRetrieveTask(){
        createTask();
        fail();
    }

    public void testShouldCreateAndRetrieveTest(){
        fail();
    }

    private ContentProviderResult[] createTask() {
        Task task = new Task();
        task.setTaskId(1);
        task.setSection(Section.MATH);
        task.setSubSection(Section.SubSection.Geometry);
        task.setGroup(Section.Group.Cylinder);
        task.setQuestion("Пользуясь графиком, поставьте в соответствие каждой точке (обозначено буквами) характеристику функции и ее производной (обозначено цифрами).");
        task.setQuestionImg("https://ege.yandex.ru/media/ege/mathematics/4/14/task_1_ege_2016_4_bas_math_14.png");

        List<Answer> answers = new ArrayList<>();
        for (int i = 1; i <= 5; i++){
            Answer answer = new Answer();
            answer.setTaskId(task.getTaskId());
            answer.setAnswer("PossibleTaskAnswer " + i);
            answer.setCorrect(0);

            answers.add(answer);
        }
        answers.get(3).setCorrect(1); // third answer is correct


        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

        ContentValues taskValues = new ContentValues();
        taskValues.put(Tasks.TASK_ID, task.getTaskId());
        taskValues.put(Tasks.SECTION, task.getSection());
        taskValues.put(Tasks.SUB_SECTION, task.getSubSection());
        taskValues.put(Tasks.GROUP, task.getGroup());
        taskValues.put(Tasks.QUESTION, task.getQuestion());
        taskValues.put(Tasks.QUESTION_IMG, task.getQuestionImg());
        ops.add(ContentProviderOperation.newInsert(Tasks.CONTENT_URI)
                        .withValues(taskValues)
                        .withYieldAllowed(true)
                        .build());

        for (Answer answer: answers){
            ContentValues answerValues = new ContentValues();
            answerValues.put(Answers.TASK_ID, answer.getTaskId());
            answerValues.put(Answers.ANSWER, answer.getAnswer());
            answerValues.put(Answers.CORRECT, answer.getCorrect());
            ops.add(ContentProviderOperation.newInsert(Tasks.CONTENT_URI)
                    .withValues(answerValues)
                    .withYieldAllowed(true)
                    .build());
        }

        try {
            return contentResolver.applyBatch(MathTestContract.CONTENT_AUTHORITY, ops);
        } catch (RemoteException e) {
            // do s.th.
        } catch (OperationApplicationException e) {
            // do s.th.
        }

        return null;
    }
}
