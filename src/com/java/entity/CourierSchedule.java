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
public class CourierSchedule {
    
    private int id;
    private int courierBranch;
    private String createdUser;
    private Timestamp createdDateTime;
    private String printedUser;
    private Timestamp printedDateTime;
    private String lastUpdatedUser;
    private Timestamp lastUpdatedDateTime;

    public CourierSchedule() {
    }

    public CourierSchedule(int id, int courierBranch, String createdUser, 
            Timestamp createdDateTime, String printedUser, Timestamp printedDateTime, 
            String lastUpdatedUser, Timestamp lastUpdatedDateTime) {
        this.id = id;
        this.courierBranch = courierBranch;
        this.createdUser = createdUser;
        this.createdDateTime = createdDateTime;
        this.printedUser = printedUser;
        this.printedDateTime = printedDateTime;
        this.lastUpdatedUser = lastUpdatedUser;
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourierBranch() {
        return courierBranch;
    }

    public void setCourierBranch(int courierBranch) {
        this.courierBranch = courierBranch;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Timestamp getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(Timestamp createdDateTime) {
        this.createdDateTime = createdDateTime;
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

    public String getLastUpdatedUser() {
        return lastUpdatedUser;
    }

    public void setLastUpdatedUser(String lastUpdatedUser) {
        this.lastUpdatedUser = lastUpdatedUser;
    }

    public Timestamp getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Timestamp lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    @Override
    public String toString() {
        return "CourierSchedule{" + "id=" + id + ", courierBranch=" + courierBranch + ", "
            + "createdUser=" + createdUser + ", createdDateTime=" + createdDateTime + ", "
            + "printedUser=" + printedUser + ", printedDateTime=" + printedDateTime + ", "
            + "lastUpdatedUser=" + lastUpdatedUser + ", lastUpdatedDateTime=" + lastUpdatedDateTime + '}';
    }

}
