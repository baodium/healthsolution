package org.eminphis.entities;

import org.eminphis.exceptions.NoSuchColumnException;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Entity.java
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
public abstract class Entity{

    /**
     * @return the name of this table.
     */
    abstract String getName();

    /**
     * Returns the name of the designated column.
     *
     * @param columnIndex the first column is 1, the second is 2, ...
     * @return the name of the column
     * @throws NoSuchColumnException
     */
    String getColumnName(int columnIndex) throws NoSuchColumnException{
        if(columnIndex==1)
            return "ID";
        throw new NoSuchColumnException(getName(),columnIndex);
    }

    /**
     * Returns the number of columns.
     *
     * @return the number of columns
     */
    int getColumnCount(){
        return 1;
    }

    /**
     * Returns the index of this table in the lexicographical ordering.
     *
     * @return the index of this table; the first index is 0, the second is 1, ...
     */
    int getIndex(){
        return -1;
    }
}
