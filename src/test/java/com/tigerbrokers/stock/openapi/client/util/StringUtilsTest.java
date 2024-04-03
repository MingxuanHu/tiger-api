package com.tigerbrokers.stock.openapi.client.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void testEqual() {
        Assert.assertTrue(StringUtils.isEqual(null, null));
        Assert.assertTrue(StringUtils.isEqual("1", "1"));
        Assert.assertFalse(StringUtils.isEqual("1", "2"));
        Assert.assertFalse(StringUtils.isEqual(null, "2"));
        Assert.assertFalse(StringUtils.isEqual("1", null));
    }
}
