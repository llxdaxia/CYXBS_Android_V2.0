package com.mredrock.cyxbs.domain.repository;

import com.mredrock.cyxbs.domain.model.Grade;

import java.util.List;

import rx.Observable;

/**
 * Interface that represents a Repository for getting {@link Grade} related data.
 * <p>
 * Created by David on 15/5/16.
 */
public interface GradeRepository extends Repository {
    /**
     * Get an {@link rx.Observable} which will emit a List of {@link Grade}.
     */
    Observable<List<Grade>> getGrades();
}
