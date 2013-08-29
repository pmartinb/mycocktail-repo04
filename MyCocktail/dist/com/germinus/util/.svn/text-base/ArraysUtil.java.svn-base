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

/**
 * This class contains usefull methods which perform operations over objects of
 * Array type.
 * @author David del Pozo González
 */
public final class ArraysUtil {

    /**
     * Creates a new instance of <code>ArraysUtil</code>.
     */
    private ArraysUtil() {
    }

    /**
     * Joins all the elements of the Array in a String and separates them
     * with the specified delimiter.
     * @param array the array to join.
     * @param delimiter the delimiter used to separate the elements of the
     * array.
     * @return the resulting String with all the joined elements.
     */
    public static String join(final Object[] array, final String delimiter) {
        if (array == null) {
            throw new IllegalArgumentException("The array cannot be null");
        }
        
        StringBuilder sb = new StringBuilder();

        if (array.length > 0) {
            int i = 0;
            for (; i < array.length-1; i++) {
                sb.append(array[i]).append(delimiter);
            }
            sb.append(array[i]);
        }

        return sb.toString();
    }
}
