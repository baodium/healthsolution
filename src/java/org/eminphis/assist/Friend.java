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

    public static void main(String[] args) throws IOException{
        JavaIdentifierToSQLIdentifier jis=new JavaIdentifierToSQLIdentifier();

//        System.out.println(jis.constructSQLTableDeclaration());
//        deleteStatement(jis);
        insertStatement(jis);
//        retrieveStatement(jis);
//        updateStatement(jis);

    }

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

    private static String delimitColumnNamesWithPlaceholder(ArrayList<String> columnNames){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<columnNames.size();i++){
            if(i!=0)
                sb.append(",");
            sb.append(columnNames.get(i)).append("=?");
        }
        return sb.toString();
    }

    private static void updateStatement(JavaIdentifierToSQLIdentifier jis){
        System.out.printf("int %sIndex=Conn.getInstance().ensureInit(Statement.%s,"
                +"\"UPDATE %s SET %s WHERE %s=?\");\n",update,update.toUpperCase(),jis.
                getSqlTableName(),
                delimitColumnNamesWithPlaceholder(jis.getSqlFieldNames(firstIsPrimaryKey)),jis.
                getFirstSqlIdentifierName());
        System.out.println();

        System.out.printf("SqlStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",update,update.toUpperCase());

        for(int i=0;i<jis.getNumIdentifiers(firstIsPrimaryKey);i++)
            System.out.printf("%sStatement.set%s(%d,%s.get%s());\n",
                    update,
                    jis.getJavaWrapperTypes(firstIsPrimaryKey).get(i),
                    i+1,
                    jis.getJavaTableVariableName(),
                    jis.getJavaMethodNames(firstIsPrimaryKey).get(i)
            );
        System.out.printf("%sStatement.set%s(%d,%s.get%s());\n",
                update,
                jis.getFirstJavaWrapperType(),
                jis.getNumIdentifiers(),
                jis.getJavaTableVariableName(),
                jis.getFirstJavaMethodName()
        );

        System.out.printf("%sStatement.executeUpdate();\n",update);
        System.out.println("//Remember to call DBManager.saveChanges() after a successful atomic update");
    }

    private static void deleteStatement(JavaIdentifierToSQLIdentifier jis){
        System.out.printf("int %sIndex=Conn.getInstance().ensureInit(Statement.%s,"
                +"\"DELETE FROM %s WHERE %s=?\");\n",
                delete,
                delete.toUpperCase(),
                jis.getSqlTableName(),
                jis.getFirstSqlIdentifierName());
        System.out.println();

        System.out.printf("SqlStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",delete,delete.toUpperCase());

        System.out.printf("%sStatement.set%s(1,%s);\n",
                delete,
                jis.getFirstJavaWrapperType(),
                jis.getFirstJavaIdentifierName()
        );

        System.out.printf("%sStatement.executeUpdate();\n",delete);
        System.out.println("//Remember to call DBManager.saveChanges() after a successful atomic update");
    }

    private static void retrieveStatement(JavaIdentifierToSQLIdentifier jis){
        System.out.printf("int %sIndex=Conn.getInstance().ensureInit(Statement.%s,"
                +"\"SELECT %4$s FROM %3$s WHERE %5$s=?\");\n",retrieve,retrieve.toUpperCase(),jis.
                getSqlTableName(),
                delimitColumnNames(jis.getSqlFieldNames(firstIsPrimaryKey)),
                jis.getFirstSqlIdentifierName());
        System.out.println();

        System.out.printf("SqlStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",retrieve,retrieve.toUpperCase());
        System.out.printf("%sStatement.set%s(1,%s);\n",
                retrieve,
                jis.getFirstJavaWrapperType(),
                jis.getFirstJavaIdentifierName()
        );
        System.out.printf("ResultSet rs=%sStatement.executeQuery();\n",retrieve);
        System.out.printf("rs.next();\n");

        for(int i=0;i<jis.getNumIdentifiers(firstIsPrimaryKey);i++)
            System.out.printf("%s %s=rs.get%s(%d);\n",
                    jis.getJavaTypes(firstIsPrimaryKey).get(i),
                    jis.getJavaIdentifierNames(firstIsPrimaryKey).get(i),
                    jis.getJavaWrapperTypes(firstIsPrimaryKey).get(i),
                    i+1
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
                +"\"INSERT INTO %s (%s) VALUES (%s)\"%s);\n",
                insert,
                insert.toUpperCase(),
                jis.getSqlTableName(),
                delimitColumnNames(jis.getSqlFieldNames(firstIsPrimaryKey)),
                getPlaceholders(jis.getNumIdentifiers(firstIsPrimaryKey)),
                firstIsPrimaryKey?",true":""
        );
        System.out.println();
        System.out.printf("SqlStatement %sStatement=Conn.getInstance()"
                +".getStatement(Statement.%s,%1$sIndex);\n",insert,insert.toUpperCase());

        for(int i=0;i<jis.getNumIdentifiers(firstIsPrimaryKey);i++)
            System.out.printf("%sStatement.%s%s(%d,%s.get%s());\n",
                    insert,
                    set,
                    jis.getJavaWrapperTypes(firstIsPrimaryKey).get(i),
                    i+1,
                    jis.getJavaTableVariableName(),
                    jis.getJavaMethodNames(firstIsPrimaryKey).get(i)
            );
        System.out.println("insertStatement.executeUpdate();");

        if(firstIsPrimaryKey){
            System.out.printf("ResultSet rs=%sStatement.getGeneratedKeys();\n",insert);
            System.out.printf(
                    "rs.next();\n"
                    +"%s %s=rs.get%s(1);\n"
                    +"rs.close();\n",jis.getFirstJavaType(),jis.getFirstJavaIdentifierName(),
                    jis.getFirstJavaWrapperType());
            System.out.printf("%s.set%s(%s);\n",jis.getJavaTableVariableName(),jis.
                    getFirstJavaMethodName(),jis.getFirstJavaIdentifierName());
        }
        System.out.println("//Remember to call DBManager.saveChanges() after a successful atomic update");

    }
}
