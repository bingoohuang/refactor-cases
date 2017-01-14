package com.github.bingoohuang.legacycode;

import lombok.Data;

import java.util.List;

/**
 * @author bingoohuang [bingoohuang@gmail.com] Created on 2017/1/14.
 */
@Data
public class TransactionBundle {
    private List<Entry> listManager;
}
