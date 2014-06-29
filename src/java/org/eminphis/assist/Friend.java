package org.eminphis.assist;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Friend.java
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
public class Friend{

    static String insert="insert";
    static String delete="delete";
    static String update="update";
    static String retrieve="retrieve";

    static String set="set";
    static String get="get";

    private static boolean firstIsPrimaryKey=true;

    private static String getPlaceholders(int n){
        StringBuilder sb=new StringBuilder(n*2);
        for(int i=0;i<n;i++){
            if(i!=0)
                sb.append(',');
            sb.append('?');
        }
        return sb.toString();
    }

    private static String delimitColumnNames(ArrayList<String> columnNames){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<columnNames.size();i++){
            if(i!=0)
                sb.append(",");
            sb.append(columnNames.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException{
        JavaIdentifierToSQLIdentifier jis=new JavaIdentifierToSQLIdentifier();

        System.out.println(jis.constructSQLTableDeclaration());
//        retrieveStatement(jis);
//        insertStatement(jis);
        
    }

    private static void retrieveStatement(JavaIdentifierToSQLIdentifier jis){
        System.out.printf("int %sIndex=Conn.getInstance().ensureInit(Statement.%s,"
                +"\"SELECT %4$s FROM %3$s WHERE %5$s=?\");\n",retrieve,retrieve.toUpperCase(),jis.
                getSqlTableName(),
                delimitColumnNames(jis.getSqlFieldNames(firstIsPrimaryKey)),jis.
                getFirstJavaIdentifierName());

        System.out.printf("CustomStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",retrieve,retrieve.toUpperCase());
        System.out.printf("ResultSet rs=%sStatement.executeQuery();\n",retrieve);
        System.out.println("int columnIndex=1;");

        for(int i=0;i<jis.getNumIdentifiers(firstIsPrimaryKey);i++)
            System.out.printf("%s %s=rs.get%s(columnIndex++);\n",
                    jis.getJavaTypes(firstIsPrimaryKey).get(i),
                    jis.getJavaIdentifierNames(firstIsPrimaryKey).get(i),
                    jis.getJavaBoxedTypes(firstIsPrimaryKey).get(i)
            );
        
        System.out.println("rs.close();");

        System.out.printf("%s %s=new %1$s(%s);\n",
                jis.getJavaTableClassName(),
                jis.getJavaTableVariableName(),
                delimitColumnNames(jis.getJavaIdentifierNames(firstIsPrimaryKey))
        );

        System.out.printf("%s.set%s(%s);\n",
                jis.getJavaTableVariableName(),
                jis.getFirstJavaMethodName(),
                jis.getFirstJavaIdentifierName()
        );

        System.out.printf("return %s;\n",
                jis.getJavaTableVariableName()
        );
    }

    private static void insertStatement(JavaIdentifierToSQLIdentifier jis){
        System.out.printf("int %sIndex=Conn.getInstance().ensureInit(Statement.%s,"
                +"\"INSERT INTO %s (%s) VALUES (%s)\");\n",insert,insert.toUpperCase(),jis.
                getSqlTableName(),
                delimitColumnNames(jis.getSqlFieldNames(firstIsPrimaryKey)),getPlaceholders(jis.
                        getNumIdentifiers(firstIsPrimaryKey)));
        System.out.println();
        System.out.printf("CustomStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",insert,insert.toUpperCase());
        System.out.println("int columnIndex=1;");

        for(int i=0;i<jis.getNumIdentifiers(firstIsPrimaryKey);i++)
            System.out.printf("%sStatement.%s%s(columnIndex++,%s.get%s());\n",insert,set,jis.
                    getJavaBoxedTypes(firstIsPrimaryKey).get(i),jis.getJavaTableVariableName(),jis.
                    getJavaMethodNames(firstIsPrimaryKey).get(
                            i));
        System.out.println("insertStatement.executeUpdate();");

        if(firstIsPrimaryKey){
            System.out.printf("ResultSet rs=%sStatement.getGeneratedKeys();\n",insert);
            System.out.printf(
                    "rs.next();\n"
                    +"%s %s=rs.get%s(1);\n"
                    +"rs.close();\n",jis.getFirstJavaType(),jis.getFirstJavaIdentifierName(),
                    jis.getFirstJavaBoxedType());
            System.out.printf("%s.set%s(%s);\n",jis.getJavaTableVariableName(),jis.
                    getFirstJavaMethodName(),jis.getFirstJavaIdentifierName());
        }

    }
}
