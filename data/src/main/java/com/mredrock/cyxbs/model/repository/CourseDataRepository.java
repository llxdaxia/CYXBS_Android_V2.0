package com.mredrock.cyxbs.model.repository;

import com.mredrock.cyxbs.model.entities.CourseEntity;
import com.mredrock.cyxbs.model.mapper.CourseEntityDataMapper;
import com.mredrock.cyxbs.model.repository.datasource.CourseDataStore;
import com.mredrock.cyxbs.model.repository.datasource.DataStoreFactory;
import com.mredrock.cyxbs.domain.model.Course;
import com.mredrock.cyxbs.domain.repository.CourseRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * {@link CourseRepository} a repository for retrieving user data.
 * <p>
 * Created by David on 15/5/16.
 */
@Singleton
public class CourseDataRepository implements CourseRepository {

    private final DataStoreFactory factory;
    private final CourseEntityDataMapper courseEntityDataMapper;

    private final Func1<List<CourseEntity>, List<Course>> courseDetailsEntityDataMapper = new Func1<List<CourseEntity>, List<Course>>() {
        @Override
        public List<Course> call(List<CourseEntity> courseEntities) {
            return CourseDataRepository.this.courseEntityDataMapper.transform(courseEntities);
        }
    };

    /**
     * Constructs a {@link CourseRepository}.
     *
     * @param factory                A factory to construct different data source implementations.
     * @param courseEntityDataMapper {@link CourseEntityDataMapper}.
     */
    @Inject
    public CourseDataRepository(CourseEntityDataMapper courseEntityDataMapper, DataStoreFactory factory) {
        this.courseEntityDataMapper = courseEntityDataMapper;
        this.factory = factory;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Observable<List<Course>> getCourses(String stuNum) {
        CourseDataStore courseDataStore = factory.createCloudCourseDataStore(stuNum);
        return courseDataStore.getCourse(stuNum).map(courseDetailsEntityDataMapper);
    }

}
