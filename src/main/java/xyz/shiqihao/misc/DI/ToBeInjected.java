package xyz.shiqihao.misc.DI;

import javax.inject.Inject;

class ToBeInjected {
    @Inject
    ToBeInjected() {

    }


    int subtract(int i, int j) {
        return i - j;
    }
}
