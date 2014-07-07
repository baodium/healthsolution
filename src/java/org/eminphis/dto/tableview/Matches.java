package org.eminphis.dto.tableview;

import org.eminphis.dto.Group;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Matches.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 *
 * </pre>
 * <p>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class Matches<T extends Match> extends Group<T>{

    /**
     * @return the number of items in this list
     */
    public long getMatchCount(){
        return super.getGroupCount();
    }

    public void addMatchedResult(T match){
        super.addElement(match);
    }
}
