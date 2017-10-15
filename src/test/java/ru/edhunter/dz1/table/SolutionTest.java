package ru.edhunter.dz1.table;

import org.junit.*;

import java.io.*;

public class SolutionTest {
    private static String dir;
    private final static String[] tests = {"test1", "test2", "test3"};
    private static int counter = 0;
    private final static InputStream in = System.in;
    private final static PrintStream out = System.out;

    @BeforeClass
    public static void setDir() {
        File resourcesDirectory = new File("src\\test\\resources");
        dir = resourcesDirectory.getAbsolutePath();
    }

    @Before
    public void prepareTest() throws FileNotFoundException {
        System.setIn(new FileInputStream(dir + "\\tableTests\\" + tests[counter]));
        System.setOut(new PrintStream(new File(dir + "\\tableTests\\" + tests[counter] + "Out")));
    }

    @AfterClass
    public static void restoreSystemIO() throws IOException {
        System.setIn(in);
        System.setOut(out);
        testRestored();
    }

    @Test(timeout = 1000)
    public void test1() throws IOException {
        Solution.main(null);
        Assert.assertTrue(checkIdentical());
    }

    @Test(timeout = 1000)
    public void test2() throws IOException {
        Solution.main(null);
        Assert.assertTrue(checkIdentical());
    }

    @Test(timeout = 1000)
    public void test3() throws IOException {
        Solution.main(null);
        Assert.assertTrue(checkIdentical());
    }

    private boolean checkIdentical() throws IOException {
        boolean result = true;
        BufferedReader reader = new BufferedReader(new FileReader(dir + "\\tableTests\\" + tests[counter] + "Out"));
        BufferedReader reader1 = new BufferedReader(new FileReader(dir + "\\tableTests\\" + tests[counter++] + "Controll"));
        while (reader1.ready()) {
            if (!reader.readLine().equals(reader1.readLine())) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static void testRestored() throws IOException {
        if (in.equals(System.in) && out.equals(System.out)) {
            System.out.println("SystemIO restored: success");
        } else System.out.println("SystemIO restored: failure");
    }
}
