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
public class CourierScheduleRecords {
    
    private long sequenceNo;
    private int schedule;
    private String facilityNo;
    private String courierCategory;
    private String courierBranch;
    private String chequeType;
    private int chequeNo;
    private double chequeAmount;
    private String remarks;
    private Timestamp addedDateTime;
    private boolean isPrinted;

    public CourierScheduleRecords() {
    }

    public long getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(long sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public int getSchedule() {
        return schedule;
    }

    public void setSchedule(int schedule) {
        this.schedule = schedule;
    }

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    public String getCourierCategory() {
        return courierCategory;
    }

    public void setCourierCategory(String courierCategory) {
        this.courierCategory = courierCategory;
    }

    public String getCourierBranch() {
        return courierBranch;
    }

    public void setCourierBranch(String courierBranch) {
        this.courierBranch = courierBranch;
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

    @Override
    public String toString() {
        return "CourierScheduleRecords{" + "sequenceNo=" + sequenceNo + ", schedule=" + schedule + ", "
            + "facilityNo=" + facilityNo + ", courierCategory=" + courierCategory + ", courierBranch=" + courierBranch + ", "
            + "chequeType=" + chequeType + ", chequeNo=" + chequeNo + ", chequeAmount=" + chequeAmount + ", "
            + "remarks=" + remarks + ", addedDateTime=" + addedDateTime + ", isPrinted=" + isPrinted + '}';
    }

}
