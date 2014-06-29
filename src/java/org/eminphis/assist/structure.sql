
DROP TABLE IF EXISTS Appointment_;
CREATE TABLE Appointment_(
primary_key_ BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
patient_i_d_ BIGINT,
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