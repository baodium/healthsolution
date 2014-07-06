
DROP TABLE IF EXISTS Appointment_;
CREATE TABLE Appointment_(
id_ BIGINT NOT NULL PRIMARY KEY,
patient_id_ BIGINT,
date_of_birth_ TEXT,
hospital_number_ TEXT,
appointment_type_ TEXT,
clinic_ TEXT,
appointment_date_ TEXT,
consultant_to_see_ TEXT,
reason_ TEXT,
referral_source_ TEXT,
tally_number_ TEXT,
clinic_time_ TEXT
);

DROP TABLE IF EXISTS Next_Of_Kin_;
CREATE TABLE Next_Of_Kin_(
hospital_number_ BIGINT NOT NULL PRIMARY KEY,
surname_ TEXT,
first_name_ TEXT,
other_name_ TEXT,
town_ TEXT,
nationality_ TEXT,
state_ TEXT,
lga_ TEXT,
relationship_to_next_of_kin_ TEXT,
phone_number_ TEXT
);

DROP TABLE IF EXISTS Nhis_Information_;
CREATE TABLE Nhis_Information_(
hospital_number_ BIGINT NOT NULL PRIMARY KEY,
nhis_number_ BIGINT NOT NULL UNIQUE,
hmo_ TEXT,
hmo_code_ TEXT,
genotype_ TEXT,
blood_group_ TEXT,
hmo_id_ TEXT,
employer_ TEXT,
address_of_employer_ TEXT,
allergies_ TEXT
);

DROP TABLE IF EXISTS Personal_Details_;
CREATE TABLE Personal_Details_(
hospital_number_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
surname_ TEXT,
first_name_ TEXT,
other_name_ TEXT,
sex_ TEXT,
marital_status_ TEXT,
maiden_name_ TEXT,
phone_numbers_ TEXT,
residential_address_ TEXT,
town_ TEXT,
nationality_ TEXT,
state_ TEXT,
lga_ TEXT,
date_of_registration_ TEXT,
national_id_card_number_ TEXT,
highest_level_of_education_ TEXT
);

--------------VIEWS------------------
DROP VIEW IF EXISTS Search_Patient_Match_;
CREATE VIEW Search_Patient_Match_
AS SELECT personal.hospital_number_,nhis.nhis_number_,personal.surname_,personal.first_name_,personal.other_name_
FROM Nhis_Information_ nhis,Personal_Details_ personal
WHERE personal.hospital_number_=nhis.hospital_number_;

