import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DProvider {

    @Test(dataProvider="DP")
    public void myTest(int a, int b, int res)
    {
        int sum = a+b;
        Assert.assertEquals(res, sum);
    }

    @DataProvider(name="DP")
    public Object[][] dpmethod()
    {
        return new Object[][] {{2, 3, 5}, {4, 6, 8}};
    }

}
