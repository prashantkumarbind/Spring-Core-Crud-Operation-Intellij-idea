package org.software;

import org.software.option.Option;
import org.software.serviceimpl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class App
{
    public static void main( String[] args )
    {
        int result;
        System.out.println("**************************************************************************************");
        StudentServiceImpl ssi = new StudentServiceImpl();
        Option option = new Option();
                while(true)
                {
                    result = option.option();
                    switch(result)
                    {
                        case 1: ssi.insert();
                                break;
                        case 2: ssi.select();
                                 break;
                        case 3: ssi.update();
                                break;
                        case 4: ssi.delete();
                                break;
                        case 5: ssi.checkByBoysAndGirlsQuantity();
                                break;
                        case 6: ssi.checkTotalStudentByClassRoomNo();
                                break;
                        case 7: ssi.checkMaxStudentInClass();
                                break;
                        default :
                                System.out.println("Please click the current option:: ");
                                break;
                        case 8: System.exit(0);
                            break;
                    }
                }
    }
}
