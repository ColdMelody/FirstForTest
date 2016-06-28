package AnnotationDemo;

import java.lang.annotation.Documented;

/**
 * Created by Bill on 2016/5/4.
 */
@Documented
@interface ClassPreablem {
    String date();
    String author();
    int currentversion() default 1;
    String lastModifided() default "N/A";
    String[] reviewers();
}
