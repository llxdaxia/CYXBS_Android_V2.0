package com.mredrock.cyxbs.data.mapper;

import com.mredrock.cyxbs.data.entities.CourseEntity;
import com.mredrock.cyxbs.domain.model.Course;

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
     * @param courseEntities Objects to be transformed.
     * @return {@link Course} if valid {@link CourseEntity} otherwise null.
     */
    public List<Course> transform(List<CourseEntity> courseEntities) {
        //TODO
        return null;
    }
}
