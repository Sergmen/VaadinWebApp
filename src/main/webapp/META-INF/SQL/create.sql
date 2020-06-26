CREATE TABLE patient
(
    id INT PRIMARY KEY  IDENTITY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    patronymic VARCHAR(50) NOT NULL,
    phone VARCHAR(50)  NULL,
)

CREATE TABLE doctor
(
     id INT PRIMARY KEY  IDENTITY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    patronymic VARCHAR(50) NOT NULL,
    specialization VARCHAR(200)  NULL,

 );


CREATE TABLE recipe
(

    id INT PRIMARY KEY  IDENTITY,
    description VARCHAR(50) NOT NULL,
    patient_id INT  NOT NULL,
    doctor_id INT  NOT NULL,

    сreation_date DATE NOT NULL,
    expiration_date DATE NOT NULL,
    priority VARCHAR(50) NOT NULL,


    FOREIGN KEY (patient_id)  REFERENCES patient (id) ON DELETE RESTRICT,

    FOREIGN KEY (doctor_id)  REFERENCES doctor (id) ON DELETE RESTRICT



);