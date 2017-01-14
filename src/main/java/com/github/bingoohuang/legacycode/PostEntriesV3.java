package com.github.bingoohuang.legacycode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
public class PostEntriesV3 {
    private TransactionBundle transactionBundle;

    // 当然也可以引入外覆方法的手法。
    // 外覆方法的第一步总是重命名原有方法和引入外覆方法，外覆方法名就是原有方法名。这一步基本不会错。

    //rename "postEntries(List<Entry> entries)" aspostEntriesDirectly
    private void postEntriesDirectly(List<Entry> entries) {
        for (Iterator<Entry> it = entries.iterator(); it.hasNext(); ) {
            Entry entry = it.next();
            entry.postDate();
        }
        transactionBundle.getListManager().addAll(entries);
    }

    // 下一步，调整外覆方法的实现,这里基本与新生方法相同
    // new wrapper method use signature "public void postEntries(List<Entry> entries)"
    public void postEntries(List<Entry> entries) {
        // 先剔除那些已经在transactionBundle管理池中的entry对象
        List<Entry>entriesToAdd = uniqueEntries(entries);

        postEntriesDirectly(entries);
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

    // 如果习惯了思考使用弱侵入式的修改方式，后面两种方式会自然而然的得到。
    // 外覆方法与新生方法的区别是外覆方法保留了原有方法（只是方法名做了修改）。
    // 如果有需要，还可以新生类和外覆类。原理都差不多。

    // 最后啰嗦一下，如果一开始需求是这样描述的：
    // 对entries列表中的Entry对象，首先要检查是否已经在管理池中。只有不存在时才执行postDate()操作，并把它添加到管理池中。
    // 这样描述后，要想到后面两种方法就会更自然一些。 所以说需求描述是很关键。
    // 但是没人会为我们做这个，一切只能靠自己。一切从需求分析开始。
}
