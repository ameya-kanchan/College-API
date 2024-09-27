import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const CollegeList = () => {
    const [colleges, setColleges] = useState([]);

    useEffect(() => {
        const fetchColleges = async () => {
            try {
                const response = await axios.get('/api/colleges');
                setColleges(response.data);
            } catch (error) {
                console.error('Error fetching colleges:', error);
            }
        };

        fetchColleges();
    }, []);

    return (
        <div>
            <h1>College List</h1>
            <table>
                <thead>
                    <tr>
                        <th>College Name</th>
                        <th>See College Details and Courses</th>
                    </tr>
                </thead>
                <tbody>
                    {colleges.map(college => (
                        <tr key={college.id}>
                            <td>{college.name}</td>
                            <td>
                                <Link to={`/colleges/${college.id}`}>View Details</Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default CollegeList;