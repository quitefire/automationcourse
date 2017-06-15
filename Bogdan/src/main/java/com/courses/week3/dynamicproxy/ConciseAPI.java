package com.courses.week3.dynamicproxy;

import com.courses.week3.conciseapi.utils.CoreConstants;
import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static com.courses.week3.conciseapi.utils.CoreConstants.WAIT_TIMEOUT;
import static com.courses.week3.conciseapi.waitconditions.ElementCondition.visible;
import static com.courses.week3.conciseapi.wrappers.WebDriverProvider.getDriver;

public class ConciseAPI {

    private final WebDriverWait wait;

    public ConciseAPI() {
        this.wait = new WebDriverWait(getDriver(), WAIT_TIMEOUT);
    }

    public WebElement $(By locator) {
        return (WebElement) newSmartElementProxy(WebElement.class, locator);
    }

    protected Object newSmartElementProxy(Class<WebElement> clazz, By elementLocator) {
        return java.lang.reflect.Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                new Class[]{clazz},
                new SmartElementProxy(elementLocator));
    }

    public WebElement $(String cssSelector) {
        return $(By.cssSelector(cssSelector));
    }

    public void open(String url) {
        getDriver().get(url);
    }

    public <V> V waitUntil(Function<? super WebDriver, V> condition, long timeout) {
        return wait.until(condition);
    }

    public <V> V assertThat(Function<? super WebDriver, V> condition) {
        return waitUntil(condition, CoreConstants.WAIT_TIMEOUT);
    }

    protected void refresh() {
        $("body").sendKeys(Keys.F5);
    }


    private class SmartElementProxy implements InvocationHandler {

        private By elementLocator;

        SmartElementProxy(By elementLocator) {
            this.elementLocator = elementLocator;
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                return method.invoke(assertThat(visible.getType().apply(elementLocator)), args);
            } catch (InvocationTargetException e) {
                // Unwrap the underlying exception
                throw e.getCause();
            }
        }
    }
}