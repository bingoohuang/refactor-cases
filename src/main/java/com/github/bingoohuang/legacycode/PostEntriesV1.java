package com.github.bingoohuang.legacycode;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class PostEntriesV1 {
    private TransactionBundle transactionBundle;

    // 根据上面的需求描述，如果你是那99.9%的人，一般就会这样实现：
    public void postEntries(List<Entry> entries) {
        // 记录哪些entries中哪些对象执行了postDate()
        List<Entry> entriesToAdd = Lists.newLinkedList();

        for (Iterator<Entry> it = entries.iterator(); it.hasNext(); ) {
            Entry entry = (Entry) it.next();
            // 只有那些不在transactionBundle管理池中的entry对象才需要执行postDate()
            if (!transactionBundle.getListManager().contains(entry)) {
                entry.postDate();
                entriesToAdd.add(entry);
            }
        }

        // 将那些执行了postDate的entry对象添加到transactionBundle管理池中
        transactionBundle.getListManager().addAll(entriesToAdd);
    }

    // 无疑，这样的修改非常具有侵入性，一旦出错，很难定位是本身已有的缺陷还是改动造成的——
    // 只有在深入理解代码的改动逻辑之后才能分析错误原因。这个不好。
}
