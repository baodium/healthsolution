package org.eminphis.assist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class JavaIdentifierToSQLIdentifier{

    private final Pattern pattern;
    private final Matcher matcher;

    private HashMap<String,String> map=new HashMap<String,String>(){
        {//JAVA to SQL type mappings
            put("String","TEXT");
            put("long","BIGINT");
            put("int","INT");
        }
    };

    private final String javaTableClassName;
    private final String javaTableVariableName;
    private final String sqlTableName;
    private ArrayList<String> javaIdentifierNames=new ArrayList<String>();
    private ArrayList<String> sqlFieldNames=new ArrayList<String>();
    private ArrayList<String> javaMethodNames=new ArrayList<String>();
    private ArrayList<String> javaTypes=new ArrayList<String>();
    private ArrayList<String> sqlTypes=new ArrayList<String>();
    private ArrayList<String> javaWrapperTypes=new ArrayList<String>();
    private final int numIdentifiers;

    public JavaIdentifierToSQLIdentifier() throws FileNotFoundException,
            IOException{
        java.io.File declarationsFile=new java.io.File(
                "/home/essiennta/NetBeansProjects/HIS/src/java/org/eminphis/assist/JavaDeclarationsFile");
        pattern=java.util.regex.Pattern.compile(
                "(\\w+(?=\\{))|"
                +"((\\w+) (\\w+)(?=;))");
        java.io.FileInputStream fis=new java.io.FileInputStream(declarationsFile);
        byte[] buf=new byte[1<<15];
        StringBuilder sb=new StringBuilder();
        for(int bytesRead=fis.read(buf);bytesRead!=-1;bytesRead=fis.read(buf))
            sb.append(new String(buf,0,bytesRead));
        fis.close();
        matcher=pattern.matcher(sb.toString());

        sb.delete(0,sb.length());
        matcher.find();
        this.javaTableClassName=matcher.group();
        this.javaTableVariableName=Character.toLowerCase(this.javaTableClassName.charAt(0))
                +this.javaTableClassName.substring(1);
        for(int i=0;i<javaTableClassName.length();i++){
            char ch=javaTableClassName.charAt(i);
            if(Character.isUpperCase(ch))
                if(i!=0)
                    sb.append("_");
            sb.append(ch);
        }
        sb.append("_");
        this.sqlTableName=sb.toString();

        while(matcher.find()){
            final String javaType=matcher.group(3);
            this.javaTypes.add(javaType);
            this.javaWrapperTypes.add(Character.toUpperCase(javaType.charAt(0))+javaType.substring(
                    1));
            this.sqlTypes.add(map.get(javaType));

            final String javaIdentifier=matcher.group(4);
            sb.delete(0,sb.length());
            this.javaIdentifierNames.add(javaIdentifier);

            this.javaMethodNames.
                    add(Character.toUpperCase(javaIdentifier.charAt(0))+javaIdentifier.substring(1));

            int i=0;
            do{
                final char theCharacter=javaIdentifier.charAt(i);
                if(Character.isUpperCase(theCharacter))
                    if(i!=0)
                        sb.append("_");
                sb.append(Character.toLowerCase(theCharacter));
            } while(++i<javaIdentifier.length());
            sb.append("_");
            this.sqlFieldNames.add(sb.toString());
        }
        numIdentifiers=javaIdentifierNames.size();
    }

    public String constructSQLTableDeclaration(){
        StringBuilder sb=new StringBuilder();
        sb.append("DROP TABLE IF EXISTS ").append(sqlTableName).append(";\n");
        sb.append("CREATE TABLE ").append(sqlTableName).append("(\n");
        for(int i=0;i<sqlFieldNames.size();i++)
            sb.append(sqlFieldNames.get(i)).append(" ").append(sqlTypes.get(i)).append(",\n");
        if(!sqlFieldNames.isEmpty())
            sb.deleteCharAt(sb.length()-2);
        sb.append(");");
        return sb.toString();
    }

    public int getNumIdentifiers(){
        return numIdentifiers;
    }

    public int getNumIdentifiers(boolean excludeFirst){
        if(excludeFirst)
            return numIdentifiers-1;
        return numIdentifiers;
    }

    public String getJavaTableClassName(){
        return javaTableClassName;
    }

    public String getJavaTableVariableName(){
        return javaTableVariableName;
    }

    public String getSqlTableName(){
        return sqlTableName;
    }

    public ArrayList<String> getJavaFieldNames(){
        return javaIdentifierNames;
    }

    public ArrayList<String> getSqlFieldNames(){
        return sqlFieldNames;
    }

    public ArrayList<String> getJavaMethodNames(){
        return javaMethodNames;
    }

    public ArrayList<String> getJavaTypes(){
        return javaTypes;
    }

    public ArrayList<String> getSqlTypes(){
        return sqlTypes;
    }

    public ArrayList<String> getJavaWrapperTypes(){
        return javaWrapperTypes;
    }

    public ArrayList<String> getJavaFieldNames(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<javaIdentifierNames.size();i++)
                list.add(javaIdentifierNames.get(i));
        else
            list=javaIdentifierNames;
        return list;
    }

    public ArrayList<String> getSqlFieldNames(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<sqlFieldNames.size();i++)
                list.add(sqlFieldNames.get(i));
        else
            list=sqlFieldNames;
        return list;
    }

    public ArrayList<String> getJavaMethodNames(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<javaMethodNames.size();i++)
                list.add(javaMethodNames.get(i));
        else
            list=javaMethodNames;
        return list;
    }

    public ArrayList<String> getJavaTypes(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<javaTypes.size();i++)
                list.add(javaTypes.get(i));
        else
            list=javaTypes;
        return list;
    }

    public ArrayList<String> getSqlTypes(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<sqlTypes.size();i++)
                list.add(sqlTypes.get(i));
        else
            list=sqlTypes;
        return list;
    }

    public ArrayList<String> getJavaWrapperTypes(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<javaWrapperTypes.size();i++)
                list.add(javaWrapperTypes.get(i));
        else
            list=javaWrapperTypes;
        return list;
    }

    public ArrayList<String> getJavaIdentifierNames(boolean excludeFirst){
        ArrayList<String> list=new ArrayList<String>();
        if(excludeFirst)
            for(int i=1;i<javaIdentifierNames.size();i++)
                list.add(javaIdentifierNames.get(i));
        else
            list=javaIdentifierNames;
        return list;
    }

    public String getFirstJavaIdentifierName(){
        return javaIdentifierNames.get(0);
    }

    public String getFirstSqlIdentifierName(){
        return sqlFieldNames.get(0);
    }

    public String getFirstJavaMethodName(){
        return javaMethodNames.get(0);
    }

    public String getFirstJavaType(){
        return javaTypes.get(0);
    }

    public String getFirstJavaWrapperType(){
        return javaWrapperTypes.get(0);
    }
}
