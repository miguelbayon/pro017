import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestR250 {

    @Test
    public void test01() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] {};
        assertEquals(0, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test02() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "" };
        assertEquals(0, objetoBase.detectarRectangulos(inputGrid));

    }

    @Test
    public void test03() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { " " };
        assertEquals(0, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test04() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "+-+", "| |", "+-+" };
        assertEquals(1, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test05() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "  +-+", "  | |", "+-+-+", "| |  ", "+-+  " };
        assertEquals(2, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test06() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "  +-+", "  | |", "+-+-+", "| | |", "+-+-+" };
        assertEquals(5, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test07() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "+--+", "+--+" };
        assertEquals(1, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test08() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "++", "||", "++" };
        assertEquals(1, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test09() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "++", "++" };
        assertEquals(1, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test10() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "  +-+", "    |", "+-+-+", "| | -", "+-+-+" };
        assertEquals(1, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test11() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "+------+----+", "|      |    |", "+---+--+    |", "|   |       |",
                "+---+-------+" };
        assertEquals(3, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test12() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "+------+----+", "|      |    |", "+------+    |", "|   |       |",
                "+---+-------+" };
        assertEquals(2, objetoBase.detectarRectangulos(inputGrid));
    }

    @Test
    public void test13() {
        R250 objetoBase = new R250();
        String[] inputGrid = new String[] { "+---+--+----+", "|   +--+----+", "+---+--+    |", "|   +--+----+",
                "+---+--+--+-+", "+---+--+--+-+", "+------+  | |", "          +-+" };
        assertEquals(60, objetoBase.detectarRectangulos(inputGrid));
    }
}
