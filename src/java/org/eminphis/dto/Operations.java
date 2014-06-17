package org.eminphis.dto;

/**
 * <u>e-MINPHIS</u><br>
 * A project of the Health Information Systems Unit of the<br>
 * Department of Computer Science and Engineering,<br>
 * Obafemi Awolowo University, Ile-Ife.<br>
 *
 *
 * <pre>
 * Class name: Operations.java
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
public class Operations{

    private final String date;
    private final String opSurgeon;
    private final String operation;
    private final String codeNumber;

    public Operations(String date,String opSurgeon,String operation,String codeNumber){
        this.date=date;
        this.opSurgeon=opSurgeon;
        this.operation=operation;
        this.codeNumber=codeNumber;
    }

    public String getDate(){
        return date;
    }

    public String getOpSurgeon(){
        return opSurgeon;
    }

    public String getOperation(){
        return operation;
    }

    public String getCodeNumber(){
        return codeNumber;
    }
}
