# LambdaTest-TestNG Certification

---

### Step 1: Environment Setup

#### LambdaTest Credentials

Set your LambdaTest username and access key as environment variables in the file `lambdatest.env`.

Replace the values with your credentials, which you can find at [LambdaTest Capabilities Generator](https://www.lambdatest.com/capabilities-generator/):

```
ln 1: export LT_USERNAME="Your Username"
ln 2: export LT_ACCESS_KEY="Your Access Key"
```

After saving your credentials in lambdatest.env, run the command:

```
$ source lambdatest.env

```

### Step 2: Setting Up Your Test Capabilities

Generate the test capabilities at LambdaTest Capabilities Generator and choose Java as the language.

You can set up the capabilities of the test in your BaseTest class:

```
ln 13: HashMap<String, Object> ltOptions = new HashMap<>();
ln 14: ltOptions.put("username", System.getenv("LT_USERNAME"));
ln 15: ltOptions.put("accessKey", System.getenv("LT_ACCESS_KEY"));
ln 16: ltOptions.put("project", "Selenium TestNG");
ln 17: ltOptions.put("name", "Test Scenario 1 " + browser + " in " + platform); // test name
ln 18: ltOptions.put("build", "Simple Form Demo");
ln 19: ltOptions.put("network", true); // Enable network logs
ln 20: ltOptions.put("video", true); // Enable video recording
ln 21: ltOptions.put("console", true); // Enable console logs
ln 22: ltOptions.put("visual", true); // Enable screenshots
```
### Step 3: Running Tests
To start a single test, run the following command:

```
$ mvn test
```

To start parallel tests, configure your TestNG XML file for parallel execution and run the following command:
```
$ mvn test -DsuiteXmlFile=testng.xml
```

About LambdaTest
LambdaTest is a cloud-based Selenium grid infrastructure that enables you to run automated cross-browser compatibility tests on 2000+ different browser and operating system environments. LambdaTest supports all programming languages and frameworks compatible with Selenium, with easy integrations into popular CI/CD platforms. It’s an excellent solution for enhancing your Selenium automation testing by increasing test coverage across multiple desktop and mobile browsers, while also reducing test execution time through parallel execution.
