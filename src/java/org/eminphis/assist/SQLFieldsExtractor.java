
package org.eminphis.assist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: SQLFieldsExtractor.java
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
public class SQLFieldsExtractor {

    java.util.regex.Pattern pattern;
    java.util.regex.Matcher matcher;
    private List<Declaration> declarations;
    
    String[]recognizedTypes=new String[]{
        "text",
        "varchar",
        "char",
        "int"
    };
    
    public SQLFieldsExtractor(java.io.File sqlFile) throws FileNotFoundException, IOException{
        pattern=java.util.regex.Pattern.compile(
                ""
                + "((?<=create\\s{1,50}table\\s{1,50}(if\\s{1,50}not\\s{1,50}exists\\s{1,50})?)(`?\\w+`?)(?=\\s{0,50}\\())|"
                + "((?<=[\\(,]\\s{0,50})(`?[\\w]+`?)\\s+([a-z]+))",java.util.regex.Pattern.CASE_INSENSITIVE);
        java.io.FileInputStream fis=new java.io.FileInputStream(sqlFile);
        byte[]buf=new byte[1<<15];
        StringBuilder sb=new StringBuilder();
        for(int bytesRead=fis.read(buf);bytesRead!=-1;bytesRead=fis.read(buf))
            sb.append(new String(buf,0,bytesRead));
        fis.close();
        matcher=pattern.matcher(sb.toString());
//        System.out.println("Finding matches in:\n"+sb.toString()+"\n\n");
        
        declarations=new ArrayList<Declaration>();
        String tableName=null;
        while(matcher.find()){
            if(matcher.group(1)!=null){
                tableName=matcher.group(3);
                System.out.println("Table name is "+tableName);
                continue;
            }
            final String identifier=matcher.group(3+2);
            final String type=matcher.group(3+3);

            if(isRecognizedType(type))
                declarations.add(new Declaration(type,identifier,tableName));
            else
                System.out.println("("+type+","+identifier+") was skipped.");
        }
    }

    private boolean isRecognizedType(final String type){
        for(int i=0;i<recognizedTypes.length;
                i++)
            if(type.equalsIgnoreCase(recognizedTypes[i]))
                return true;
        return false;
    }
    
    public List<Declaration> getDeclarations(){
        return declarations;
    }

    private String adjustIfNecessary(String identifier){
        return identifier.startsWith("`")||identifier.startsWith("'")?identifier.substring(
                1,identifier.length()-1):identifier;
    }
    
    public class Declaration{
        String sqlType;
        String sqlIdentifier;
        String javaType;
        String javaIdentifier;
        
        String tableName;

        public Declaration(String sqlType,String sqlIdentifier,String tableName){
            this.tableName=tableName;
            this.sqlType=sqlType;
            this.sqlIdentifier=sqlIdentifier;
            switch(this.sqlType.toLowerCase()){
                case "text":
                case "char":
                case "varchar":
                    javaType="String";break;
                case "int":
                    javaType="int";break;
                default:throw new RuntimeException("Cannot figure out the java type");
            }
            String[] split=adjustIfNecessary(sqlIdentifier).split("_");
            StringBuilder sb=new StringBuilder();
            int i=0;
            do{
                sb.append(i==0?Character.toLowerCase(split[i].charAt(0)):Character.toUpperCase(split[i].charAt(0)));
                sb.append(split[i].substring(1));
            }while(++i!=split.length);
            javaIdentifier=sb.toString();
        }
        public String toString(){
            return "("+sqlType+" "+sqlIdentifier+") <-> ("+javaType+" "+javaIdentifier+")   found in "+tableName;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException{
        SQLFieldsExtractor sqlFieldsExtractor=new SQLFieldsExtractor(new java.io.File("/home/essiennta/Downloads/healthrecord.sql"));
        List<Declaration> declarations=sqlFieldsExtractor.getDeclarations();
        for(Declaration declaration:declarations){
            System.out.println(declaration);
        }
    }
}
