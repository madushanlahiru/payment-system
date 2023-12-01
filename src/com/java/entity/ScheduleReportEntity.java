/*
 * The MIT License
 *
 * Copyright 2023 SandBox.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.java.entity;

import java.sql.Timestamp;

/**
 *
 * @author SandBox
 */
public class ScheduleReportEntity {

    private String facilityNo;
    private String courierBranch;
    private String courierType;
    private String chequeType;
    private int chequeNo;
    private double chequeAmount;
    private String remarks;
    private String addedUser;
    private Timestamp addedDateTime;
    private boolean isPrinted;
    private int sceduleId;
    private String printedUser;
    private Timestamp printedDateTime;

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    public String getCourierBranch() {
        return courierBranch;
    }

    public void setCourierBranch(String courierBranch) {
        this.courierBranch = courierBranch;
    }

    public String getCourierType() {
        return courierType;
    }

    public void setCourierType(String courierType) {
        this.courierType = courierType;
    }

    public String getChequeType() {
        return chequeType;
    }

    public void setChequeType(String chequeType) {
        this.chequeType = chequeType;
    }

    public int getChequeNo() {
        return chequeNo;
    }

    public void setChequeNo(int chequeNo) {
        this.chequeNo = chequeNo;
    }

    public double getChequeAmount() {
        return chequeAmount;
    }

    public void setChequeAmount(double chequeAmount) {
        this.chequeAmount = chequeAmount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getAddedUser() {
        return addedUser;
    }

    public void setAddedUser(String addedUser) {
        this.addedUser = addedUser;
    }

    public Timestamp getAddedDateTime() {
        return addedDateTime;
    }

    public void setAddedDateTime(Timestamp addedDateTime) {
        this.addedDateTime = addedDateTime;
    }

    public boolean isIsPrinted() {
        return isPrinted;
    }

    public void setIsPrinted(boolean isPrinted) {
        this.isPrinted = isPrinted;
    }

    public int getSceduleId() {
        return sceduleId;
    }

    public void setSceduleId(int sceduleId) {
        this.sceduleId = sceduleId;
    }

    public String getPrintedUser() {
        return printedUser;
    }

    public void setPrintedUser(String printedUser) {
        this.printedUser = printedUser;
    }

    public Timestamp getPrintedDateTime() {
        return printedDateTime;
    }

    public void setPrintedDateTime(Timestamp printedDateTime) {
        this.printedDateTime = printedDateTime;
    }

    @Override
    public String toString() {
        return "ScheduleReportEntity{" + "facilityNo=" + facilityNo + ", courierBranch=" + 
            courierBranch + ", corierType=" + courierType + ", chequeType=" + chequeType + 
            ", chequeNo=" + chequeNo + ", chequeAmount=" + chequeAmount + ", remarks=" 
            + remarks + ", addedUser=" + addedUser + ", addedDateTime=" + addedDateTime 
            + ", isPrinted=" + isPrinted + ", sceduleId=" + sceduleId + ", printedUser=" 
            + printedUser + ", printedDateTime=" + printedDateTime + '}';
    }
    
}
