package org.software.serviceimpl;

import org.software.controller.StudentController;
import org.software.entity.Student;
import org.software.rowmapper.StudentRowMapper;
import org.software.services.StudentService;
import org.springframework.jdbc.core.JdbcTemplate;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    int rollNumber;
    JdbcTemplate template;
    Student s = new Student();
    StudentController controller = new StudentController();
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    @Override
    public void insert() {
        template = controller.config();

        try{
            String querySelect = "select * from student";
            List<Student> list = template.query(querySelect, new StudentRowMapper());
            for(Student s :  list){
                rollNumber = s.getRoll();
            }
        }catch(Exception e){
            System.out.println("Exception Occur in the StudentServiceImple class insert method first try block:"+e);
        }
        try
        {
            System.out.println("Enter name:: ");
            s.setName(bfr.readLine());
            System.out.println("Enter address:: ");
            s.setAddress(bfr.readLine());
            rollNumber++;
            s.setRoll(rollNumber);
            System.out.println("Enter fees:: ");
            s.setFees(Float.parseFloat(bfr.readLine()));
            System.out.println("Enter age:: ");
            s.setAge(Integer.parseInt(bfr.readLine()));
            System.out.println("Enter the Class name:: ");
            s.setClassName(bfr.readLine());
            System.out.println("Enter the Previous Result Percentage:: ");
            s.setPreviousClassPercentage(Float.parseFloat(bfr.readLine()));
            System.out.println("Enter the Mobile Number:: ");
            s.setMobileNo(bfr.readLine());
            System.out.println("Enter the Class Room Number:: ");
            s.setClassRoomNo(Integer.parseInt(bfr.readLine()));
            System.out.println("Enter gender :: ");
            s.setGender(bfr.readLine());
            System.out.println("Enter the Zip Number:: ");
            s.setZipNo(Integer.parseInt(bfr.readLine()));
            System.out.println("Enter the City:: ");
            s.setCity(bfr.readLine());
            System.out.println("Enter Father Name:: ");
            s.setFatherName(bfr.readLine());
            String queryInsert = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            int result = template.update(queryInsert,s.getName(),s.getAddress(),s.getRoll(),s.getFees(),s.getAge(),s.getClassName(),s.getPreviousClassPercentage(),s.getMobileNo(),s.getClassRoomNo(),s.getGender(),s.getZipNo(),s.getCity(),s.getFatherName());
            if(result==1) {
                System.out.println("\n Insert of value  Successfully  :: ");
            } else {
                System.out.println("\n Insert of value not inserted  ::");
            }
        }catch(Exception e){
            System.out.println("Exception Occur in StudentServiceImpl insert class:: "+e);
        }
    }

    @Override
    public void select() {

        template = controller.config();
        try{
            String querySelect = "select * from student";
            List<Student> list = template.query(querySelect,new StudentRowMapper());
            for(Student s : list)
            {
                System.out.println(s);
            }
        }catch(Exception e){
            System.out.println("Exception Occur StudentServiceImpl class select method::  "+e);
        }
    }

    @Override
    public void update() {
        template = controller.config();
        try{
            System.out.println("====== === === ==== ===** UPDATE ** === ==== ==== ==== ====");
            System.out.println("Enter the Roll number you want to change details:: ");
            s.setRoll(Integer.parseInt(bfr.readLine()));
            System.out.println("Change name :: ");
            s.setName(bfr.readLine());
            System.out.println("Change Mobile no:: ");
            s.setMobileNo(bfr.readLine());
            System.out.println("Change Father Name::");
            s.setFatherName(bfr.readLine());
            System.out.println("Change City name");
            s.setCity(bfr.readLine());
            System.out.println("Change Age :: ");
            s.setAge(Integer.parseInt(bfr.readLine()));
            String updateQuery = "update student set name=?, age=?, mobile_no=?, city=?, father_name=? where roll=?";
            int result = template.update(updateQuery,s.getName(),s.getAge(),s.getMobileNo(),s.getCity(),s.getFatherName(),s.getRoll());
            if(result==1)
                System.out.println("\n Data Successfully Update: ");
            else
                System.out.println("\n Not Updated=====================");
        }catch(Exception e){
            System.out.println("Exception occur in the StudentServiceImpl update  method::"+e);
        }
    }

    @Override
    public void delete() {
        template = controller.config();
        try {
            System.out.println("Enter the roll number you want to delete:: ");
            s.setRoll(Integer.parseInt(bfr.readLine()));
            String deleteQuery = "delete from student where roll="+s.getRoll();
            int result = template.update(deleteQuery);
            if(result==1)
                System.out.println("Data Delete from the database");
            else
                System.out.println("Data not delete from the database");
        }catch(Exception e){
            System.out.println("Exception Occur in the program::"+e);
        }

    }

    @Override
    public void checkByBoysAndGirlsQuantity() {
        int list_size;
        int boysQuantity = 0;
        int girlsQuantity=0;
        List<String> strlist = new ArrayList<>();
        template = controller.config();
        try{
            System.out.println("Enter the class name ::: ");
            s.setClassName(bfr.readLine());
            String sql = "select * from student where class_name='"+s.getClassName()+"';";
            List<Student> list = template.query(sql,new StudentRowMapper());
            list_size = list.size();
            for(Student val : list)
            {
                if(val.getGender().equalsIgnoreCase("male"))
                {
                    boysQuantity++;
                }
                else if(val.getGender().equalsIgnoreCase("female"))
                {
                    girlsQuantity++;
                }
            }
        }catch(Exception e){
            System.out.println("Exception Occur in the program::"+e);
        }

        System.out.println("Total Girls :: "+girlsQuantity);
        System.out.println("total Boys :: "+boysQuantity);
    }

    @Override
    public void checkTotalStudentByClassRoomNo() {
        template = controller.config();
        try{
            System.out.println("Enter the class room number :: ");
            s.setClassRoomNo(Integer.parseInt(bfr.readLine()));
            String sql = "select * from student where class_room_no="+s.getClassRoomNo();
            List<Student> list = template.query(sql, new StudentRowMapper());
            int total = list.size();
            System.out.println("Total Student Quantity ::"+total);
        }catch(Exception e){
            System.out.println("exception occur in the StudentServiceImpl checkTotalStudentByClassNo method:: "+e);
        }
    }

    @Override
    public void checkMaxStudentInClass() {
        template = controller.config();
        int bca=0,ba=0,bsc=0,ma=0,mca=0;
        try{
            String sql = "select * from student";
            List<Student> list = template.query(sql, new StudentRowMapper());
            for(Student val : list)
            {
                if(val.getClassName().equalsIgnoreCase("BCA"))
                    bca++;
                else if(val.getClassName().equalsIgnoreCase("MCA"))
                    mca++;
                else if(val.getClassName().equalsIgnoreCase("BA"))
                    ba++;
                else if(val.getClassName().equalsIgnoreCase("BSC"))
                    bsc++;
                else if(val.getClassName().equalsIgnoreCase("MA"))
                    ma++;
            }
            System.out.println("================== TOTAL MAX STUDENT WHICH CLASS================\n");

            if(bca>mca && bca>ba && bca>bsc && bca>ma)
                System.out.println("total Max Student in Bca class:: "+bca);
            else if(mca>bca && mca>ba && mca>bsc && mca>ma)
                System.out.println("total Max Student in Mca class::"+mca);
            else if(ba>bca && ba>bsc && ba>mca && ba>ma)
                System.out.println("total max Student in BA class:: "+ba);
            else if(bsc>ba && bsc>bca && bsc>ma && bsc>mca)
                System.out.println("total max Student in BSC class:: "+bsc);
            else if(ma>bca && ma>mca && ma>ba && ma>bsc)
                System.out.println("total max Student in MA class:: "+ma);
            System.out.println("================== TOTAL MIN STUDENT WHICH CLASS================\n");

            if(bca<mca && bca<ba && bca<bsc && bca<ma)
                System.out.println("total MIN Student in Bca class:: "+bca);
            else if(mca<bca && mca<ba && mca<bsc && mca<ma)
                System.out.println("total MIN Student in Mca class::"+mca);
            else if(ba<bca && ba<bsc && ba<mca && ba<ma)
                System.out.println("total MIN Student in BA class:: "+ba);
            else if(bsc<ba && bsc<bca && bsc<ma && bsc<mca)
                System.out.println("total MIN Student in BSC class:: "+bsc);
            else if(ma<bca && ma<mca && ma<ba && ma<bsc)
                System.out.println("total MIN Student in MA class:: "+ma);
        }catch(Exception e){
            System.out.println("Exception Occur in the StudentServiceImpl checkMINStudentInClass method:: "+e);
        }
    }
}














