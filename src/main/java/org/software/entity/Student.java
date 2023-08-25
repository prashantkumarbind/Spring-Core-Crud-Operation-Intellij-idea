package org.software.entity;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Student {


        private String name;
        private String address;
        private int roll;
        private int age;
        private float fees;
        private float previousClassPercentage;
        private String mobileNo;
        private String className;
        private int classRoomNo;
        private String gender;
        private String fatherName;
        private int zipNo;
        private String city;
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public int getRoll() {
                return roll;
        }

        public void setRoll(int roll) {
                this.roll = roll;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public float getFees() {
                return fees;
        }

        public void setFees(float fees) {
                this.fees = fees;
        }

        public float getPreviousClassPercentage() {
                return previousClassPercentage;
        }

        public void setPreviousClassPercentage(float previousClassPercentage) {
                this.previousClassPercentage = previousClassPercentage;
        }

        public String getMobileNo() {
                return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
                this.mobileNo = mobileNo;
        }

        public String getClassName() {
                return className;
        }

        public void setClassName(String className) {
                this.className = className;
        }

        public int getClassRoomNo() {
                return classRoomNo;
        }

        public void setClassRoomNo(int classRoomNo) {
                this.classRoomNo = classRoomNo;
        }

        public String getGender() {
                return gender;
        }

        public void setGender(String gender) {
                this.gender = gender;
        }

        public String getFatherName() {
                return fatherName;
        }

        public void setFatherName(String fatherName) {
                this.fatherName = fatherName;
        }

        public int getZipNo() {
                return zipNo;
        }

        public void setZipNo(int zipNo) {
                this.zipNo = zipNo;
        }

        public String getCity() {
                return city;
        }

        public void setCity(String city) {
                this.city = city;
        }

        @Override
        public String toString() {
                return "\n ** STUDENT DETAILS ** \n Name:: " + name +"\n " +"Address::" + address + "\n Roll::" + roll +"\n Age:: " + age +
                        "\n Fees=" + fees +
                        "\n Percentage:: " + previousClassPercentage +
                        "\n MobileNo:: " + mobileNo +
                        "\n ClassName:: " + className +
                        "\n ClassRoomNo:: " + classRoomNo +
                        "\n Gender:: " + gender +
                        "\n FatherName:: " + fatherName +
                        "\n ZipNo:: " + zipNo +
                        "\n City:: " + city;
        }
}
