/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author dattv
 */
public class MonthSoft {

    private String createdate;
    private int entryId;

    public MonthSoft(String createdate, int entryId) {
        this.createdate = createdate;
        this.entryId = entryId;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }



}
