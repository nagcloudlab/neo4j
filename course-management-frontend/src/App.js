import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";

function App() {
    const [courses, setCourses] = useState([]);
    useEffect(() => {
        fetch("http://localhost:8080/api/v1/courses")
            .then(response => response.json())
            .then(courses => setCourses(courses))
    }, []);
  return (
    <div className="container">
     <div className={"display-1"}>course management UI</div>
      <hr/>
        <table className={"table"}>
            <thead>
            <tr>
                <th>Course Name</th>
                <th>Course Duration</th>
            </tr>
            </thead>
            <tbody>
            {
                courses.map(course =>
                    <tr key={course.id}>
                        <td>{course.title}</td>
                        <td>{course.teacher}</td>
                    </tr>
                )
            }
            </tbody>
        </table>
    </div>
  );
}

export default App;
