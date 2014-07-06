package org.eminphis.db;

import java.sql.SQLException;
import java.util.ArrayList;
import org.eminphis.ErrorLogger;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Conn.java
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
class Conn{

    private static Conn instance;
    private final int STATEMENTS_COUNT=4;

    private ArrayList<SqlStatement> statements[];

    private Conn(){
        initStatements();
    }

    static Conn getInstance(){
        if(instance==null)
            instance=new Conn();
        return instance;
    }

    private void initStatements(){
        statements=new ArrayList[STATEMENTS_COUNT];
        for(int i=0;i<STATEMENTS_COUNT;i++)
            statements[i]=new java.util.ArrayList<SqlStatement>();
    }

    void closeResources(){

        //close delete statements
        for(SqlStatement sqlStatement:statements[Statement.DELETE.ordinal()])
            try{
                sqlStatement.close();
            } catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
        statements[Statement.DELETE.ordinal()]=null;

        //close insert statements
        for(SqlStatement sqlStatement:statements[Statement.INSERT.ordinal()])
            try{
                sqlStatement.close();
            } catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
        statements[Statement.INSERT.ordinal()]=null;

        //close retrieve statements
        for(SqlStatement sqlStatement:statements[Statement.RETRIEVE.ordinal()])
            try{
                sqlStatement.close();
            } catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
        statements[Statement.RETRIEVE.ordinal()]=null;

        //close update statements
        for(SqlStatement sqlStatement:statements[Statement.UPDATE.ordinal()])
            try{
                sqlStatement.close();
            } catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
        statements[Statement.UPDATE.ordinal()]=null;

        statements=null;
    }

    private int indexOfStatement(Statement type,String sqlStatement){
        for(int i=statements[type.ordinal()].size()-1;i>=0;i--)
            if(statements[type.ordinal()].get(i).getStatement()==sqlStatement)
                return i;
        return -1;
    }

    /**
     * Ensures that the specified {@code sqlStatement} argument is present under the category of type {@code type}. If
     * the statement wasn't already present under the list for its category, it is created and added to the list.
     *
     * @param type                the type of statement
     * @param sqlStatement        the SQL Statement
     * @param returnGeneratedKeys flag that indicates whether any generated keys as a result of this operation should be
     *                            returned
     * @return the index of this statement in its category.
     * @throws SQLException
     */
    int ensureInit(Statement type,String sqlStatement,boolean returnGeneratedKeys) throws SQLException{
        //Check if this statement is already present in the 'type' category.
        //If it's not there, return -1. Otherwise, return its index in the category.
        int index=indexOfStatement(type,sqlStatement);
        if(index==-1){
            //The statement wasn't present, add it.
            index=statements[type.ordinal()].size();
            statements[type.ordinal()].add(new SqlStatement(sqlStatement,returnGeneratedKeys));
        }
        return index;
    }

    /**
     * Ensures that the specified {@code sqlStatement} argument is present under the category of type {@code type}. If
     * the statement wasn't already present under the list for its category, it is created and added to the list.
     *
     * @param type         the type of statement
     * @param sqlStatement the SQL Statement
     * @return the index of this statement in its category.
     * @throws SQLException
     */
    int ensureInit(Statement type,String sqlStatement) throws SQLException{
        return ensureInit(type,sqlStatement,false);
    }

    /**
     * Returns the statement of type {@code type} under the specified {@code index}
     *
     * @param type  one of {@link Statement#DELETE}, {@link Statement#INSERT},
     * {@link Statement#RETRIEVE}, {@link Statement#UPDATE}
     * @param index the index of the statement to be retrieved
     * @return statement
     */
    SqlStatement getStatement(Statement type,int index){
        return statements[type.ordinal()].get(index);
    }
}
