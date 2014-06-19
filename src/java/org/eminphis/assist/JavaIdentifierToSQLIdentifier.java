
package org.eminphis.assist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: JavaIdentifierToSQLIdentifier.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * 
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class JavaIdentifierToSQLIdentifier {
    private final Pattern pattern;
    private final Matcher matcher;

    public JavaIdentifierToSQLIdentifier(java.io.File sqlFile) throws FileNotFoundException, IOException{
        pattern=java.util.regex.Pattern.compile(
                "(\\w+(?=\\{))|"
                + "(\\w+(?=;))");
        java.io.FileInputStream fis=new java.io.FileInputStream(sqlFile);
        byte[]buf=new byte[1<<15];
        StringBuilder sb=new StringBuilder();
        for(int bytesRead=fis.read(buf);bytesRead!=-1;bytesRead=fis.read(buf))
            sb.append(new String(buf,0,bytesRead));
        fis.close();
        matcher=pattern.matcher(sb.toString());
        
        sb.delete(0,sb.length());
        matcher.find();
        String tableName=matcher.group();
        for(int i=0;i<tableName.length();i++){
            char ch=tableName.charAt(i);
            if(Character.isUpperCase(ch))
                if(i!=0)
                    sb.append("_");
            sb.append(ch);
        }
        sb.append("_");
        tableName=sb.toString();
        sb.delete(0,sb.length());
        
        StringBuilder mainSB=new StringBuilder();
        mainSB.append("DROP TABLE IF EXISTS "+tableName+";\n");
        mainSB.append("CREATE TABLE "+tableName+" (\n");
        mainSB.append("ID BIGINT NOT NULL PRIMARY KEY,");
        while(matcher.find()){
            mainSB.append("\n");
            sb.delete(0,sb.length());
            final String capturedGroup=matcher.group();
//            System.out.println("found "+capturedGroup);
            int i=0;
            do{
                final char theCharacter=capturedGroup.charAt(i);
                if(Character.isUpperCase(theCharacter))
                    if(i!=0)
                    sb.append("_");
                sb.append(Character.toLowerCase(theCharacter));
            }while(++i<capturedGroup.length());
            sb.append("_ TEXT,");
//            System.out.println(sb.toString());
            mainSB.append(sb);
        }
        mainSB.deleteCharAt(mainSB.length()-1);
        mainSB.append(");");
        System.out.println(mainSB.toString());
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        JavaIdentifierToSQLIdentifier javaIdentifierToSQLIdentifier=new JavaIdentifierToSQLIdentifier(new java.io.File("/home/essiennta/NetBeansProjects/HIS/src/java/org/eminphis/assist/JavaDeclarationsFile"));
    }

}
