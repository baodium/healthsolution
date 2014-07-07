package org.eminphis.dto;

import java.util.Iterator;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Group.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Encapsulates a list of a specified type.
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class Group<T> implements Iterable<T>{

    private final java.util.ArrayList<T> groups=new java.util.ArrayList<T>();

    /**
     * @return the number of items in the group.
     */
    public long getGroupCount(){
        return groups.size();
    }

    /**
     * Inserts a new element into the group.
     *
     * @param element the element to be inserted
     */
    public void addElement(T element){
        groups.add(element);
    }

    @Override
    public Iterator<T> iterator(){
        return groups.iterator();
    }

}
