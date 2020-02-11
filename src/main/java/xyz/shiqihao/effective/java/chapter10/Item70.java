package xyz.shiqihao.effective.java.chapter10;

/**
 * 对于受检查异常和未受检查异常的几点建议:
 * ① 在程序是可恢复的情况下使用受检查异常, 例如: 用户支付的金额大于余额, 输入不符合预期格式等. 并且
 * 使用受检查异常要确保程序真的能恢复过来.
 * ② 对于程序的错误使用不受检查异常, 继续执行会造成更严重的错误. 例如: 数组越界.
 * ③ 当不确定是哪种情况时, 选择不受检查异常.
 * ④ 不要使用Error及其子类. Error可以被视为编译时的异常, 当出现Error时, 意味着程序已经没救了.
 * ⑤ 不要直接继承Throwable. 直接继承的异常会被视为受检查异常, 并且你的API会让调用者感到困惑.
 */
public class Item70 {
}

// NEVER DO THIS!
class MyException extends Throwable {
}