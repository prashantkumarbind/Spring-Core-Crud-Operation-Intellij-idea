package org.software.rowmapper;

import org.software.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student s = new Student();
        s.setName(rs.getString("name"));
        s.setAddress(rs.getString("address"));
        s.setRoll(rs.getInt("roll"));
        s.setFees(rs.getFloat("fee"));
        s.setAge(rs.getInt("age"));
        s.setClassName(rs.getString("class_name"));
        s.setPreviousClassPercentage(rs.getFloat("previouse_class_percentage"));
        s.setMobileNo(rs.getString("mobile_no"));
        s.setClassRoomNo(rs.getInt("class_room_no"));
        s.setGender(rs.getString("gender"));
        s.setZipNo(rs.getInt("zip_no"));
        s.setCity(rs.getString("city"));
        s.setFatherName(rs.getString("father_name"));
        return s;
    }
}
