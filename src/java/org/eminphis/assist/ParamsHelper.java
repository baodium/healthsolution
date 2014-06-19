package org.eminphis.assist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
 * Class name: ParamsHelper.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class ParamsHelper{

    private Pattern pattern;
    private Matcher matcher;

    public ParamsHelper(java.io.File sqlFile) throws FileNotFoundException,IOException{
        pattern=java.util.regex.Pattern.compile(
                "(\\w+(?=\\{))|"
                +"(\\w+(?=;))|"
                +"(\\w+\\..*\"(\\w+)\".*)");

        java.io.FileInputStream fis=new java.io.FileInputStream(sqlFile);
        byte[] buf=new byte[1<<15];
        StringBuilder sb=new StringBuilder();
        for(int bytesRead=fis.read(buf);bytesRead!=-1;bytesRead=fis.read(buf))
            sb.append(new String(buf,0,bytesRead));
        fis.close();
        matcher=pattern.matcher(sb.toString());

        matcher.find();
        String tableName=matcher.group();

        ArrayList<String> methodNames=new ArrayList<String>();
        int i=0;
        while(matcher.find()){
            if(matcher.group(2)!=null){
                String methodName=matcher.group(2);
                methodName=Character.toUpperCase(methodName.charAt(0))+methodName.substring(1);
                methodNames.add(methodName);
            }
            else if(matcher.group(4)!=null){
                System.out.println("request.setAttribute(\""+matcher.group(4)+"\",patient.get"+tableName+"().get"+methodNames.get(i)+"());");
                i++;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        ParamsHelper paramsHelper=new ParamsHelper(new java.io.File("/home/essiennta/NetBeansProjects/HIS/src/java/org/eminphis/assist/RegexFile"));
    }
}
