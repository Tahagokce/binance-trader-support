package com.binance.trader.support.business;

import com.core.utilities.results.DataResult;
import com.core.utilities.results.Result;

import java.util.List;

public interface BaseService<T,L> {
    DataResult<T> findById(L id);

    DataResult<T> save(T entity);

    DataResult<T> update(T entity);

    Result delete(T entity);

    DataResult<List<T>> findAll();
}
