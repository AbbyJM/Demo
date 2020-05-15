### java异常机制
异常机制是指当程序出现错误后，不希望直接crash，而是可以恢复，java提供了一种识别以及处理错误的一种机制。java的异常机制主要依赖try，catch，finally，throw和throws这五个关键字。
* try： 包含可能发生异常的代码块。
* catch 每一种类型对应一个catch代码块，用于处理某一类异常
* finally： 用于回收try中的资源，如关闭数据库或网络的连接，异常机制保证finally代码块中的代码总是会被执行。
* throw： 用于显式地抛出一个异常
* throws： 用在方法的签名中，声明该方法可能抛出的异常。

java中常见的异常：
|  异常名称   | 异常描述  |
|  ----  | ----  |
|ArithmeticException|算术异常|
|NullPointerException|空指针异常|
|ClassCastException|类型强制转换异常|
|NegativeArrayException|数组负下标异常|
|ArrayIndexOutOfBoundsException|数组下标越界异常|
|EOFException|文件结束异常|
|FileNotFoundException|文件未找到异常|
|IOException|输入输出异常|
|SQLException|数据库操作异常|
|NoSuchMethodException|方法未找到异常|


&nbsp;
java异常的使用应该遵循以下的原则：
* 尽量捕获原始的异常而不是泛化的异常，以下是错误的示例：
```java
InputStream is =null;
try{
    is = new FileInputStream("test.txt");
}catch(Exception e){
    e.printStackTrace();
}
```
正确的做法应该是捕获FileNotFoundException

* 不要使用异常代替判断，因为捕获异常需要耗费的时间远远长于使用判断。下面是错误的示例。
```java
public static void sayHello(){
    try{
         User user = null;
         user.sayHello();
    }catch(NullPointerException e){
        e.printStackTrace();
    }
}
```
* 不能盲目过早捕获异常,下面是错误的示例：
```java
InputStream is = null;
try{
    is = new FileInputStream("test.txt");
}catch(FileNotFoundException e){
    e.printStackTrace();
}
int read;

//如果上面发生异常这个is就是null，程序抛出的就是NullPointerException
//但是实际的异常应该是FileNotFoundException
while((read=is.read())!=-1) {

}
```
* 不要先记录异常再抛出异常，因为这样可能会看到多条输出日志，难以区分，下面是错误示例：
```java
try{
    is = new FileNotFoundException("test.txt");
}catch(FileNotFoundException e){
    //可能会重复输出错误日志
    log.error(e);
    throw e;
}
```
