package com.fire.phenix.container.callback;

/**
 * @author bluelight
 * @since 2022-07-02
 * 键过期回调函数
 */
@FunctionalInterface
public interface ExpireCallback<K, V> {

    /**
     * 当键过期时执行的函数
     *
     * @param key 过期的键
     * @param val 过期的值
     */
    void onExpire(K key, V val);
}
