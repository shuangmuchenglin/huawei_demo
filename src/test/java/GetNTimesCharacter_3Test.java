import org.junit.*;

public class GetNTimesCharacter_3Test {

    @BeforeClass
    public static void start(){
        System.out.println("BeforeClass!");
    }

    @AfterClass
    public static void end(){
        System.out.println("AfterClass!");
    }

    @Before
    public void before(){
        System.out.println("before method!");
    }

    @After
    public void after(){
        System.out.println("after method!");
    }

    @Test
    public void shouldReturnTrue(){
        int nvalue = 2;
        String[] strings = {"aabbccFFFFx2x2", "aaccddFFFFx2x2", "aabcdFFFFx2x2"};
        char[] expected = {'2', 'F', 'a', 'x'};
        char[] actual = GetNTimesCharacter_3.getNTimesCharacter(nvalue,strings);
        Assert.assertArrayEquals(expected,actual);
        System.out.println("this is correct!");
    }

}