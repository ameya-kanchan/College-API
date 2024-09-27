import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const CollegeDetails = () => {
    const { id } = useParams();
    const [college, setCollege] = useState(null);
    const [courses, setCourses] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchCollegeDetails = async () => {
            try {
                
                const collegeResponse = await axios.get(`/api/colleges/${id}`); 
                setCollege(collegeResponse.data); 
                
               
                const coursesResponse = await axios.get(`/api/courses/${id}`); 
                setCourses(coursesResponse.data); 
            } catch (error) {
                console.error('Error fetching college details or courses:', error);
                setError('Failed to load college details or courses');
            } finally {
                setLoading(false);
            }
        };

        fetchCollegeDetails();
    }, [id]);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>{error}</div>;

    
    if (!college) return <div>No college details found.</div>;

    return (
        <div>
            <h1>{college.name}</h1>
            <p>Accommodation: {college.accommodation}</p>
            <p>Accommodation Fee: ${college.accommodationfee}</p>
            <h2>Courses</h2>
            <table>
                <thead>
                    <tr>
                        <th>Course Name</th>
                        <th>Course Fee</th>
                        <th>Duration</th>
                    </tr>
                </thead>
                <tbody>
                    {courses.map(course => (
                        <tr key={course.id}>
                            <td>{course.name}</td>
                            <td>${course.fee}</td>
                            <td>{course.duration}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};

export default CollegeDetails;