package com.github.bingoohuang.building_maintainable_software.ch11;

public class DeadCode {
    public class Transaction {
        public Transaction(@SuppressWarnings("unused") long uid) {
        }
    }

    public Transaction getTransaction(long uid) {
        Transaction result = new Transaction(uid);
        if (result != null) {
            return result;
        } else {
            return lookupTransaction(uid); // <1>
        }
    }

    private Transaction lookupTransaction(
        @SuppressWarnings("unused") long uid) {
        return null;
    }
}