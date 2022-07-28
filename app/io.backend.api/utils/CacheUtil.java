package io.backend.api.utils;

import akka.Done;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.Logger;
import play.cache.AsyncCacheApi;
import play.libs.Json;

/**
 * Created by agonlohaj on 11 Nov, 2019
 */
public class CacheUtil {

	/**
	 * Find any type of data in cache, as long as we can serialize/deserialize it
	 * Primitives enabled by default, for other types look at the configuration
	 * @param cacheApi
	 * @param id
	 * @return
	 */
	public static Object findDataInCache(AsyncCacheApi cacheApi, String id) {
		try {
			Object data = cacheApi.sync().get(id);
			if (data != null) {
				Logger.of(CacheUtil.class).debug("Cached data for key: {}", id);
			}
			return data;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns an Json Node from cache, if it exists
	 * @param cacheApi
	 * @param id
	 * @return
	 */
	public static JsonNode findJsonNodeInCache(AsyncCacheApi cacheApi, String id) {
		try {
			String data = (String) CacheUtil.findDataInCache(cacheApi, id);
			if (data == null) {
				return null;
			}
			return Json.parse(data);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Returns an Array Node from cache, if it exists
	 * @param cacheApi
	 * @param id
	 * @return
	 */
	public static ArrayNode findArrayNodeInCache(AsyncCacheApi cacheApi, String id) {
		JsonNode node = CacheUtil.findJsonNodeInCache(cacheApi, id);
		try {
			if (node == null) {
				return null;
			}
			if (!node.isArray()) {
				return null;
			}
			return (ArrayNode) node;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * Puts json node data in cache, by default the expiration is at 30 days
	 * @param cacheApi
	 * @param id
	 * @param result
	 */
	public static void putInCache(AsyncCacheApi cacheApi, String id, JsonNode result) {
		// 30 days default cache, 60 seconds * 60 minutes * 24 * 30
		CacheUtil.putInCache(cacheApi, id, result, 60 * 60 * 24 * 30);
	}

	/**
	 * Puts json node data in cache given the expiration
	 * @param cacheApi
	 * @param id
	 * @param result
	 * @param expiration
	 */
	public static void putInCache(AsyncCacheApi cacheApi, String id, JsonNode result, int expiration) {
		CacheUtil.putInCache(cacheApi, id, result.toString(), expiration);
	}

	/**
	 * Puts data in cache, by default the expiration is at 30 days
	 * @param cacheApi
	 * @param id
	 * @param result
	 */
	public static void putInCache(AsyncCacheApi cacheApi, String id, Object result) {
		// 30 days default cache, 60 seconds * 60 minutes * 24 * 30
		CacheUtil.putInCache(cacheApi, id, result, 60 * 60 * 24 * 30);
	}

	/**
	 * Puts data in cache, by default the expiration is at 30 days
	 * @param id
	 * @return
	 */
	public static void putInCache(AsyncCacheApi cacheApi, String id, Object result, int expiration) {
		try {
			Logger.of(CacheUtil.class).debug("Putting data in cache for key: {}", id);
			if (result == null) {
				cacheApi.remove(id).exceptionally((ex) -> {
					ex.printStackTrace();
					return Done.done();
				});
			} else {
				cacheApi.set(id, result, expiration).exceptionally((ex) -> {
					ex.printStackTrace();
					return Done.done();
				});
			}
		} catch (Exception ex) {
			Logger.of(CacheUtil.class).debug("Failed putting data in cache {}", id);
			ex.printStackTrace();
		}
	}
}
