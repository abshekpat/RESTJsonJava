import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Params {
    @Test(priority=0)
    @Parameters({"val1", "val2"})
    public void sum(int x, int y)
    {
        int finalsum = x+y;
        System.out.println("sum :"+ finalsum);
    }

    @Test
    @Parameters({"val1", "val2"})
    public void diff(int x, int y)
    {
        int finalsum = x-y;
        System.out.println("Diff :"+ finalsum);
    }

}
