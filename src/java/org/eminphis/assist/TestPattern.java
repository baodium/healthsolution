package org.eminphis.assist;

import java.util.regex.Matcher;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: TestPattern.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class TestPattern{

    private static final java.util.regex.Pattern pattern=java.util.regex.Pattern.compile(
            ".+\\[NHIS ID:(\\d+), Hospital ID:(\\d+)\\]");

    public static void main(String[] args){
        final Matcher matcher=pattern.matcher("ADEBAKIN SODUNKE OGUNTOYE [NHIS ID:94067, Hospital ID:3971]");
        System.out.println(matcher.matches());
        System.out.println(matcher.group());
        System.out.println(matcher.group(1));
        System.out.println(matcher.group(2));
    }
}
