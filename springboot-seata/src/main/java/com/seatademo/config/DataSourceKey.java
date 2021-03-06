package com.seatademo.config;

import lombok.Getter;

/**
 * @author HelloWoodes
 */

@Getter
public enum DataSourceKey {
    /**
     * Order data source key.
     */
    ORDER,
    /**
     * Stock data source key.
     */
    STOCK,
    /**
     * Pay data source key.
     */
    PAY,
}