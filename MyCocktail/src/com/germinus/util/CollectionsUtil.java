/*
 * Copyright 2009 David del Pozo González (dpozog--at--grupogesfor.com)
 * Informática Gesfor
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.germinus.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * This class contains usefull methods which perform operations over objects
 * which implement the interface Collection.
 * @author David del Pozo González
 */
public final class CollectionsUtil {
    /**
     * Creates a new instance of <code>CollectionsUtil</code>.
     */
    private CollectionsUtil() {
    }

    /**
     * Joins all the elements of the collection in a String and separates them
     * with the specified delimiter.
     * @param <E> The parametrized type of the Collection
     * @param collection the collection to join.
     * @param delimiter the delimiter used to separate the elements of the
     * collection.
     * @return the resulting String with all the joined elements.
     */
    public static <E> String join(final Collection<E> collection, final String delimiter) {
        if (collection == null) {
            throw new IllegalArgumentException("The collection cannot be null");
        }
        
        StringBuilder sb = new StringBuilder();

        for (Iterator<E> it = collection.iterator(); it.hasNext();) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(delimiter);
            }
        }

        return sb.toString();
    }
}
