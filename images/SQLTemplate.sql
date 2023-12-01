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
/**
 * Author:  Protector
 * Created: Oct 23, 2021
 */

/**
 * Database name - payment_system
 *
 */

CREATE TABLE file_received (
    id int AUTO_INCREMENT NOT NULL,
    date_time timestamp NOT NULL,
    facility_no varchar(17) NOT NULL,
    vehicle_no varchar(10) NOT NULL,
    file_type int NOT NULL,
    comment int NOT NULL,
    completed_date_time timestamp NULL,
    entered_user varchar(10) NOT NULL,

    PRIMARY KEY (id),
    UNIQUE (facility_no)
);

CREATE TABLE file_return (
    facility_no varchar(17) NOT NULL,
    process int NOT NULL,
    updated_comment varchar(100) NULL,
    returned_date_time timestamp NOT NULL,
    received_date_time timestamp NULL,
    returned_user varchar(10) NOT NULL,
    received_user varchar(10) NULL,

    FOREIGN KEY (facility_no) REFERENCES file_received(facility_no)
);
 
/**
 * Audit record table for to keep update about facility remove from system.
 */
CREATE TABLE audit_data_remove (
    facility_no varchar(17) NOT NULL,
    date_time timestamp NOT NULL,
    comment varchar(100),
    user varchar(10) NOT NULL,

    PRIMARY KEY (facility_no)
);



INSERT INTO file_received(date_time, facility_no, vehicle_no, file_type, comment, entered_user) VALUES
('2021-10-24 14:39:30', 'BRL21LA000485', '56-8547', 1, 1, 'Protector'),
('2021-10-24 14:40:30', 'GLE21ML006348', 'WPCAX-5698', 2, 1, 'Protector'),
('2021-10-24 14:41:30', 'HOF21AD005836', '301-5874', 1, 1, 'Protector'),
('2021-10-24 14:42:30', 'RGY21PL000056', 'PL', 3, 1, 'Protector'),
('2021-10-24 14:45:30', 'HNW21VL000596', 'U/R', 2, 1, 'Protector');



SELECT R.id, R.date_time, R.facility_no, R.vehicle_no, R.file_type, R.comment, R.completed_date_time, R.entered_user, 
    H.process, H.updated_comment, H.returned_date_time, H.received_date_time, H.returned_user, H.received_user 
FROM file_received R LEFT JOIN file_return H
ON R.facility_no = H.facility_no ORDER BY R.date_time ASC, H.returned_date_time ASC;

UPDATE file_return SET received_date_time=null, received_user=null where facility_no='' and process=2;

DROP TABLE file_return;
DROP TABLE file_received;
 