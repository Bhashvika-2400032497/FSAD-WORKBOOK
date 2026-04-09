import { useEffect, useState } from "react";

function UserList() {

  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {

    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("Error fetching users");
        setLoading(false);
      });

  }, []);

  if (loading) return <p>Loading API users...</p>;
  if (error) return <p>{error}</p>;

  return (
    <div>
      <h2>Users from API</h2>

      {users.map((user) => (
        <div key={user.id} className="card">
          <p><b>Name:</b> {user.name}</p>
          <p><b>Email:</b> {user.email}</p>
          <p><b>Phone:</b> {user.phone}</p>
        </div>
      ))}
    </div>
  );
}

export default UserList;
