package com.mredrock.cyxbs.di;

/**
 * Interface representing a contract for clients that contains a component for dependency injection.
 * Created by David on 15/5/12.
 */
public interface HasComponent<C> {
    C getCompontent();
}
