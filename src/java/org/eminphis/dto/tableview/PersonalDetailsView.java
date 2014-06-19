package org.eminphis.dto.tableview;

import java.util.ArrayList;
import java.util.Iterator;
import org.eminphis.dto.tableview.PersonalDetailsView.Match;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: PersonalDetailsView.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 *
 * <u>Description</u>
 * Represents a vertical view of the Patient's table. Created to hold patient's ID number and
 * their full names.
 *
 *
 * </pre>
 *
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class PersonalDetailsView implements Iterable<Match>{

    private final ArrayList<Match> results;

    public PersonalDetailsView(){
        results=new ArrayList<Match>();
    }

    /**
     * @return the number of items in this list
     */
    public long getMatchCount(){
        return results.size();
    }

    public void addMatchedResult(long ID,String surname,String firstName,String otherName){
        results.add(new Match(ID,surname,firstName,otherName));
    }

    @Override
    public Iterator<Match> iterator(){
        return results.iterator();
    }

    public static class Match{

        private long ID;
        private String surname;
        private String firstName;
        private String otherName;

        public Match(long ID,String surname,String firstName,String otherName){
            this.ID=ID;
            this.surname=surname;
            this.firstName=firstName;
            this.otherName=otherName;
        }

        public long getID(){
            return ID;
        }

        public String getFirstName(){
            return firstName;
        }

        public String getOtherName(){
            return otherName;
        }

        public String getSurname(){
            return surname;
        }

        @Override
        public String toString(){
            return surname+" "+firstName+" "+otherName+" ["+ID+"]";
        }
        
    }
}
