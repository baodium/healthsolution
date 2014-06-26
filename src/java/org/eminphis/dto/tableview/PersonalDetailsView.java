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

    public void addMatchedResult(String NHISNumber,String surname,String firstName,String otherName){
        results.add(new Match(NHISNumber,surname,firstName,otherName));
    }

    @Override
    public Iterator<Match> iterator(){
        return results.iterator();
    }

    /**
     * Encapsulates an item that matched the query
     */
    public static class Match{

        private String NHISNumber;
        private String surname;
        private String firstName;
        private String otherName;

        public Match(String NHISNumber,String surname,String firstName,String otherName){
            this.NHISNumber=NHISNumber;
            this.surname=surname;
            this.firstName=firstName;
            this.otherName=otherName;
        }

        public String getNHISNumber(){
            return NHISNumber;
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

        /**
         * Given the string returned by toString() of an object of
         * this type, this method retrieves the ID in the string.
         *
         * @param stringRepresentation the string returned by toString() of
         * an object of type {@link Match}
         * @return the ID
         */
        public static long retrievePatientID(String stringRepresentation){
            int indexOfRightSquareBracket=stringRepresentation.length()-1;
            int indexOfLeftSquareBracket=indexOfRightSquareBracket;
            while(--indexOfLeftSquareBracket>=0&&Character.isDigit(stringRepresentation.charAt(
                    indexOfLeftSquareBracket)));
//            assert stringRepresentation.charAt(indexOfLeftSquareBracket)=='[';
            return Integer.parseInt(stringRepresentation.substring(indexOfLeftSquareBracket+1,
                    indexOfRightSquareBracket));
        }

        @Override
        public String toString(){
            return surname+" "+firstName+" "+otherName+" ["+NHISNumber+"]";
        }
    }
}
