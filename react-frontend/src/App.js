import EmployeeComponent from "./components/EmployeeComponent";

export default function App() {
  return (
    <h1 className="text-3xl font-bold underline">
      <EmployeeComponent employeeId={6} />
    </h1>
  )
}