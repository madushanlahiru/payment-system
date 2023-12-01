/*
 * The MIT License
 *
 * Copyright 2021 Madushan Lahiru.
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
package com.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Madushan Lahiru
 */
public class CommonUtils {

  public static final String[] TYPE = {"Registerd", "Unregisterd", "Other Security", "Property Mortgage"};
  public static final String[] COMMENT = {"Completed File", "R.M.V Pending", "Re-Finance", "Month End", "Month End - Re-Finance",
    "Granting Purpose", "Facility Cancellation", "PM - Bond Pending"};
  public static final String[] PROCESS = {"Cheque Completed", "Returned to Admin", "Returned to Finance", "CEFT Transfered"};

  public CommonUtils() {
    //
  }

  /**
   * This method will check the input facility number validity. <br>
   * Ex: HOF21LA000001, HOF21LA000001RS01
   *
   * @param facilityNo String
   * @return this will returns true if the facility number valid, else false.
   */
  public static boolean facilityNoValidator(String facilityNo) {
    String regexPattern = "^([A-Z]{3})([0-9]{2})([A-Z]{2})([0-9]{6})$";
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(facilityNo);

    return matcher.matches();
  }

  /**
   * This method will check the input vehicle number validity. <br>
   * Ex: 56-1254, KA-2541 or WPCAE-0001
   *
   * @param vehicleNo String
   * @return this will returns true if the vehicle number valid, else false.
   */
  public static boolean vehicleNoValidator(String vehicleNo) {
    String regexPattern = "(^[A-Z0-9]{2,5})-([0-9]{4})$";
    Pattern pattern = Pattern.compile(regexPattern);
    Matcher matcher = pattern.matcher(vehicleNo);

    return matcher.matches();
  }

  /**
   * This method will pick a file type relevant to given index number.
   * 
   * @param index int number
   * @return String - File type
   */
  public static String selectFileType(int index) {
    return TYPE[index - 1];
  }

  /**
   * This method will pick a initial comment relevant to given index number.
   * 
   * @param index int number
   * @return String - Comment
   */
  public static String selectComment(int index) {
    return COMMENT[index - 1];
  }

  /**
   * This method will pick a initial process relevant to given index number.
   * 
   * @param index int number
   * @return String - Process
   */
  public static String selectProcess(int index) {
    return PROCESS[index - 1];
  }

}
