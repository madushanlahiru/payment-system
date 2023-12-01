/*
 * The MIT License
 *
 * Copyright 2021 Protector.
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
import java.util.Objects;

/**
 *
 * @author Protector
 */
public class FileReportEntity {

    private Long id;
    private Timestamp dateTime;
    private String facilityNo;
    private String vehicleNo;
    private int fileType;
    private int comment;
    private Timestamp completedDateTime;
    private String enteredUser;
    private int process;
    private String updatedComment;
    private Timestamp returnedDateTime;
    private Timestamp receivedDateTime;
    private String returnedUser;
    private String receivedUser;

    public FileReportEntity() {
        //
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public String getFacilityNo() {
        return facilityNo;
    }

    public void setFacilityNo(String facilityNo) {
        this.facilityNo = facilityNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getFileType() {
        return fileType;
    }

    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public Timestamp getCompletedDateTime() {
        return completedDateTime;
    }

    public void setCompletedDateTime(Timestamp completedDateTime) {
        this.completedDateTime = completedDateTime;
    }

    public String getEnteredUser() {
        return enteredUser;
    }

    public void setEnteredUser(String enteredUser) {
        this.enteredUser = enteredUser;
    }

    public int getProcess() {
        return process;
    }

    public void setProcess(int process) {
        this.process = process;
    }

    public String getUpdatedComment() {
        return updatedComment;
    }

    public void setUpdatedComment(String updatedComment) {
        this.updatedComment = updatedComment;
    }

    public Timestamp getReturnedDateTime() {
        return returnedDateTime;
    }

    public void setReturnedDateTime(Timestamp returnedDateTime) {
        this.returnedDateTime = returnedDateTime;
    }

    public Timestamp getReceivedDateTime() {
        return receivedDateTime;
    }

    public void setReceivedDateTime(Timestamp receivedDateTime) {
        this.receivedDateTime = receivedDateTime;
    }

    public String getReturnedUser() {
        return returnedUser;
    }

    public void setReturnedUser(String returnedUser) {
        this.returnedUser = returnedUser;
    }

    public String getReceivedUser() {
        return receivedUser;
    }

    public void setReceivedUser(String receivedUser) {
        this.receivedUser = receivedUser;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.dateTime);
        hash = 17 * hash + Objects.hashCode(this.facilityNo);
        hash = 17 * hash + Objects.hashCode(this.vehicleNo);
        hash = 17 * hash + this.fileType;
        hash = 17 * hash + this.comment;
        hash = 17 * hash + Objects.hashCode(this.completedDateTime);
        hash = 17 * hash + Objects.hashCode(this.enteredUser);
        hash = 17 * hash + this.process;
        hash = 17 * hash + Objects.hashCode(this.updatedComment);
        hash = 17 * hash + Objects.hashCode(this.returnedDateTime);
        hash = 17 * hash + Objects.hashCode(this.receivedDateTime);
        hash = 17 * hash + Objects.hashCode(this.returnedUser);
        hash = 17 * hash + Objects.hashCode(this.receivedUser);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FileReportEntity other = (FileReportEntity) obj;
        if (this.fileType != other.fileType) {
            return false;
        }
        if (this.comment != other.comment) {
            return false;
        }
        if (this.process != other.process) {
            return false;
        }
        if (!Objects.equals(this.facilityNo, other.facilityNo)) {
            return false;
        }
        if (!Objects.equals(this.vehicleNo, other.vehicleNo)) {
            return false;
        }
        if (!Objects.equals(this.enteredUser, other.enteredUser)) {
            return false;
        }
        if (!Objects.equals(this.updatedComment, other.updatedComment)) {
            return false;
        }
        if (!Objects.equals(this.returnedUser, other.returnedUser)) {
            return false;
        }
        if (!Objects.equals(this.receivedUser, other.receivedUser)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateTime, other.dateTime)) {
            return false;
        }
        if (!Objects.equals(this.completedDateTime, other.completedDateTime)) {
            return false;
        }
        if (!Objects.equals(this.returnedDateTime, other.returnedDateTime)) {
            return false;
        }
        if (!Objects.equals(this.receivedDateTime, other.receivedDateTime)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FileReportEntity{" + "id=" + id + ", dateTime=" + dateTime + ", facilityNo=" + facilityNo + 
                ", vehicleNo=" + vehicleNo + ", fileType=" + fileType + ", comment=" + comment + 
                ", completedDateTime=" + completedDateTime + ", enteredUser=" + enteredUser + ", process=" + process +
                ", updatedComment=" + updatedComment + ", returnedDateTime=" + returnedDateTime + 
                ", receivedDateTime=" + receivedDateTime + ", returnedUser=" + returnedUser + ", receivedUser=" + receivedUser + 
                '}';
    }

}
