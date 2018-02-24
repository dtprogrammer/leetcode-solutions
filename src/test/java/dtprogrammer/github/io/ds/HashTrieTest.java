package dtprogrammer.github.io.ds;

import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class HashTrieTest {

    @org.junit.Test
    public void test() throws Exception {
        HashTrie st = new HashTrie();
        List<String> strings = Arrays.asList("shore",
                "shoreline", "sew", "notify", "notion",
                "sewage", "paunch",
                "paunchy",
                "shortage", "shell", "shellsorting", "sheldon",
                "shelter", "ahello", "aheelo", "ahlllo");
        int mid = (strings.size() - 1) / 2;
        for (int i = 0; i < mid; i++) {
            String key = strings.get(i);
            st.insert(key);
        }
        for (int i = mid; i < strings.size(); i++) {
            String key = strings.get(i);
            st.insertRecursive(key);
        }

        Assert.assertTrue("shell", st.search("shell"));
        Assert.assertFalse("shell", st.search("shel"));
        Assert.assertTrue("shell", st.searchRecursive("notify"));
        Assert.assertFalse("shell", st.searchRecursive("notionn"));

        st.delete("notify");
        Assert.assertFalse("shell", st.searchRecursive("notify"));
    }
}
