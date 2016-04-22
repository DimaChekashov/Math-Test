package com.foxsay.mathtest.provider;

import android.provider.BaseColumns;

/**
 * @author roman
 * @since 17.04.2016
 */
public class MyContract {
    //TODO: прописать атрибуты таблиц из документации

    public interface Tables {
        String TASKS = "tasks";
        String TASK_ANSWERS = "task_answers";
        String POSSIBLE_TASK_ANSWERS = "possible_task_answers";
        String TESTS = "tests";
        String TEST_TASK_ANSWERS = "test_task_answers";
    }

    public interface TaskColumns {
        String _ID = BaseColumns._ID;
        String SECTION = "section";
        String SUB_SECTION = "sub_section";
        String GROUP = "group";
        String QUESTION_IMG = "question_img";
        String QUESTION = "question";
        String QUESTION_VIEW_TYPE = "question_view_type";
        String ONE_ANSWER = "one_answer";
    }

    public interface TaskAnswerColumns {
        String TASK_ID = "task_id";
        String ANSWER = "answer";
    }
    public interface PossibleTaskAnswersColumns {
        String TASK_ID = "task_id";
        String ANSWER = "answer";
    }
    public interface TestColumns {
        String _ID = BaseColumns._ID;
        String DATE = "date";
        String TIME = "time";
        String GRADE = "grade";
    }
    public interface TestTaskAnswersColumns {
        String TEST_ID = "test_id";
        String TASK_ID = "task_id";
        String ANSWER = "answer";
    }
}
