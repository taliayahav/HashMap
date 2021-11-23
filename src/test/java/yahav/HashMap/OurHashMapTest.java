package yahav.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    @Test
    void getNull() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when

        // then
        assertNull(map.get("ENGLISH1"));
    }

    @Test
    void put() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("ENGLISH2", "HI");
        map.put("ENGLISH3", "HEY");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("RUSSIAN", "PRIVIT");
        map.put("JAPANESE", "NE HOW");
        map.put("MANDARIN", "CONICHIWA");

        // then
        assertEquals("HELLO", map.get("ENGLISH1"));
        assertEquals("HI", map.get("ENGLISH2"));
        assertEquals("HEY", map.get("ENGLISH3"));
        assertEquals("HOLA", map.get("SPANISH"));
        assertEquals("SHALOM", map.get("HEBREW"));
        assertEquals("BONJOUR", map.get("FRENCH"));
        assertEquals("PRIVIT", map.get("RUSSIAN"));
        assertEquals("NE HOW", map.get("JAPANESE"));
        assertEquals("CONICHIWA", map.get("MANDARIN"));
    }

    @Test
    void putSameKeys() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        // when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");
        map.put("ENGLISH1", "HI");

        // then
        assertEquals("HI", map.get("ENGLISH1"));
    }

    @Test
    void getSize() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.put("HEBREW", "SHALOM");
        map.put("FRENCH", "BONJOUR");

        //then
        assertEquals(4, map.size());
    }
    @Test
    void checkMapIsEmpty() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertEquals(false, map.isEmpty());
        assertNotNull(map);
    }
    @Test
    void checkContainsKey() {
        // given
        OurHashMap<String,String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertEquals(true, map.containsKey("ENGLISH1"));
        assertTrue(map.containsKey("ENGLISH1"));
    }
    @Test
    void checkContainsValue() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");

        //then
        assertEquals(true, map.containsValue("HELLO"));
    }
    @Test
    void removeMap() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        map.remove("ENGLISH1", "HELLO");

        //then
        assertEquals(false, map.containsKey("ENGLISH1"));
    }
//    @Test
//    void clearAll() {
//        // given
//        OurHashMap<String, String> map = new OurHashMap<>();
//
//        //when
//        map.put("ENGLISH1", "HELLO");
//        map.clear();
//
//        //then
//        assertEquals(true, map.isEmpty());
//    }
    @Test
    void returnKeys() {
        // given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        Set keySet = map.keySet();

        //then
        assertTrue(keySet.contains("ENGLISH1"));
        assertTrue(keySet.contains("SPANISH"));
    }
    @Test
    void returnValues() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.put("SPANISH", "HOLA");
        Collection values = map.values();

        //then
        assertTrue(values.contains("HELLO"));
        assertTrue(values.contains("HOLA"));
    }
    @Test
    void putValuesInNewMap() {
        //given
        OurHashMap<String, String> map = new OurHashMap<>();
        Map<String, String> m = new HashMap<>();

        //when
        map.put("ENGLISH1", "HELLO");
        map.putAll(m);

        //then
        assertTrue(map.containsKey("ENGLISH1"));
    }
}