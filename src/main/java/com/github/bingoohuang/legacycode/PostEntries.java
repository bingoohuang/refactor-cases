package com.github.bingoohuang.legacycode;

import java.util.Iterator;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
    public class PostEntries {
    private TransactionBundle transactionBundle;

    // 《修改代码的艺术》，《Working Effectively with Legacy Code》
    // 对列表entries中的每个对象，依次执行postDate（）对象，然后添加的transactionBundle的管理池中。
    public void postEntries(List<Entry> entries) {
        for (Iterator<Entry> it = entries.iterator(); it.hasNext(); ) {
            Entry entry = it.next();
            entry.postDate();
        }

        transactionBundle.getListManager().addAll(entries);
    }

    // 新的需求，需求描述是这样的：（需求描述实际是很关键的，不同的描述方式会不自觉的影响程序员的实现方式）

    //  entries列表中不是所有的对象都要执行postDate()和添加进transactionBundle的管理池中。
    // 只有还尚未在transactionBundle的管理池中的对象才需要执行postDate()操作，
    // 只有那些执行了postDate()的entry对象，才需要添加到transactionBundle的管理池中。
}
