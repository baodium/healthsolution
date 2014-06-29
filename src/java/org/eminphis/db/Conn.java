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

    private final ArrayList<CustomStatement> statements[];

    private Conn(){
        statements=new ArrayList[4];
        for(int i=0;i<4;i++)
            statements[i]=new java.util.ArrayList<CustomStatement>();
    }

    void closeAllStatements(){

        //close delete statements
        for(CustomStatement customStatement:statements[Statement.DELETE.ordinal()])
            try{
                customStatement.close();
            }catch(SQLException ex){
                ErrorLogger.logError(ex);
            }

        //close insert statements
        for(CustomStatement customStatement:statements[Statement.INSERT.ordinal()])
            try{
                customStatement.close();
            }catch(SQLException ex){
                ErrorLogger.logError(ex);
            }

        //close retrieve statements
        for(CustomStatement customStatement:statements[Statement.RETRIEVE.ordinal()])
            try{
                customStatement.close();
            }catch(SQLException ex){
                ErrorLogger.logError(ex);
            }

        //close update statements
        for(CustomStatement customStatement:statements[Statement.UPDATE.ordinal()])
            try{
                customStatement.close();
            }catch(SQLException ex){
                ErrorLogger.logError(ex);
            }
    }

    static Conn getInstance(){
        return instance==null?new Conn():instance;
    }

    private int indexOfStatement(Statement type,String sqlStatement){
        for(int i=statements[type.ordinal()].size()-1;i>=0;i--)
            if(statements[type.ordinal()].get(i).getStatement()==sqlStatement)
                return i;
        return -1;
    }

    /**
     * Ensures that the specified {@code sqlStatement} argument is present under the
     * category of type {@code type}.
     * If the statement wasn't already present under the list for its category, it is created
     * and added to the list.
     *
     * @param type the type of statement
     * @param sqlStatement the SQL Statement
     * @return the index of this statement in its category.
     * @throws SQLException
     */
    int ensureInit(Statement type,String sqlStatement) throws SQLException{
        //Check if this statement is already present in the 'type' category.
        //If it's not there, return -1. Otherwise, return its index in the category.
        int index=indexOfStatement(type,sqlStatement);
        if(index==-1){
            //The statement wasn't present, add it.
            index=statements[type.ordinal()].size();
            statements[type.ordinal()].add(new CustomStatement(sqlStatement));
        }
        return index;
    }

    /**
     * Returns the statement of type {@code type} under the specified {@code index}
     *
     * @param type one of {@link Statement#DELETE}, {@link Statement#INSERT},
     * {@link Statement#RETRIEVE}, {@link Statement#UPDATE}
     * @param index the index of the statement to be retrieved
     * @return statement
     */
    CustomStatement getStatement(Statement type,int index){
        return statements[type.ordinal()].get(index);
    }
}
