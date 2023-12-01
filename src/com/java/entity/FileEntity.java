/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 927
 */
public class FileEntity {

  private Long id;
  private Timestamp dateTime;
  private String facilityNo;
  private String vehicleNo;
  private int fileType;
  private int comment;
  private Timestamp completedDateTime;
  private String enteredUser;
  private List<FileReturnHistory> returnHistory;

  // Default Constructor
  public FileEntity() {
    //
  }

  public FileEntity(Timestamp dateTime, String facilityNo, String vehicleNo, int fileType, int comment,
          String enteredUser) {
    this.dateTime = dateTime;
    this.facilityNo = facilityNo;
    this.vehicleNo = vehicleNo;
    this.fileType = fileType;
    this.comment = comment;
    this.enteredUser = enteredUser;
  }

  public FileEntity(Timestamp dateTime, String facilityNo, String vehicleNo, int fileType, int comment,
          Timestamp completedDataTime, String enteredUser) {
    this.dateTime = dateTime;
    this.facilityNo = facilityNo;
    this.vehicleNo = vehicleNo;
    this.fileType = fileType;
    this.comment = comment;
    this.completedDateTime = completedDataTime;
    this.enteredUser = enteredUser;
  }

  public FileEntity(Long id, Timestamp dateTime, String facilityNo, String vehicleNo, int fileType, int comment,
          Timestamp completedDateTime, String enteredUser, List<FileReturnHistory> returnHistory) {
    this.id = id;
    this.dateTime = dateTime;
    this.facilityNo = facilityNo;
    this.vehicleNo = vehicleNo;
    this.fileType = fileType;
    this.comment = comment;
    this.completedDateTime = completedDateTime;
    this.enteredUser = enteredUser;
    this.returnHistory = returnHistory;
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

  public Timestamp getCompletedDataTime() {
    return completedDateTime;
  }

  public void setCompletedDataTime(Timestamp completedDateTime) {
    this.completedDateTime = completedDateTime;
  }

  public String getEnteredUser() {
    return enteredUser;
  }

  public void setEnteredUser(String enteredUser) {
    this.enteredUser = enteredUser;
  }

  public List<FileReturnHistory> getReturnHistory() {
    return returnHistory;
  }

  public void setReturnHistory(List<FileReturnHistory> returnHistory) {
    this.returnHistory = returnHistory;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 19 * hash + Objects.hashCode(this.id);
    hash = 19 * hash + Objects.hashCode(this.dateTime);
    hash = 19 * hash + Objects.hashCode(this.facilityNo);
    hash = 19 * hash + Objects.hashCode(this.vehicleNo);
    hash = 19 * hash + Objects.hashCode(this.fileType);
    hash = 19 * hash + Objects.hashCode(this.comment);
    hash = 19 * hash + Objects.hashCode(this.completedDateTime);
    hash = 19 * hash + Objects.hashCode(this.enteredUser);
    hash = 19 * hash + Objects.hashCode(this.returnHistory);
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
    final FileEntity other = (FileEntity) obj;
    if (!Objects.equals(this.facilityNo, other.facilityNo)) {
      return false;
    }
    if (!Objects.equals(this.vehicleNo, other.vehicleNo)) {
      return false;
    }
    if (!Objects.equals(this.fileType, other.fileType)) {
      return false;
    }
    if (!Objects.equals(this.comment, other.comment)) {
      return false;
    }
    if (!Objects.equals(this.enteredUser, other.enteredUser)) {
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
    if (!Objects.equals(this.returnHistory, other.returnHistory)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FileEntity{" + "id=" + id + ", dateTime=" + dateTime + ", facilityNo=" + facilityNo + ", vehicleNo=" + vehicleNo + ", "
            + "fileType=" + fileType + ", comment=" + comment + ", completedDataTime=" + completedDateTime + ", enteredUser=" + enteredUser + ","
            + " returnHistory=" + returnHistory + '}';
  }

}
