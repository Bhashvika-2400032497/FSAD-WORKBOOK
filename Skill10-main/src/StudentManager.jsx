import { useState } from 'react';

const initialStudents = [
  { id: 'S101', name: 'Aarav Mehta', course: 'Computer Science' },
  { id: 'S102', name: 'Nisha Rao', course: 'Electronics' },
  { id: 'S103', name: 'Rohan Patel', course: 'Mechanical' },
  { id: 'S104', name: 'Priya Singh', course: 'Civil' },
  { id: 'S105', name: 'Kabir Shah', course: 'Mathematics' }
];

const emptyStudent = {
  id: '',
  name: '',
  course: ''
};

function StudentManager() {
  const [students, setStudents] = useState(initialStudents);
  const [newStudent, setNewStudent] = useState(emptyStudent);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setNewStudent((prevStudent) => ({
      ...prevStudent,
      [name]: value
    }));
  };

  const handleAddStudent = () => {
    const trimmedStudent = {
      id: newStudent.id.trim(),
      name: newStudent.name.trim(),
      course: newStudent.course.trim()
    };

    if (!trimmedStudent.id || !trimmedStudent.name || !trimmedStudent.course) {
      return;
    }

    setStudents((prevStudents) => [...prevStudents, trimmedStudent]);
    setNewStudent(emptyStudent);
  };

  const handleDeleteStudent = (studentId) => {
    setStudents((prevStudents) =>
      prevStudents.filter((student) => student.id !== studentId)
    );
  };

  return (
    <div className="student-manager">
      <h1>Student Manager</h1>

      <div className="form-row">
        <input
          type="text"
          name="id"
          placeholder="Enter ID"
          value={newStudent.id}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Enter Name"
          value={newStudent.name}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Enter Course"
          value={newStudent.course}
          onChange={handleInputChange}
        />
        <button type="button" className="add-btn" onClick={handleAddStudent}>
          Add Student
        </button>
      </div>

      {students.length === 0 ? (
        <p className="empty-state">No students available</p>
      ) : (
        <table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    type="button"
                    className="delete-btn"
                    onClick={() => handleDeleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}

export default StudentManager;
