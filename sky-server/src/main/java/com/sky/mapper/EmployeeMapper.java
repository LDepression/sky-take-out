package com.sky.mapper;

import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    @Insert("insert into employee(username, name, password, phone, sex, id_number, status,create_user,update_user,create_time, update_time) " +
            "values (#{username}, #{name}, #{password}, #{phone}, #{sex}, #{idNumber}, #{status},#{createUser},#{updateUser}, #{createTime}, #{updateTime})")
    void addEmploy(Employee e);

    List<Employee> PageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
