package org.eminphis.exceptions;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: NoSuchColumnException.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Represents an exception that is thrown when a non-existent column is tried to be accessed.
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class NoSuchColumnException extends MINPHISException{

    private String tableName;
    private int columnIndex;

    public NoSuchColumnException(String tableName,int columnIndex){
        super("The "+tableName+" entity does not have an attribute on index "+columnIndex);
    }

    public int getColumnIndex(){
        return columnIndex;
    }

    public String getTableName(){
        return tableName;
    }
}
