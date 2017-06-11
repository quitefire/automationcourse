package com.courses.junit.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
// Categories!
@RunWith(Categories.class)
@Categories.ExcludeCategory(PerformanceTests.class)
@Suite.SuiteClasses({ClassA.class})
public class PerformanceTestSuite {
}