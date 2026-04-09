import { useEffect,useState } from "react";
import axios from "axios";
import AddStudent from "./AddStudent";

function StudentList(){

  const [students,setStudents] = useState([]);
  const [editStudent,setEditStudent] = useState(null);

  const fetchStudents = async() =>{

    const res = await axios.get("http://localhost:8080/students");
    setStudents(res.data);

  };

  useEffect(()=>{
    fetchStudents();
  },[]);

  const deleteStudent = async(id)=>{

    await axios.delete(`http://localhost:8080/students/${id}`);
    fetchStudents();

  };

  const updateStudent = async()=>{

    await axios.put(
      `http://localhost:8080/students/${editStudent.id}`,
      editStudent
    );

    setEditStudent(null);
    fetchStudents();

  };

  return(

    <div>

      <h2>Student Management</h2>

      <AddStudent refresh={fetchStudents}/>

      <table border="1">

        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Course</th>
            <th>Actions</th>
          </tr>
        </thead>

        <tbody>

          {students.map((s)=>(
            <tr key={s.id}>

              <td>{s.name}</td>
              <td>{s.email}</td>
              <td>{s.course}</td>

              <td>

                <button onClick={()=>setEditStudent(s)}>
                  Edit
                </button>

                <button onClick={()=>deleteStudent(s.id)}>
                  Delete
                </button>

              </td>

            </tr>
          ))}

        </tbody>

      </table>

      {editStudent && (

        <div>

          <h3>Update Student</h3>

          <input
          value={editStudent.name}
          onChange={(e)=>
            setEditStudent({...editStudent,name:e.target.value})
          }
          />

          <input
          value={editStudent.email}
          onChange={(e)=>
            setEditStudent({...editStudent,email:e.target.value})
          }
          />

          <input
          value={editStudent.course}
          onChange={(e)=>
            setEditStudent({...editStudent,course:e.target.value})
          }
          />

          <button onClick={updateStudent}>
            Update
          </button>

        </div>

      )}

    </div>

  );
}

export default StudentList;
