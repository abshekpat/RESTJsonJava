import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DProvider1 {

    @Test(dataProvider="DP", invocationCount = 1, threadPoolSize=3, timeOut=1000)
    public void Sum(int a, int b, int res)
    {
        int sum = a+b;
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(res, sum);
        sa.assertAll();
    }

    @Test(dataProvider="DP", invocationCount = 1, threadPoolSize=3, timeOut=1000)
    public void Diff(int a, int b, int res)
    {
        int diff = a-b;
        System.out.println(Thread.currentThread().getId());
        Assert.assertEquals(res, diff);
    }

    @DataProvider(name="DP")
    public Object[][] dpmethod(Method m)
    {
        switch(m.getName())
        {
        case "Sum":
            return new Object[][] {{2, 3, 5}, {4, 6, 8}};
        case "Diff":
            return new Object[][] {{5, 3, 2}, {6, 4, 2}};
        }
        return null;
    }

}
