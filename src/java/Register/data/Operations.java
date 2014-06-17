/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Register.data;

/**
 *
 * @author AZEEZ TAIWO
 */
public class Operations {
    private String date;
    private String opSurgeon;
    private String operation;
    private String codeNumber;

    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     */
    public String getOpSurgeon() {
        return opSurgeon;
    }

    /**
     * 
     * @param opSurgeon
     */
    public void setOpSurgeon(String opSurgeon) {
        this.opSurgeon = opSurgeon;
    }

    /**
     * 
     * @return
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 
     * @param operation
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * 
     * @return
     */
    public String getCodeNumber() {
        return codeNumber;
    }

    /**
     * 
     * @param codeNumber
     */
    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }
    public String toString(){
        return "Operations";
    }
}
