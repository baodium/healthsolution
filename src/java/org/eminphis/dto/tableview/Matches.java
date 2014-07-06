package org.eminphis.dto.tableview;

import java.util.ArrayList;
import java.util.Iterator;

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
public class Matches<M extends Match> implements Iterable<M>{

    private final ArrayList<M> results=new ArrayList<M>();

    /**
     * @return the number of items in this list
     */
    public long getMatchCount(){
        return results.size();
    }

    public void addMatchedResult(M match){
        results.add(match);
    }

    @Override
    public Iterator<M> iterator(){
        return results.iterator();
    }
}
