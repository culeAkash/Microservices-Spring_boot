import React, { useEffect, useState } from 'react'
import { getEmployee } from '../services/EmployeeService';

export default function EmployeeComponent({ employeeId }) {

    const intitialEmployee = {
        employee: {},
        department: {},
        organisation: {}
    }


    const [employeeData, setEmployeeData] = useState(intitialEmployee);


    useEffect(() => {
        getEmployee(employeeId).then((data) => {
            console.log(data);
            setEmployeeData({
                employee: data.employee,
                department: data.department,
                organisation: data.organisation
            })
        })
    }, []);

    return (
        <div>
            <h1>Employee Details</h1>
            <p>Employee ID: {employeeData.employee.employeeId}</p>
            <p>Employee Name: {employeeData.employee.employeeName}</p>
            <p>Department: {employeeData.department.departmentName}</p>
            <p>Organisation: {employeeData.organisation.organisationName}</p>
        </div>
    )
}
