//STAGE 1

package de.entwicklerheld.betterplace.challenge.stage1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class Stage1 {

    // STAGE 1

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Test{
         boolean ignore() default false;
    }

    public static class Assert {


        public static void assertEquals(final Object expected, final Object actual, final String message) {
            // STAGE 1
            if(expected != actual){
                throw new AssertionError(message + "Expected: " + expected + ", but got: " + actual);
            }
        }

        public static void fail(final String message) {
            // STAGE 1
            throw new AssertionError(message);
        }

    }

}

//STAGE 2

package de.entwicklerheld.betterplace.challenge.stage2;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class Stage2 {

    public static class Service {

        public static int add(int... summands) {
            // STAGE 2
            if(summands.length == 0)
            throw new IllegalArgumentException("Input is required!");

            int sum = 0;
            for(Integer summand : summands){
                sum = sum + summand;
            }
            return sum;
        }
    }


    public static class TestRunner {

        public static void main(String[] args) {
            runTests();
        }

        public static String runTests() {
            Set<Method> testMethods = findMethodsAnnotatedWith(Stage1.Test.class);
            de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult = new de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult();
            for (Method method : testMethods) {
                runTestMethod(testResult, method);
            }
            return printResult(testResult);
        }

        public static Set<Method> findMethodsAnnotatedWith(Class<? extends Annotation> annotation) {
            // STAGE 2
            ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.setUrls(ClasspathHelper.forPackage( "de.entwicklerheld.betterplace.challenge.stage2" ));
            builder.setScanners(new MethodAnnotationsScanner());
            Reflections reflections = new Reflections(builder);
            return reflections.getMethodsAnnotatedWith(annotation);
        }

        public static void runTestMethod(final de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult, final Method method) {
            // STAGE 2
            Object o = null;
            try {                
                o = method.getDeclaringClass().newInstance();
            } catch (Exception e){
                System.out.println(e.getCause());
            }

            if(method.getDeclaredAnnotation(Stage1.Test.class).ignore()){
                testResult.ignoredTests.add(method);
                return;
            }
            
            testResult.runnedTests.add(method);
            boolean failure = false;
            try{
                method.invoke(o);
            }catch (Exception e){
                failure = true;
                if(e.getCause() instanceof AssertionError){
                    testResult.failures.add(method + " : " + e.getCause().getMessage());
                }else{
                    testResult.errors.add(method + " : " + e.getCause());
                }
            }
            if(!failure){
                testResult.successes.add(method.getName());
            }
        }

        public static String printResult(final de.entwicklerheld.betterplace.challenge.stage2.Stage2.TestRunner.TestResult testResult) {
            // STAGE 2
            String result = testResult.getSuccesses().size() + " test(s) finished without errors.\n" + testResult.getIgnoredTests().size() + " test(s) were ignored.\n" + testResult.getFailures().size() + " test(s) failed.\n" + testResult.getErrors().size() + " test(s) threw an exception.\n";
            for(String failure : testResult.getFailures()){
                result += failure + "\n";
            }
            for(String error : testResult.getErrors()){
                result += error + "\n";
            }    
            return result;
        }

        public static class TestResult {

            List<String> failures;

            List<String> errors;

            List<String> successes;

            List<Method> runnedTests;

            List<Method> ignoredTests;

            public TestResult() {
                failures = new ArrayList<>();
                errors = new ArrayList<>();
                successes = new ArrayList<>();
                runnedTests = new ArrayList<>();
                ignoredTests = new ArrayList<>();
            }

            public List<String> getFailures() {
                return failures;
            }

            public List<String> getErrors() {
                return errors;
            }

            public List<String> getSuccesses() {
                return successes;
            }

            public List<Method> getRunnedTests() {
                return runnedTests;
            }

            public List<Method> getIgnoredTests() {
                return ignoredTests;
            }

        }
    }



}

//STAGE 3

package de.entwicklerheld.betterplace.challenge.stage3;

import org.reflections.util.ClasspathHelper;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stage3 {

    @Target({ ElementType.METHOD })
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface ParameterizedTest {

        boolean ignore() default false;

        String parameterProvider();
    }

    public static class ExtendedTestRunner extends Stage2.TestRunner {

        public static void main(String[] args) {
            System.out.println(runTests());
        }

        public static String runTests() {
            Set<Method> testMethods = new HashSet<>();
            testMethods.addAll(findMethodsAnnotatedWith(Stage1.Test.class));
            testMethods.addAll(findMethodsAnnotatedWith(ParameterizedTest.class));

            TestResult testResult = new TestResult();

            for (Method method : testMethods) {
                runTestMethod(testResult, method);
            }

            return printResult(testResult);
        }

        public static void runTestMethod(final TestResult testResult, final Method method) {
            // STAGE 3
            if (method.isAnnotationPresent(Stage1.Test.class)) {
                Stage2.TestRunner.runTestMethod(testResult, method);
            }
            if (method.isAnnotationPresent(Stage3.ParameterizedTest.class)) {
                Object o = null;
                try {
                    o = method.getDeclaringClass().newInstance();
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (method.getAnnotation(Stage3.ParameterizedTest.class).ignore()) {
                    testResult.ignoredTests.add(method);
                    return;
                }

                boolean failure = false;

                try {
                    Method m = method.getDeclaringClass()
                            .getMethod(method.getAnnotation(Stage3.ParameterizedTest.class).parameterProvider());
                    Object r = m.invoke(o);
                    List<TestParameters> tpl = (List<TestParameters>) r;
                    for (TestParameters tp : tpl) {
                        try {
                            testResult.runnedTests.add(method);
                            method.invoke(o, tp.expectedResult, tp.parameters);
                        } catch (Exception e) {
                            failure = true;
                            if (e.getCause() instanceof AssertionError) {
                                testResult.failures.add(method + " : " + e.getCause() + " TestParams: " + tp);
                            } else {
                                testResult.errors.add(method + " : " + e.getCause() + " TestParams: " + tp);
                            }
                        }
                        if (!failure) {
                            testResult.successes.add(method.getName());
                        }
                    }
                } catch (Exception e) {

                }

            }
        }
    }

}
