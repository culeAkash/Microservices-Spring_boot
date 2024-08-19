import axios from "axios";


const EMPLOYEE_SERVICE_BASE_URL = "http://localhost:9191/api/v1/employees/"

// const employeeId = 6


export function getEmployee(employeeId) {
    return axios.get(EMPLOYEE_SERVICE_BASE_URL + "getEmployee/" + employeeId).then(res => res.data);
}