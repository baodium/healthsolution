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
 * Class name: RegEx.java
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
public class RegEx{

    static java.util.regex.Pattern pattern=java.util.regex.Pattern.compile(
            "((\\w+) (\\w+(<\\w+>)?)(?=;))");

    public static void main(String[] args){
        String seq="private final Group<String> phoneNumbers;";
        Matcher matcher=pattern.matcher(seq);
        System.out.println(matcher.groupCount());
//        while(matcher.find()){
//            
//        }
    }
}
