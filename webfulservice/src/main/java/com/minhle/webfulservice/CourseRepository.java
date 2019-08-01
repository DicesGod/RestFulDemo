package com.minhle.webfulservice;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends JpaRepository<Course, Long>{
    Collection<Course> findCourseByCourseTitle(String courseTitle);
    Collection<Course> findCourseByCredits(int credits);
    Collection<Course> findCourseByCourseID(String courseID);
}