/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.search;

import java.io.IOException;

/** 
 * Cache regenerator that just populates the new cache
 * with the old items.
 * <p>
 * This is useful for e.g. CachingWrapperFilters that are not
 * invalidated by the creation of a new searcher.
 */
public class NoOpRegenerator implements CacheRegenerator {

  @Override
  public <K,V> boolean regenerateItem(SolrIndexSearcher newSearcher, SolrCache<K,V> newCache, SolrCache<K,V> oldCache, K oldKey, V oldVal) throws IOException {
    newCache.put(oldKey, oldVal);
    return true;
  }
  
}
