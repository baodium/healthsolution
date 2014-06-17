
package org.eminphis.assist;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 * 
 * 
 * <pre>
 * Class name: PatientConnHelper.java
 * Version: 1.0
 * Author: Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * 
 * <u>Description</u>
 * 
 * 
 * </pre>
 * @author Essiennta Emmanuel (colourfulemmanuel@gmail.com)
 * @version 1.0
 */
public class PatientConnHelper {
    private static String[]tableNames={
        "Diagnosis",
        "HospitalHistory",
        "NHISInformation",
        "NextOfKin",
        "Operations",
        "OtherInformation",
        "PersonalDetails"};
    
    
    public static void p(String format,Object... args){
        System.out.printf(format+"\n",args);
    }
    public static void main(String[] args){
        for(int i=0;i<tableNames.length;i++){
            p("","");
p("        //generate the sequence of column names for the %s table",tableNames[i]);
p("        sb.append(' ');","");
p("        for(int i=startIndex;i<=%s.getInstance().getColumnCount();i++){",tableNames[i]);
p("            if(i!=startIndex)","");
p("                sb.append(',');","");
p("            sb.append(%s.getInstance().getColumnName(i));",tableNames[i]);
p("            sb.append(\"=?\");","");
p("        }","");
p("        sb.append(' ');","");
p("        update[%s.getInstance().getIndex()]=getDBConnection().prepareStatement(\"UPDATE \"+%s.getInstance().getIndex()+\" SET\"+sb.toString()+\"WHERE ID=?\");",tableNames[i],tableNames[i]);
p("        sb.delete(0,sb.length());","");
        }
    }

    private static void ensureInsertStatementsWithIDsExcludingPersonalDetails(int i){
        p("","");
p("        //generate the sequence of column names and placeholders for the Diagnosis table","");
p("        sb.append('(');","");
p("        placeHolders.append('(');","");
p("        for(int i=startIndex;i<=%s.getInstance().getColumnCount();i++){",tableNames[i]);
p("            if(i!=startIndex){","");
p("                sb.append(',');","");
p("                placeHolders.append(',');","");
p("            }","");
p("            sb.append(%s.getInstance().getColumnName(i));",tableNames[i]);
p("            placeHolders.append('?');","");
p("        }","");
p("        sb.append(')');","");
p("        placeHolders.append(')');","");
p("        insertInto[%s.getInstance().getIndex()]=getDBConnection().prepareStatement(\"INSERT INTO \"",tableNames[i]);
p("                +%s.getInstance().getName()+sb.toString()+\"VALUES\"+placeHolders.toString());",tableNames[i]);
p("        sb.delete(0,sb.length());","");
p("        placeHolders.delete(0,placeHolders.length());","");
    }

    private static void deletePatient(int i){
        p("","");
p("        deleteFrom[%s.getInstance().getIndex()].setInt(1,patientID);",tableNames[i]);
p("        deleteFrom[%s.getInstance().getIndex()].executeUpdate();",tableNames[i]);
    }

    private static void ensureSelectStatements(int i){
        p("","");
        p("        //generate the sequence of column names for the %s table",tableNames[i]);
        p("        sb.append(' ');","");
        p("        int startIndex=2;//Starting at column 2 effectively skips the ID column.","");
        p("        for(int i=startIndex;i<=%s.getInstance().getColumnCount();i++){",tableNames[i]);
        p("            if(i!=startIndex)","");
        p("                sb.append(',');","");
        p("            sb.append(%s.getInstance().getColumnName(i));",tableNames[i]);
        p("        }","");
        p("        sb.append(' ');","");
        p("        selectFrom[%s.getInstance().getIndex()]=getDBConnection().prepareStatement(\"SELECT\"",tableNames[i]);
        p("                +sb.toString()+\"FROM \"+%s.getInstance().getName()+\" WHERE ID=?\");",tableNames[i]);
        p("        sb.delete(0,sb.length());","");
    }
}
