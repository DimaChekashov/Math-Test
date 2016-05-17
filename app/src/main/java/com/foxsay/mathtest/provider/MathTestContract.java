package com.foxsay.mathtest.provider;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author roman
 * @since 17.04.2016
 */
public class MathTestContract {
    //TODO: прописать атрибуты таблиц из документации

    public interface Tables {
        String TASKS = "tasks";
        String ANSWERS = "answers";
        String TESTS = "tests";
        String TEST_TASK_ANSWERS = "test_task_answers";
    }

    public interface TaskColumns {
        String TASK_ID = "taskId"; // unique id in server
        String SECTION = "section";
        String SUB_SECTION = "sub_section";
        String GROUP = "group";
        String QUESTION_IMG = "question_img";
        String QUESTION = "question";
        String QUESTION_VIEW_TYPE = "question_view_type";
        String ONE_ANSWER = "one_answer";
    }

    public interface AnswerColumns {
        String TASK_ID = "task_id";
        String ANSWER = "answer";
        String CORRECT = "correct";
    }
    public interface TestColumns {
        String TEST_ID = "testId"; // unique id in server
        String DATE = "date";
        String TIME = "time";
        String GRADE = "grade";
    }
    public interface TestTaskAnswersColumns {
        String TEST_ID = "test_id";
        String TASK_ID = "task_id";
        String ANSWER = "answer";
    }

    // the symbolic name of the entire provider (its authority)
    public static final String CONTENT_AUTHORITY = "com.foxsay.mathtest";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private static final String PATH_TASKS = "tasks";

    public static class Tasks implements TaskColumns, BaseColumns {
        public static final String BLOCK_TYPE_FREE = "free";
        public static final String BLOCK_TYPE_BREAK = "break";
        public static final String BLOCK_TYPE_KEYNOTE = "keynote";

        public static final boolean isValidBlockType(String type) {
            return BLOCK_TYPE_FREE.equals(type) ||  BLOCK_TYPE_BREAK.equals(type)
                    || BLOCK_TYPE_KEYNOTE.equals(type);
        }

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_TASKS).build();

        public static final String CONTENT_TYPE =
                "vnd.android.cursor.dir/vnd.com.foxsay.mathtest.task";
        public static final String CONTENT_ITEM_TYPE =
                "vnd.android.cursor.item/vnd.com.foxsay.mathtest.task";

        /** "ORDER BY" clauses. */
//        public static final String DEFAULT_SORT = BlocksColumns.BLOCK_START + " ASC, "
//                + BlocksColumns.BLOCK_END + " ASC";

        /** Build {@link Uri} for requested {@link #_ID}. */
        public static Uri buildUri(String taskId) {
            return CONTENT_URI.buildUpon().appendPath(taskId).build();
        }

        /** Read {@link #_ID} from {@link Tasks} {@link Uri}. */
        public static String getId(Uri uri) {
            return uri.getPathSegments().get(1);
        }

//        /**
//         * Generate a {@link #BLOCK_ID} that will always match the requested
//         * {@link Blocks} details.
//         * @param startTime the block start time, in milliseconds since Epoch UTC
//         * @param endTime the block end time, in milliseconds since Epoch UTF
//         */
//        public static String generateBlockId(long startTime, long endTime) {
//            startTime /= DateUtils.SECOND_IN_MILLIS;
//            endTime /= DateUtils.SECOND_IN_MILLIS;
//            return ParserUtils.sanitizeId(startTime + "-" + endTime);
//        }
    }

    public static class Answers implements AnswerColumns {

    }
}
