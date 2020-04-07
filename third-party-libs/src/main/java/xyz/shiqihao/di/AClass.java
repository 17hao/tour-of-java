package xyz.shiqihao.di;

import javax.inject.Inject;

class AClass {
    @Inject
    AClass() {

    }


    int subtract(int i, int j) {
        return i - j;
    }
}
