/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * Copyright 2008 Rhythm Computing All rights reserved.
 *
 * CollectionAsserts.java
 * @date: Oct 12, 2008
 * @author Michael J. Lee
 *
 */

package kind.test.assertions;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Michael J. Lee
 */
public class CollectionAsserts {

    public static void assertCollectionSize(final int expectedSize, final Collection collection) {
        assertCollectionSize("", expectedSize, collection);
    }

    public static void assertCollectionSize(String message, int expectedSize, Collection collection) {

        if (collection == null)
            fail("colleciton is null but expected a size of [" + expectedSize + "]");

        assertEquals(expectedSize, collection.size(), message);

    }

    public static void assertCollectionContains(final Collection collection, final Object... items) {

        if (collection == null)
            fail("colleciton is null");

        for (int i = 0; i < items.length; i++) {
            assertTrue(collection.contains(items[i]), "Item [" + i + "] was not found in the collection.");
        }

    }

    /**
     * Asserts that the given iterator contains the array of objects.  The
     * order of the array must be aligned with the order of the iterator.
     * The iterator's position will be moved and may be left exhausted if all
     * items are tested.
     *
     * @param iterator The iterator to test.  The position of the iterator
     *                 will be moved and may be left exhaused if all items are tested.
     * @param items    Items to check.
     */
    public static void assertIteratorContains(final Iterator iterator, final Object... items) {

        if (iterator == null)
            fail("iterator is null");

        final int countOfExpectedTests = items.length;
        int testIndex = 0;

        while (iterator.hasNext()) {
            Object itemFromIterator = iterator.next();
            assertEquals(items[testIndex], itemFromIterator, "Item [" + testIndex + "] was not found in the iterator");

            testIndex++;
            if (countOfExpectedTests == testIndex) {
                break;
            }
        }

        if (countOfExpectedTests > testIndex)
            assertEquals(testIndex, countOfExpectedTests, "The number of items given was greater than the number of items in the iterator");


    }


}
