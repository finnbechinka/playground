# Make the world a better place

### Zusammenfassung 

In a post-apocalyptic world without JUnit, you want to make the world a better place. Go for it and create your own testing framework! Lately, some super evil alien zombie viruses tried to destroy human computer science and were almost succesful. Luckily enough Java survived, but somehow JUnit got lost in the troubles of the apocalypse. Humankind needs you to rebuild a simple Testing Framework from scratch!

## STAGE 1

### Zielstellung

Do you remember the good old times of test driven development? Oh, it was a blast to see your tests finally turn green. Let's bring those happy days back!

### Szenario 1: The 'Stage1.Test' Annotation

Well, actually you never spent a second thinking about how automatic testing could work. So let's start from what we remember.

All you had to do was marking the test method with @Stage1.Test, so getting a new Stage1.Test annotation could be a nice thing to start with.

You should add a boolean parameter called ignore to easily turn off the test. The default for ignore should definitely be false.

This annotation should only be used with Methods, so restrict your annotation to be used with Methods only.

Also make sure the annotation is still available at runtime.

### Szenario 2: The 'Stage1.Assert' utility class

A utility class to compare our expectations to the values returned by our Service method would be nice.

To start with, implement the assertEquals method for comparing Objects.

Those method needs 3 Parameters: Expected value, actual value, message to be returned in case of error.

Throw an java.lang AssertionError with given message and 'Expected: {expectedValue}, but got: {actualValue}' if assertion fails, otherwise do nothing.

Add another method named fail that always throws an java.lang AssertionError.

fail just needs the message as parameter.

## STAGE 2

### Zielstellung

Back in the days, where we had nice testing frameworks: a click on 'Run Tests' collected all tests to run and did the work. Someone has to do it now. It's your turn.

### Szenario 1: Build the 'Stage2.Service' test scenario

To test your new testing framework, we need a method to run our tests on. Implement a simple addition of n summands.

Throw an IllegalArgumentException with message Input is required! if input parameters are empty.

### Szenario 2: The 'Stage2.TestRunner' should find all tests

Great. Now we have a nice method we can test our tests on. We already wrote some tests for you: ServiceTest.java. Let's find those annotated methods and run them automatically! For the moment, our test classes containing the test methods are placed in the root folder where the productive code is placed too.
HINT: You can use org.reflections to find the methods, if you want to.

Implement the method findMethodsAnnotatedWith to find all methods in source code folder that are annotated with @Stage1.Test

Afterwards implement the method runTestMethod and store the results of the test execution in the TestResult. Do not care for the content of the single result strings for now. This is for the next test scenario.

Make sure, the ignored methods are not executed.

### Szenario 3: Make the logs readable

Now we should make the results human-readable. Please implement the method printResult. The returned String will be printed to console when running the Stage2.TestRunner.

Add a short overview of the test execution to the result String. It should look like this:

{n} test(s) finished without errors.
{m} test(s) were ignored.
{o} test(s) failed.
{p} test(s) threw an exception.

Please return useful information about failed method calls. Users want to know the fully qualified name of the failed method and what actually went wrong.

Also return information about method calls that threw an unexpected exception. Users want to know the fully qualified name of the method in error and the Exception that was thrown.

## STAGE 3

### Zielstellung

Have you realized there is only one test case for the main feature of our add-Method?
 

 
@Test
public void testTestExecution() {
    Assert.assertEquals(4, Service.add(1, 1, 2), "Addition is not working properly");
}


Wouldn't it be nice to have some more tests to make sure, the method really adds the input values? Maybe it just always returns 4? I admit it will be really annoying to write those test, because only the values used inside of the test method will change, the structure of the tests will look exactly the same. We could run those test parameterized, if you dare to extend the existing Testrunner. 

### Szenario 1: (Find) and run

Therefore we implemented a Stage3.ParameterizedTest Annotation for you, that has an additional parameter (parameterProvider) we can use to define the method that returns the parameters we can run our tests with.

The methods in class path, annotated with Stage1.Test and Stage3.ParameterizedTest are found in existing runTests implementation. This time we call the runTestMethod method directly.

Run normal tests with Stage2.TestRunner.runTestMethods()

The following classes already exist: TestParameters.java and ParameterizedServiceTest.java

Run parameterized tests with TestParameters taken from the method (given as string) that is defined in @Stage3.ParameterizedTest's parameterProvider. As a reminder you get the TestResult linked here. Again, the content of the strings in the result is checked later.

### Szenario 2: Feed the logs

You need to add some information to the TestResult, to give the user some hints about his failed implementation.

The printResult method is called again and should give information about the runned tests. Make sure every test run with a set of parameters should be count as separate execution.

Please return useful information about failed method calls. Users want to know the fully qualified name of the failed method and what actually went wrong. Return the parameters with which the test execution failed.

Also return information about method calls that threw an unexpected exception. Users want to know the fully qualified name of the method in which the error occurred and the Exception that was thrown. Return the parameters with which the test execution failed.
