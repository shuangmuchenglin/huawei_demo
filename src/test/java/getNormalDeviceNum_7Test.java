import org.junit.*;

/**
 * @ClassName: GetNormalDeviceNum_7Test
 * @Author: Zuo
 * @Date 2022/4/17
 * @Version 1.0
 */
public class getNormalDeviceNum_7Test {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass!");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass!");
    }

    @Before
    public void before(){
        System.out.println("before method test!");
    }

    @After
    public void after(){
        System.out.println("after method test!");
    }

    //@Ignore
    @Test
    public void shouldReturn15when3and20(){
        int actual = GetNormalDeviceNum_7.getNormalDeviceNum(3,20);
        int expect = 15;
        Assert.assertEquals(expect,actual);
        System.out.println("shouldReturn15when3and20");
    }

    @Test
    public void shouldReturn711when1and1000(){
        int actual = GetNormalDeviceNum_7.getNormalDeviceNum(1,1000);
        int expect = 711;
        Assert.assertEquals(expect,actual);
        System.out.println("shouldReturn711when1and1000");
    }

}
