package com.github.bingoohuang.legacycode.postentries;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class PostEntriesV2 {
    private TransactionBundle transactionBundle;

    // 这个需求，本质上就是先找出那些还没有在管理池中的entry对象，
    // 然后执行postDate()和add()操作。
    // 因此这里实际可以应用“新生方法”手法，引入一个侵入性相当弱的修改。
    public void postEntries(List<Entry> entries) {
        // 先剔除那些已经在transactionBundle管理池中的entry对象
        List<Entry> entriesToAdd = uniqueEntries(entries);

        for (Iterator<Entry> it = entriesToAdd.iterator(); it.hasNext(); ) {
            Entry entry = it.next();
            entry.postDate();
        }
        transactionBundle.getListManager().addAll(entriesToAdd);
    }

    // 剔除那些已经在transactionBundle管理池中的entry对象
    private List<Entry> uniqueEntries(List<Entry> entries) {
        // return entries; //如果出现错误，可以直接return。
        // 新生方法的好处就是代码隔离，可以快速定位是修改引入的问题还是原始代码本身就有的bug

        List<Entry> result = new LinkedList<Entry>();
        for (Iterator<Entry> it = entries.iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            if (!transactionBundle.getListManager().contains(entry)) {
                result.add(entry);
            }
        }
        return result;
    }
}
