package com.mredrock.cyxbs.model.mapper;

import com.mredrock.cyxbs.model.entities.CourseEntity;
import com.mredrock.cyxbs.domain.model.Course;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Mapper class used to transform {@link CourseEntity} (in the data layer) to {@link Course} in the
 * domain layer.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class CourseEntityDataMapper {
    @Inject
    public CourseEntityDataMapper() {
    }

    /**
     * Transform a {@link CourseEntity} into an {@link Course}.
     *
     * @param courseEntity Object to be transformed.
     * @return {@link Course} if valid {@link CourseEntity} otherwise null.
     */
    public Course transform(CourseEntity courseEntity) {
        Course course = null;
        if (courseEntity != null) {
            course = new Course();
            course.setHash_day(courseEntity.getHash_day());
            course.setHash_lesson(courseEntity.getHash_lesson());
            course.setBegin_lesson(courseEntity.getBegin_lesson());
            course.setDay(courseEntity.getDay());
            course.setLesson(courseEntity.getLesson());
            course.setCourse(courseEntity.getCourse());
            course.setTeacher(courseEntity.getTeacher());
            course.setClassroom(courseEntity.getClassroom());
            course.setRawWeek(courseEntity.getRawWeek());
            course.setWeekModel(courseEntity.getWeekModel());
            course.setWeekBegin(courseEntity.getWeekBegin());
            course.setWeekEnd(courseEntity.getWeekEnd());
            course.setWeek(courseEntity.getWeek());
            course.setStatus(courseEntity.getStatus());
            course.setPeriod(courseEntity.getPeriod());
        }

        return course;
    }

    /**
     * Transform a {@link CourseEntity} into an {@link Course}.
     *
     * @param courseEntityCollection Objects to be transformed.
     * @return {@link Course} if valid {@link CourseEntity} otherwise null.
     */
    public List<Course> transform(Collection<CourseEntity> courseEntityCollection) {
        List<Course> courseList = new ArrayList<>();
        Course course;
        for (CourseEntity courseEntity : courseEntityCollection) {
            course = transform(courseEntity);
            if (course != null) {
                courseList.add(course);
            }
        }
        return courseList;
    }
}
