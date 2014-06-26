package org.eminphis.assist;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import org.eminphis.db.DBManager;
import org.eminphis.dto.*;
import org.eminphis.dto.tableview.PersonalDetailsView;
import org.eminphis.exceptions.NoSuchColumnException;
import org.eminphis.exceptions.NoSuchPatientIDException;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Generator.java
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
public class Generator{

    private static java.util.Random random=new java.util.Random(35);
    private static java.util.ArrayList<FullName> fullNamesList=new ArrayList<FullName>();

    private static void insertPatients() throws NoSuchColumnException,SQLException{
        /*
         * Connect to database
         * tables
         * update tables
         */
        int i=1;
        for(FullName fullName:fullNamesList){
            Diagnosis diagnosis=new Diagnosis(randomString(),randomString(),randomString(),
                    randomString());
            HospitalHistory hospitalHistory=new HospitalHistory(randomString(),randomString(),
                    randomString(),randomString(),randomString(),randomString());
            NHISInformation nHISInformation=new NHISInformation(randomString()+i++,randomString(),
                    randomString(),randomString(),randomString(),randomString(),randomString(),
                    randomString(),randomString());
            NextOfKin nextOfKin=new NextOfKin(randomString(),randomString(),randomString(),
                    randomString(),randomString(),randomString(),randomString(),randomString(),
                    randomString(),randomString());
            Operations operations=new Operations(randomString(),randomString(),randomString(),
                    randomString());
            OtherInformation otherInformation=new OtherInformation(randomString(),randomString());

            PersonalDetails personalDetails=new PersonalDetails(fullName.lastName,fullName.firstName,
                    fullName.middleName,randomString(),randomString(),randomString(),randomString(),
                    randomString(),randomString(),randomString(),randomString());

            Patient patient=new Patient(diagnosis,hospitalHistory,nHISInformation,nextOfKin,
                    operations,otherInformation,personalDetails);

            DBManager.insertPatient(patient);
        }
    }

    private static String randomString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<30;i++)
            sb.append((char)('a'+random.nextInt(26)));
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException,SQLException,
            NoSuchColumnException, NoSuchPatientIDException{
                File file=new File("/home/essiennta/FinalYearProject/src/finalyearproject/","UniqueNames.txt");
                Scanner sc=new Scanner(file);
                List<String>uniqueNames=new ArrayList<String>();
                for(String uniqueName=sc.nextLine();sc.hasNextLine();uniqueName=sc.nextLine()){
                    uniqueNames.add(uniqueName);
                }
                sc.close();
                generate(uniqueNames);
        //                DBManager.deletePatient(44);
//        DBManager.initialize();
//        PersonalDetailsView retrievePersonalDetailsView=
//                DBManager.retrievePersonalDetailsView("adeb");
//        System.out.println("retrieval done");
//        for(PersonalDetailsView.Match match:retrievePersonalDetailsView){
//            System.out.println(match.getID()+" "+match.getSurname()+" "+match.getFirstName()+" "+match.getOtherName());
//        }
//        String format="NHIS/";
//        for(int i=1;i<=4000;i++){
//                    Patient patient=DBManager.retrievePatient(i);
//                    patient.getNHISInformation().setNHISNumber(format+i);
//                    DBManager.updatePatient(patient);
//        }
//                insertPatients();
                
//        Patient patient=DBManager.retrievePatient(41);
//        patient.getNHISInformation().setEmployer("Emmanuel");
//        DBManager.updatePatient(patient);
//        
//        DBManager.closeDatabaseResources();
        
        //        System.out.println(fullNamesList.size()+" patients inserted.");
    }

    private static void generate(List<String> uniqueNames) throws FileNotFoundException{

        Set<String> uniqueFullNames=new HashSet<String>();
        //process
        while(uniqueFullNames.size()<4000){
            //generate a uniqueName;
            int a, b, c;
            do{
                a=random.nextInt(uniqueNames.size());
                b=random.nextInt(uniqueNames.size());
                c=random.nextInt(uniqueNames.size());
            }while(a==b||a==c||b==c);
            uniqueFullNames.add(uniqueNames.get(a)+" "+uniqueNames.get(b)+" "+uniqueNames.get(c));
        }
        for(String fullName:uniqueFullNames){
            String[] parts=fullName.split(" ");
                fullNamesList.add(new FullName(parts[0],parts[1],parts[2]));
        }

//        intoFile.close();
//        sc.close();
        System.out.println("done");
    }

    private static class FullName{

        String firstName;
        String middleName;
        String lastName;

        public FullName(String firstName,String middleName,String lastName){
            this.firstName=firstName;
            this.middleName=middleName;
            this.lastName=lastName;
        }

        public String toString(){
            return firstName+" "+middleName+" "+lastName;
        }
    }
}
