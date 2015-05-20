package com.mredrock.cyxbs.model.mapper;

import com.mredrock.cyxbs.domain.model.Course;
import com.mredrock.cyxbs.model.CourseModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by David on 15/5/20.
 */
public class CourseModelDataMapper {
    @Inject
    public CourseModelDataMapper() {
    }

    /**
     * Transform a {@link Course} into an {@link CourseModel}.
     *
     * @param course Object to be transformed.
     * @return {@link Course} if valid {@link CourseModel} otherwise null.
     */
    public CourseModel transform(Course course) {
        CourseModel courseModel = null;
        if (course != null) {
            courseModel = new CourseModel();
            courseModel.setHash_day(course.getHash_day());
            courseModel.setHash_lesson(course.getHash_lesson());
            courseModel.setBegin_lesson(course.getBegin_lesson());
            courseModel.setDay(course.getDay());
            courseModel.setLesson(course.getLesson());
            courseModel.setCourse(course.getCourse());
            courseModel.setTeacher(course.getTeacher());
            courseModel.setClassroom(course.getClassroom());
            courseModel.setRawWeek(course.getRawWeek());
            courseModel.setWeekModel(course.getWeekModel());
            courseModel.setWeekBegin(course.getWeekBegin());
            courseModel.setWeekEnd(course.getWeekEnd());
            courseModel.setWeek(course.getWeek());
            courseModel.setStatus(course.getStatus());
            courseModel.setPeriod(course.getPeriod());
        }

        return courseModel;
    }

    /**
     * Transform a {@link Course} into an {@link CourseModel}.
     *
     * @param courseCollection Objects to be transformed.
     * @return {@link CourseModel} if valid {@link Course} otherwise null.
     */
    public List<CourseModel> transform(Collection<Course> courseCollection) {
        List<CourseModel> courseModelList = new ArrayList<>();
        CourseModel courseModel;
        for (Course course : courseCollection) {
            courseModel = transform(course);
            if (courseModel != null) {
                courseModelList.add(courseModel);
            }
        }
        return courseModelList;
    }
}
